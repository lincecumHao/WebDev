package tw.cddb.dao.method.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import tw.cddb.dao.bean.impl.Building;
import tw.cddb.dao.method.CommunityBuildingDAO;
import tw.cddb.dao.model.impl.PostgreDAOFactory;

public class PostgreCommunityBuildingDAO implements CommunityBuildingDAO{

	@Override
	public Collection<Building> getBuildingById(String id) {
		List<Building> resultList = new ArrayList<Building>();
		Connection con = PostgreDAOFactory.createConnection();
		String sql = "SELECT *, ST_AsText(geom) as wktgeom FROM \"140_community_building\" ";
		sql += "WHERE id = " + id + ";";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				resultList.add(new Building(rs.getInt("gid"), 
						rs.getInt("id"), 
						rs.getString("zone"), 
						rs.getString("bid"), 
						rs.getDouble("twd97_x"),
						rs.getDouble("twd97_y"),
						rs.getString("pasa_num"),
						rs.getString("build_id"),
						rs.getString("address"),
						rs.getInt("floor_on_the_ground"),
						rs.getInt("floor_under_ground"),
						rs.getString("type_build"),
						rs.getString("type_road"),
						rs.getString("pavement_feature"),
						rs.getString("building_facades_feature"),
						rs.getString("building_dandw_feature"),
						rs.getString("beams_crack"),
						rs.getString("differental_settlement"),
						rs.getString("feature_level"),
						rs.getString("note"),
						rs.getString("bid_full"),
						rs.getString("wktgeom")				
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
