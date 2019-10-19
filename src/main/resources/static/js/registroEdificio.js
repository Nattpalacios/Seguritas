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
        
    }
  
    return {
      agregarPiso: agregarPiso,
      quitarPiso: quitarPiso,
      guardarEdificio: guardarEdificio
    };
  })();