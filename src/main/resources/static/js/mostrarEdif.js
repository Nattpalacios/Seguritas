var visualizar = (function () {
    
    var mostrEdificio = function(edif){
        var edificio = edif;
        var nombre = edificio.nombre;
        var txt = document.createElement("label");
        txt.innerHTML = nombre;
        var boton = document.createElement("button");
        var mostrar = document.getElementById("edificios");
        mostrar.appendChild(txt);
        mostrar.appendChild(boton);
    }

    var generarTabla = function(lisEdificios) {
        console.log(lisEdificios);
        /*for(var i = 0; i < edificios.length; i++){
            var edificio = edificios[i];
            var nombre = edificio.nombre;
            var numPisos = edificio.numPisos;
            var boton = documento.createElement("button");
            var lista = document.createElement("ul");
            var listaN = document.createElement("li");
            var listaP = document.createElement("li");
            var listaB = document.createElement("li");
            listaN.innerHTML = nombre;
            listaP.innerHTML = numPisos;
            listaB.innerHTML = boton;
            lista.appendChild(listaN);
            $('#edificios').appendChild(lista);
        }*/
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