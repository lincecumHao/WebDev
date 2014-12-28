package tw.cddb.view;

import java.util.UUID;

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
		item.setId(UUID.randomUUID().toString());
		item.setOpen(true);
		item.setValue(data);
		int childCount = 0;
		if(ctn.getChildren() != null){
			childCount = ctn.getChildren().size();
		}
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
		if(childCount == 0){
			pathCell.setLabel(ctn.getName());
			
		}else{
			pathCell.setLabel(ctn.getName() + " (" + childCount + ")");
		}
		pathCell.setParent(tr);
	}
}
