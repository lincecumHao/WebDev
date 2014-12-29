package tw.cddb.dao.bean.impl;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.json.JSONObject;

import tw.cddb.dao.bean.Factor;

public class Building extends Factor{

	private int gid;
	private String zone;
	private String bid;
	private double twd97_x;
	private double twd97_y;
	private String pasaNum;
	private String buildId;
	private String address;
	private int floorOnTheGround;
	private int floorUnderGround;
	private String typeBuild;
	private String typeRoad;
	private String pavementFeature;
	private String buildingFacadesFeature;
	private String buildingDandwFeature;
	private String beamsCrack;
	private String differentalSettlement;
	private String note;
	private String bidFull;
	
	public Building(int gid, int id, String zone, String bid, double twd97_x,
			double twd97_y, String pasaNum, String buildId, String address,
			int floorOnTheGround, int floorUnderGround, String typeBuild,
			String typeRoad, String pavementFeature,
			String buildingFacadesFeature, String buildingDandwFeature,
			String beamsCrack, String differentalSettlement,
			String featureLevel, String note, String bidFull, String geom) {
		super();
		this.gid = gid;
		setId(id);
		this.zone = zone;
		this.bid = bid;
		this.twd97_x = twd97_x;
		this.twd97_y = twd97_y;
		this.pasaNum = pasaNum;
		this.buildId = buildId;
		this.address = address;
		this.floorOnTheGround = floorOnTheGround;
		this.floorUnderGround = floorUnderGround;
		this.typeBuild = typeBuild;
		this.typeRoad = typeRoad;
		this.pavementFeature = pavementFeature;
		this.buildingFacadesFeature = buildingFacadesFeature;
		this.buildingDandwFeature = buildingDandwFeature;
		this.beamsCrack = beamsCrack;
		this.differentalSettlement = differentalSettlement;
		setFeatureLevel(featureLevel);
		this.note = note;
		this.bidFull = bidFull;
		setGeom(geom);
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public double getTwd97_x() {
		return twd97_x;
	}

	public void setTwd97_x(double twd97_x) {
		this.twd97_x = twd97_x;
	}

	public double getTwd97_y() {
		return twd97_y;
	}

	public void setTwd97_y(double twd97_y) {
		this.twd97_y = twd97_y;
	}

	public String getPasaNum() {
		return pasaNum;
	}

	public void setPasaNum(String pasaNum) {
		this.pasaNum = pasaNum;
	}

	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getFloorOnTheGround() {
		return floorOnTheGround;
	}

	public void setFloorOnTheGround(int floorOnTheGround) {
		this.floorOnTheGround = floorOnTheGround;
	}

	public int getFloorUnderGround() {
		return floorUnderGround;
	}

	public void setFloorUnderGround(int floorUnderGround) {
		this.floorUnderGround = floorUnderGround;
	}

	public String getTypeBuild() {
		return typeBuild;
	}

	public void setTypeBuild(String typeBuild) {
		this.typeBuild = typeBuild;
	}

	public String getTypeRoad() {
		return typeRoad;
	}

	public void setTypeRoad(String typeRoad) {
		this.typeRoad = typeRoad;
	}

	public String getPavementFeature() {
		return pavementFeature;
	}

	public void setPavementFeature(String pavementFeature) {
		this.pavementFeature = pavementFeature;
	}

	public String getBuildingFacadesFeature() {
		return buildingFacadesFeature;
	}

	public void setBuildingFacadesFeature(String buildingFacadesFeature) {
		this.buildingFacadesFeature = buildingFacadesFeature;
	}

	public String getBuildingDandwFeature() {
		return buildingDandwFeature;
	}

	public void setBuildingDandwFeature(String buildingDandwFeature) {
		this.buildingDandwFeature = buildingDandwFeature;
	}

	public String getBeamsCrack() {
		return beamsCrack;
	}

	public void setBeamsCrack(String beamsCrack) {
		this.beamsCrack = beamsCrack;
	}

	public String getDifferentalSettlement() {
		return differentalSettlement;
	}

	public void setDifferentalSettlement(String differentalSettlement) {
		this.differentalSettlement = differentalSettlement;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getBidFull() {
		return bidFull;
	}

	public void setBidFull(String bidFull) {
		this.bidFull = bidFull;
	}
	
	public String toJSONString(){
		Map<String, String> map = new HashMap<>();
		map.put("id", getId());
		map.put("featureLevel", getFeatureLevel());
		map.put("geom", getGeom());
		return JSONObject.toJSONString(map);
	}

}
