
public class NodeD {

    private int data;
    private NodeD prev; 
    private NodeD next;
    private String name;

   public NodeD(int dataToAdd, String name) {
     data = dataToAdd;
     prev = null;
     next = null;
     this.name=name;
   }
	   
   public int getData2() {    // for only integer data
     return data;
   }
   public String getData() { // for writing player  to txt. 
	     return name+";"+data+"\n";
	   }
   public String getData3() {// For show all player in the DLL
	     return "  "+name+"  "+data;
	   }

   public void setData(int data) {
     this.data = data;
   }

   public NodeD getNext() {
     return next; 
   }

   public void setNext(NodeD next) {
     this.next = next;
   }
   
   public NodeD getPrev() {
	 return prev; 
   }

   public void setPrev(NodeD prev) {
     this.prev = prev;
   }
}
