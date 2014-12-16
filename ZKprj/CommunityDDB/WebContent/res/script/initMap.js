google.maps.event.addDomListener(window, 'load', initialize);
var MAP;
function initialize() {
	var mapOptions = {
		center : new google.maps.LatLng(25.080899, 121.471959),
		zoom : 11,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	var mapId = zk.Widget.$('$map_canvas').$n().id;
	MAP = new google.maps.Map(document.getElementById(mapId), mapOptions);
}