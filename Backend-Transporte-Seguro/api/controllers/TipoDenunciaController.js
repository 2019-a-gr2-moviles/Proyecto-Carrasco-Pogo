/**
 * TipoDenunciaController
 *
 * @description :: Server-side actions for handling incoming requests.
 * @help        :: See https://sailsjs.com/docs/concepts/actions
 */

module.exports = {
    'Mostrar': async function(req, res){
        var values = req.body;
        var TiposDenuncias = TipoDenuncia.find(values);
        return res.json(TiposDenuncias);
    }

};

