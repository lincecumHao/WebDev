package tw.cddb.dao.method;

import java.util.ArrayList;

import tw.cddb.dao.bean.impl.Drain;

public interface CommunityDrainDAO {

	public ArrayList<Drain> getDrainById(String id);
}
