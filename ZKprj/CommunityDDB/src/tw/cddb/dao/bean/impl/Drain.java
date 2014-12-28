package tw.cddb.dao.bean.impl;

import tw.cddb.dao.bean.Factor;

public class Drain extends Factor{

	private int gid;
	private String zone;
	private String did;
	private double twd97_x;
	private double twd97_y;
	private String pasaNum;
	private String drId;
	private String drType;
	private String drMaterial;
	private String drStoppage;
	private String drCrack;
	private String drEndDischarge;
	private String sedWeirAndDetentionpond;
	private String featureLevel;
	private String note;
	private String drIdFull;

	public Drain(int gid, int id, String zone, String did, double twd97_x,
			double twd97_y, String pasaNum, String drId, String drType,
			String drMaterial, String drStoppage, String drCrack,
			String drEndDischarge, String sedWeirAndDetentionpond,
			String featrueLevel, String note, String drIdFull, String geom) {
		super();
		this.gid = gid;
		setId(id);
		this.zone = zone;
		this.did = did;
		this.twd97_x = twd97_x;
		this.twd97_y = twd97_y;
		this.pasaNum = pasaNum;
		this.drId = drId;
		this.drType = drType;
		this.drMaterial = drMaterial;
		this.drStoppage = drStoppage;
		this.drCrack = drCrack;
		this.drEndDischarge = drEndDischarge;
		this.sedWeirAndDetentionpond = sedWeirAndDetentionpond;
		this.featureLevel = featrueLevel;
		this.note = note;
		this.drIdFull = drIdFull;
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

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
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

	public String getDrId() {
		return drId;
	}

	public void setDrId(String drId) {
		this.drId = drId;
	}

	public String getDrType() {
		return drType;
	}

	public void setDrType(String drType) {
		this.drType = drType;
	}

	public String getDrMaterial() {
		return drMaterial;
	}

	public void setDrMaterial(String drMaterial) {
		this.drMaterial = drMaterial;
	}

	public String getDrStoppage() {
		return drStoppage;
	}

	public void setDrStoppage(String drStoppage) {
		this.drStoppage = drStoppage;
	}

	public String getDrCrack() {
		return drCrack;
	}

	public void setDrCrack(String drCrack) {
		this.drCrack = drCrack;
	}

	public String getDrEndDischarge() {
		return drEndDischarge;
	}

	public void setDrEndDischarge(String drEndDischarge) {
		this.drEndDischarge = drEndDischarge;
	}

	public String getSedWeirAndDetentionpond() {
		return sedWeirAndDetentionpond;
	}

	public void setSedWeirAndDetentionpond(String sedWeirAndDetentionpond) {
		this.sedWeirAndDetentionpond = sedWeirAndDetentionpond;
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

	public String getDrIdFull() {
		return drIdFull;
	}

	public void setDrIdFull(String drIdFull) {
		this.drIdFull = drIdFull;
	}

}
