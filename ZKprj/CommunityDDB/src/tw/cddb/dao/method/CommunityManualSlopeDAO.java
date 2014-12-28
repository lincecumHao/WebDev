package tw.cddb.dao.method;

import java.util.ArrayList;

import tw.cddb.dao.bean.impl.ManualSlope;

public interface CommunityManualSlopeDAO {

	public ArrayList<ManualSlope> getManualSlopeById(String id);
}
