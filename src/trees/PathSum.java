package trees;
import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
*/

public class PathSum {
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> currentResult = new ArrayList<Integer>();
		pathSum(root, sum, currentResult, result);
		return result;
	}

	public static void pathSum(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {
		if (root == null)
			return;
		currentResult.add(new Integer(root.val));
		if (root.left == null && root.right == null && sum == root.val) {
			result.add(new ArrayList<>(currentResult));
			currentResult.remove(currentResult.size() - 1);// don't forget to remove the last integer
			return;
		} else {
			pathSum(root.left, sum - root.val, currentResult, result);
			pathSum(root.right, sum - root.val, currentResult, result);
		}
		currentResult.remove(currentResult.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		List<List<Integer>> res = pathSum(root,22);
		System.out.println(res);
	}
}
