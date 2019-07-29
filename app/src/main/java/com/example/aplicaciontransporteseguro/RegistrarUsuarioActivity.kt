package com.example.aplicaciontransporteseguro


import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registrar_usuario.*

class RegistrarUsuarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_usuario)

        val urlCrearUsuario = "http://192.168.1.145:1337/usuario"

        btn_create_account.setOnClickListener {

            val parametrosCrearUsuario = listOf(
                "nombre_completo" to txt_fullname.text.toString(),
                "correo_electronico" to  txt_email.text.toString(),
                "contrasena" to txt_password.text.toString()
                )

            urlCrearUsuario
                .httpPost(parametrosCrearUsuario)
                .responseString { request, response, result ->
                    when(result){
                        is Result.Failure -> {
                            val error = result.getException()
                            Log.i("http","Error: ${error}")
                        }
                        is Result.Success ->{
                            val usuarioString = result.get()
                            Log.i("http","${usuarioString}")
                        }
                    }
                }

            crearUsuario()
        }
    }

    fun crearUsuario(){

    }
}
