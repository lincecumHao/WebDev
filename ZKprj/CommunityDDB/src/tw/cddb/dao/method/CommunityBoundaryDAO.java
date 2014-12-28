package tw.cddb.dao.method;

import java.util.Collection;

import tw.cddb.dao.bean.impl.Boundary;

public interface CommunityBoundaryDAO {
	public Collection<Boundary> getAllCommunityBoudnary();
	public Boundary getCommunityBoudnaryById(String id);
}
