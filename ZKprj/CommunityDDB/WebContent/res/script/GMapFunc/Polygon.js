function Polygon(json) {

	Polygon.prototype.json = json;
	Polygon.prototype.id = this.json.id;
	
	Polygon.prototype.setPath = function(polygon){
		var bounds = new FormatWKT(this.json.geom).getLatLngArray();
		if(bounds.length == 1){
			polygon.setPath(bounds[0]);
		}else{
			polygon.setPaths(bounds);
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

	Polygon.prototype.initialize = function() {
		if (this.json.geom != null) {
			var polygon = new google.maps.Polygon({
				strokeColor : '#FF0000',
				strokeOpacity : 1,
				strokeWeight : 2,
				fillColor : '#FFFFFF',
				fillOpacity : 0,
				map : MAP
			});
			this.setPath(polygon);
			return polygon;
		} else {
			return null;
		}
	};
	
	Polygon.prototype.symbol = this.initialize();
}

Polygon.prototype = new Symbol();