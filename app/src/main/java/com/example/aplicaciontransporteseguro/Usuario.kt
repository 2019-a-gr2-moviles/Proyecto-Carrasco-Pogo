package com.example.aplicaciontransporteseguro

import java.util.*

class Usuario(var id:Int,
              var nombre_completo:String,
              var createdAt:Long,
              var updatedAt: Long,
              var correo_electronico: String,
              var nombre_usuario: String,
              var contrasena:String) {

    var fechaCreacion: Date
    var fechaActualizacion: Date
    init {
        fechaCreacion = Date(createdAt)
        fechaActualizacion = Date(updatedAt)
    }

}