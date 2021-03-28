package model;

import java.util.List;

public class Automata {
	
	private List<Node> nodes;
	private Node first;
	
	public Automata(List<Node> nodes) {
		this.nodes = nodes;
	}
	
	public void setFirst(Node node) {
		this.first = node;
	}
	
	public Node getFirst() {
		return first;
	}
	
	public List<Node> relatedMachine() {
		setTrue(nodes.get(0));
		for (Node node : nodes) {
			if (!node.getVisited()) {
				nodes.remove(node);
				
			}
			
		}
		
		return nodes;
	}
	
	
	private void setTrue(Node node) {
		node.setVisited(true);
		setTrue(node.getDestinationOne());
		setTrue(node.getDestinationCero());
		
	}
	
}
