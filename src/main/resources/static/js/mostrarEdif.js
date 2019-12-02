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
        boton.id = nombre;
        var mostrar = document.getElementById("edificios");
        mostrar.appendChild(txtN);
        mostrar.appendChild(txtP);
        mostrar.appendChild(boton);

        boton.onclick = function() {          
            window.location='http://localhost:8080/edificio.html?nombre='+nombre;
            
        };
        
    }

    var generarTabla = function(listEdificios) {
        var lisEdificios = listEdificios;
        for(var i = 0; i < lisEdificios.length; i++){
            var edif = lisEdificios[i];
            var nombreEd = edif.nombre;
            var pisosE = edif.pisos;
            var numP = pisosE.length;
            var boton = document.createElement("button");
            boton.id = nombreEd;
            var lista = document.createElement("ul");
            var listaN = document.createElement("li");
            var listaP = document.createElement("li");
            listaN.innerHTML = nombreEd;
            listaP.innerHTML = numP;
            lista.appendChild(listaN);
            lista.appendChild(listaP);
            lista.appendChild(boton);
            var edifcs = document.getElementById("edificios");
            edifcs.appendChild(lista);

            boton.onclick = function() {
                //alert(nombreEd);
                window.location='http://localhost:8080/edificio.html?nombre='+boton.id;
                //console.log(boton.id);
            };

            
        }
    }

    var dentroEdificio = function() {
        var hr = window.location.href;
        var nombre = hr.split("=")[1];
        var nomEdificio = document.createElement("h1");
        nomEdificio.innerHTML = nombre;
        var encabezado = document.getElementById("cabeza");
        encabezado.appendChild(nomEdificio);


        apiclient.traerEdificioPorNombre(nombre,mostrarPisos);
        
    }

    var mostrarPisos = function(edificio){
        var ed = edificio; 
        var pisos = ed.pisos;
        console.log(ed.nombre);
        var numP = pisos.length;
        //var muestraPisos = document.getElementById("pisoss");
        
        $('#pisoss').empty();
        for(var i = 0; i < numP; i++){
            var boton = "<li id='piso"+i+"'>piso</li>"
            $('#pisoss').append(boton);
        }
    }
  
    return {
        dentroEdificio: dentroEdificio,
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