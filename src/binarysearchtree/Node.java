
package binarysearchtree;

/**
 *
 * @author Guillermo Colin
 */

public class Node {

    //  Declare all the properties of a Node.
    int intData;                //  Define the value of this particular Node.
    public Node leftChild;      //  Define the Node's leftChild
    public Node rightChild;     //  Define the Node's rightChild
    public String placement;    //  Right or Left to its root
    public int particularRoot;  //  The root for this particular Node

    //  Node toString().
    @Override
    public String toString() {
        return "Node{" + "intData=" + intData + '}';
    }
    
    
}
