/*

Problem statement : 

An XOR linked list is a more memory efficient doubly linked list. 
Instead of each node holding next and prev fields, it holds a field named both, 
which is an XOR of the next node and the previous node. 

Implement an XOR linked list; 
it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.

If using a language that has no pointers (such as Python),
you can assume you have access to get_pointer and dereference_pointer functions that converts between nodes and memory addresses.

*/
import java.util.ArrayList;

public class Day_6_XORLinkedList{
    public static void main(String[] args){
        int[] nums = new int[]{1, 2, 3, 4}; // input
        
        XORLinkedList LL = new XORLinkedList();
        for(int x : nums){
            LL.add(x);
        }
        
        for(int i=0;i<LL.size();i++){
            Node x = LL.get(i);
            System.out.print(x.val + "," + x.both + " -> ");
        }
    }
    
    static class Node{
        int val, both;
        
        public Node(int val, int both){
            this.val = val;
            this.both = both;
        }
    }
    
    // Time O(1) for each method and Space O(n) for n elements in a data stream    
    static class XORLinkedList{
        private ArrayList<Node> list = new ArrayList<>();
        
        // Time O(1)
        public void add(int val){
            int size = list.size();
            int prevVal = 0;
            
            if(size > 0){
                Node prev = list.get(size-1);
                prev.both ^= val;
                prevVal = prev.val;
            }
            
            list.add(new Node(val, prevVal));
        }
        
        // Time O(1)
        public Node get(int index){
            if(index < list.size()){
                return list.get(index);
            }
            
            return null;
        }
        
        // Time O(1)
        public int size(){
            return list.size();
        }
    }
}