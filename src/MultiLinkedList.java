
public class MultiLinkedList {
	CategoryNode head;	
	int point;

	public void addCategory(String dataToAdd) {// for add  AminoAcids Category . 
		
		CategoryNode temp;
		if (head == null) {
			temp = new CategoryNode(dataToAdd); 
			head = temp;
		}
		
		else {		     
			temp = head;
			while (temp.getDown() != null)
				temp = temp.getDown();
			CategoryNode newnode = new CategoryNode(dataToAdd);
			temp.setDown(newnode);
		}
	}

	public void addItem(String Category, String Item,int point) {// for add aminoAcids to MLL with their point and category. 
		if (head == null)    
			System.out.println("Add a Category before Item");
		else {
			CategoryNode temp = head;
			while (temp != null)
			{	    	 
				if (Category.equals(temp.getCategoryName())) {
					ItemNode temp2 = temp.getRight(); 
					if (temp2 == null) {
						temp2 = new ItemNode(Item,point); 
						temp.setRight(temp2);
					}
					else {				 
						while (temp2.getNext() != null)
							temp2 = temp2.getNext();
						ItemNode newnode = new ItemNode(Item,point);
						temp2.setNext(newnode);
					}			          
				}
				temp = temp.getDown();
			}
		}
	}

	public int sizeCategory()// find size Category.
	{
		int count = 0;
		if (head == null)
			System.out.println("linked list is empty");
		else {
			CategoryNode temp = head;
			while (temp != null)
			{
				count++;
				temp=temp.getDown();
			}
		}
		return count;   
	}

	public int sizeItem() // for find size item . 
	{
		int count = 0;
		if (head == null)
			System.out.println("linked list is empty");
		else {
			CategoryNode temp = head;
			while (temp != null)
			{
				ItemNode temp2 = temp.getRight();
				while (temp2 != null)
				{
					count++;
					temp2 = temp2.getNext();
				}
				temp = temp.getDown();
			}
		}
		return count;   
	}

	public void display()// show all MLL  (it was used for test .)
	{
		if (head == null)    
			System.out.println("linked list is empty");
		else {
			CategoryNode temp = head;
			while (temp != null)
			{
				System.out.print(temp.getCategoryName() + " --> ");
				ItemNode temp2 = temp.getRight();
				while (temp2 != null)
				{
					System.out.print(temp2.getItemName() + " ");
					temp2 = temp2.getNext();
				}
				temp = temp.getDown();
				System.out.println();
			}
		}
	}

	public int serach(MultiLinkedList amino, String partOfSnake) {// if match part of snake, it is  determine amino point.  
		int point = 0;
		CategoryNode temp = amino.head;
		boolean flag = false;
		while (temp != null) {
			ItemNode temp2 = temp.getRight();
			while (temp2 != null) {

				if (partOfSnake.equalsIgnoreCase(temp2.getItemName())) {
					point = temp2.getPoint();
					flag = true;
					break;
				}
				if (flag)
					break;
				temp2 = temp2.getNext();
			}

			temp = temp.getDown();

		}
		if (!flag) {
			return 0;
		} else {
			return point;

		}
	}
	public String serach2(MultiLinkedList amino, String partOfSnake) {// if match part of snake, it is  determine amino point. Also it was used  for  show it . 
		int point = 0;
		CategoryNode temp = amino.head;
		boolean flag = false;
		while (temp != null) {
			ItemNode temp2 = temp.getRight();
			while (temp2 != null) {

				if (partOfSnake.equalsIgnoreCase(temp2.getItemName())) {
					point = temp2.getPoint();
					flag = true;
					break;
				}
				if (flag)
					break;
				temp2 = temp2.getNext();

			}

			temp = temp.getDown();

		}
		if (!flag) {
			return null ;
		} else {
			
			return partOfSnake+" - "+point;

		}
	}

}
