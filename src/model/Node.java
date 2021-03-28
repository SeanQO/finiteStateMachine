package model;

import java.util.Arrays;
import java.util.List;

public class Node {
	
	private boolean input;
	private boolean output;
	private List<Node> destination;
	private boolean visited;
	private boolean acceptance;
	private Character state;
	
	/**
	 * Constructs a new node based on its value
	 * @param value Value of the Node
	 */
	public Node(char state, List<Node> destination, boolean output) {
		this.output = output;
		this.state = state;
		this.destination = destination;
		visited = false;
		
	}
	
	
	
	public boolean isAcceptance() {
		return acceptance;
	}



	public void setAcceptance(boolean acceptance) {
		this.acceptance = acceptance;
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
		return destination.get(1);
	}
	
	public Node getDestinationCero() {
		return destination.get(0);
	}
	
	public boolean areEquivalent(Node nodeB, List<List<Node>> pk) {
	
		for (List<Node> list : pk) {
			if (!list.containsAll(Arrays.asList(this.getDestinationCero(),this.getDestinationOne(),
					nodeB.getDestinationCero(),nodeB.getDestinationOne()))) {
				return false;
			}
			
		}
		
		return true;
	}
	
	public Character getDestinationOneState() {
		return destination.get(1).getState();
	}
	
	public Character getDestinationCeroState() {
		return destination.get(0).getState();
	}
	
	public void setDestinationCero(Node ceroSuccesor) {
		destination.set(0, ceroSuccesor);
	}
	
	public void setDestinationOne(Node oneSuccesor) {
		destination.set(1, oneSuccesor);
	}
	
	public void setDestination(List<Node> succesor) {
		this.destination = succesor;
	}

}
