package tw.cddb.ctrl;

import java.util.ArrayList;
import java.util.Set;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treeitem;

import tw.cddb.dao.bean.Boundary;
import tw.cddb.dao.bean.Building;
import tw.cddb.dao.bean.CommunityTreeNode;
import tw.cddb.dao.bean.Drain;
import tw.cddb.dao.bean.ManualSlope;
import tw.cddb.dao.bean.NaturalSlope;

public class TreeSelectEvent implements EventListener<Event> {

	private ArrayList<Treeitem> originSelectedItems = new ArrayList<Treeitem>();
	private Set<Treeitem> newSelectedItems = null;

	@SuppressWarnings("unchecked")
	@Override
	public void onEvent(Event event) throws Exception {
		Tree tree = (Tree) event.getTarget();

		// set the new select Set.
		this.newSelectedItems = tree.getSelectedItems();
		
		if (newSelectedItems.size() >= this.originSelectedItems.size()) {

			// must had a new select one.
			renderNewSelect();

		} else if (newSelectedItems.size() < this.originSelectedItems.size()) {

			// must had a remove one;
			renderRemoveSelect();
		}

		setOriginSelectItems(tree);

		if (this.newSelectedItems.size() > 0) {
			for (Treeitem item : this.newSelectedItems) {
				if(isFactorParent(item)){
					return;
				}
				CommunityTreeNode<Object> ct = (CommunityTreeNode<Object>) ((DefaultTreeNode<CommunityTreeNode<Object>>) item
						.getValue()).getData();
				for(Object obj : ct.getChildren()){
					if(obj instanceof Building){
						Building build = (Building) obj;

					}else if(obj instanceof Drain){
						Drain drain = (Drain) obj;

					}else if(obj instanceof ManualSlope){
						ManualSlope ms = (ManualSlope) obj;

					}else if(obj instanceof NaturalSlope){
						NaturalSlope ns = (NaturalSlope) obj;

					}else if(obj instanceof Boundary){
						Boundary bound = (Boundary) obj;
						System.out.println("new Polygon(" + bound.getId() + ",\"" + bound.getWktGeom() + "\").setPath();");
						Clients.evalJavaScript("new Polygon(" + bound.getId() + ",\"" + bound.getWktGeom() + "\");");
					}
					
				}
			}
		}

		// DefaultTreeNode<CommunityTreeNode<Object>> dtn =
		// (DefaultTreeNode<CommunityTreeNode<Object>>)
		// tree.getSelectedItem().getValue();
		// CommunityTreeNode<Object> ct = dtn.getData();
		// for(Object a : ct.getChildren()){
		// System.out.println(a.getClass());
		// System.out.println(a instanceof ManualSlope);
		// }

	}

	private void renderRemoveSelect() {
		for (Treeitem item : this.originSelectedItems) {
			if (isRemovedItem(item)) {
				if (isFactorParent(item)) {
					uncheckAllSubFactor(item);
				}
			}
		}
	}

	private void renderNewSelect() {
		for (Treeitem item : this.newSelectedItems) {
			if (isNewSelectItem(item)) {
				if (isFactorParent(item)) {
					checkAllSubFactor(item);
				}
			}
		}
	}

	private void setOriginSelectItems(Tree tree) {
		//reset originSelectItem;
		this.originSelectedItems = new ArrayList<Treeitem>();
		
		if (tree.getSelectedCount() <= 0) {
			return;
		}
		for (Treeitem item : this.newSelectedItems) {
			this.originSelectedItems.add(item);
		}
	}

	private boolean isFactorParent(Treeitem item) {
		boolean flag = false;
		if (item.getTreechildren() != null
				&& item.getTreechildren().getItemCount() > 0) {
			flag = true;
		}

		if(item.getLabel().indexOf("邊界") > 0){
			flag = false;
		}
		return flag;
	}

	private boolean isNewSelectItem(Treeitem item) {
		boolean flag = true;
		for (Treeitem it : this.originSelectedItems) {
			if (it.getId().equals(item.getId())) {
				flag = false;
			}
		}
		return flag;
	}

	/**
	 * 其實跟 isNewSelectItem 是同樣的方法 為了避免混淆所以另外建一個function 用名稱區隔用途
	 * 
	 * @param item
	 * @return
	 */
	private boolean isRemovedItem(Treeitem item) {
		boolean flag = true;
		for (Treeitem it : this.newSelectedItems) {
			if (it.getId().equals(item.getId())) {
				flag = false;
			}
		}
		return flag;
	}

	private void checkAllSubFactor(Treeitem item) {
		Treechildren tc = item.getTreechildren();
		for (Treeitem ti : tc.getItems()) {
			if (!ti.isSelected()) {
				ti.setSelected(true);
			}
		}
	}

	private void uncheckAllSubFactor(Treeitem item) {
		Treechildren tc = item.getTreechildren();
		for (Treeitem ti : tc.getItems()) {
			if (ti.isSelected()) {
				ti.setSelected(false);
			}
		}
	}
}
