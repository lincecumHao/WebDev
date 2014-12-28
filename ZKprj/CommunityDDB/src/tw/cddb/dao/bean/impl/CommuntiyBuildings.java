package tw.cddb.dao.bean.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import tw.cddb.dao.bean.Factor;
import tw.cddb.dao.bean.FactorUtil;

public class CommuntiyBuildings implements FactorUtil{
	
	//all Building in this Community.
	private Collection<Building> builds;
	
	/**
	 * 取得每種分類跟建物
	 * @return Map<featureLevel, buildings>
	 */
	public Map<String, ArrayList<Building>> getFeatureLevel(){
		Map<String, ArrayList<Building>> map = new HashMap<String, ArrayList<Building>>();
		for(Building build : builds){
			String level = build.getFeatureLevel();
			ArrayList<Building> temp;
			if(map.containsKey(level)){
				temp = map.get(level);
			}else{
				temp = new ArrayList<Building>();	
			}
			temp.add(build);
			map.put(level, temp);
		}
		return map;
	}
	
	public Collection<Building> getBuilds() {
		return builds;
	}
	
	public ArrayList<Factor> getFactor() {
		ArrayList<Factor> cast = new ArrayList<>();
		for(Building b : this.builds){
			cast.add((Factor) b);
		}
		return cast;
	}

	public void setBuilds(Collection<Building> builds) {
		this.builds = builds;
	}

	public CommuntiyBuildings(Collection<Building> builds) {
		super();
		if(builds == null){
			return;
		}
		this.builds = builds;
	}

}
