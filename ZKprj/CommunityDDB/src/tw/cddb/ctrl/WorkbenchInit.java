package tw.cddb.ctrl;

import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Initiator;

import tw.cddb.dao.bean.UserCredentialManager;


public class WorkbenchInit implements Initiator{

	/*
	 * Invoked while ZK Parser start to
	 */
	@Override
	public void doInit(Page page, Map<String, Object> arg) throws Exception {

		if (!UserCredentialManager.getInstance().isAuthenticated()) {
			// You can also get Execution by desktop
			// page.getDesktop().getExecution().sendRedirect("login.zul");
			Executions.getCurrent().sendRedirect("login.zul");
		}
	}

}
