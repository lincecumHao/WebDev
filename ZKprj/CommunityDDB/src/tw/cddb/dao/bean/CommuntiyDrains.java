package tw.cddb.dao.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CommuntiyDrains {
	
	//all Building in this Community.
	private Collection<Drain> drains;
	
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

	public void setBuilds(Collection<Drain> drains) {
		this.drains = drains;
	}

	public CommuntiyDrains(Collection<Drain> drains) {
		super();
		if(drains == null){
			return;
		}
		this.drains = drains;
	}

}
