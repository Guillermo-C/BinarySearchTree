
package binarysearchtree;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Guillermo Colin
 */

public class BinarySearchTree {

    //  Initialize Scanner input to request input from the user. 
    static Scanner input = new Scanner(System.in);
    
    //  Initialize the tree. 
    static Tree tree = new Tree();
    
    //  Create a menu for the user to use (enter -1 to exit). 
    public static void menu(){
        
        int choice = 0;
        
        while (choice != -1){
            
            System.out.println("\n0: Add node");
            System.out.println("1: Remove node");
            System.out.println("2: Height of the tree");
            System.out.println("3: Print tree (preorder)");
            
            System.out.println("\nEnter an integer from the available choices (enter -1 to exit):\n");
            try{
                choice = input.nextInt();   input.nextLine();
                doMenu(tree,choice);
            }catch(InputMismatchException e){
                System.out.println("Sorry, I didn't understand your input.");
                break;
            }

        }
    }
    
    //  Execute the menu item as instructed by the user. 
    public static void doMenu(Tree tree, int choice){
        
        int userInput = 0;
        
        switch(choice){
            
            case 0: System.out.println("\nType a non-existing value: ");
                    userInput = input.nextInt();    input.nextLine();
                    try{
                        tree.add(userInput);
                    }catch(InputMismatchException e){
                        System.out.println("Not possible.");
                    }
                    break;
                    
            case 1: System.out.println("\nType an existing value: ");
                    userInput = input.nextInt();    input.nextLine();
                    try{
                        tree.remove(userInput);
                    }catch(NullPointerException e){
                        System.out.println("Not possible");
                    }
                    break;
                    
            case 2: System.out.println("\nThe height of the tree is: " + tree.getHeight(tree.root));                
                    break;       
                    
            case 3: tree.printTree(tree.root);
                    System.out.println();
                    break;           
            default: break;
            
        }
        
    }
    
    public static void main(String[] args) {
        
        //  Present menu to the user and execute accordingly.
        menu();
        
    }
    
}
