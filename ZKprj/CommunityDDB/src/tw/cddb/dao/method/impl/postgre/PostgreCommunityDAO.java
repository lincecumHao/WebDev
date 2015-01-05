package tw.cddb.dao.method.impl.postgre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import tw.cddb.dao.bean.impl.Community;
import tw.cddb.dao.method.CommunityDAO;
import tw.cddb.dao.model.impl.PostgreDAOFactory;

public class PostgreCommunityDAO implements CommunityDAO {

	@Override
	public Collection<Community> getAllCommunity() {
		List<Community> resultList = new ArrayList<Community>();
		Connection con = PostgreDAOFactory.createConnection();
		String sql = "SELECT id, name FROM \"140_community_boundary\" ORDER BY id";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				resultList.add(new Community(rs.getInt("id"), rs
						.getString("name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;

	}
}
