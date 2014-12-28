package tw.cddb.dao.method.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tw.cddb.dao.bean.impl.ManualSlope;
import tw.cddb.dao.method.CommunityManualSlopeDAO;
import tw.cddb.dao.model.impl.PostgreDAOFactory;

public class PostgreCommunityManualSlopeDAO implements CommunityManualSlopeDAO {

	@Override
	public ArrayList<ManualSlope> getManualSlopeById(String id) {
		ArrayList<ManualSlope> resultList = new ArrayList<ManualSlope>();
		Connection con = PostgreDAOFactory.createConnection();
		String sql = "SELECT *, ST_AsText(geom) as wktgeom FROM \"140_community_manuallslope\" ";
		sql += "WHERE id = " + id + ";";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				resultList.add(new ManualSlope(rs.getInt("gid"), 
						rs.getInt("id"), 
						rs.getString("zone"), 
						rs.getString("mid"), 
						rs.getDouble("twd97_x"),
						rs.getDouble("twd97_y"),
						rs.getString("pasa_num"),
						rs.getString("mms_id"),
						rs.getString("mms_type"),
						rs.getString("mms_height"),
						rs.getString("max_slope_up"),
						rs.getString("max_slope_down"),
						rs.getString("loading_up"),
						rs.getString("mms_type_use"),
						rs.getString("backfills_scour"),
						rs.getString("wall_deformatic"),
						rs.getString("drainage"),
						rs.getString("foot_scour_and_cavern"),
						rs.getString("face_crack"),
						rs.getString("material_collapse"),
						rs.getString("feature_level"),
						rs.getString("note"),
						rs.getString("earth_anchor_note"),
						rs.getString("mms_id_full"),
						rs.getString("wktgeom")				
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
