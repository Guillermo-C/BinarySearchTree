/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

/**
 *
 * @author ninjamemo
 */
public class BinarySearchTree {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Tree myTree = new Tree();
        
        /*        myTree.add(44);
        myTree.add(94);
        myTree.add(92);
        myTree.add(93);
        myTree.add(90);
        myTree.add(34);
        myTree.add(14);
        myTree.add(4);
        myTree.add(-4);*/
        myTree.add(50);
        myTree.add(30);
        myTree.add(60);
        myTree.add(58);
        myTree.add(65);
        myTree.add(63);
        myTree.add(68);
        
        
        myTree.printTree(myTree.root);
        System.out.println();
        System.out.println("Height of the tree: " + myTree.getHeight(myTree.root));
        myTree.remove(60);
        myTree.printTree(myTree.root);
        
    }
    
}
