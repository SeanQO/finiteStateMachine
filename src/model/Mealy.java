package model;
import java.util.ArrayList;
import java.util.List;

public class Mealy extends Automata{

	public Mealy(List<Node> nodes) {
		super(nodes);
		
	}
	
	public void partition() {
		List<Node> nodesConected = relatedMachine();
		boolean[] output = new boolean[2];
		List<List<Node>> partitionList = new ArrayList<List<Node>>();

		for (Node node : nodesConected) {
			output[0] = node.getDestinationCero().isOutput();
			output[1] = node.getDestinationOne().isOutput();
			
		}
		
	}
	
}
