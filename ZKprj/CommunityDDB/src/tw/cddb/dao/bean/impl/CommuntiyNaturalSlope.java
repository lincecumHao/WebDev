package tw.cddb.dao.bean.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import tw.cddb.dao.bean.Factor;
import tw.cddb.dao.bean.FactorUtil;

public class CommuntiyNaturalSlope implements FactorUtil{
	
	//all Building in this Community.
	private Collection<NaturalSlope> naturalSlopes;
	
	/**
	 * 取得每種分類
	 * @return Map<featureLevel, drains>
	 */
	public Map<String, ArrayList<NaturalSlope>> getFeatureLevel(){
		Map<String, ArrayList<NaturalSlope>> map = new HashMap<String, ArrayList<NaturalSlope>>();
		for(NaturalSlope naturalSlope : naturalSlopes){
			String level = naturalSlope.getFeatureLevel();
			ArrayList<NaturalSlope> temp;
			if(map.containsKey(level)){
				temp = map.get(level);
			}else{
				temp = new ArrayList<NaturalSlope>();	
			}
			temp.add(naturalSlope);
			map.put(level, temp);
		}
		return map;
	}
	
	public Collection<NaturalSlope> getNaturalSlopes() {
		return naturalSlopes;
	}

	public void setBuilds(Collection<NaturalSlope> naturalSlope) {
		this.naturalSlopes = naturalSlope;
	}

	public CommuntiyNaturalSlope(Collection<NaturalSlope> naturalSlope) {
		super();
		if(naturalSlope == null){
			return;
		}
		this.naturalSlopes = naturalSlope;
	}
	
	public ArrayList<Factor> getFactor() {
		ArrayList<Factor> cast = new ArrayList<>();
		for(NaturalSlope b : this.naturalSlopes){
			cast.add((Factor) b);
		}
		return cast;
	}

}
