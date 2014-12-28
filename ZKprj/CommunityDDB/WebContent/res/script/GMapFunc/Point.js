function Point(id, wkt) {

	Point.prototype.id = id;

	Point.prototype.getIcon = function(level, type) {
		var redRec = {
			path : 'M 0,0 5,0 5,5 0,5 z',
			fillColor : "red",
			fillOpacity : 1,
			scale : 1,
			strokeColor : "red",
			strokeWeight : 5
		};
		return redRec;
	};

	Point.prototype.setPosition = function(point) {
		var positions = new FormatWKT(wkt).getLatLngArray();
		if (positions.length == 1) {
			point.setPosition(positions[0]);
		} else {
			point.setPosition(positions);
		}
	};

	Point.prototype.getCenter = function() {
		return this.symbol.getPosition();
	};

	Point.prototype.initialize = function() {
		if (wkt != null) {
			var point = new google.maps.Marker({
				map : MAP,
				icon : this.getIcon("", ""),
				animation : google.maps.Animation.DROP
			});
			this.setPosition(point);
			return point;
		} else {
			return null;
		}
	};

	Point.prototype.symbol = this.initialize();
}

Point.prototype = new Symbol();