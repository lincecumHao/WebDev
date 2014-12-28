package tw.cddb.dao.bean.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import tw.cddb.dao.bean.Factor;
import tw.cddb.dao.bean.FactorUtil;

public class CommuntiyDrains implements FactorUtil{
	
	//all Building in this Community.
	private Collection<Drain> drains;
	
	public CommuntiyDrains(Collection<Drain> drains) {
		super();
		if(drains == null){
			return;
		}
		this.drains = drains;
	}
	
	/**
	 * 取得每種分類
	 * @return Map<featureLevel, drains>
	 */
	public Map<String, ArrayList<Drain>> getFeatureLevel(){
		Map<String, ArrayList<Drain>> map = new HashMap<String, ArrayList<Drain>>();
		for(Drain drain : drains){
			String level = drain.getFeatureLevel();
			ArrayList<Drain> temp;
			if(map.containsKey(level)){
				temp = map.get(level);
			}else{
				temp = new ArrayList<Drain>();	
			}
			temp.add(drain);
			map.put(level, temp);
		}
		return map;
	}
	
	public Collection<Drain> getDrains() {
		return drains;
	}
	
	public void setBuilds(ArrayList<Drain> drains) {
		this.drains = drains;
	}

	public CommuntiyDrains(ArrayList<Drain> drains) {
		super();
		if(drains == null){
			return;
		}
		this.drains = drains;
	}
	
	@Override
	public ArrayList<Factor> getFactor() {
		ArrayList<Factor> cast = new ArrayList<>();
		for(Drain d : this.drains){
			cast.add((Factor) d);
		}
		return cast;
	}
}
