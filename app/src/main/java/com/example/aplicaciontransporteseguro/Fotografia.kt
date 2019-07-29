package com.example.aplicaciontransporteseguro

import java.util.*

class Fotografia(var id:Int,
                 var nombre:String,
                 var createdAt:Long,
                 var updatedAt:Long,
                 var fkDenuncia:Int) {
    var fechaCreacion: Date
    var fechaActualizacion: Date
    init {
        fechaCreacion = Date(createdAt)
        fechaActualizacion = Date(updatedAt)
    }
}