package com.example.aplicaciontransporteseguro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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

        val url = "http://172.31.104.142:1337/usuario/login"

        btn_login.setOnClickListener {
            val parametrosLogin = listOf(
                "correo_electronico" to  txt_user.text.toString(),
                "contrasena" to txt_pass.text.toString()
            )
            url.httpPost(parametrosLogin)
                .responseString { request, response, result ->
                    when (result) {
                        is Failure -> {
                            val ex = result.getException()
                            Log.i("http","Error: ${ex.message}")
                        }
                        is Success -> {
                            val data = result.get()
                            Log.i("http","Data: ${data[1]}")

                            val usuarioParseado = Klaxon()
                                .parseArray<Usuario>(data)
                            if(usuarioParseado != null){

                                //if(txt_user.text.toString().equals(usuarioParseado.correo_electronico) && txt_pass.text.toString().equals(usuarioParseado.contrasena)){
                                    acceder()
                                //}
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
