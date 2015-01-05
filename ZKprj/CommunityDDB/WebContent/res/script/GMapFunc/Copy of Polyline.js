function Polyline(json) {
	Polyline.prototype.json = json;
	Polyline.prototype.id = this.json.id;

	Polyline.prototype.drainIcon_level_1 = function() {
		var icons = [ {
			icon : {
				path : 'M 0,-2 0,2',
				strokeOpacity : 1,
				strokeColor : "red",
				scale : 3
			},
			offset : '0',
			repeat : '20px'
		} ];
		return icons;
	};

	Polyline.prototype.drainIcon_level_2 = function() {
		var icons = [ {
			icon : {
				path : 'M 0,-2 0,2',
				strokeOpacity : 1,
				strokeColor : "yellow",
				scale : 3
			},
			offset : '0',
			repeat : '20px'
		} ];
		return icons;
	};

	Polyline.prototype.drainIcon_level_3 = function() {
		var icons = [ {
			icon : {
				path : 'M 0,-2 0,2',
				strokeOpacity : 1,
				strokeColor : "green",
				scale : 3
			},
			offset : '0',
			repeat : '20px'
		} ];
		return icons;
	};

	Polyline.prototype.msIcon_level_1 = function() {
		var icons = [ {
			icon : {
				path : google.maps.SymbolPath.CIRCLE,
				fillColor : "red",
				strokeOpacity : 1,
				fillOpacity : 1,
				strokeColor : "red",
				scale : 4,
			},
			offset : '0%',
			repeat : '60px'
		} ];
		return icons;
	};

	Polyline.prototype.msIcon_level_2 = function() {
		var icons = [ {
			icon : {
				path : google.maps.SymbolPath.CIRCLE,
				fillColor : "yellow",
				strokeOpacity : 1,
				fillOpacity : 1,
				strokeColor : "yellow",
				scale : 4,
			},
			offset : '0%',
			repeat : '60px'
		} ];
		return icons;
	};

	Polyline.prototype.msIcon_level_3 = function() {
		var icons = [ {
			icon : {
				path : google.maps.SymbolPath.CIRCLE,
				fillColor : "green",
				strokeOpacity : 1,
				fillOpacity : 1,
				strokeColor : "green",
				scale : 4,
			},
			offset : '0%',
			repeat : '60px'
		} ];
		return icons;
	};

	Polyline.prototype.getIcon = function(name, featureLevel) {
		var icon = null;
		if (name == "Drain") {
			if (featureLevel == "一") {
				icon = this.drainIcon_level_1();
			} else if (featureLevel == "二") {
				icon = this.drainIcon_level_2();
			} else if (featureLevel == "三") {
				icon = this.drainIcon_level_3();
			}
		} else if (name == "ManualSlope") {
			if (featureLevel == "一") {
				icon = this.msIcon_level_1();
			} else if (featureLevel == "二") {
				icon = this.msIcon_level_2();
			} else if (featureLevel == "三") {
				icon = this.msIcon_level_3();
			}
		}
		return icon;
	};
	
	Polyline.prototype.setDefaultStrokeColor = function(){
		var featureLevel = this.json.featureLevel;
		if (featureLevel == "一") {
			return "red";
		} else if (featureLevel == "二") {
			return "yellow";
		} else if (featureLevel == "三") {
			return "green";
		}
	};

	Polyline.prototype.setIconByLevel = function() {
		this.symbol.set("icons", this.getIcon(this.json.name,
				this.json.featureLevel));
	};

	Polyline.prototype.setPath = function() {
		var bounds = new FormatWKT(this.json.geom).getLatLngArray();
		if (bounds.length == 1) {
			this.symbol.setPath(bounds[0]);
		} else {
			this.symbol.setPath(bounds);
		}
	};

	Polyline.prototype.getCenter = function() {
		var bounds = new google.maps.LatLngBounds();
		var path = this.symbol.getPath().getArray();
		for (var i = 0; i < path.length; i++) {
			bounds.extend(path[i]);
		}
		return bounds.getCenter();
	};

	Polyline.prototype.initialize = function() {
		var polyline = new google.maps.Polyline({
			strokeOpacity : (this.json.name == "ManualSlope" ? 1 : 0),
			strokeColor : this.setDefaultStrokeColor(),
			map : MAP
		});
		return polyline;
	};

	Polyline.prototype.setupSymbol = function() {
		(this.json.geom != null ? this.setPath() : "");
		(this.json.featureLevel != null ? this.setIconByLevel() : "");
	};

	Polyline.prototype.symbol = this.initialize();
	this.setupSymbol();
}

Polyline.prototype = new Symbol();