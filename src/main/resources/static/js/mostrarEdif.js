var visualizar = (function () {
    
    var mostrEdificio = function(edif){
        var edificio = edif;
        var nombre = edificio.nombre;
        var pisos = edificio.pisos;
        var numP = pisos.length;
        var txtN = document.createElement("label");
        var txtP = document.createElement("label");
        txtN.innerHTML = nombre;
        txtP.innerHTML = numP;
        var boton = document.createElement("button");
        var mostrar = document.getElementById("edificios");
        mostrar.appendChild(txtN);
        mostrar.appendChild(txtP);
        mostrar.appendChild(boton);
    }

    var generarTabla = function(listEdificios) {
        var lisEdificios = listEdificios;
        for(var i = 0; i < lisEdificios.length; i++){
            var edif = lisEdificios[i];
            //console.log(edif);
            var nombreEd = edif.nombre;
            var pisosE = edif.pisos;
            var numP = pisosE.length;
            var boton = document.createElement("button");
            var lista = document.createElement("ul");
            var listaN = document.createElement("li");
            var listaP = document.createElement("li");
            //var listaB = document.createElement("li");
            listaN.innerHTML = nombreEd;
            listaP.innerHTML = numP;
            //boton.type = "button";
            //listaB.innerHTML = boton;
            lista.appendChild(listaN);
            lista.appendChild(listaP);
            lista.appendChild(boton);
            //lista.appendChild(listaB);
            var edifcs = document.getElementById("edificios");
            edifcs.appendChild(lista);
        }
    }
  
    return {
      mostrarEdificio: function(){
        $('#edificios').empty();
        var nombre = $('#inputEdificio').val();
        if(nombre == ""){
            apiclient.traerEdificios(generarTabla);
        }else{
            apiclient.traerEdificioPorNombre(nombre,mostrEdificio);
        }
      }
    };
  })();