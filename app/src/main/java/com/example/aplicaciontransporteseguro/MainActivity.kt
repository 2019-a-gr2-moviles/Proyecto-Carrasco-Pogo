package com.example.aplicaciontransporteseguro

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.beust.klaxon.Klaxon

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val json = """
            {
              "denuncias": [],
              "createdAt": 1564272729328,
              "updatedAt": 1564272729328,
              "id": 1,
              "correo_electronico": "",
              "nombre_completo": "",
              "nombre_usuario": "",
              "contrasena": "",
              "fkTipoUsuario": null
            }
        """.trimIndent()

        try {
            val usuarioInstancia = Klaxon()
                .parse<Usuario>(json)
            Log.i("http",
                "Nombre ${usuarioInstancia?.nombre_usuario}")
            Log.i("http",
                "ID ${usuarioInstancia?.id}")
        }catch (e:Exception){
            Log.i("http",
                "Error instanciando la empresa")
        }

    }
}
