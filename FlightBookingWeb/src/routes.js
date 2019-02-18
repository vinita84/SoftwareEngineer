module.exports = function(app){
    var passengers = require('./controller/flightBookingController');  
    app.get('/passengers', passengers.findAll);
    
}