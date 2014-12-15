google.maps.event.addDomListener(window, 'load', initialize);
var MAP;
function initialize() {

	var mapOptions = {
		center : new google.maps.LatLng(-34.397, 150.644),
		zoom : 8,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	var mapId = zk.Widget.$('$map_canvas').$n().id;
	this.MAP = new google.maps.Map(document.getElementById(mapId), mapOptions);
}