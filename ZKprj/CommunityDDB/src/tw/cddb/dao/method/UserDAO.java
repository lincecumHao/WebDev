package tw.cddb.dao.method;

import java.util.List;

import tw.cddb.dao.bean.User;

public interface UserDAO {

	public List<User> findAll();

	public User findById(long id);

	public User findUserByName(String name);
}
