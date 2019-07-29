package com.example.aplicaciontransporteseguro

import java.util.*
import kotlin.collections.ArrayList

class TipoDenuncia (var id:Int,
                    var denuncias:ArrayList<Denuncia>,
                    var createdAt:Long,
                    var updatedAt:Long,
                    var nombre:String){
    var fechaCreacion: Date
    var fechaActualizacion: Date
    init {
        fechaCreacion = Date(createdAt)
        fechaActualizacion = Date(updatedAt)
    }
}