import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DoubleLinkedList {
	private NodeD head;	
	private NodeD tail;

	public DoubleLinkedList() {
		head = null;
		tail = null;
	}
 
	public void add(Integer dataToAdd,String Name) {// for normal add
		NodeD newNodeD;
		if (head == null) {  //list is empty
			newNodeD = new NodeD(dataToAdd,Name); 
			head = newNodeD;
			tail = newNodeD;	     
		}
		else {   //add to the end
			newNodeD = new NodeD(dataToAdd,Name); 
			newNodeD.setPrev(tail);
			tail.setNext(newNodeD);				
			tail=newNodeD;			
		}
		
	}
	
	public void addPriority(Integer dataToAdd,String Name) { //it is necessary for add variables. priority 
		NodeD newNodeD;
		newNodeD = new NodeD(dataToAdd,Name);
		if (head == null) {  //list is empty
			 
			head = newNodeD;
			tail = newNodeD;	     
		}
		else if(dataToAdd>head.getData2()){   //add to the end
			NodeD temp=head;
			while(temp.getNext()!=null&&dataToAdd>temp.getNext().getData2()){
				temp=temp.getNext();
			}
			newNodeD.setPrev(temp);
			newNodeD.setNext(temp.getNext());
			if(temp.getNext()!=null)
			{
				temp.getNext().setPrev(newNodeD);
			}
			else
			tail=newNodeD;
			temp.setNext(newNodeD);
			
		}
		else {
			NodeD temp=head;
			temp.setPrev(newNodeD);
			newNodeD.setNext(head);
			head = newNodeD;
		}
		
		
	}
	
	
	public void addToTex(String data){// this is provide to write data to text. 
          try{
        	    
                File file = new File("Top10");
                FileWriter writer = new FileWriter(file,true);
                BufferedWriter write = new BufferedWriter(writer);
                PrintWriter pw = new PrintWriter("Top10");
                pw.close();
                write.write(data);
                write.close();
          }
          catch (Exception Error){
                Error.printStackTrace();
          }
    }
		

	public int size()// for determine the size of list. 
	{
		int count = 0;
		if (head == null)
			System.out.println("linked list is empty");
		else {
			NodeD temp = head;
			while (temp != null)
			{
				count++;
				temp=temp.getNext();
			}
		}
		return count;   
	}
	public String displayList()// Display list.
	{   
		String display="";
		if (head == null)    
			System.out.println("linked list is empty");
		else {
			NodeD temp = tail;
			
			while (temp != null)
			{
				display+=temp.getData();
				temp = temp.getPrev();
				
			}
			
		}
		return display;
		
	}	
	public void display1()// display from front until end. 
	{
		if (head == null)    
			System.out.println("linked list is empty");
		else {
			NodeD temp = head;
			
			while ( temp != null)
			{
				System.out.print(temp.getData() +" ");
				System.out.println();
				temp = temp.getNext();
				
			}
			
		}
		
	}	
	
	
	public void display2()// Display from tail
	{
		int i=0;
		if (head == null)    
			System.out.println("linked list is empty");
		else {
			NodeD temp = tail;
			while (temp != null&&i<10)
			{
				System.out.print(temp.getData3());
				temp = temp.getPrev();
				System.out.println();
				i++;
			}
			System.out.println();
		}
	}
	

	

	
}
