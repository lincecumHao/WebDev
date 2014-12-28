package tw.cddb.dao.method.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tw.cddb.dao.bean.impl.Drain;
import tw.cddb.dao.method.CommunityDrainDAO;
import tw.cddb.dao.model.impl.PostgreDAOFactory;

public class PostgreCommunityDrainDAO implements CommunityDrainDAO{

	@Override
	public ArrayList<Drain> getDrainById(String id) {
		ArrayList<Drain> resultList = new ArrayList<Drain>();
		Connection con = PostgreDAOFactory.createConnection();
		String sql = "SELECT *, ST_AsText(geom) as wktgeom FROM \"140_community_drain\" ";
		sql += "WHERE id = " + id + ";";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				resultList.add(new Drain(rs.getInt("gid"), 
						rs.getInt("id"), 
						rs.getString("zone"), 
						rs.getString("did"), 
						rs.getDouble("twd97_x"),
						rs.getDouble("twd97_y"),
						rs.getString("pasa_num"),
						rs.getString("dr_id"),
						rs.getString("dr_type"),
						rs.getString("dr_material"),
						rs.getString("dr_stoppage"),
						rs.getString("dr_crack"),
						rs.getString("dr_end_discharge"),
						rs.getString("sed_weir_and_detentionpond"),
						rs.getString("feature_level"),
						rs.getString("note"),
						rs.getString("dr_id_full"),
						rs.getString("wktgeom")				
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
