package _007_Tree;

import java.util.List;

/**
 * @BelongsProject: ArithmeticCode
 * @Author: cct
 * @Description: TODO
 */
class Node {
    public int val;
    public List<Node> children;
    Node left;
    Node right;
    Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};