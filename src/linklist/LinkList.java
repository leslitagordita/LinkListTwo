package linklist;
import java.util.Scanner;    //imports Scanner 
import java.io.*;

/**
 * @author Leslie Salazar
 * CSCI 211, Last modified October 28th, 2015.
 * Linked List Assignment number 2.
 *Program includes a Linked List class, a Node class and a Person class. Main method in Link List class
 *creates a linked list reading data from the personData.txt file.  All linked list methods are tested
 * in Link list's main method.
 */
public class LinkList 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        //Person class is the LinkedList data object.
        Person personData = new Person();
        
        //Linked list will hold Nodes of Person data
        LinkedList listOfFamily = new LinkedList();
        
        //File class object linked to personData.txt
        //personData.txt holds new line delimited data
        File linkFile;
        linkFile = new File("personData.txt");
        
        //Scanner class object to read input streem from linked text file
        Scanner fileStream = new Scanner(linkFile);
        
        //loop will dynamically assign values to instance of Person class 
        //values come from personData.txt
        while(fileStream.hasNextLine())
        {
            personData.setSocSecNumb(fileStream.nextLine());
            personData.setFirstName(fileStream.nextLine());
            personData.setLastName(fileStream.nextLine());
            personData.setEmail(fileStream.nextLine());
            personData.setDateOfBirth(fileStream.nextLine());
            
            //utilityNode.setNodeData(personData);
            Node utilityNode = new Node(personData);
            
            // reset the personData object to null porperties
            personData = new Person();
            
            //appends instance of Node to listOfFamily linkedlist
            listOfFamily.append(utilityNode);
            
           
            //System.out.println("this is the head"+listOfFamily.getHead());
        }
        
        //closes filestream
        fileStream.close();
/************************ ***************************************************************************/ 
    //First call to printList() method.  Output to console should include 9 names 
    //Names are the firstName property of the Person class
    listOfFamily.printList();
    
    //listSize method called
    System.out.println("\nThis is the list size of Family linked list: "+listOfFamily.listSize() +"\n");
    //System.out.println(listOfFamily.getHead().getNodeData());
    
    //Instantiating new Person object and adding it to new Node to use for
    //method testing
    Person salchi = new Person("987653678", "salchi", "salazar", "salchi@salazar.com", "111000");
    Node salchiNode = new Node(salchi);
    
    //method will prepend Node to Linked List
    listOfFamily.prependNode(salchiNode);
    
    //getHead() method is called to verify that salchi node was prepended to Linked list.
    System.out.println("New head of list after prepend method call is Node with First Name property: "+listOfFamily.getHead().getNodeData().getFirstName() + "\n");
    
    //method will delete the head of linked list
    listOfFamily.deleteHead();
    System.out.println("New head of list after delete head method call is Node with First Name property: "+listOfFamily.getHead().getNodeData().getFirstName() + "\n");
    
    //method will add new Node BEFORE the node containing the first name String parameter
    listOfFamily.addNodeBefore(salchiNode, "Agustin");
    //Print list method call to confirm that Node pointing to Person object with firstName salchi has been printed
    System.out.println("Salchi should be before Agustin\n");
    listOfFamily.printList();
    
    //method will delete node containing object with first name string property
    listOfFamily.deleteNodeBefore("Agustin");
    
    //Print list method call to confirm that Node before Node pointing to Person object with 
    //first name Agustin has been deleted
    System.out.println("\nSalch first name should no longer be in List\n");
    listOfFamily.printList();
    
      //method will add new Node After the node containing the first name String parameter
    listOfFamily.addNodeAfter(salchiNode, "Manuel");
    //Print list method call to confirm that Node pointing to Person object with firstName salchi has been printed
    System.out.println("\nSalchi should be after Manuel\n");
    listOfFamily.printList();
    
    //method will delete node containing object with first name string property
    listOfFamily.deleteNodeAfter("Manuel");
    
    //Print list method call to confirm that Node before Node pointing to Person object with 
    //first name Agustin has been deleted
    System.out.println("\nSalchi first name should no longer be in List\n");
    listOfFamily.printList();
    
    //Will print to console if list is empty calling the isListEmpty() method.
    System.out.println("Is the list empty?: " + listOfFamily.isListEmpty());
    
    //New linked list will be used to test the cloneList method()
    //Call to the clone list method and assigned to copyList
    LinkedList cloneOfList = listOfFamily.cloneList();
    
    //Call to printlist method on the cloned list, copyList
    System.out.println("\nThis the cloned list:\n");
    cloneOfList.printList();
    
    //will delete head method on original list to confirm the change does not
    //effect the cloned list
    listOfFamily.deleteHead();
    System.out.println("\nThis is the original list. Head \"leslie\" should be gone\n");
    listOfFamily.printList();
    
    //printlist method will be called on cloned list to confirm it still has leslie Node as head
    System.out.println("\nThis is cloned list. Leslie Node should still be head\n");
    cloneOfList.printList();
    
    //Compare list method will be called which compares if both lists are equal based on list size 
    System.out.println("\nAre the two lists the same size?: "+listOfFamily.equalsList(cloneOfList));
    
    
    
  
    
    
          
    }//end main class
    
}
