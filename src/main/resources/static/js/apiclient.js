apiclient = (function(){

    return {
		agregarEdificio: function(edificio){
        			$.post( "/edificios", edificio,function( data ) {
                      });
		},
		traerEdificioPorNombre: function(name,callback){
			$.get( "/seguritas/edificios/"+name, function( data ) {
                callback(data);
              });
		}
	}
})();