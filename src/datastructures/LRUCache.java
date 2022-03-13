package datastructures;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {
	private final int CACHE_SIZE;
	private Deque<Integer> cache;
	private HashSet<Integer> elements;
	
	public LRUCache(int capacity) {
		CACHE_SIZE = capacity;
		cache = new LinkedList<>();
		elements = new HashSet<>();
	}
	public void refer(int page) {
		if(!elements.contains(page)) {
			if(cache.size()==CACHE_SIZE) {
				int last = cache.removeLast();
				elements.remove(last);
			}
		}else {
			cache.remove(page);
		}
		cache.push(page);
		elements.add(page);
		
	}
	public void display() {
		Iterator<Integer> itr = cache.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	public static void main(String[] args) {
//		LRUCache cache = new LRUCache(4);
//		cache.refer(1);
//		cache.refer(2);
//		cache.refer(3);
//		cache.refer(4);
//		cache.refer(1);
//		cache.refer(3);
//		cache.display();
		System.out.println('a'-'z');
	}

}
