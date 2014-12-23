package tw.cddb.dao.method;

import java.util.ArrayList;

import tw.cddb.dao.bean.NaturalSlope;

public interface CommunityNaturalSlopeDAO {

	public ArrayList<NaturalSlope> getNaturalSlopeById(String id);
}
