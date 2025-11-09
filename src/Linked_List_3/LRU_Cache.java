package Linked_List_3;

import java.util.*;

public class LRU_Cache {

	static class LRUCache {

		static class ListNode {
			int key;
			int value;
			ListNode prev;
			ListNode next;

			ListNode(int key, int value) {
				this.key = key;
				this.value = value;
				this.prev = this.next = null;
			}
		}

		int capacity;
		Map<Integer, ListNode> CacheMap;
		ListNode head = new ListNode(-1, -1);
		ListNode tail = new ListNode(-1, -1);

		LRUCache(int capacity) {
			this.capacity = capacity;
			CacheMap = new LinkedHashMap<>();
			head.next = tail;
			tail.prev = head;
		}

		public void Insertion(ListNode node) {
			ListNode nextNode = head.next;
			head.next = node;
			node.prev = head;
			node.next = nextNode;
			nextNode.prev = node;
		}

		public void Deletion(ListNode node) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}

		public int get(int key) {
			if (!CacheMap.containsKey(key))
				return -1;
			ListNode node = CacheMap.get(key);
			Deletion(node);
			Insertion(node);
			return node.value;

		}

		public void put(int key, int value) {
			if (CacheMap.containsKey(key)) {
				ListNode node = CacheMap.get(key);
				node.value = value;
				Deletion(node);
				Insertion(node);
			} else {
				if (CacheMap.size() == capacity) {
					ListNode node = tail.prev;
					Deletion(node);
					CacheMap.remove(node.key);
				}
				ListNode newNode = new ListNode(key, value);
				Insertion(newNode);
				CacheMap.put(key, newNode);
			}

		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		cache.put(1, 10);
		cache.put(2, 20);
		cache.put(3, 30);

		System.out.println(cache.get(1)); // Access app 1 → should print 10
		cache.put(4, 40);
		System.out.println(cache.get(2)); // -1 (not found)
		System.out.println(cache.get(3)); // 30
		System.out.println(cache.get(1)); // 10
		System.out.println(cache.get(4)); // 40
	}

}
