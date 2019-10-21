apiclient = (function(){

    return {
		agregarEdificio: function(edificio){
        			$.post( "/edificios", edificio,function( data ) {
                      });
        		}
	}
})();