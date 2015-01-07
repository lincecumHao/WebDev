function panTo(id) {

	if (findSymbolById(id) != undefined || findSymbolById(id) != null) {
		MAP.setCenter(findSymbolById(id).getCenter());
		MAP.setZoom(18);
	}

}

function findSymbolById(id) {
	for (var i = 0; i < SYMBOL.length; i++) {
		var symbol = SYMBOL[i];
		if (symbol.getId() == id) {
			return symbol;
		}
	}
	return null;
}

function removeAll() {
	for (var i = 0; i < SYMBOL.length; i++) {
		var symbol = SYMBOL[i].symbol;
		symbol.setMap(null);
		delete SYMBOL[i];
	}
	SYMBOL = [];
}

function getPdf() {
	zAu.send(new zk.Event(zk.Widget.$('$map_canvas'), "onDraw", {
		'' : {
			'data' : {
				'nodeId' : ''
			}
		}
	}, {
		toServer : true
	}));
}