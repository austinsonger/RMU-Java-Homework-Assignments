
/**
**************************************************************************************
*Array.Java
*Matthew Tait 3460396
*Created: Mar.21/13
*Last edited:
**************************************************************************************
*Type: Array
**************************************************************************************
*Purpose: 
**************************************************************************************
*Attributes: 
*           Node root
**************************************************************************************
*Methods: 
*           public void addElement(Data)
**************************************************************************************
 */
public class Array
{
    Node root;

    /**
     * Constructor for objects of class Array
     */
    public Array()
    {
       
    }//end constructor
    
    public void addElement(Data x)
    {
        Node z = new Node();
        if (root==null)
        {
            root = new Node();
        }//end if
        
        else
        {
            Node temp = root;
            while(temp.next != null)
            {
                temp = temp.getNext();
                temp.setNext(new Node());
            }
        }
      
        
    }

    
}
