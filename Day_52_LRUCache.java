/*

Implement an LRU (Least Recently Used) cache. 
It should be able to be initialized with a cache size n, and contain the following methods:

set(key, value): 
sets key to value. If there are already n items in the cache and we are adding a new item, 
then it should also remove the least recently used item.

get(key): 
gets the value at key. If no such key exists, return null.

Each operation should run in O(1) time.

*/

import java.util.HashMap;

public class Day_52_LRUCache{
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(2);
		lru.put(1,1);
		lru.put(2,2);
		System.out.println(lru.get(1));
		lru.put(3,3);
		System.out.println(lru.get(2));
		lru.put(4,4);
		System.out.println(lru.get(1));
		System.out.println(lru.get(3));
		System.out.println(lru.get(4));
	}

	// get() & put() Time is O(1)
	// space is O(n)
	static class LRUCache{
		static class Node{
			int key, val;
			Node prev, next;

			public Node(int key, int val){
				this.key = key;
				this.val = val;
			}
		}

		HashMap<Integer, Node> map = new HashMap<>();
		Node head, tail;
		int len = 0, capacity;

		/* Public methods */
		public LRUCache(int capacity) {
			this.capacity = capacity;
		}

		public int get(int key) {
			if(map.containsKey(key)){
				removeNode(key);
				addNode(key, map.get(key).val);
				return map.get(key).val;
			}

			return -1;
		}

		public void put(int key, int value) {
			if(!map.containsKey(key)){
				if(len == capacity)
				evictNode();
			}else{
				removeNode(key);
			}

			addNode(key, value);
		}

		public int size(){
			return len;
		}

		/* Private methods */
		private void addNode(int key, int val){
			if(len == 0){
				head = tail = new Node(key, val);
			}else{
				Node temp = new Node(key, val);
				tail.next = temp;
				temp.prev = tail;
				tail = temp;
			}

			map.put(key, tail);
			len++;
		}

		private void removeNode(int key){
			Node node = map.get(key);
			len--;

			if(node == tail){
				if(len == 0){
					head = tail = null;
				}else{
					tail = tail.prev;
					tail.next = null;
				}
			}else if(node == head){
				head = head.next;
				head.prev = null;
			}else{
				node.prev.next = node.next;
				node.next.prev = node.prev;
			}
		}

		private void evictNode(){
			map.remove(head.key);

			if(len == 1){
				head = tail = null;    
			}else{
				head = head.next;
				head.prev = null;
			}

			len--;
		}
	}
}