package tw.cddb.view;

import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;

import tw.cddb.dao.bean.CommunityTreeNode;

public class TreeModelRender implements
		TreeitemRenderer<DefaultTreeNode<CommunityTreeNode<Object>>> {

	@Override
	public void render(Treeitem item,
			DefaultTreeNode<CommunityTreeNode<Object>> data, int index)
			throws Exception {
		final CommunityTreeNode<Object> ctn = data.getData();
		item.setOpen(true);

		// for update treeNode data
		Treerow tr = item.getTreerow();
		if (tr == null) {
			tr = new Treerow();
		} else {
			tr.getChildren().clear();
		}
		item.appendChild(tr);

		// render file path cell
		Treecell pathCell = new Treecell();
		pathCell.setLabel(ctn.getName());
		pathCell.setParent(tr);

	}
}
