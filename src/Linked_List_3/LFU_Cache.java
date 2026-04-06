package Linked_List_3;

import java.util.*;

public class LFU_Cache {
	static class ListNode {
		int key;
		int value;
		int freq;
		ListNode prev;
		ListNode next;

		ListNode() {
		}

		ListNode(int key, int value) {
			this.key = key;
			this.value = value;
			this.freq = 1;
			this.prev = this.next = null;

		}
	}

	static class DoublyLinkedList {
		ListNode head = new ListNode(-1, -1);;
		ListNode tail = new ListNode(-1, -1);;

		DoublyLinkedList() {
			head.next = tail;
			tail.prev = head;
		}

		public void Insert(ListNode node) {
			ListNode nextNode = head.next;
			head.next = node;
			node.prev = head;
			node.next = nextNode;
			nextNode.prev = node;
		}

		public void Delete(ListNode node) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}

		public boolean isEmpty() {
			return head.next == tail;
		}
	}

	static class LFUCache {
		int minFreq;
		int capacity;
		Map<Integer, ListNode> keyMap;
		Map<Integer, DoublyLinkedList> freqMap;

		LFUCache(int capacity) {
			this.capacity = capacity;
			minFreq = 0;
			keyMap = new HashMap<>();
			freqMap = new HashMap<>();
		}

		private void Update(ListNode node) {
			int freq = node.freq;
			DoublyLinkedList list = freqMap.get(freq);
			list.Delete(node);
			if (freq == minFreq && list.isEmpty()) {
				minFreq++;
			}
			node.freq++;
			freqMap.putIfAbsent(node.freq, new DoublyLinkedList());
			freqMap.get(node.freq).Insert(node);

		}

		public int get(int key) {
			if (!keyMap.containsKey(key))
				return -1;
			ListNode node = keyMap.get(key);
			Update(node);
			return node.value;
		}

		public void put(int key, int value) {
			if (capacity == 0)
				return;
			if (keyMap.containsKey(key)) {
				ListNode CurrNode = keyMap.get(key);
				Update(CurrNode);
				CurrNode.value = value;
				return;
			}
			if (keyMap.size() == capacity) {
				DoublyLinkedList list = freqMap.get(minFreq);
				ListNode nodeToDelete = list.tail.prev;
				list.Delete(nodeToDelete);
				keyMap.remove(nodeToDelete.key);
			}
			ListNode newNode = new ListNode(key, value);
			minFreq = 1;
			keyMap.put(key, newNode);
			freqMap.putIfAbsent(1, new DoublyLinkedList());
			freqMap.get(1).Insert(newNode);
		}

	}

	public static void main(String[] args) {
		LFUCache cache = new LFUCache(3);

		cache.put(1, 10);
		cache.put(2, 20);
		cache.put(3, 30);

		System.out.println(cache.get(1)); // 10
		cache.put(4, 40); // removes least freq

		System.out.println(cache.get(2)); // -1
		System.out.println(cache.get(3)); // 30
		System.out.println(cache.get(1)); // 10
		System.out.println(cache.get(4)); // 40
	}

}
