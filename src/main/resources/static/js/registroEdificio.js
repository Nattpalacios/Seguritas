var registro = (function () {
    var numPisos;

    var agregarPiso = function(){
        var pisos = document.getElementById("numPisos");
        numPisos = Number(pisos.innerHTML);
        numPisos+=1;
        ajustarValor(numPisos);
    }

    var quitarPiso = function(){
        var pisos = document.getElementById("numPisos");
        numPisos = Number(pisos.innerHTML);
        if(numPisos > 0){
            numPisos-=1;
        }
        ajustarValor(numPisos);
    }

    var ajustarValor = function(cantPisos){
        $('#edificio').empty();
        for(var i = 0; i < cantPisos; i++){
            var boton = "<li id='piso"+i+"'>piso</li>"
            $('#edificio').append(boton);
        }
        document.getElementById("numPisos").innerHTML = cantPisos;
    }

    var guardarEdificio = function(){
        var nombreEdificio = document.getElementById("inputEdificio").value;
        var pisos = new Array();
        var piso = new Object();
        for(var i = 0; i < numPisos; i++){
            var piso = new Object();
            piso.id = nombreEdificio+" piso "+i;
            piso.nombre = "Piso "+i;
            piso.puertas = new Array();
            pisos.push(piso);
        }

        var edificio = new Object();
        edificio.id = "E"+nombreEdificio;
        edificio.nombre = nombreEdificio;
        edificio.tablero = null;
        edificio.pisos = pisos;
        var edificiojson = JSON.stringify(edificio);
        apiclient.agregarEdificio(edificiojson);
    }
  
    return {
      agregarPiso: agregarPiso,
      quitarPiso: quitarPiso,
      guardarEdificio: guardarEdificio
    };
  })();