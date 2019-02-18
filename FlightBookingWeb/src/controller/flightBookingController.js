//Import model
Passenger = require('./passengerModel');



// Get all Passenger info
exports.view = function (req, res) {
  Passenger.getPassengers(req.params.booking_id, function (err, pass) {
      if (err)
          res.send(err);
      res.json({
          message: 'Passenger Info =>>',
          data: pass
      });
  });
};


// Update seat info
exports.update = function (req, res) {
Passenger.addSeating(req.params.booking_id, function (err, pass) {
      if (err)
          res.send(err);
pass.seat = req.body.seat ? req.body.seat : pass.seat;
      
// save the contact and check for errors
      pass.save(function (err) {
          if (err)
              res.json(err);
          res.json({
              message: 'Seat Info updated',
              data: pass
          });
      });
  });
};


