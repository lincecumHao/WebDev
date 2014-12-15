package tw.cddb.dao.method.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import tw.cddb.dao.bean.CommunityBoundary;
import tw.cddb.dao.method.CommunityBoundaryDAO;
import tw.cddb.dao.model.impl.PostgreDAOFactory;

public class PostgreCommunityBoundaryDAO implements CommunityBoundaryDAO {

	@Override
	public Collection<CommunityBoundary> getAllCommunityBoudnary() {
		List<CommunityBoundary> resultList = new ArrayList<CommunityBoundary>();
		Connection con = PostgreDAOFactory.createConnection();
		String sql = "SELECT *, ST_AsText(geom) as wktGeom FROM \"140_community_boundary\" ORDER BY id";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				resultList.add(new CommunityBoundary(rs.getInt("gid"), rs
						.getInt("id"), rs.getString("name"), rs
						.getString("wktGeom")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
