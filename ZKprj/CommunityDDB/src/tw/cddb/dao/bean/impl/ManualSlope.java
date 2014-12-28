package tw.cddb.dao.bean.impl;

import tw.cddb.dao.bean.Factor;

public class ManualSlope extends Factor {

	private int gid;
	private String zone;
	private String mid;
	private double twd97_x;
	private double twd97_y;
	private String pasaNum;
	private String mmsId;
	private String mmsType;
	private String mmsHeight;
	private String maxSlopeUp;
	private String maxSlopeDown;
	private String loadingUp;
	private String mmsTypeUse;
	private String backfillsScour;
	private String wallDeformatic;
	private String drainage;
	private String footScourAndCavern;
	private String faceCrack;
	private String materialCollapse;
	private String featureLevel;
	private String note;
	private String earthAnchorNote;
	private String mmsIdFull;

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

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
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

	public String getMmsId() {
		return mmsId;
	}

	public void setMmsId(String mmsId) {
		this.mmsId = mmsId;
	}

	public String getMmsType() {
		return mmsType;
	}

	public void setMmsType(String mmsType) {
		this.mmsType = mmsType;
	}

	public String getMmsHeight() {
		return mmsHeight;
	}

	public void setMmsHeight(String mmsHeight) {
		this.mmsHeight = mmsHeight;
	}

	public String getMaxSlopeUp() {
		return maxSlopeUp;
	}

	public void setMaxSlopeUp(String maxSlopeUp) {
		this.maxSlopeUp = maxSlopeUp;
	}

	public String getMaxSlopeDown() {
		return maxSlopeDown;
	}

	public void setMaxSlopeDown(String maxSlopeDown) {
		this.maxSlopeDown = maxSlopeDown;
	}

	public String getLoadingUp() {
		return loadingUp;
	}

	public void setLoadingUp(String loadingUp) {
		this.loadingUp = loadingUp;
	}

	public String getMmsTypeUse() {
		return mmsTypeUse;
	}

	public void setMmsTypeUse(String mmsTypeUse) {
		this.mmsTypeUse = mmsTypeUse;
	}

	public String getBackfillsScour() {
		return backfillsScour;
	}

	public void setBackfillsScour(String backfillsScour) {
		this.backfillsScour = backfillsScour;
	}

	public String getWallDeformatic() {
		return wallDeformatic;
	}

	public void setWallDeformatic(String wallDeformatic) {
		this.wallDeformatic = wallDeformatic;
	}

	public String getDrainage() {
		return drainage;
	}

	public void setDrainage(String drainage) {
		this.drainage = drainage;
	}

	public String getFootScourAndCavern() {
		return footScourAndCavern;
	}

	public void setFootScourAndCavern(String footScourAndCavern) {
		this.footScourAndCavern = footScourAndCavern;
	}

	public String getFaceCrack() {
		return faceCrack;
	}

	public void setFaceCrack(String faceCrack) {
		this.faceCrack = faceCrack;
	}

	public String getMaterialCollapse() {
		return materialCollapse;
	}

	public void setMaterialCollapse(String materialCollapse) {
		this.materialCollapse = materialCollapse;
	}

	public String getFeatureLevel() {
		return featureLevel;
	}

	public void setFeatureLevel(String featureLevel) {
		this.featureLevel = featureLevel;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getEarthAnchorNote() {
		return earthAnchorNote;
	}

	public void setEarthAnchorNote(String earthAnchorNote) {
		this.earthAnchorNote = earthAnchorNote;
	}

	public String getMmsIdFull() {
		return mmsIdFull;
	}

	public void setMmsIdFull(String mmsIdFull) {
		this.mmsIdFull = mmsIdFull;
	}

	public ManualSlope(int gid, int id, String zone, String mid,
			double twd97_x, double twd97_y, String pasaNum, String mmsId,
			String mmsType, String mmsHeight, String maxSlopeUp,
			String maxSlopeDown, String loadingUp, String mmsTypeUse,
			String backfillsScour, String wallDeformatic, String drainage,
			String footScourAndCavern, String faceCrack,
			String materialCollapse, String featureLevel, String note,
			String earthAnchorNote, String mmsIdFull, String geom) {
		super();
		this.gid = gid;
		setId(id);
		this.zone = zone;
		this.mid = mid;
		this.twd97_x = twd97_x;
		this.twd97_y = twd97_y;
		this.pasaNum = pasaNum;
		this.mmsId = mmsId;
		this.mmsType = mmsType;
		this.mmsHeight = mmsHeight;
		this.maxSlopeUp = maxSlopeUp;
		this.maxSlopeDown = maxSlopeDown;
		this.loadingUp = loadingUp;
		this.mmsTypeUse = mmsTypeUse;
		this.backfillsScour = backfillsScour;
		this.wallDeformatic = wallDeformatic;
		this.drainage = drainage;
		this.footScourAndCavern = footScourAndCavern;
		this.faceCrack = faceCrack;
		this.materialCollapse = materialCollapse;
		this.featureLevel = featureLevel;
		this.note = note;
		this.earthAnchorNote = earthAnchorNote;
		this.mmsIdFull = mmsIdFull;
		setGeom(geom);
	}

}
