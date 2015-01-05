package tw.cddb.dao.method.impl.postgre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tw.cddb.dao.bean.User;
import tw.cddb.dao.method.UserDAO;
import tw.cddb.dao.model.impl.PostgreDAOFactory;

public class PostgreUserDAO implements UserDAO{

	@Override
	public List<User> findAll() {
		List<User> resultList = new ArrayList<>();
		Connection con = PostgreDAOFactory.createConnection();
		String sql = "SELECT * FROM \"User\" ORDER BY id";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				resultList.add(new User(rs.getLong("id"), rs.getString("name"),
						rs.getString("password"), rs.getString("role")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public User findById(long id) {
		Connection con = PostgreDAOFactory.createConnection();
		String sql = "SELECT * FROM \"User\" WHERE id = " + id + ";";
		Statement stmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				user = new User(rs.getLong("id"), rs.getString("name"),
						rs.getString("password"), rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User findUserByName(String name) {
		Connection con = PostgreDAOFactory.createConnection();
		String sql = "SELECT * FROM \"User\" WHERE name = \'" + name + "\';";
		Statement stmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				user = new User(rs.getLong("id"), rs.getString("name"),
						rs.getString("password"), rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
