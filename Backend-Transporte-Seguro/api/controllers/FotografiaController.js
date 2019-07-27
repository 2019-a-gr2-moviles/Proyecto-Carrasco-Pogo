/**
 * FotografiaController
 *
 * @description :: Server-side actions for handling incoming requests.
 * @help        :: See https://sailsjs.com/docs/concepts/actions
 */

module.exports = {
  'Registrar': async function(req, res){
        req.file('archivo').upload({dirname: require('path').resolve(sails.config.appPath, 'assets/images')},async function (err, files) {
            if (err)
            {
                return res.serverError(err);
            }
            var values = req.body;
            values.nombre =require('util').format('/images/'+files[0].fd.split('\\').pop());

            await Fotografia.create(values);
            return res.json({registro: 'Satisfactorio'});
          });
  },
  'Mostrar': async function(req, res){
        var values = req.body;
        var Fotografias = await Fotografia.find(values);
        return res.json(Fotografias);
  },
  'Actualizar': async function(req, res){
    req.file('archivo').upload({dirname: require('path').resolve(sails.config.appPath, 'assets/images')},async function (err, files) {
      if (err)
      {
          return res.serverError(err);
      }
        var values = req.body;
        values.nombre =require('util').format('/images/'+files[0].fd.split('\\').pop());

        await Fotografia.update({id:values.id}).set(values); 
        return res.json({actualizacion:'Satisfactoria'});
      });
    },
  'Eliminar':async function(req, res){
    var values = req.body;
    await Fotografia.destroy({id: values.id}); 
    return res.json({eliminacion:'Satisfactoria'});
  }
};

