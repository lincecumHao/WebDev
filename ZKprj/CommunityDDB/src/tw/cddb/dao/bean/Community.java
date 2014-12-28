package tw.cddb.dao.bean;

public class Community {

	private int id;
	private String name;
	private Boundary communityBoundary;
	private CommuntiyBuildings communtiyBuildings;
	private CommuntiyDrains communtiyDrains;
	private CommuntiyManualSlope communtiyManualSlope;
	private CommuntiyNaturalSlope communtiyNaturalSlope;

	public CommuntiyManualSlope getCommuntiyManualSlope() {
		return communtiyManualSlope;
	}

	public void setCommuntiyManualSlope(
			CommuntiyManualSlope communtiyManualSlope) {
		this.communtiyManualSlope = communtiyManualSlope;
	}

	public CommuntiyNaturalSlope getCommuntiyNaturalSlope() {
		return communtiyNaturalSlope;
	}

	public void setCommuntiyNaturalSlope(
			CommuntiyNaturalSlope communtiyNaturalSlope) {
		this.communtiyNaturalSlope = communtiyNaturalSlope;
	}

	
	public CommuntiyBuildings getCommuntiyBuildings() {
		return communtiyBuildings;
	}

	public void setCommuntiyBuildings(CommuntiyBuildings communtiyBuildings) {
		this.communtiyBuildings = communtiyBuildings;
	}

	public Boundary getCommunityBoundary() {
		return communityBoundary;
	}

	public void setCommunityBoundary(Boundary communityBoundary) {
		this.communityBoundary = communityBoundary;
	}

	public CommuntiyDrains getCommuntiyDrains() {
		return communtiyDrains;
	}

	public void setCommuntiyDrains(CommuntiyDrains communtiyDrains) {
		this.communtiyDrains = communtiyDrains;
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

	public Community(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
