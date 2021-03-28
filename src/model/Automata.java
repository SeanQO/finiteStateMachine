package model;

import java.util.List;

public class Automata {
	
	private List<Node> nodes;
	private Node first;
	
	public Automata(List<Node> nodes) {
		this.nodes = nodes;
	}
	
	public List<Node> getNodes(){
		return nodes;
	}
	
	public void setNodes(List<Node> nodes){
		this.nodes = nodes; 
	}
	
	public void setFirst(Node node) {
		this.first = node;
	}
	
	public Node getFirst() {
		return first;
	}
	
	public List<Node> relatedMachine() {
		//System.out.println("node: " + nodes.get(0).getState());
		//System.out.println("dest: " + nodes.get(0).getDestinationCeroState() + nodes.get(0).getDestinationOneState() );
		setTrue(nodes.get(0));
		int size = nodes.size();
		
		for (int i = 0; i < size; i++) {
			if (!nodes.get(i).getVisited()) {
				nodes.remove(nodes.get(i));
				size --;
				i --;
			}
			
		}
		

		return nodes;
	}
	
	
	private void setTrue(Node node) {
		//System.out.println("node : " + node.getState());
		if (!node.getVisited()) {
			node.setVisited(true);
			//System.out.println("dest 0: " + node.getDestinationCeroState());
			setTrue(node.getDestinationCero());
			//System.out.println("dest 1: " + node.getDestinationOneState());
			setTrue(node.getDestinationOne());
		}
		
	}
	
}
