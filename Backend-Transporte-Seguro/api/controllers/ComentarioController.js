/**
 * ComentarioController
 *
 * @description :: Server-side actions for handling incoming requests.
 * @help        :: See https://sailsjs.com/docs/concepts/actions
 */

module.exports = {
    'Registrar': async function(req, res){
        var values = req.body;
        await Comentario.create(values);
        return res.json({registro: 'Satisfactorio'});
  },
    'Mostrar': async function(req, res){
        var values = req.body;
        var Comentarios = await Comentario.find(values);
        return res.json(Comentarios);
  },
  'Actualizar': async function(req, res){
        var values = req.body;
        await Comentario.update({id:values.id}).set(values); 
        return res.json({actualizacion:'Satisfactoria'});
    },
  'Eliminar':async function(req, res){
    var values = req.body;
    await Comentario.destroy({id: values.id}); 
    return res.json({eliminacion:'Satisfactoria'});
  }

};

