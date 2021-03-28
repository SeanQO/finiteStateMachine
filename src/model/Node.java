package model;

import java.util.Arrays;
import java.util.List;

public class Node {
    // Attributes
    private boolean input;
    private boolean output;
    private List<Node> destination;
    private boolean visited;
    private boolean acceptance;
    private Character state;

    // Constructor

    /**
     * Constructs a new node based on its value
     *
     * @param destination It is a list with the destination of the output node 0 and 1
     * @param output      Node output value
     * @param state       It is the state of the node
     */
    public Node(char state, List<Node> destination, boolean output) {
        this.output = output;
        this.state = state;
        this.destination = destination;
        visited = false;

    }
    // Getters && Setters


    /**
     * Node acceptance
     *
     * @return The acceptance of the node
     */
    public boolean isAcceptance() {
        return acceptance;
    }

    /**
     * Sets the acceptance of the node
     *
     * @param acceptance Whether the node is accepted or not
     */

    public void setAcceptance(boolean acceptance) {
        this.acceptance = acceptance;
    }

    /**
     * Returns the state of the node
     *
     * @return state node status
     */

    public Character getState() {
        return state;
    }

    /**
     * Sets if the node has been visited
     *
     * @param input // preguntar <----------
     */

    public void setVisited(boolean input) {
        this.visited = input;
    }

    /**
     * Returns whether a node has been visited or not
     *
     * @return visited node
     */

    public boolean getVisited() {
        return visited;
    }

    /**
     * Return input // preguntar
     *
     * @return input
     */

    public boolean isInput() {
        return input;
    }

    /**
     * Sets the input
     *
     * @param input //preguntar
     */

    public void setInput(boolean input) {
        this.input = input;
    }

    /**
     * Returns the node's output
     *
     * @return output node output
     */

    public boolean isOutput() {
        return output;
    }

    /**
     * Sets node output
     *
     * @param output node output
     */

    public void setOutput(boolean output) {
        this.output = output;
    }

    /**
     * Returns the one destination of the node
     *
     * @return Node one destination
     */

    public Node getDestinationOne() {
        return destination.get(1);
    }

    /**
     * Returns the destinationCero of the node
     *
     * @return Node zero destination
     */

    public Node getDestinationCero() {
        return destination.get(0);
    }


    /**
     * preguntar <------------
     *
     * @param nodeB
     * @param pk
     * @return false or true if the nodes are equivalent or not
     */

    public boolean areEquivalent(Node nodeB, List<List<Node>> pk) {

        for (List<Node> list : pk) {
            if (!list.containsAll(Arrays.asList(this.getDestinationCero(), this.getDestinationOne(),
                    nodeB.getDestinationCero(), nodeB.getDestinationOne()))) {
                return false;
            }

        }

        return true;
    }

    /**
     * Returns the state of the destinationOneState
     *
     * @return the character at position 1
     */

    public Character getDestinationOneState() {
        return destination.get(1).getState();
    }

    /**
     * Returns the state of the destinationCeroState
     *
     * @return the character at position 0
     */

    public Character getDestinationCeroState() {
        return destination.get(0).getState();
    }

    /**
     * Sets the destination of the successor zero node of the destinationCero
     *
     * @param ceroSuccesor the successor node enters
     */

    public void setDestinationCero(Node ceroSuccesor) {
        destination.set(0, ceroSuccesor);
    }

    /**
     * Sets the destination of the successor one node of the destinationCero
     *
     * @param oneSuccesor the successor node enters
     */

    public void setDestinationOne(Node oneSuccesor) {
        destination.set(1, oneSuccesor);
    }

    /**
     * Sets to successor
     *
     * @param succesor node list
     */

    public void setDestination(List<Node> succesor) {
        this.destination = succesor;
    }

}
