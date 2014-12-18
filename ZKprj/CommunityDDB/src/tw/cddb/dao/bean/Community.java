package tw.cddb.dao.bean;


public class Community {
	
	private int id;
	private String name;
	private CommuntiyBuildings communtiyBuildings;
	private CommunityBoundary communityBoundary;
	
	public CommuntiyBuildings getCommuntiyBuildings() {
		return communtiyBuildings;
	}

	public void setCommuntiyBuildings(CommuntiyBuildings communtiyBuildings) {
		this.communtiyBuildings = communtiyBuildings;
	}

	public CommunityBoundary getCommunityBoundary() {
		return communityBoundary;
	}

	public void setCommunityBoundary(CommunityBoundary communityBoundary) {
		this.communityBoundary = communityBoundary;
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
