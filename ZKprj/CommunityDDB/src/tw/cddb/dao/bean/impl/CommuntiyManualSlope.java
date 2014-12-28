package tw.cddb.dao.bean.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import tw.cddb.dao.bean.Factor;
import tw.cddb.dao.bean.FactorUtil;

public class CommuntiyManualSlope implements FactorUtil{
	
	//all Building in this Community.
	private Collection<ManualSlope> manualSlopes;
	
	/**
	 * 取得每種分類
	 * @return Map<featureLevel, drains>
	 */
	public Map<String, ArrayList<ManualSlope>> getFeatureLevel(){
		Map<String, ArrayList<ManualSlope>> map = new HashMap<String, ArrayList<ManualSlope>>();
		for(ManualSlope manualSlope : manualSlopes){
			String level = manualSlope.getFeatureLevel();
			ArrayList<ManualSlope> temp;
			if(map.containsKey(level)){
				temp = map.get(level);
			}else{
				temp = new ArrayList<ManualSlope>();	
			}
			temp.add(manualSlope);
			map.put(level, temp);
		}
		return map;
	}
	
	public Collection<ManualSlope> getManualSlopes() {
		return manualSlopes;
	}

	public void setBuilds(Collection<ManualSlope> manualSlope) {
		this.manualSlopes = manualSlope;
	}

	public CommuntiyManualSlope(Collection<ManualSlope> manualSlope) {
		super();
		if(manualSlope == null){
			return;
		}
		this.manualSlopes = manualSlope;
	}

	@Override
	public ArrayList<Factor> getFactor() {
		ArrayList<Factor> cast = new ArrayList<>();
		for(ManualSlope b : this.manualSlopes){
			cast.add((Factor) b);
		}
		return cast;
	}

}
