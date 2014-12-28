function FormatWKT(wkt){
	FormatWKT.prototype.WKT = wkt;
	this.init();
}

/**
 * 取得該WKT裡面所有LatLng
 * @returns {Array}
 */
FormatWKT.prototype.getLatLngArray = function(){
	return this.symbolToLatLng(this.getSymbols());
};

FormatWKT.prototype.symbolToLatLng = function(symbolAry){
	var latLngAry = [];
	if(this.isMulti()){
		for(var index = 0; index < symbolAry.length; index++){
			console.log(symbolAry);
			latLngAry.push(this.toLatLng(symbolAry[index][0]));
		}
	}else{
		
		//only one symbol.
		latLngAry = this.toLatLng(symbolAry);
	}
	return latLngAry;
};

/**
 * 把陣列裡面的xy轉為 google.maps.LatLng();
 * @param strAry
 * @returns {Array}
 */
FormatWKT.prototype.toLatLng = function(strAry){
	var coordAry = [];
	for(var i = 0; i < strAry.length; i++){
		var str = strAry[i];
		var coord = new google.maps.LatLng(str.y, str.x);
		coordAry.push(coord);
	}
	return coordAry;
};

/**
 * 用WKT lib 取得 WKT裡面所有的坐標
 * @returns
 */
FormatWKT.prototype.getSymbols = function(){
	var wkt = new Wkt.Wkt();
	wkt.read(this.WKT);
	return wkt.components;
};

FormatWKT.prototype.init = function(){
	if(this.hasZM()){
		this.WKT = this.removeZM();
	}
};

FormatWKT.prototype.removeZM = function(){
	return this.WKT.replace(" ZM", "").replace(/e\+/g, "").trim();
};

FormatWKT.prototype.getLastNum = function(){
	return (this.WKT.indexOf(")))") > -1 ? this.WKT.indexOf(")))") : this.WKT.indexOf("))"));
};

FormatWKT.prototype.isMulti = function(){
	return (this.WKT.indexOf("MULTI") > -1 ? true : false);
};

FormatWKT.prototype.hasZM = function(){
	return (this.WKT.indexOf("ZM") > -1 ? true : false);
};