/**
 * Fotografia.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    id:{
      type:'number',
      unique: true,
      autoIncrement: true,
      columnName:'ID_FOTOGRAFIA'
    },
    nombre:{
      type:'string',
      columnName:'NOMBRE'
    },
    fkdenuncia:{
      model:'Denuncia',
      columnName:'FK_ID_DENUNCIA'
    }
  },

};

