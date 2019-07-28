package com.example.aplicaciontransporteseguro

class Denuncia(var id:Int,
               var id_agente:Int,
               var estado:String,
               var descripcion:String,
               var comentarios:ArrayList<Comentario>,
               var fotografias:ArrayList<Fotografia>,
               var createdAt:Long,
               var updatedAt:Long,
               var fkUsuario:Int,
               var fkTipoDenuncia:Int) {

}