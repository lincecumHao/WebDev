package tw.cddb.ctrl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Path;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Tree;

import tw.cddb.dao.bean.Building;
import tw.cddb.dao.bean.Community;
import tw.cddb.dao.bean.CommunityTreeNode;
import tw.cddb.dao.bean.Drain;
import tw.cddb.dao.bean.ManualSlope;
import tw.cddb.dao.bean.NaturalSlope;
import tw.cddb.view.TreeModelRender;

public class CommunityInfoTreeCtrl {

	private Community community;
	private Tree tree;

	private int DRAIN = 1;
	private int BUILDIND = 2;
	private int MANUAL_SLOPE = 3;
	private int NATURAL_SLOPE = 4;

	private int DRAIN_PARENT = 5;
	private int BUILDIND_PARENT = 6;
	private int MANUAL_SLOPE_PARENT = 7;
	private int NATURAL_SLOPE_PARENT = 8;

	public CommunityInfoTreeCtrl(Community community) {
		this.community = community;
		this.tree = getTree();

		List<DefaultTreeNode<CommunityTreeNode<?>>> factorParentList = new ArrayList<>();
		factorParentList.add(createFactorParent(this.DRAIN_PARENT,
				getFactorNode(this.DRAIN)));
		factorParentList.add(createFactorParent(this.BUILDIND_PARENT,
				getFactorNode(this.BUILDIND)));
		factorParentList.add(createFactorParent(this.MANUAL_SLOPE_PARENT,
				getFactorNode(this.MANUAL_SLOPE)));
		factorParentList.add(createFactorParent(this.NATURAL_SLOPE_PARENT,
				getFactorNode(this.NATURAL_SLOPE)));

		CommunityTreeNode<?> firstNode = new CommunityTreeNode<>(
				community.getName(), null);
		DefaultTreeNode<CommunityTreeNode<?>> firstTn = new DefaultTreeNode<>(
				firstNode, factorParentList);

		List<DefaultTreeNode<CommunityTreeNode<?>>> rootList = new ArrayList<>();
		rootList.add(firstTn);
		DefaultTreeNode<CommunityTreeNode<?>> rootTreeNode = new DefaultTreeNode<>(
				null, rootList);

		DefaultTreeModel<CommunityTreeNode<?>> model = new DefaultTreeModel<CommunityTreeNode<?>>(
				rootTreeNode);

		tree.setModel(model);
		tree.setItemRenderer(new TreeModelRender());
		if (!tree.isVisible()) {
			tree.setVisible(true);
		}
		if (!tree.isMultiple()) {
			tree.setMultiple(true);
		}
		if (!tree.isCheckmark()) {
			tree.setCheckmark(true);
		}
	}

	private List<DefaultTreeNode<CommunityTreeNode<?>>> getFactorNode(int type) {
		List<DefaultTreeNode<CommunityTreeNode<?>>> treeNode = new ArrayList<>();
		ArrayList<String> keylist = new ArrayList<>();
		keylist.add("一");
		keylist.add("二");
		keylist.add("三");
		switch (type) {
		case 1:
			Map<String, ArrayList<Drain>> map = community.getCommuntiyDrains()
					.getFeatureLevel();
			for (String key : keylist) {
				if (map.containsKey(key)) {
					CommunityTreeNode<?> ctnode = new CommunityTreeNode<>(
							getFeatureLevelString(key), map.get(key));
					treeNode.add(createDefaultTreeNode(ctnode));
				}
			}
			return treeNode;
		case 2:
			Map<String, ArrayList<Building>> buildMap = community
					.getCommuntiyBuildings().getFeatureLevel();
			for (String key : keylist) {
				if (buildMap.containsKey(key)) {
					CommunityTreeNode<?> ctnode = new CommunityTreeNode<>(
							getFeatureLevelString(key), buildMap.get(key));
					treeNode.add(createDefaultTreeNode(ctnode));
				}
			}
			return treeNode;
		case 3:
			Map<String, ArrayList<ManualSlope>> msMap = community
					.getCommuntiyManualSlope().getFeatureLevel();
			for (String key : keylist) {
				if (msMap.containsKey(key)) {
					CommunityTreeNode<?> ctnode = new CommunityTreeNode<>(
							getFeatureLevelString(key), msMap.get(key));
					treeNode.add(createDefaultTreeNode(ctnode));
				}
			}
			return treeNode;
		case 4:
			Map<String, ArrayList<NaturalSlope>> nsMap = community
					.getCommuntiyNaturalSlope().getFeatureLevel();
			for (String key : keylist) {
				if (nsMap.containsKey(key)) {
					CommunityTreeNode<?> ctnode = new CommunityTreeNode<>(
							getFeatureLevelString(key), nsMap.get(key));
					treeNode.add(createDefaultTreeNode(ctnode));
				}
			}
			return treeNode;
		}
		return null;
	}

	private String getFeatureLevelString(String name) {
		if (name.equals("一")) {
			return "第一級";
		} else if (name.equals("二")) {
			return "第二級";
		} else {
			return "第三級";
		}
	}

	private DefaultTreeNode<CommunityTreeNode<?>> createFactorParent(int type,
			List<DefaultTreeNode<CommunityTreeNode<?>>> child) {
		switch (type) {
		case 5:
			return new DefaultTreeNode<CommunityTreeNode<?>>(
					new CommunityTreeNode<>("排水設施徵兆分級",
							(ArrayList<Drain>) community.getCommuntiyDrains()
									.getDrains()), child);
		case 6:
			return new DefaultTreeNode<CommunityTreeNode<?>>(
					new CommunityTreeNode<>("路面與建物徵兆分級",
							(ArrayList<Building>) community
									.getCommuntiyBuildings().getBuilds()),
					child);

		case 7:
			return new DefaultTreeNode<CommunityTreeNode<?>>(
					new CommunityTreeNode<>("人工邊坡徵兆分級",
							(ArrayList<ManualSlope>) community
									.getCommuntiyManualSlope()
									.getManualSlopes()), child);
		case 8:
			return new DefaultTreeNode<CommunityTreeNode<?>>(
					new CommunityTreeNode<>("自然邊坡徵兆分級",
							(ArrayList<NaturalSlope>) community
									.getCommuntiyNaturalSlope()
									.getNaturalSlopes()), child);
		default:
			return null;
		}
	}

	private DefaultTreeNode<CommunityTreeNode<?>> createDefaultTreeNode(
			CommunityTreeNode<?> parent) {
		DefaultTreeNode<CommunityTreeNode<?>> node = new DefaultTreeNode<CommunityTreeNode<?>>(
				parent);
		return node;
	}

	private Tree getTree() {
		Tree t = (Tree) Path.getComponent("/overlap_Window/communityInfo_Tree");
		while (t.getItemCount() > 0) {
			t.removeChild(t.getFirstChild());
		}
		t.setModel(null);
		t.setMultiple(false);
		t.setCheckmark(false);
		return t;
	}

}
