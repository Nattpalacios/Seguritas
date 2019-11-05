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

    var generarTabla = function() {
        alert("Hola");
        /*var body = document.getElementsByTagName("body")[0];
        var tabla   = document.createElement("table");
        var tblBody = document.createElement("tbody");
        
        for (var i = 0; i < 2; i++) {
            var hilera = document.createElement("tr");
        
            for (var j = 0; j < 2; j++) {
                var celda = document.createElement("td");
                var textoCelda = document.createTextNode("celda en la hilera "+i+", columna "+j);
                celda.appendChild(textoCelda);
                hilera.appendChild(celda);
            }
            tblBody.appendChild(hilera);
        }
        tabla.appendChild(tblBody);
        body.appendChild(tabla);
        tabla.setAttribute("border", "2");*/
    }
  
    return {
      mostrarEdificio: function(){
        $('#edificios').empty();
        var nombre = $('#inputEdificio').val();
        if(nombre == ""){
            this.generarTabla();
        }else{
            apiclient.traerEdificioPorNombre(nombre,mostrEdificio);
        }
      },
      generarTabla: generarTabla
    };
  })();