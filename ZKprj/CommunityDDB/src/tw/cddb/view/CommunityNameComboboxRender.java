package tw.cddb.view;

import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;

import tw.cddb.dao.bean.impl.Community;

public class CommunityNameComboboxRender implements
		ComboitemRenderer<Community> {

	@Override
	public void render(Comboitem item, Community data, int index)
			throws Exception {
		item.setId(String.valueOf(data.getId()));
		item.setLabel(data.getName());
	}

}
