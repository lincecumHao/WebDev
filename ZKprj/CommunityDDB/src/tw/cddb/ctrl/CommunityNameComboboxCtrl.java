package tw.cddb.ctrl;

import java.util.Collection;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ListModelList;

import tw.cddb.dao.bean.CommunityBoundary;
import tw.cddb.dao.method.CommunityBoundaryDAO;
import tw.cddb.dao.model.DAOFactory;
import tw.cddb.view.CommunityNameComboboxRender;

public class CommunityNameComboboxCtrl extends SelectorComposer<Component> {

	/**
	 * 20141215. Combobox Controller. to show all community name for select.
	 */
	private static final long serialVersionUID = 1L;
	
	@Wire
	Combobox communityName_cbbox;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		// create the required DAO Factory
		DAOFactory postgreDAO = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

		// Create a DAO
		CommunityBoundaryDAO cbDAO = postgreDAO.getCommunityBoundDAO();

		//get data from server.
		Collection<CommunityBoundary> list = cbDAO.getAllCommunityBoudnary();

		// get data from service and wrap it to list-model for the view
		ListModelList<CommunityBoundary> todoListModel = new ListModelList<CommunityBoundary>(list);
		communityName_cbbox.setModel(todoListModel);
		communityName_cbbox.setItemRenderer(new CommunityNameComboboxRender());
	}

	// test case
	public static void main(String[] args) {

		// create the required DAO Factory
		DAOFactory postgreDAO = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

		// Create a DAO
		CommunityBoundaryDAO cbDAO = postgreDAO.getCommunityBoundDAO();

		Collection<CommunityBoundary> list = cbDAO.getAllCommunityBoudnary();

		System.out.println(list.size());

	}
}
