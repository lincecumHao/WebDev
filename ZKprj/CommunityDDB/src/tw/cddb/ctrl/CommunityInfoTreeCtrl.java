package tw.cddb.ctrl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Path;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Tree;
import org.zkoss.zul.TreeNode;

import tw.cddb.dao.bean.Building;
import tw.cddb.dao.bean.Community;
import tw.cddb.dao.bean.CommunityTreeNode;
import tw.cddb.dao.bean.Drain;
import tw.cddb.dao.bean.ManualSlope;
import tw.cddb.dao.bean.NaturalSlope;
import foo.TreeModelRender;

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
		tree.setMultiple(true);
		tree.setCheckmark(true);
		tree.setVisible(true);

	}

	private List<DefaultTreeNode<CommunityTreeNode<?>>> getFactorNode(int type) {
		List<DefaultTreeNode<CommunityTreeNode<?>>> treeNode = new ArrayList<>();

		switch (type) {
		case 1:
			Map<String, ArrayList<Drain>> map = community.getCommuntiyDrains()
					.getFeatureLevel();
			for (String key : map.keySet()) {
				CommunityTreeNode<?> ctnode = new CommunityTreeNode<>(key,
						map.get(key));
				treeNode.add(createDefaultTreeNode(ctnode));
			}
			return treeNode;
		case 2:
			Map<String, ArrayList<Building>> buildMap = community
					.getCommuntiyBuildings().getFeatureLevel();
			for (String key : buildMap.keySet()) {
				CommunityTreeNode<?> ctnode = new CommunityTreeNode<>(key,
						buildMap.get(key));
				treeNode.add(createDefaultTreeNode(ctnode));
			}
			return treeNode;
		case 3:
			Map<String, ArrayList<ManualSlope>> msMap = community
					.getCommuntiyManualSlope().getFeatureLevel();
			for (String key : msMap.keySet()) {
				CommunityTreeNode<?> ctnode = new CommunityTreeNode<>(key,
						msMap.get(key));
				treeNode.add(createDefaultTreeNode(ctnode));
			}
			return treeNode;
		case 4:
			Map<String, ArrayList<NaturalSlope>> nsMap = community
					.getCommuntiyNaturalSlope().getFeatureLevel();
			for (String key : nsMap.keySet()) {
				CommunityTreeNode<?> ctnode = new CommunityTreeNode<>(key,
						nsMap.get(key));
				treeNode.add(createDefaultTreeNode(ctnode));
			}
			return treeNode;
		}
		return null;
	}

	private DefaultTreeNode<CommunityTreeNode<?>> createFactorParent(int type,
			List<DefaultTreeNode<CommunityTreeNode<?>>> child) {
		switch (type) {
		case 5:
			return new DefaultTreeNode<CommunityTreeNode<?>>(
					new CommunityTreeNode<>("排水設施偵照分級",
							(ArrayList<Drain>) community.getCommuntiyDrains()
									.getDrains()), child);
		case 6:
			return new DefaultTreeNode<CommunityTreeNode<?>>(
					new CommunityTreeNode<>("路面與建物偵照分級",
							(ArrayList<Building>) community
									.getCommuntiyBuildings().getBuilds()),
					child);

		case 7:
			return new DefaultTreeNode<CommunityTreeNode<?>>(
					new CommunityTreeNode<>("人工邊坡偵照分級",
							(ArrayList<ManualSlope>) community
									.getCommuntiyManualSlope()
									.getManualSlopes()), child);
		case 8:
			return new DefaultTreeNode<CommunityTreeNode<?>>(
					new CommunityTreeNode<>("自然邊坡偵照分級",
							(ArrayList<NaturalSlope>) community
									.getCommuntiyNaturalSlope()
									.getNaturalSlopes()), child);
		default:
			return null;
		}
	}

	// private List<DefaultTreeNode<CommunityTreeNode<?>>> createSubParent(
	// int type, List<DefaultTreeNode<CommunityTreeNode<?>>> child) {
	// List<DefaultTreeNode<CommunityTreeNode<?>>> treeNodeParent = new
	// ArrayList<>();
	// CommunityTreeNode<?> sunParent = null;
	// switch (type) {
	// case 5:
	// sunParent = new CommunityTreeNode<>("排水設施偵照分級",
	// (ArrayList<Drain>) community.getCommuntiyDrains()
	// .getDrains());
	// break;
	// case 6:
	// sunParent = new CommunityTreeNode<>("路面與建物偵照分級",
	// (ArrayList<Building>) community.getCommuntiyBuildings()
	// .getBuilds());
	// break;
	// case 7:
	// sunParent = new CommunityTreeNode<>("人工邊坡偵照分級",
	// (ArrayList<ManualSlope>) community
	// .getCommuntiyManualSlope().getManualSlopes());
	// break;
	// case 8:
	// sunParent = new CommunityTreeNode<>("自然邊坡偵照分級",
	// (ArrayList<NaturalSlope>) community
	// .getCommuntiyNaturalSlope().getNaturalSlopes());
	// break;
	// }
	// treeNodeParent.add(createDefaultTreeNode(sunParent, child));
	// return treeNodeParent;
	// }

	private DefaultTreeNode<CommunityTreeNode<?>> createDefaultTreeNode(
			CommunityTreeNode<?> parent) {
		DefaultTreeNode<CommunityTreeNode<?>> node = new DefaultTreeNode<CommunityTreeNode<?>>(
				parent);
		return node;
	}

	private DefaultTreeNode<CommunityTreeNode<?>> createDefaultTreeNode(
			CommunityTreeNode<?> parent,
			List<DefaultTreeNode<CommunityTreeNode<?>>> child) {
		return new DefaultTreeNode<>(parent, child);
	}

	// private void setFirstParent(
	// List<DefaultTreeNode<CommunityTreeNode<?>>> parent,
	// CommunityTreeNode<?> parentNode,
	// List<DefaultTreeNode<CommunityTreeNode<?>>> child) {
	//
	// parent.add(new DefaultTreeNode<CommunityTreeNode<?>>(parentNode, child));
	//
	// }

	// public void ctreateTree() {

	// List<DefaultTreeNode<CommunityTreeNode<?>>> buildTreeNode = new
	// ArrayList<>();
	//
	// Map<String, ArrayList<Building>> bulidingMap = community
	// .getCommuntiyBuildings().getFeatureLevel();
	//
	// for (String key : bulidingMap.keySet()) {
	//
	// CommunityTreeNode<?> build = new CommunityTreeNode<>(key,
	// bulidingMap.get(key));
	// DefaultTreeNode<CommunityTreeNode<?>> node =
	// createDefaultTreeNode(build);
	// buildTreeNode.add(node);
	// }

	// List<DefaultTreeNode<CommunityTreeNode<?>>> buildTreeNodeParent = new
	// ArrayList<>();
	// CommunityTreeNode<?> commBuildTreeNode = new CommunityTreeNode<>(
	// "建物評分", (ArrayList<Building>) community.getCommuntiyBuildings()
	// .getBuilds());
	//
	// buildTreeNodeParent.add(new DefaultTreeNode<CommunityTreeNode<?>>(
	// commBuildTreeNode, buildTreeNode));

	// List<DefaultTreeNode<CommunityTreeNode<?>>> commBuildTreeNodeParent = new
	// ArrayList<>();
	// CommunityTreeNode<Building> commTreeNodeRoot = new CommunityTreeNode<>(
	// community.getName(), null);
	// commBuildTreeNodeParent.add(new DefaultTreeNode<CommunityTreeNode<?>>(
	// commTreeNodeRoot, buildTreeNodeParent));
	//
	// DefaultTreeNode<CommunityTreeNode<?>> root = new DefaultTreeNode<>(
	// null, commBuildTreeNodeParent);
	//
	// DefaultTreeModel<CommunityTreeNode<?>> model = new
	// DefaultTreeModel<CommunityTreeNode<?>>(
	// root);
	// Tree tree = (Tree) Path
	// .getComponent("/overlap_Window/communityInfo_Tree");
	//
	// tree.setModel(model);
	// tree.setItemRenderer(new TreeModelRender());
	// tree.setMultiple(true);
	// tree.setCheckmark(true);
	// tree.setVisible(true);
	// }

	private Tree getTree() {
		return (Tree) Path.getComponent("/overlap_Window/communityInfo_Tree");
	}

}
