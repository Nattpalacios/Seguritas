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
	
    return {
		agregarEdificio: agregarEdificio,
		traerEdificios: traerEdificios,
		traerEdificioPorNombre: traerEdificioPorNombre 
	}
})();