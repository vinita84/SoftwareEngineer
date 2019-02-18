var express = require('express');

var app = express();

require('./src/routes')(app);

app.listen(3001);
console.log("listening on port 3001...");




