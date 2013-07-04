
public class BinaryTree {
	TreeNode root;
	
	public BinaryTree() {
		
	}
	
	public void add(int value) {
		if (root == null) {
			root = new TreeNode(value);
		} else {
			TreeNode current = root;
			
			boolean done = false;
			while (!done) {
				if (value < current.value) {
					if (current.left != null) 
						current = current.left;
					 else {
						current.left = new TreeNode(value);
						done = true;
					}
				}
				else {
					if (current.right != null) 
						current = current.right;
					 else {
						current.right = new TreeNode(value);
						done = true;
					}
				}
			}
		}
	}
	
	public boolean contains (int value) {
		TreeNode current = root;
		boolean done = false;
		
		while (!done) {
			if (current==null) {
				return false;
			}
			if (value == current.value) {
				return true;
			}
			else 
			if (value < current.value) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		
		return false;
	}
	
	public void print() {
		print(root,0);	
	}
	
	public void print(TreeNode node, int indent) {
		if (node == null) return;
		for (int i=0; i<indent; i++) {
			System.out.print(" ");
		}
		System.out.println(node.value);
		print(node.left, indent + 2);
		print(node.right, indent + 2);
	}
}
