//save all symbol on the map;
var SYMBOL = [];

function panTo(id){
	MAP.setCenter(findSymbolById(id).getCenter());
	MAP.setZoom(18);
}

function findSymbolById(id){
	for(var i = 0; i < SYMBOL.length; i++){
		var symbol = SYMBOL[i];
		if(symbol.getId() == id){
			return symbol;
		}
	}
	return null;
}

function removeAll(){
	for(var i = 0; i < SYMBOL.length; i++){
		var symbol = SYMBOL[i];
		symbol.symbol.setMap(null);
		delete SYMBOL[i];
	}
	SYMBOL = [];
}