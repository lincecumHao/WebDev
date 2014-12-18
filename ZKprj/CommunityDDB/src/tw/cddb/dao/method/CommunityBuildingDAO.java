package tw.cddb.dao.method;

import java.util.Collection;

import tw.cddb.dao.bean.Building;

public interface CommunityBuildingDAO {

	public Collection<Building> getBuildingById(String id);
	
	
}
