package linklist;

/**
 *Node class holds pointers for a Person object.  Nodes will
 * be used in a linked list.
 * 
 */
public class Node 
{
    //uses generic types so node object can be of any type.
        private Node nextNode;
        private Person nodeData;

        //constructor methods

        //default constructor
        public Node()
        {
            this.nodeData = null;
            this.nextNode = null;
        }

        //constructor to create new individual node pointing to nothing
        public Node(Person nodeData)
        {
            this.nodeData = nodeData;
            this.nextNode = null;
        }

        //constructor to specify the node to point to
        public Node(Person nodeData, Node nextNode)
        {
            this.nodeData = nodeData;
            this.nextNode = nextNode;
        }

        //accessor methods
        public Person getNodeData()
        {
            return nodeData;
        }
     
        public Node getNextNode()
        {
            return nextNode;
        }

        //mutator methods
        public void setNodeData(Person data)
        {
            this.nodeData = data;
        }

        public void setNextNode(Node next)
        {
            this.nextNode = next;
        }
   
}//end Node class
