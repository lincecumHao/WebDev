function formatWKT(wkt){
	var coords = [];
	var start = wkt.lastIndexOf("(") + 1;
	var end = wkt.indexOf(")");
	wkt = wkt.substring(start, end);
	var info = wkt.split(",");
	for(var flag = 0; flag < info.length; flag++){
		var temp = info[flag].split(" ");
		coords.push(new google.maps.LatLng(temp[1], temp[0]));
	}
	return coords;
}