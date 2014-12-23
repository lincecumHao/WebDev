package tw.cddb.dao.bean;

public class Boundary {

	private int gid;
	private int id;
	private String name;
	private String wktGeom;

	public Boundary(int gid, int id, String name, String wktGeom) {
		super();
		this.gid = gid;
		this.id = id;
		this.name = name;
		this.wktGeom = wktGeom;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getId() {
		return String.valueOf(id);
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWktGeom() {
		return wktGeom;
	}

	public void setWktGeom(String wktGeom) {
		this.wktGeom = wktGeom;
	}
}
