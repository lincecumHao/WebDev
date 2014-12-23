package tw.cddb.dao.method.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tw.cddb.dao.bean.NaturalSlope;
import tw.cddb.dao.method.CommunityNaturalSlopeDAO;
import tw.cddb.dao.model.impl.PostgreDAOFactory;

public class PostgreCommunityNaturalSlopeDAO implements
		CommunityNaturalSlopeDAO {

	@Override
	public ArrayList<NaturalSlope> getNaturalSlopeById(String id) {
		ArrayList<NaturalSlope> resultList = new ArrayList<NaturalSlope>();
		Connection con = PostgreDAOFactory.createConnection();
		String sql = "SELECT *, ST_AsText(geom) as wktgeom FROM \"140_community_naturalslope\" ";
		sql += "WHERE id = " + id + ";";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				resultList.add(new NaturalSlope(rs.getInt("gid"), 
						rs.getInt("id"), 
						rs.getString("zone"), 
						rs.getString("nid"), 
						rs.getDouble("twd97_x"),
						rs.getDouble("twd97_y"),
						rs.getString("pasa_num"),
						rs.getString("ns_id"),
						rs.getDouble("gps_x_twd97"),
						rs.getDouble("gps_y_twd97"),
						rs.getString("pasa_up_or_down"),
						rs.getString("avg_slope"),
						rs.getString("delta_h"),
						rs.getString("direct_runoff"),
						rs.getString("new_disaster"),
						rs.getString("feature_level"),
						rs.getString("note"),
						rs.getString("ns_id_full"),
						rs.getString("wktgeom")				
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
