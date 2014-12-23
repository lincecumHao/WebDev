package tw.cddb.dao.method;

import java.util.ArrayList;

import tw.cddb.dao.bean.Drain;

public interface CommunityDrainDAO {

	public ArrayList<Drain> getDrainById(String id);
}
