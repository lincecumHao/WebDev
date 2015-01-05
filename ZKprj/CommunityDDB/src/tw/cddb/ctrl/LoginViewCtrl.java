package tw.cddb.ctrl;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

import tw.cddb.dao.bean.UserCredentialManager;


public class LoginViewCtrl extends SelectorComposer<Component>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Wire
	private Textbox nameTxb;
	@Wire
	private Textbox passwordTxb;
	@Wire
	private Label mesgLb;
	@Wire
	private Button confirmBtn;
	@Wire
	private Button guestBtn;
	@Wire("textbox")
	private List<Textbox> inputs;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		if(UserCredentialManager.getInstance(Sessions.getCurrent()).isAuthenticated()){
			Executions.sendRedirect("index.zul");
		}
		nameTxb.setFocus(true);
	}
	
	@Listen("onCancel=#loginWin")
	public void onCancel(){
		for(Textbox input : inputs){
			input.setValue("");	
		}
		nameTxb.setFocus(true);
	}
	
	@Listen("onClick=#confirmBtn; onOK=#loginWin")
	public void doLogin() {
		UserCredentialManager mgmt = UserCredentialManager.getInstance(Sessions.getCurrent());
		mgmt.login(nameTxb.getValue(), passwordTxb.getValue());
		if (mgmt.isAuthenticated()) {
			Executions.sendRedirect("index.zul");
		} else {
			mesgLb.setValue("帳號/密碼 錯誤!");
		}
	}
	
	@Listen("onClick=#guestBtn")
	public void guestLogin(){
		nameTxb.setValue("guest");
		passwordTxb.setValue("guest");
		Events.postEvent("onClick", this.confirmBtn, null);
	}

}
