const api = require('../controllers/card-controller')

module.exports = (app) => {
    app.route('/cards')
        .get(api.findAll)
        .post(api.save)

    app.route('/cards/:id')
        .get(api.findById)
        .put(api.update)
        .delete(api.delete)

    // Tem uma pegadinha nas rotas no Express, então é necessário fazer
    // algo diferente de '/cards', então vamos ter que setar a rota como
    // '/card/paginationAndSorting'.
    app.route('/card/paginationAndSorting')
        .get(api.paginationAndSorting) // http://localhost:3000/card/paginationAndSorting?limit=5&page=0

}