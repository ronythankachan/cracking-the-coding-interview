package graphalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


public class Traversal {
	
	public static void depthFirst(Map<Character, List<Character>> graph, Character root) {
		
		Stack<Character> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Character node = stack.pop();
			System.out.println(node);
			if(graph.get(node)!=null)
			for(Character ch: graph.get(node)) {
				stack.push(ch);
			}
		}
		
	}
	
	public static void breadthFirst(Map<Character, List<Character>> graph, Character root) {
		
		Queue<Character> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Character node = queue.remove();
			System.out.println(node);
			if(graph.get(node)!=null)
			for(Character ch: graph.get(node)) {
				queue.add(ch);
			}
		}
		
	}	
	
	public static void main(String[] args) {
//		Map<Character,List<Character>> graph = new HashMap<>();
//		graph.put('a', Arrays.asList('b','c'));
//		graph.put('b', Arrays.asList('d'));
//		graph.put('c', Arrays.asList('e'));
//		graph.put('d', Arrays.asList('f'));
//		graph.put('f', new ArrayList<>());
//		Traversal.depthFirst(graph, 'a');
//		Traversal.breadthFirst(graph, 'a');
		String[] test = new String[10];
		test[0]= "hello";
		System.out.println(test[0]);
	}

}
