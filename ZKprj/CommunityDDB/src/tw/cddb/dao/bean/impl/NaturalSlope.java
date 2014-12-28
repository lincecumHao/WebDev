package tw.cddb.dao.bean.impl;

import tw.cddb.dao.bean.Factor;

public class NaturalSlope extends Factor {
	
	private int gid;
	private String zone;
	private String nid;
	private double twd97_x;
	private double twd97_y;
	private String pasaNum;
	private String nsId;
	private double gps_x_twd97;
	private double gps_y_twd97;
	private String pasaUpOrDown;
	private String avgSlope;
	private String deltaH;
	private String directRunoff;
	private String newDisaster;
	private String featureLevel;
	private String note;
	private String nsIdFull;

	public NaturalSlope(int gid, int id, String zone, String nid,
			double twd97_x, double twd97_y, String pasaNum, String nsId,
			double gps_x_twd97, double gps_y_twd97, String pasaUpOrDown,
			String avgSlope, String deltaH, String directRunoff,
			String newDisaster, String featureLevel, String note,
			String nsIdFull, String geom) {
		super();
		this.gid = gid;
		setId(id);
		this.zone = zone;
		this.nid = nid;
		this.twd97_x = twd97_x;
		this.twd97_y = twd97_y;
		this.pasaNum = pasaNum;
		this.nsId = nsId;
		this.gps_x_twd97 = gps_x_twd97;
		this.gps_y_twd97 = gps_y_twd97;
		this.pasaUpOrDown = pasaUpOrDown;
		this.avgSlope = avgSlope;
		this.deltaH = deltaH;
		this.directRunoff = directRunoff;
		this.newDisaster = newDisaster;
		this.featureLevel = featureLevel;
		this.note = note;
		this.nsIdFull = nsIdFull;
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

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
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

	public String getNsId() {
		return nsId;
	}

	public void setNsId(String nsId) {
		this.nsId = nsId;
	}

	public double getGps_x_twd97() {
		return gps_x_twd97;
	}

	public void setGps_x_twd97(double gps_x_twd97) {
		this.gps_x_twd97 = gps_x_twd97;
	}

	public double getGps_y_twd97() {
		return gps_y_twd97;
	}

	public void setGps_y_twd97(double gps_y_twd97) {
		this.gps_y_twd97 = gps_y_twd97;
	}

	public String getPasaUpOrDown() {
		return pasaUpOrDown;
	}

	public void setPasaUpOrDown(String pasaUpOrDown) {
		this.pasaUpOrDown = pasaUpOrDown;
	}

	public String getAvgSlope() {
		return avgSlope;
	}

	public void setAvgSlope(String avgSlope) {
		this.avgSlope = avgSlope;
	}

	public String getDeltaH() {
		return deltaH;
	}

	public void setDeltaH(String deltaH) {
		this.deltaH = deltaH;
	}

	public String getDirectRunoff() {
		return directRunoff;
	}

	public void setDirectRunoff(String directRunoff) {
		this.directRunoff = directRunoff;
	}

	public String getNewDisaster() {
		return newDisaster;
	}

	public void setNewDisaster(String newDisaster) {
		this.newDisaster = newDisaster;
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

	public String getNsIdFull() {
		return nsIdFull;
	}

	public void setNsIdFull(String nsIdFull) {
		this.nsIdFull = nsIdFull;
	}

}
