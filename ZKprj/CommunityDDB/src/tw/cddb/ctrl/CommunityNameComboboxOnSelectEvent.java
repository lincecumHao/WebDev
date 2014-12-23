package tw.cddb.ctrl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Path;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Tree;

import tw.cddb.dao.bean.Building;
import tw.cddb.dao.bean.Community;
import tw.cddb.dao.bean.CommunityTreeNode;
import tw.cddb.dao.bean.CommuntiyBuildings;
import tw.cddb.dao.method.CommunityBuildingDAO;
import tw.cddb.dao.model.DAOFactory;
import foo.TreeModelRender;

public class CommunityNameComboboxOnSelectEvent implements EventListener<Event> {

	@Override
	public void onEvent(Event event) throws Exception {
		Combobox combbx = (Combobox) Path
				.getComponent("/overlap_Window/communityName_cbbox");
		ListModel<Community> lml = combbx.getModel();
		Community community = lml.getElementAt(combbx.getSelectedIndex());
		
//		ClientsJsFunc.createSymbol(DAOFactory.POSTGRESQL, cb.getId(),
//				cb.getWktGeom());
//		ClientsJsFunc.panTo(cb.getId());

		new CommunityInfoSet(community);
		new CommunityInfoTreeCtrl(community);
//		getFullCommunityInfo(community);
	}

	
	/**
	 * TODO REFACTOR THIS FUCKING CLASS
	 * @param community
	 */
	private void getFullCommunityInfo(Community community) {
		
		// create the required DAO Factory
		DAOFactory postgreDAO = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);

		// Create a DAO
		CommunityBuildingDAO cbDAO = postgreDAO.getCommunityBuildingDAO();

		// get data from server.
		Collection<Building> list = cbDAO.getBuildingById(community.getId());
		
		//set data to community.
		community.setCommuntiyBuildings(new CommuntiyBuildings(list));


		List<DefaultTreeNode<CommunityTreeNode<?>>> buildTreeNode = new ArrayList<>();
		
		Map<String, ArrayList<Building>> bulidingMap = community.getCommuntiyBuildings().getFeatureLevel();
		
		for(String key : bulidingMap.keySet()){
			
			CommunityTreeNode<?> build = new CommunityTreeNode<>(key, bulidingMap.get(key));
			DefaultTreeNode<CommunityTreeNode<?>> node = new DefaultTreeNode<CommunityTreeNode<?>>(build);
			buildTreeNode.add(node);
		}
		
		List<DefaultTreeNode<CommunityTreeNode<?>>> buildTreeNodeParent = new ArrayList<>();
		CommunityTreeNode<?> commBuildTreeNode = new CommunityTreeNode<>("建物評分", (ArrayList<Building>) community.getCommuntiyBuildings().getBuilds());
		
		buildTreeNodeParent.add(new DefaultTreeNode<CommunityTreeNode<?>>(commBuildTreeNode, buildTreeNode));
		
		
		List<DefaultTreeNode<CommunityTreeNode<?>>> commBuildTreeNodeParent = new ArrayList<>();
		CommunityTreeNode<Building> commTreeNodeRoot = new CommunityTreeNode<>(community.getName(), null);
		commBuildTreeNodeParent.add(new DefaultTreeNode<CommunityTreeNode<?>>(commTreeNodeRoot, buildTreeNodeParent));
		
		DefaultTreeNode<CommunityTreeNode<?>> root = new DefaultTreeNode<>(null, commBuildTreeNodeParent);
		
			
		DefaultTreeModel<CommunityTreeNode<?>> model = new DefaultTreeModel<CommunityTreeNode<?>>(root);
		Tree tree = (Tree) Path.getComponent("/overlap_Window/communityInfo_Tree");
		
		tree.setModel(model);
		tree.setItemRenderer(new TreeModelRender());
		tree.setMultiple(true);
		tree.setCheckmark(true);
		tree.setVisible(true);
		
	}

}
