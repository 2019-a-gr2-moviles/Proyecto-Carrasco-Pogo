/**
 * DenunciaController
 *
 * @description :: Server-side actions for handling incoming requests.
 * @help        :: See https://sailsjs.com/docs/concepts/actions
 */

module.exports = {
    'Registrar': async function(req, res){
        var values = req.body;
        var Agentes = await Usuario.findOne({fkTipoUsuario:1});
        console.log(values);
        if(Agentes!=null)
        {
            if(Agentes.length > 0)
            {
                var Agente=Math.random() * (Agentes.length - 1) + 1;
                values.id_agente=Agente.id;
            }
            else
            {
                values.id_agente=0;
            }
        }
        else
        {
            values.id_agente=0;
        }    
        await Denuncia.create(values);
        return res.json({registro: 'Satisfactorio'});
  },
    'Mostrar': async function(req, res){
        var values = req.body;
        var Denuncias = await Denuncia.find(values);
        return res.json(Denuncias);
  },
  'Actualizar': async function(req, res){
        var values = req.body;
        await Denuncia.update({id:values.id}).set(values); 
        return res.json({actualizacion:'Satisfactoria'});
    },
  'Eliminar':async function(req, res){
    var values = req.body;
    await Denuncia.destroy({id: values.id}); 
    return res.json({eliminacion:'Satisfactoria'});
  }

};

