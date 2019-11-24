apiclient = (function(){
	var agregarEdificio = function(edificio){
		$.post( "/edificios/", edificio,function( data ) {
		  });
	}
	var traerEdificios = function(callback){
		$.get( "/seguritas/edificios/", function( data ) {
			callback(data);
		  });
	}
	var traerEdificioPorNombre = function(name,callback){
		$.get( "/seguritas/edificios/"+name, function( data ) {
			callback(data);
		  });
	}
	var traerEdificioPorNombre2 = function(name){
		//var info;
		$.get( "/seguritas/edificios/"+name, function( data ) {
			//info = data;
			mostrarEdif.guardarEdificioParaTabla(data);
		  });
		//console.log("Aqui va la info");
		//console.log(info);
		//return info;
	}
	
    return {
		agregarEdificio: agregarEdificio,
		traerEdificios: traerEdificios,
		traerEdificioPorNombre: traerEdificioPorNombre,
		traerEdificioPorNombre2: traerEdificioPorNombre2
	}
})();