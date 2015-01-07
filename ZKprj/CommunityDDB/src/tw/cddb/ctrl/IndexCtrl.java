package tw.cddb.ctrl;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;

import tw.cddb.dao.bean.UserCredentialManager;

public class IndexCtrl extends SelectorComposer<Component>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Wire
	private Div map_canvas;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
	}
	
	@Listen("onDraw = Div#map_canvas")
	public void getSendBack(Event evt){
		if (UserCredentialManager.getInstance().isGuest()) {
			Window win = new Window();
			win.setMode("highlighted");
			win.setParent(this.map_canvas);
			win.setPosition("center");
			win.setTitle("<錯誤>");
			win.setClosable(true);
			Hlayout hlayout = new Hlayout();
			hlayout.setParent(win);
			Label label = new Label("Guest 無下載權限");
			label.setParent(hlayout);	
		}else{
			
		}
	}

}
