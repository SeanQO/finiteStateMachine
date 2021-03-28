package model;

import java.util.ArrayList;

import java.util.List;

public class Moore extends Automata{
	
	public Moore(List<Node> nodes) {
		super(nodes);
		
	}
	
	// partition(partitionOne());
	
	public List<List<Node>> partitionOne() {
		List<Node> nodesConected = relatedMachine();
		List<List<Node>> partitionList = new ArrayList<List<Node>>();

		for (Node node : nodesConected) {
			if (node.isOutput()) {
				partitionList.get(0).add(node);
				
			}else {
				partitionList.get(1).add(node);
				
			}
			
		}
		
		return partitionList;
	}

	public List<List<Node>> partition(List<List<Node>> pk){
		List<List<Node>> pki = pk;
		int size = pki.size();
		
		for (int i = 0; i < size; i++) {
			List<Node> partTemp = new ArrayList<>();
			int nodeListSize = pki.get(i).size();
			
			for (int j = 1; j < nodeListSize; j++) {
				if ((pki.get(i).get(0).getDestinationCero()).areEquivalent(pki.get(i).get(j).getDestinationCero(),pk) ) {
					if (!(pki.get(i).get(0).getDestinationOne()).areEquivalent(pki.get(i).get(j).getDestinationOne(),pk) ) {
						partTemp.add(pki.get(i).get(j));
						pki.get(i).remove(pki.get(i).get(j));
						nodeListSize --;
						j--;
					}
				}else {
					partTemp.add(pki.get(i).get(j));
					pki.get(i).remove(pki.get(i).get(j));
					nodeListSize --;
					j--;
				}
				
			}
			
			if (partTemp.size() != 0) {
				pki.add(partTemp);
			}
			
		}
		
		boolean exit = false;
		
		for (int i = 0; i < pk.size() && !exit ; i++) {
			
			for (int j = 0; j < pk.get(i).size() && !exit; j++) {
				if ( !pk.get(i).get(j).getState().equals(pki.get(i).get(j).getState()) ) {
					exit = true;
				}
				
			}
		}
		
		if (exit) {
			pki = partition(pki);
		}
		

		return pki;
	}
	
	
	@Override
	public String toString() {
		String nodesState = "";
		for (Node node : super.getNodes()) {
			nodesState += node.getState(); 
		}
		
		return nodesState;
	}
	
}
