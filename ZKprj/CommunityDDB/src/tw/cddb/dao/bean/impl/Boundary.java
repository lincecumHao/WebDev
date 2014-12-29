package tw.cddb.dao.bean.impl;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.json.JSONObject;

import tw.cddb.dao.bean.Factor;

public class Boundary extends Factor{

	private int gid;
	private String name;

	public Boundary(int gid, int id, String name, String wktGeom) {
		super();
		this.gid = gid;
		setId(id);
		this.name = name;
		setGeom(wktGeom);
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toJSONString(){
		Map<String, String> map = new HashMap<>();
		map.put("id", getId());
		map.put("name", getName());
		map.put("geom", getGeom());
		return JSONObject.toJSONString(map);
	}

}
