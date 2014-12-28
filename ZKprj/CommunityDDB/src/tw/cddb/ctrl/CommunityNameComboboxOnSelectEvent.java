package tw.cddb.ctrl;

import org.zkoss.zk.ui.Path;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ListModel;

import tw.cddb.dao.bean.impl.Community;

public class CommunityNameComboboxOnSelectEvent implements EventListener<Event> {

	@Override
	public void onEvent(Event event) throws Exception {
		Combobox combbx = (Combobox) Path
				.getComponent("/overlap_Window/communityName_cbbox");
		ListModel<Community> lml = combbx.getModel();
		Community community = lml.getElementAt(combbx.getSelectedIndex());
		
		new CommunityInfoSet(community);
		new CommunityInfoTreeCtrl(community);
	}

}
