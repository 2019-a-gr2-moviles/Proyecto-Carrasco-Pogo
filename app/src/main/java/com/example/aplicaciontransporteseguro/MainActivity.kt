package com.example.aplicaciontransporteseguro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import com.github.kittinunf.result.Result.Failure
import com.github.kittinunf.result.Result.Success
import kotlinx.android.synthetic.main.activity_registrar_usuario.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "http://192.168.1.145:1337/usuario/3"

        btn_login.setOnClickListener {
            url.httpGet()
                .responseString { request, response, result ->
                    when (result) {
                        is Failure -> {
                            val ex = result.getException()
                            Log.i("http","Error: ${ex.message}")
                        }
                        is Success -> {
                            val data = result.get()
                            Log.i("http","Data: ${data}")

                            val usuarioParseado = Klaxon()
                                .parse<Usuario>(data)
                            if(usuarioParseado != null){
                                Log.i("http","Correo: ${usuarioParseado.correo_electronico}")
                                Log.i("http","Usuario: ${usuarioParseado.contrasena}")
                                if((txt_user.text.toString().equals(usuarioParseado.correo_electronico)) && (txt_pass.text.toString().equals(usuarioParseado.contrasena))){
                                    Log.i("http","${txt_user.text}")
                                }
                            }
                        }
                    }
                }
        }


        txt_create_account.setOnClickListener {
            crearUsuario()
        }



    }

    fun acceder(){
        val intentExplicito = Intent(
            this,
            MenuPrincipalActivity::class.java
        )
        startActivity(intentExplicito)
    }

    fun crearUsuario(){
        val intentExplicito = Intent(
            this,
            RegistrarUsuarioActivity::class.java
        )
        startActivity(intentExplicito)
    }
}
