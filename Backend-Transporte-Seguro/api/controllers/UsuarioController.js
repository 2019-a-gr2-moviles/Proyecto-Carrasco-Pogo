/**
 * UsuarioController
 *
 * @description :: Server-side actions for handling incoming requests.
 * @help        :: See https://sailsjs.com/docs/concepts/actions
 */

module.exports = {
    'Login': async function(req, res){
        var values = req.body;
        var Usuarios = await Usuario.find({nombre_usuario: values.nombre_usuario, contrasena:values.contrasena});
        if(Usuarios!=null)
        {
            if(Usuarios.length > 0)
            {
                return res.json({login:'accede'});
            }
            else
            {
                return res.json({login:'No accede'});    
            }
        }    
    },
    'Registrar':async function(req, res){
        var values = req.body;
        await Usuario.create(values);
        return res.json({registro: 'Satisfactorio'});
    },
    'Mostrar':async function(req, res){
        var values = req.body;
        var Usuarios = await Usuario.find(values);
        return res.json(Usuarios);
    },
    'Actualizar': async function(req, res){
        var values = req.body;
        await Usuario.update({id:values.id})
            .set(values);
            return res.json({actualizacion: 'Satisfactorio'});
    },
    'Eliminar': async function(req, res){
        var values = req.body;
        await Usuario.destroy({id:values.id});
        return res.json({eliminacion: 'Satisfactorio'});
    },
};

