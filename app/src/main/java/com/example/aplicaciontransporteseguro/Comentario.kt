package com.example.aplicaciontransporteseguro

import java.util.*

class Comentario(var id:Int,
                 var mensaje:String,
                 var createdAt:Long,
                 var updatedAt:Long,
                 var fkDenuncia:Int
                 ) {
    var fechaCreacion: Date
    var fechaActualizacion: Date
    init {
        fechaCreacion = Date(createdAt)
        fechaActualizacion = Date(updatedAt)
    }
}