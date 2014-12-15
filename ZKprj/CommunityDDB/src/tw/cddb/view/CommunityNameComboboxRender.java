package tw.cddb.view;

import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;

import tw.cddb.dao.bean.CommunityBoundary;

public class CommunityNameComboboxRender implements
		ComboitemRenderer<CommunityBoundary> {

	@Override
	public void render(Comboitem item, CommunityBoundary data, int index)
			throws Exception {
		item.setId(String.valueOf(data.getId()));
		item.setLabel(data.getName());
	}

}
