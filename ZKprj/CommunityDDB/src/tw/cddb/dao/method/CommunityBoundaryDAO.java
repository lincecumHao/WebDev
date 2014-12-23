package tw.cddb.dao.method;

import java.util.Collection;

import tw.cddb.dao.bean.Boundary;

public interface CommunityBoundaryDAO {
	public Collection<Boundary> getAllCommunityBoudnary();
	public Boundary getCommunityBoudnaryById(String id);
}
