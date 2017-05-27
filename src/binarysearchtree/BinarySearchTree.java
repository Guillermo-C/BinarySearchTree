/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import java.util.Scanner;

/**
 *
 * @author ninjamemo
 */
public class BinarySearchTree {

    /**
     * @param args the command line arguments
     */
    
    static Scanner input = new Scanner(System.in);
    
    static Tree tree = new Tree();
    
    public static void menu(){
        
        int choice = 0;
        while (choice != -1){
            
            System.out.println("\n0: Add node");
            System.out.println("1: Remove node");
            System.out.println("2: Height of the tree");
            System.out.println("3: Print tree (preorder)");
            
            
            System.out.println("\nEnter an integer from the available choices (enter -1 to exit):\n");
            choice = input.nextInt();   input.nextLine();
            doMenu(tree,choice);
        }
    }
    
    public static void doMenu(Tree tree, int choice){
        int userInput = 0;
        
        switch(choice){
            case 0: System.out.println("\nType a non-existing value: ");
                    userInput = input.nextInt();    input.nextLine();
                    tree.add(userInput);
                    break;
            case 1: System.out.println("\nType an existing value: ");
                    userInput = input.nextInt();    input.nextLine();
                    tree.remove(userInput);
                    break;
            case 2: System.out.println("\nThe height of the tree is: " + tree.getHeight(tree.root));                
                    break;                   
            case 3: tree.printTree(tree.root);
                    break;
            
            default: 
                    break;
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Tree myTree = new Tree();
        
        /*        myTree.add(44);
        myTree.add(94);
        myTree.add(92);
        myTree.add(93);
        myTree.add(90);
        myTree.add(34);
        myTree.add(14);
        myTree.add(4);
        myTree.add(-4);*/
        
        //  For testing
        /*        myTree.add(50);
        myTree.add(30);
        myTree.add(60);
        myTree.add(58);
        myTree.add(65);
        myTree.add(63);
        myTree.add(68);*/
        
        
        //myTree.printTree(myTree.root);
        //System.out.println();
        //System.out.println("Height of the tree: " + myTree.getHeight(myTree.root));
        //myTree.remove(60);
        //myTree.printTree(myTree.root);
        
        menu();
        
    }
    
}
