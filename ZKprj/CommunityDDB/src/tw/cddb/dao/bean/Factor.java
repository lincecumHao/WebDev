package tw.cddb.dao.bean;

import org.zkoss.json.JSONAware;

public class Factor implements JSONAware{
	
	private int id;
	private String wktGeom;
	private String featureLevel;

	public String getId() {
		return String.valueOf(id);
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGeom() {
		return wktGeom;
	}

	public void setGeom(String wktGeom) {
		this.wktGeom = wktGeom;
	}
	
	public String getFeatureLevel() {
		return featureLevel;
	}

	public void setFeatureLevel(String featureLevel) {
		this.featureLevel = featureLevel;
	}

	@Override
	public String toJSONString(){return null;};
}
