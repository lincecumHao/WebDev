package tw.cddb.dao.bean;

import java.util.ArrayList;

public class CommunityTreeNode<E extends Object> {
	
	private String name;
	private ArrayList<E> children;
	
	public CommunityTreeNode(String name, ArrayList<E> children){
		this.name = name;
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<E> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<E> children) {
		this.children = children;
	}
	
	

}
