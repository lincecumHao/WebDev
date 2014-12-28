package tw.cddb.ctrl;

import java.util.Collection;

import tw.cddb.dao.bean.Boundary;
import tw.cddb.dao.bean.Building;
import tw.cddb.dao.bean.Community;
import tw.cddb.dao.bean.CommuntiyBuildings;
import tw.cddb.dao.bean.CommuntiyDrains;
import tw.cddb.dao.bean.CommuntiyManualSlope;
import tw.cddb.dao.bean.CommuntiyNaturalSlope;
import tw.cddb.dao.bean.Drain;
import tw.cddb.dao.bean.ManualSlope;
import tw.cddb.dao.bean.NaturalSlope;
import tw.cddb.dao.method.CommunityBoundaryDAO;
import tw.cddb.dao.method.CommunityBuildingDAO;
import tw.cddb.dao.method.CommunityDrainDAO;
import tw.cddb.dao.method.CommunityManualSlopeDAO;
import tw.cddb.dao.method.CommunityNaturalSlopeDAO;
import tw.cddb.dao.model.DAOFactory;

public class CommunityInfoSet {

	private Community community;
	private DAOFactory postgreDAO;

	public CommunityInfoSet(Community community) {

		this.community = community;
		// create the required DAO Factory
		this.postgreDAO = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

		setAllInfo();
	}

	private void setAllInfo() {
		setBoundary();
		setBuilding();
		setDrain();
		setManualSlope();
		setNaturalSlope();
	}

	private void setNaturalSlope() {
		// Create a DAO
		CommunityNaturalSlopeDAO cbDAO = postgreDAO
				.getCommunityNaturalSlopeDAO();

		// get data from server.
		Collection<NaturalSlope> list = cbDAO.getNaturalSlopeById(community
				.getId());

		// set data to community.
		community.setCommuntiyNaturalSlope(new CommuntiyNaturalSlope(list));

	}

	private void setManualSlope() {
		// Create a DAO
		CommunityManualSlopeDAO cbDAO = postgreDAO
				.getCommunityManualSlopeDAO();

		// get data from server.
		Collection<ManualSlope> list = cbDAO.getManualSlopeById(community
				.getId());

		// set data to community.
		community.setCommuntiyManualSlope(new CommuntiyManualSlope(list));

	}

	private void setDrain() {
		// Create a DAO
		CommunityDrainDAO cbDAO = postgreDAO.getCommunityDrainDAO();

		// get data from server.
		Collection<Drain> list = cbDAO.getDrainById(community.getId());

		// set data to community.
		community.setCommuntiyDrains(new CommuntiyDrains(list));

	}

	private void setBuilding() {

		// Create a DAO
		CommunityBuildingDAO cbDAO = postgreDAO.getCommunityBuildingDAO();

		// get data from server.
		Collection<Building> list = cbDAO.getBuildingById(community.getId());

		// set data to community.
		community.setCommuntiyBuildings(new CommuntiyBuildings(list));

	}

	private void setBoundary() {

		// Create a DAO
		CommunityBoundaryDAO cbDAO = postgreDAO.getCommunityBoundDAO();

		// get data from server.
		Boundary boundary = cbDAO.getCommunityBoudnaryById(this.community
				.getId());
		System.out.println(boundary.getId());
		
		// set data to community.
		community.setCommunityBoundary(boundary);

	}
}
