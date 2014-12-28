package tw.cddb.dao.method.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import tw.cddb.dao.bean.Boundary;
import tw.cddb.dao.method.CommunityBoundaryDAO;
import tw.cddb.dao.model.impl.PostgreDAOFactory;

public class PostgreCommunityBoundaryDAO implements CommunityBoundaryDAO {

	@Override
	public Collection<Boundary> getAllCommunityBoudnary() {
		List<Boundary> resultList = new ArrayList<Boundary>();
		Connection con = PostgreDAOFactory.createConnection();
		String sql = "SELECT *, ST_AsText(geom) as wktGeom FROM \"140_community_boundary\" ORDER BY id";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				resultList.add(new Boundary(rs.getInt("gid"), rs.getInt("id"),
						rs.getString("name"), rs.getString("wktGeom")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public Boundary getCommunityBoudnaryById(String id) {
		Boundary boundary = null;
		Connection con = PostgreDAOFactory.createConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT *, ST_AsText(geom) as wktGeom FROM \"140_community_boundary\" ")
				.append("WHERE id = ").append(id).append(";");
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sb.toString());
			while (rs.next()) {
				boundary = new Boundary(rs.getInt("gid"), rs.getInt("id"),
						rs.getString("name"), rs.getString("wktGeom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boundary;
	}

}
