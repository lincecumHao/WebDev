package tw.cddb.dao.bean;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.json.JSONAware;
import org.zkoss.json.JSONObject;

public class Factor implements JSONAware{
	
	private int id;
	private String wktGeom;
	private String featureLevel;
	public String name;
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}

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
	public String toJSONString(){
		Map<String, String> map = new HashMap<>();
		map.put("id", getId());
		map.put("name", getName());
		map.put("featureLevel", getFeatureLevel());
		map.put("geom", getGeom());
		return JSONObject.toJSONString(map);
	}
}
