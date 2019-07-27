/**
 * Denuncia.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    id:{
      type:'number',
      unique:true,
      autoIncrement:true,
      columnName:'ID_DENUNCIA'
    },
    id_agente:{
      type:'number',
      columnName:'ID_AGENTE'
    },
    estado:{
      type:'string',
      columnName:'ESTADO'
    },
    descripcion:{
      type:'string',
      columnName:'DESCRIPCION'
    },    
    fkUsuario:{
      model:'Usuario',
      columnName:'FK_ID_USUARIO'
    },
    fkTipoDenuncia:{
      model:'TipoDenuncia',
      columnName:'FK_ID_TIPO_DENUNCIA'
    },
    comentarios:{
      collection:'Comentario',
      via:'fkdenuncia'
    },
    fotografias:{
      collection:'Fotografia',
      via:'fkdenuncia'
    }
  },
};

