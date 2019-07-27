/**
 * TipoUsuario.js
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
      columnName:'ID_TIPO_USUARIO'
    },
    nombre:{
      type:'string',
      columnName:'NOMBRE'
    },
    usuarios: {
      collection: 'Usuario',
      via: 'fkTipoUsuario'
    }
  },

};

