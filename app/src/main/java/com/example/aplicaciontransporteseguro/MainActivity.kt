package com.example.aplicaciontransporteseguro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

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
    }
}
