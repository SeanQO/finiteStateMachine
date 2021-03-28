package model;

import java.util.List;

public class Node {
	
	private boolean input;
	private boolean output;
	private List<Node> destination;
	private boolean visited;
	private Character state;
	
	/**
	 * Constructs a new node based on its value
	 * @param value Value of the Node
	 */
	public Node(char state, List<Node> destination) {
		this.state = state;
		this.destination = destination;
		visited = false;
		
	}
	
	public Character getState() {
		return state;
	}
	
	public void setVisited(boolean input) {
		this.visited = input;
	}
	
	public boolean getVisited() {
		return visited;
	}
	
	public boolean isInput() {
		return input;
	}

	public void setInput(boolean input) {
		this.input = input;
	}

	public boolean isOutput() {
		return output;
	}

	public void setOutput(boolean output) {
		this.output = output;
	}

	public Node getDestinationOne() {
		return destination.get(0);
	}
	
	public Node getDestinationCero() {
		return destination.get(1);
	}
	
	public Character getDestinationOneState() {
		return destination.get(0).getState();
	}
	
	public Character getDestinationCeroState() {
		return destination.get(1).getState();
	}

	public void setDestination(List<Node> succesor) {
		this.destination = succesor;
	}

}
