/**
 * Usuario.js
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
      columnName:'ID_USUARIO'
    },
    id_tipo_usuario:{
      type:'number',
      columnName:'ID_TIPO_USUARIO',
    },
    correo_electronico:{
      type:'string',
      isEmail: true,
      columnName:'CORREO_ELECTRONICO'
    },
    nombre_completo:{
      type:'string',
      columnName:'NOMBRE_COMPLETO'
    },
    nombre_usuario:{
      type:'string',
      columnName:'NOMBRE_USUARIO'
    },
    contrasena:{
      type:'string',
      columnName:'CONTRASENA'
    },
    fkTipoUsuario:{
      model:'TipoUsuario',
      columnName:'FK_ID_TIPO_USUARIO'
    },
    denuncias: {
      collection: 'Denuncia',
      via: 'fkUsuario'
    }
  }
};

