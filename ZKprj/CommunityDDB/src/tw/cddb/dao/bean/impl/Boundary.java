package tw.cddb.dao.bean.impl;

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

}
