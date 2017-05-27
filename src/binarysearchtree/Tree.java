
package binarysearchtree;

/**
 *
 * @author Guillermo Colin
 */

public class Tree {
    
    //  Root of the tree.
    public Node root; 
    
    //  Default constructor.
    public Tree(){
        root = null;
    }
    
    //  Function to add a node.
    public void add(int value){
        
        Node newNode = new Node();
        
        newNode.intData = value;
        
        if(root == null){         
            newNode.placement = "root";
            root = newNode;
            System.out.println("\n" + value + " added as root");
            
        }
        else{
            
            Node currentNode = root;
            Node parent; 
            
            while(true){
                
                parent = currentNode;
                
                if(newNode.intData < parent.intData){
                    newNode.particularRoot = parent.intData;
                    currentNode = currentNode.leftChild;
                    
                    if(currentNode == null){
                        parent.leftChild = newNode;
                        newNode.placement = "LEFT";
                        System.out.println("Child added Left");                      
                        return;
                    }
                }
                else{
                    newNode.particularRoot = parent.intData;
                    currentNode = currentNode.rightChild;
                    
                    if(currentNode == null){
                        parent.rightChild = newNode;
                        newNode.placement = "RIGHT";
                        System.out.println("Child added Right");
                        return;
                    }
                }
            }
        }
    }
    
    //  Function to remove a node.
    public void remove(int value){
        
        Node currentNode = root;
        Node parent = root;
        boolean isLeftChild = true;

        
        while(currentNode.intData != value){
            
            parent = currentNode;
            
            if(value < currentNode.intData){
                isLeftChild = true;
                currentNode = currentNode.leftChild;
            }
            else {
                isLeftChild = false;
                currentNode = currentNode.rightChild;
            }
            
            if(currentNode == null){
                System.out.println("\nNumber: "+ value +" does not exist\n");          
                break;
            }
            
        } 
 
        
        //  Node has no children
        if( currentNode.leftChild == null && currentNode.rightChild == null ){
            if(currentNode == root) root = null;
            if(isLeftChild){
                parent.leftChild = null;
            }
            else{
                parent.rightChild = null;
            }
        } 
        
        //  Node has one (LEFT) child 
        else if(currentNode.rightChild == null){
            
            if(currentNode == root) root = currentNode.leftChild;
            else if(isLeftChild){
                parent.leftChild = currentNode.leftChild;
                parent.leftChild.particularRoot = parent.intData;   //  Update the particularRoot for that node
            }
            else{   
                parent.rightChild = currentNode.leftChild;
            }
        }
        
        //  Node has one (RIGHT) child
        else if(currentNode.leftChild == null){
            
            if(currentNode == root) root = currentNode.rightChild;
            
            else if (isLeftChild){
                parent.leftChild = currentNode.rightChild;
                parent.leftChild.particularRoot = parent.intData;
                parent.leftChild.placement = "LEFT";
            }
            
            else{    
                parent.rightChild = currentNode.rightChild; //  Need to update particularRoot           
            }
        }
       
        //  Node has two children
        else{

            Node successor = getMinRSubT(currentNode);
            
            if(currentNode == root) root = successor;
            else if(isLeftChild){parent.leftChild = successor;}
            else{parent.rightChild = successor;}
            
            successor.leftChild = currentNode.leftChild;
            
            //  Update the particularRoot and placement for the successor.
            successor.particularRoot = parent.intData;
            successor.placement = "RIGHT";
            
            //  Update particularRoot(s)
            successor.leftChild.particularRoot = successor.intData;
            successor.rightChild.particularRoot = successor.intData;
            
            //  ignore-for testing purposes only
            /*System.out.println("Current parent is: " + parent.intData);
            System.out.println("Current node is: " + successor.intData);         
            System.out.println("Current node's left is: " + successor.leftChild.intData);
            System.out.println("Successor right child: " + successor.rightChild.intData);*/
            
        }

    }
    
    
    //  Get the min node on right subtree. Used when deleting a node with 2 children.
    public Node getMinRSubT(Node value){
        
        Node successorParent = value;
        Node successor = value;
        Node current = value.rightChild;
        
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
            
        }
        
        if(successor != value.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = value.rightChild;
        }
        
        return successor;
    }
    
    //  Print Tree in PreOrder. 
    public void printTree(Node currentNode){
        
        if(currentNode != null){
            System.out.print(currentNode.intData + " (" + currentNode.placement + ", root: "+ currentNode.particularRoot+ ")\t");
            printTree(currentNode.leftChild);
            printTree(currentNode.rightChild);
        }
    }
    
    
    //  Get the height of the tree
    public int getHeight(Node root)
    {

        if (root == null)
            return 0;
 
        if (root.leftChild == null && root.rightChild == null)
            return 1;
 
        if (root.leftChild == null)
            return getHeight(root.rightChild) + 1;
 
        if (root.rightChild == null)
            return getHeight(root.leftChild) + 1;
 
        return Math.max(getHeight(root.leftChild),
                        getHeight(root.rightChild)) + 1;
    }
    
}
