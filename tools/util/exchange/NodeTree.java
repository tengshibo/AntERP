package util.exchange;

import java.util.LinkedList;
import java.util.List;

public class NodeTree {

	private TreeNode tn;
	private List<NodeTree> children = new LinkedList<NodeTree>();

	public NodeTree() {
	}

	public NodeTree(TreeNode tn) {
		this.tn = tn;
	}

	public int getSelfId() {
		return this.getTn().getId();
	}

	public int getSelfParentId() {
		return this.getTn().getParentId();
	}

	public void addChild(NodeTree tn) {
		this.children.add(tn);
	}

	public TreeNode getTn() {
		return tn;
	}

	public void setTn(TreeNode tn) {
		this.tn = tn;
	}

	public List<NodeTree> getChildren() {
		return children;
	}

	public void setChildren(List<NodeTree> children) {
		this.children = children;
	}

}
