package tw.cddb.ctrl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Path;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Tree;

import tw.cddb.dao.bean.ArrayCast;
import tw.cddb.dao.bean.Factor;
import tw.cddb.dao.bean.impl.Building;
import tw.cddb.dao.bean.impl.Community;
import tw.cddb.dao.bean.impl.CommunityTreeNode;
import tw.cddb.dao.bean.impl.Drain;
import tw.cddb.dao.bean.impl.ManualSlope;
import tw.cddb.dao.bean.impl.NaturalSlope;
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

	private int BOUNDARY = 9;

	public CommunityInfoTreeCtrl(Community community) {
		this.community = community;
		this.tree = getTree();

		List<DefaultTreeNode<CommunityTreeNode>> factorParentList = new ArrayList<>();
		factorParentList.add(createFactorParent(this.BOUNDARY, null));
		factorParentList.add(createFactorParent(this.DRAIN_PARENT,
				getFactorNode(this.DRAIN)));
		factorParentList.add(createFactorParent(this.BUILDIND_PARENT,
				getFactorNode(this.BUILDIND)));
		factorParentList.add(createFactorParent(this.MANUAL_SLOPE_PARENT,
				getFactorNode(this.MANUAL_SLOPE)));
		factorParentList.add(createFactorParent(this.NATURAL_SLOPE_PARENT,
				getFactorNode(this.NATURAL_SLOPE)));

		CommunityTreeNode firstNode = new CommunityTreeNode(
				community.getName(), null);
		DefaultTreeNode<CommunityTreeNode> firstTn = new DefaultTreeNode<>(
				firstNode, factorParentList);

		List<DefaultTreeNode<CommunityTreeNode>> rootList = new ArrayList<>();
		rootList.add(firstTn);
		DefaultTreeNode<CommunityTreeNode> rootTreeNode = new DefaultTreeNode<>(
				null, rootList);

		DefaultTreeModel<CommunityTreeNode> model = new DefaultTreeModel<CommunityTreeNode>(
				rootTreeNode);

		tree.setModel(model);
		tree.setItemRenderer(new TreeModelRender());
		tree.addEventListener("onClick", new TreeSelectEvent());
		
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
	
	private List<DefaultTreeNode<CommunityTreeNode>> getFactorNode(int type) {
		List<DefaultTreeNode<CommunityTreeNode>> treeNode = new ArrayList<>();
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
					ArrayList<Factor> ary = new ArrayCast<>(map.get(key)).toFactorArray();
					CommunityTreeNode ctnode = new CommunityTreeNode(getFeatureLevelString(key), ary);
					treeNode.add(createDefaultTreeNode(ctnode));
				}
			}
			break;
		case 2:
			Map<String, ArrayList<Building>> buildMap = community
					.getCommuntiyBuildings().getFeatureLevel();
			for (String key : keylist) {
				if (buildMap.containsKey(key)) {
					ArrayList<Factor> ary = new ArrayCast<>(buildMap.get(key)).toFactorArray();
					CommunityTreeNode ctnode = new CommunityTreeNode(getFeatureLevelString(key), ary);
					treeNode.add(createDefaultTreeNode(ctnode));
				}
			}
			break;
		case 3:
			Map<String, ArrayList<ManualSlope>> msMap = community
					.getCommuntiyManualSlope().getFeatureLevel();
			for (String key : keylist) {
				if (msMap.containsKey(key)) {
					ArrayList<Factor> ary = new ArrayCast<>(msMap.get(key)).toFactorArray();
					CommunityTreeNode ctnode = new CommunityTreeNode(getFeatureLevelString(key), ary);
					treeNode.add(createDefaultTreeNode(ctnode));
				}
			}
			break;
		case 4:
			Map<String, ArrayList<NaturalSlope>> nsMap = community
					.getCommuntiyNaturalSlope().getFeatureLevel();
			for (String key : keylist) {
				if (nsMap.containsKey(key)) {
					ArrayList<Factor> ary = new ArrayCast<>(nsMap.get(key)).toFactorArray();
					CommunityTreeNode ctnode = new CommunityTreeNode(getFeatureLevelString(key), ary);
					treeNode.add(createDefaultTreeNode(ctnode));
				}
			}
			break;
		}
		return treeNode;
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

	private DefaultTreeNode<CommunityTreeNode> createFactorParent(int type,
			List<DefaultTreeNode<CommunityTreeNode>> child) {
		switch (type) {
		case 5:
			return new DefaultTreeNode<CommunityTreeNode>(
					new CommunityTreeNode("排水設施徵兆分級",
							community.getCommuntiyDrains()
									.getFactor()), child);
		case 6:
			return new DefaultTreeNode<CommunityTreeNode>(
					new CommunityTreeNode("路面與建物徵兆分級",
							community
									.getCommuntiyBuildings().getFactor()),
					child);

		case 7:
			return new DefaultTreeNode<CommunityTreeNode>(
					new CommunityTreeNode("人工邊坡徵兆分級",
							community
									.getCommuntiyManualSlope()
									.getFactor()), child);
		case 8:
			return new DefaultTreeNode<CommunityTreeNode>(
					new CommunityTreeNode("自然邊坡徵兆分級",
							community
									.getCommuntiyNaturalSlope()
									.getFactor()), child);
		case 9:
			ArrayList<Factor> list = new ArrayList<>();
			list.add(this.community.getCommunityBoundary());
			return new DefaultTreeNode<CommunityTreeNode>(
					new CommunityTreeNode("社區邊界", list));
		default:
			return null;
		}
	}

	private DefaultTreeNode<CommunityTreeNode> createDefaultTreeNode(
			CommunityTreeNode parent) {
		DefaultTreeNode<CommunityTreeNode> node = new DefaultTreeNode<CommunityTreeNode>(
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
