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
			var retorno = guardarEdificioParaTabla(data);
			return retorno;
		  });
		//console.log("Aqui va la info");
		//console.log(info);
		//return info;
	}

	var guardarEdificioParaTabla = function(edificio){
        console.log("Aqui entre");
		var edificioTabla = edificio;
		return edificioTabla;
    }
	
    return {
		agregarEdificio: agregarEdificio,
		traerEdificios: traerEdificios,
		traerEdificioPorNombre: traerEdificioPorNombre,
		traerEdificioPorNombre2: traerEdificioPorNombre2
	}
})();