import java.util.Scanner;
/**
**************************************************************************************
*Node.Java
*Matthew Tait 3460396
*Created: Mar.21/13
*Last edited:
**************************************************************************************
*Type:  Node
**************************************************************************************
*Purpose: 
**************************************************************************************
*Attributes:
*           protected int universe
*           protected Data x
**************************************************************************************
*Methods:
*           public void setNext()
*           public int getNext()
**************************************************************************************
 */
public class Node
{
    protected int y;
    protected Data x;
    protected Node next;
    
    public Node()
    {
        x = new Data(y);
        
        next = null;
    }//end constructor

    public void setInt()
    {
        Scanner key = new Scanner(System.in);
        y = key.nextInt();
        
    }//end setInt
    
    public int getInt()
    {
        return y;
    }//end getInt
    
    public Node getNext()
    {
        return next;
    }
    
    public void setNext(Node z)
    {
        Node v  = new Node();
        v = z;
    }
}
