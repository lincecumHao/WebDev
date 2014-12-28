package tw.cddb.dao.bean;

public class Factor {
	private int id;
	private String wktGeom;

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

}
