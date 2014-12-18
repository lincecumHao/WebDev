package tw.cddb.dao.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CommuntiyBuildings {
	
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
