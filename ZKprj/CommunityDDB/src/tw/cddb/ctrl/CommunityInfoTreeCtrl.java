package tw.cddb.ctrl;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Tree;

public class CommunityInfoTreeCtrl extends SelectorComposer<Component>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Wire
	Tree communityInfo_Tree;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
	}

}
