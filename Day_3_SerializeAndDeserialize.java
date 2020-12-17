/*

Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

class Node{
    String val;
    Node left, right;
    
    public Node(String val){
        this.val = val;
    }
}

The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'

*/

// Solution overall complexity - Time O(n), Space O(n)

import java.util.*;
public class Day_3_SerializeAndDeserialize{
    
    // The tree node structure and methods
    static class Node{
        String val;
        Node left, right;
        
        public Node(String val){
            this.val = val;
        }
        
        public Node(String val, Node left){
            this(val);
            this.left = left;
        }
        
        public Node(String val, Node left, Node right){
            this(val, left);
            this.right = right;
        }
    }
    
    public static void main(String[] args){
        Node root = new Node("root", new Node("left", new Node("left.left")), new Node("right"));
        System.out.println(deserialize(serialize(root)).left.left.val);// should print "left.left"
    }
    
    private static String serialize(Node root){
        // using string builder for efficiency
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    
    // Time : O(n) - DFS all the tree nodes
    private static void dfs(Node root, StringBuilder sb){
        if(root == null){
            sb.append("$Null,");
            return;
        }
        
        sb.append(root.val).append(",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }
    
    // Space O(n) - allocates n strings to a queue
    private static Node deserialize(String s){
        String[] nodes = s.split(",");
        Queue<String> q = new LinkedList<String>(Arrays.asList(nodes));
        return buildTree(q);
    }
    
    // Time O(n) - visits atmost n nodes || until all the n strings in a queue are polled
    private static Node buildTree(Queue<String> q){
        // if there's nothing then just break here
        if(q.size() == 0){
            return null;
        }
        
        String curr = q.poll();
        if(curr.equals("$Null")){
            return null;
        }
    
        // build the tree here
        Node root = new Node(curr);
        root.left = buildTree(q);
        root.right = buildTree(q);
        
        return root;
    }
    
}