package util.exchange;


/**
 * 属性结构中的节点<br>
 * <ul>
 * <li>每个节点都有一个唯一的id</li>
 * <li>顶层节点的parentId为0</li>
 * <li>每一个节点都可以有多个子节点</li>
 * </ul>
 */
public class TreeNode {

	private int id;
	private int parentId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

}
