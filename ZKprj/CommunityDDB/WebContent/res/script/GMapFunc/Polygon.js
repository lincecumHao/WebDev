function Polygon(id, wkt) {

	Polygon.prototype.id = id;

	Polygon.prototype.initialize = function() {
		if (wkt != null) {
			return new google.maps.Polygon({
				strokeColor : '#FF0000',
				strokeOpacity : 0.8,
				strokeWeight : 2,
				fillColor : '#FF0000',
				fillOpacity : 0.35,
				map : MAP
			});
		} else {
			return null;
		}
	};
	
	Polygon.prototype.setPath = function(){
		var bounds = formatWKT(wkt);
		if(bounds.length == 1){
			this.symbol.setPath(bounds[0]);
		}else{
			this.symbol.setPaths(bounds);
		}
	};
	
	Polygon.prototype.getCenter = function(){
		var bounds = new google.maps.LatLngBounds();
		var path = this.symbol.getPath().getArray();
		for(var i = 0; i < path.length; i++){
			bounds.extend(path[i]);
		}
		return bounds.getCenter();
	};

	Polygon.prototype.symbol = this.initialize();
	
	this.setPath();
}

Polygon.prototype = new Symbol();