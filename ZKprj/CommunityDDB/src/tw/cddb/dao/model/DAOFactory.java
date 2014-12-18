package tw.cddb.dao.model;

import tw.cddb.dao.method.CommunityBoundaryDAO;
import tw.cddb.dao.method.CommunityBuildingDAO;
import tw.cddb.dao.method.CommunityDAO;
import tw.cddb.dao.model.impl.PostgreDAOFactory;

public abstract class DAOFactory {

	// List of DAO types supported by the factory
	public static final int POSTGRESQL = 1;

	// There will be a method for each DAO that can be
	// created. The concrete factories will have to
	// implement these methods.
	public abstract CommunityBoundaryDAO getCommunityBoundDAO();
	public abstract CommunityBuildingDAO getCommunityBuildingDAO();
	public abstract CommunityDAO getCommunityDAO();

	public static DAOFactory getDAOFactory(int whichFactory) {

		switch (whichFactory) {
		case POSTGRESQL:
			return new PostgreDAOFactory();
		default:
			return null;
		}
	}
}
