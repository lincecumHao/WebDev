package tw.cddb.dao.bean.impl;

import java.util.ArrayList;

import tw.cddb.dao.bean.Factor;

public class CommunityTreeNode{
	
	private String name;
	private ArrayList<Factor> children;
	
	public CommunityTreeNode(String name, ArrayList<Factor> children){
		this.name = name;
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Factor> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Factor> children) {
		this.children = children;
	}
	
	

}
