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

/**
 * TODO Refactor as a class
 * @param wkt
 * @returns {Array}
 */
function formatWKT(wkt){
	coordsAry = [];
	
	var name = wkt.substring(0, wkt.indexOf("("));
	console.log("name: " + name);
	
	var mulitPoly = wkt.split(")),((");
	console.log(wkt);
	
	if(mulitPoly.length == 1){
		//mean only 1 polygon
		
		var start = wkt.lastIndexOf("(") + 1;
		var end = wkt.indexOf(")");

		wkt = getWKTBody(wkt, start, end);
		
		coordsAry.push(getPointAry(wkt));
	}else{
		//Multi polygon
		
		var start = wkt.lastIndexOf("(((") + 3;
		var end = wkt.indexOf(")))");

		//23,123)),((
		wkt = getWKTBody(wkt, start, end);
		var coords = wkt.split(")),((");
		
		for(var i = 0; i < coords.length; i++){
			coordsAry.push(getPointAry(coords[i]));
		}
	}
	return coordsAry;
}

function getWKTBody(wkt, start, end){
	return wkt.substring(start, end);
}

/**
 * 23 123, 24 124
 * @param wkt
 */
function getPointAry(wkt){
	var pointAry = [];
	var pointInfo = wkt.split(/[,]/);

	for(var flag = 0; flag < pointInfo.length; flag++){
		pointAry.push(getPoints(pointInfo[flag].trim()));
	}
	return pointAry;
}

/**
 * 23.123 123.456
 * @param wktCoords
 * @return google.maps.LatLng
 */
function getPoints(wktCoords){
	var temp = wktCoords.split(/\s+/);
	return new google.maps.LatLng(temp[1], temp[0]);
}
