package linklist;

/**
 *Linked List class creates a singly linked list. With several methods for
 * changing and maintaining a linked list.
 * 
 */
public class LinkedList 
{
    //head pointer
    private Node head;

    //LinkedList constructor. Head property is a node with no data.
    public LinkedList()
    {
        this.head = null;
    }

    //Checks for an empty list.  Returns boolean value
    public boolean isListEmpty()
    {
        if(head == null)
        {
            return true;
        }

        return false;
    }// end isListEmpty
        
    //prints first name property for each Person object in the list
    public void printList()
    {
        Node currentNode = head;
        String nodeSocSec;
        
        if(this.head ==null)
        {
            System.out.println("List is empty");
        }else if (currentNode != null)
            {

                while(currentNode != null)
                {
                    nodeSocSec = currentNode.getNodeData().getFirstName();
                    System.out.println(nodeSocSec);

                    currentNode = currentNode.getNextNode();

                }
        }
    }//end printList
    

    //traverses list and returns list size as an integer
    public int listSize()
    {  
        int i;
        Node currentNode = head;

        for(i = 0; currentNode != null; i++)
        {
            currentNode = currentNode.getNextNode();
        }
        return (i);
    }// end listSize

    //points list head reference to new Node
    public void setHead(Node nodeToAdd)
    {
        this.head = nodeToAdd;    
    }

    //adds parameter Node to the end of the list
    public void append(Node nodeToAdd)
    {
        Node temp;
        temp = nodeToAdd;
        Node currentNode = head;

        if(head == null)
        {
            this.head = temp;
        }
        if(currentNode != null)
        {
           
            while(currentNode.getNextNode() != null)
            {
              currentNode = currentNode.getNextNode();
            }//end while
            currentNode.setNextNode(temp);
            
        }
        
    }//end append


    //adds parameter node to the beginning of the list
    public void prependNode(Node nodeToAdd)
    {
        if(head == null)
        {
            head = nodeToAdd;
        }else
        {
            nodeToAdd.setNextNode(head);
            head = nodeToAdd;
        }
    }//end prependNode

    //Method crawls list to find Node with String socialSecNum and adds parameter Node before found Node.
    public void addNodeBefore(Node nodeToAdd, String firstName)
    {
        Node temp;
        temp = nodeToAdd;

        Node currentNode = head;
        Node previousNode = head;
        
        //if head is not referencing any Node, then it will add temp Node to head
        if(currentNode == null)
        {
            this.head = temp;
        }else if(currentNode != null){ //loop will continue if it has not found socSecNumb passed as a parameter
            while(!(currentNode.getNodeData().getFirstName().equals(firstName)))
            {
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
            
            //New node points 
            temp.setNextNode(currentNode);
            previousNode.setNextNode(temp);
        }
    }//end addNodeBefore
    
    //takes a Node as a parameter and a String.  Adds the new parameter Node after
    //Node matching the firstName string parameter 
    public void addNodeAfter(Node nodeToAdd, String firstName)
    {
        Node currentNode = head;
        //Node afterNode = currentNode.getNextNode();
        
        if(head == null)
        {
            head = nodeToAdd;
        }
        else if(currentNode != null)
        {
            while(!(currentNode.getNodeData().getFirstName().equals(firstName)))
            {
                currentNode = currentNode.getNextNode();
              
            }//end while
            
            nodeToAdd.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(nodeToAdd);
        }//end else if
    }//end addNodeAfter
   
    //will delete Node before the node with Person object matching the firstName string parameter
    public void deleteNodeBefore(String firstName)
    {
        Node beforePreviousNode = head;
        Node previousNode = head;
        Node currentNode = head.getNextNode();
        
        if(head == null)
        {
            System.out.println("List is empty. There is nothing to delete");
        }//end if
        else if(currentNode != null)
            {
                
                while(!(currentNode.getNodeData().getFirstName().equals(firstName)))
                {
                    //exception if user enters a String matching the head Node firstName String
                    if(previousNode.getNodeData().getFirstName().equals(firstName))
                    {
                        System.out.println("There isn't a Node to delete before the Head Node. Please enter another name");
                        return;
                    }//end if
                   
                   beforePreviousNode = previousNode;
                   previousNode = currentNode;
                   currentNode = currentNode.getNextNode(); 
                }//end while

                beforePreviousNode.setNextNode(previousNode.getNextNode());
            }//end else if  
    }//end deleteNodeBefore
    
    //will delete a Node after Node with the matching Person firstName property for the firstName 
    //string parameter
    public void deleteNodeAfter(String firstName)
    {
        Node currentNode = head;
        Node afterNode = currentNode.getNextNode();
        
        if(head == null)
        {
            System.out.println("List is empty. There is nothing to delete");
        }
        else if(currentNode != null)
        {
            while(!(currentNode.getNodeData().getFirstName().equals(firstName)))
            {
                if(afterNode.getNextNode() == null)
                {
                    System.out.println("There is no Node after designated Node. There is nothing to delete");
                    return;
                }//end if
             
               currentNode = afterNode;
               afterNode =afterNode.getNextNode();
               
            }//end while
        
           
            currentNode.setNextNode(afterNode.getNextNode());
        }//end else if
    }//end deleteNodeAfter
  
    //Will delete head of the list and set it to next available list Node.
    public void deleteHead()
    {
        if (head == null)
        {
            System.out.println("Head is empty. There is nothing to delete");
        }
        if(head != null && head.getNextNode() !=null)
        {
            head = head.getNextNode();
        }
        if(head != null && head.getNextNode()== null)
        {
            head = null;
        }

    }// end deleteHead()

    //deletes last node in list
    public void deleteLastNode()
    {
        Node previousNode = head;
        Node currentNode = head;
        
        if(head == null)
        {
            System.out.println("List is empty. There is nothing to delete");
        }
        
        if(currentNode != null)
        {
            while(!(currentNode.getNextNode() == null))
            {
               previousNode = currentNode;
               currentNode = currentNode.getNextNode(); 
            }
            
            //previous node's next pointer becomes null dropping any reference to the last node
            previousNode.setNextNode(null);
        }
    }
    
    //Will return pointer to List's head
    public Node getHead()
    {
        return this.head;
    }//end deleteLastNode()

    //clones list (Nodes and data) and returns a Linked List copy
    public LinkedList cloneList()
    {   
        LinkedList copyOfLinkList = new LinkedList();
        Node currentNode = head;
        
        Node utilityNode;
        //copyOfLinkList.setHead(currentNode);
        if(currentNode == null)
        {
            System.out.println("List is empty. There's nothing to copy!");
        }else if(currentNode!= null)
            while(currentNode != null)
            {
               System.out.println("in while loop");
                utilityNode = new Node(currentNode.getNodeData());
                copyOfLinkList.append(utilityNode);
                currentNode = currentNode.getNextNode();
                //Node utilityNode = new Node();
            }
        return copyOfLinkList;
    }//end cloneList()
    
    //will return shallow copy of list
    public LinkedList copyList()
    {
        Node currentNode = head;

        LinkedList copyOfList = new LinkedList();

        copyOfList.head.setNextNode(currentNode.getNextNode());

        return copyOfList;
    }

    //will compare two lists based on size and return boolean value
    public boolean equalsList(LinkedList toCompare)
    {
        if(this.listSize() != toCompare.listSize())
        {   
            return false;
        }

        if(this.getHead() != toCompare.getHead())
        {
            return false;
        }

        return true;
    }
            
}//end LinkList class
