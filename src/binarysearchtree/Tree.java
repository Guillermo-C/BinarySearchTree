/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import java.util.LinkedList;

/**
 *
 * @author ninjamemo
 */
public class Tree {
    
    public Node root; 

    public int height = 0;
    
    public LinkedList<Integer> treeContentList = new LinkedList();
    
    public Tree(){
        root = null;
    }
    
    public void add(int value){
        Node newNode = new Node();
        newNode.intData = value;
        
        if(root == null){
            newNode.placement = "root";
            root = newNode;
            
            //treeContentList.add(newNode.intData);
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
            
            /*            if(currentNode.intData == value){
            System.out.println("Value: " + value + " was found");
            break;
            }*/
            
            if(currentNode == null){
            //if(currentNode.leftChild == null && currentNode.rightChild == null){
                System.out.println("DIDN'T FIND SHIT");
                break;
            }
            
        }   //  End while
        
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
                    //  Need to update particularRoot
                System.out.println("Doing something wrong");    
                parent.rightChild = currentNode.leftChild;
            }
        }
        
        //  Node has one (RIGHT) child
        else if(currentNode.leftChild == null){
            System.out.println("Would happen here");
            if(currentNode == root) root = currentNode.rightChild;
            
            else if (isLeftChild){
                parent.leftChild = currentNode.rightChild;
                parent.leftChild.particularRoot = parent.intData;
                parent.leftChild.placement = "LEFT";
            System.out.println("Was left child");
            }
            
            else{
            //  Need to update particularRoot
            parent.rightChild = currentNode.rightChild;
            
            }
        }
       
        //  Node has two children
        else{
            //System.out.println("TWO CHILDREN");
            Node successor = getMinRSubT(currentNode);
            
            if(currentNode == root) root = successor;
            else if(isLeftChild){parent.leftChild = successor;}
            else{parent.rightChild = successor;}
            
            successor.leftChild = currentNode.leftChild;
            
            successor.particularRoot = parent.intData;
            successor.placement = "RIGHT";
            //  Update particularRoot(s)
            successor.leftChild.particularRoot = successor.intData;
            successor.rightChild.particularRoot = successor.intData;
            
            //  For testing purposes
            /*System.out.println("Current parent is: " + parent.intData);
            System.out.println("Current node is: " + successor.intData);         
            System.out.println("Current node's left is: " + successor.leftChild.intData);
            System.out.println("Successor right child: " + successor.rightChild.intData);*/
            
        }
        
        
        
    }
    
    
    //  Get the min node on right subtree
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
    
    
        /* Function to calculate the minimum depth of the tree */
    public int getHeight(Node root)
    {
        // Corner case. Should never be hit unless the code is
        // called on root = NULL
        if (root == null)
            return 0;
 
        // Base case : Leaf Node. This accounts for height = 1.
        if (root.leftChild == null && root.rightChild == null)
            return 1;
 
        // If left subtree is NULL, recur for right subtree
        if (root.leftChild == null)
            return getHeight(root.rightChild) + 1;
 
        // If right subtree is NULL, recur for right subtree
        if (root.rightChild == null)
            return getHeight(root.leftChild) + 1;
 
        return Math.max(getHeight(root.leftChild),
                        getHeight(root.rightChild)) + 1;
    }
}
