function Point(json) {
	Point.prototype.json = json;
	Point.prototype.id = this.json.id;

	Point.prototype.buildingIcon_level_1 = function() {
		var redRec = {
			path : 'M 0,0 5,0 5,5 0,5 z',
			fillColor : "red",
			strokeColor : "red"
		};
		return redRec;
	};

	Point.prototype.buildingIcon_level_2 = function() {
		var redRec = {
			path : 'M 0,0 5,0 5,5 0,5 z',
			fillColor : "yellow",
			strokeColor : "yellow"
		};
		return redRec;
	};

	Point.prototype.buildingIcon_level_3 = function() {
		var redRec = {
			path : 'M 0,0 5,0 5,5 0,5 z',
			fillColor : "green",
			strokeColor : "green"
		};
		return redRec;
	};

	Point.prototype.nsIcon_level_1 = function() {
		var redRec = {
			path : google.maps.SymbolPath.CIRCLE,
			fillColor : "red",
			strokeColor : "red",
			scale : 7
		};
		return redRec;
	};

	Point.prototype.nsIcon_level_2 = function() {
		var redRec = {
			path : google.maps.SymbolPath.CIRCLE,
			fillColor : "yellow",
			strokeColor : "yellow",
			scale : 7
		};
		return redRec;
	};

	Point.prototype.nsIcon_level_3 = function() {
		var redRec = {
			path : google.maps.SymbolPath.CIRCLE,
			fillColor : "green",
			strokeColor : "green",
			scale : 7
		};
		return redRec;
	};

	Point.prototype.getIcon = function(name, featureLevel) {
		var icon = null;
		if (name == "Building") {
			if (featureLevel == "一") {
				icon = this.buildingIcon_level_1();
			} else if (featureLevel == "二") {
				icon = this.buildingIcon_level_2();
			} else if (featureLevel == "三") {
				icon = this.buildingIcon_level_3();
			}
		} else if (name == "NaturalSlope") {
			if (featureLevel == "一") {
				icon = this.nsIcon_level_1();
			} else if (featureLevel == "二") {
				icon = this.nsIcon_level_2();
			} else if (featureLevel == "三") {
				icon = this.nsIcon_level_3();
			}
		}
		(icon.fillOpacity == undefined ? icon.fillOpacity = 1 : "");
		(icon.scale == undefined ? icon.scale = 3 : "");

		return icon;
	};

	Point.prototype.setIconByLevel = function() {
		this.symbol.setIcon(this
				.getIcon(this.json.name, this.json.featureLevel));
	};

	Point.prototype.setPosition = function() {
		var positions = new FormatWKT(this.json.geom).getLatLngArray();
		if (positions.length == 1) {
			this.symbol.setPosition(positions[0]);
		} else {
			this.symbol.setPosition(positions);
		}
	};

	Point.prototype.getCenter = function() {
		return this.symbol.getPosition();
	};

	Point.prototype.initialize = function() {
		var point = new google.maps.Marker({
			map : MAP,
//			animation : google.maps.Animation.DROP
		});
		return point;
	};

	Point.prototype.setupSymbol = function() {
		(this.json.geom != null ? this.setPosition() : "");
		(this.json.featureLevel != null ? this.setIconByLevel() : "");
	};

	this.symbol = this.initialize();
	this.setupSymbol();
}

Point.prototype = new Symbol();