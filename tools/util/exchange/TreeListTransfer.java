package util.exchange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeListTransfer {

	/**
	 * 输入：没有填充children的树形结构节点列表.<br>
	 * 输出：填充children的树形结构列表.<br>
	 * 
	 * @param nodes
	 *            散乱的TreeNode节点
	 * @return 排序后的树形结构列表
	 */
	public List<NodeTree> sortNodes(List<TreeNode> nodes) {
		List<NodeTree> re = new ArrayList<NodeTree>();
		List<NodeTree> nts = new ArrayList<NodeTree>();
		for (TreeNode tn : nodes) {
			nts.add(new NodeTree(tn));
		}
		nts = Collections.synchronizedList(nts);
		synchronized (nts) {
			for (NodeTree nt1 : nts) {
				boolean matchFlag = false;
				for (NodeTree nt2 : nts) {
					if (nt1.getSelfParentId() == nt2.getSelfId()) {
						nt2.addChild(nt1);
						matchFlag = true;
						break;
					}
				}
				if (!matchFlag) {
					re.add(nt1);
				}
			}
		}
		return re;
	}

	private StringBuilder outPut(NodeTree nt) {
		// System.out.print("M:" + nt.getSelfId());
		StringBuilder re = new StringBuilder();
		re.append("M:" + nt.getSelfId() + "-");

		List<NodeTree> children = nt.getChildren();
		if (children.size() > 0) {
			for (NodeTree child : children) {
				re.append(this.outPut(child));
			}
		}
		return re;
	}

	public static void main(String[] args) {
		List<TreeNode> tns = new ArrayList<TreeNode>();
		TreeNode tn = new TreeNode();
		tn.setId(1);
		tn.setParentId(7);
		tns.add(tn);

		tn = new TreeNode();
		tn.setId(2);
		tn.setParentId(7);
		tns.add(tn);

		tn = new TreeNode();
		tn.setId(3);
		tn.setParentId(1);
		tns.add(tn);

		tn = new TreeNode();
		tn.setId(4);
		tn.setParentId(2);
		tns.add(tn);

		tn = new TreeNode();
		tn.setId(5);
		tn.setParentId(3);
		tns.add(tn);

		TreeListTransfer tts = new TreeListTransfer();
		List<NodeTree> nts = tts.sortNodes(tns);
		for (NodeTree nt : nts) {
			System.out.println(tts.outPut(nt));
		}
	}

}