//save all symbol on the map;
var SYMBOL = [];

function Symbol() {

	this.id;

	this.getId = function() {
		return this.id;
	};

	this.initialize = function() {};

//	this.symbol = this.initialize();
}

function CreateSymbol(json){
	this.json = json;
	
	this.parse();
}

CreateSymbol.prototype.parse = function(){
	for(var i = 0; i < this.json.length; i++){
		var arg = this.json[i];
		var geom = arg.geom;
		if(geom.indexOf("POLYGON") > -1){
			SYMBOL.push(new Polygon(arg));
		}else if(geom.indexOf("POINT") > -1){
			SYMBOL.push(new Point(arg));
		}else if(geom.indexOf("LINE") > -1){
			SYMBOL.push(new Polyline(arg));
			console.log(SYMBOL);
		}
	}
};
