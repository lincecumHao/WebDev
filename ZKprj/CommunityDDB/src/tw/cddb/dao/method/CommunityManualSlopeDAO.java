package tw.cddb.dao.method;

import java.util.ArrayList;

import tw.cddb.dao.bean.ManualSlope;

public interface CommunityManualSlopeDAO {

	public ArrayList<ManualSlope> getManualSlopeById(String id);
}
