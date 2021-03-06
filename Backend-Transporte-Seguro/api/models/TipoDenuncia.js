/**
 * TipoDenuncia.js
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
      columnName:'ID_TIPO_DENUNCIA'
    },
    nombre:{
      type:'string',
      columnName:'NOMBRE'
    },
    denuncias: {
      collection: 'Denuncia',
      via: 'fkTipoDenuncia'
    }
  },
};

