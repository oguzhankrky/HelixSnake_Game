
import enigma.core.Enigma;

public class SingleLinkedList {
	enigma.console.Console cn = Enigma.getConsole("SNAKE GAME");
	private Node head;
	public int xCoordinate = 30; // Snake's first coordinate was created. 
	public int yCoordinate = 12;
	

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public SingleLinkedList() {
		head = null;
	}

	public void add(Object dataToAdd) {// for add object.

		Node newNode = new Node(dataToAdd, xCoordinate--, yCoordinate);
		if (head == null) {
			head = newNode;

		} else {
			Node temp = head;
			while (temp.getLink() != null) {
				temp = temp.getLink();
			}
			temp.setLink(newNode);

		}
	}

	public boolean checkSnakeParts() { // snake part was checked.
		Node temp = head;
		int headX = temp.getxCoordinate();
		int headY = temp.getyCoordinate();
		temp = temp.getLink();
		while (temp.getLink() != null)

		{
			if (temp.getxCoordinate() == headX && temp.getyCoordinate() == headY) {
				return true;
			}

			temp = temp.getLink();
		}

		return false;

	}

	public void addFront(Object dataToAdd, int x, int y) { // When snake eat  code  , this code is add to front. 

		Node newNode = new Node(dataToAdd, x--, y--);
		Node temp = head;
		head = newNode;
		head.setLink(temp);


	}

	public void addFront2(Object dataToAdd) {// add front for temp Sll. 
		
		if (head == null) {
			Node newNode = new Node(dataToAdd);
			head = newNode;
		} else {
			Node newNode = new Node(dataToAdd);
			Node temp = head;
			head = newNode;
			head.setLink(temp);
			while (temp.getLink() != null) {
				temp = temp.getLink();
			}
		}

	}

	

	public void setHeadXYCoordinate(int updatedxCoordinate, int updatedyCoordinate) // swap coordinates
	{
		Queue carryX = new Queue(99999);
		Queue carryY = new Queue(99999);

		Node temp = head;

		carryX.enqueue(updatedxCoordinate);
		carryY.enqueue(updatedyCoordinate);
		carryX.enqueue(head.getxCoordinate());
		carryY.enqueue(head.getyCoordinate());

		while (head.getLink() != null) {
			head.setxCoordinate((int) carryX.dequeue());
			head.setyCoordinate((int) carryY.dequeue());
			cn.getTextWindow().output(head.getxCoordinate(), head.getyCoordinate(), (char) head.getData());

			head = head.getLink();

			carryX.enqueue(head.getxCoordinate());
			carryY.enqueue(head.getyCoordinate());

		}
		cn.getTextWindow().output(head.getxCoordinate(), head.getyCoordinate(), ' ');
		head.setxCoordinate((int) carryX.dequeue());
		head.setyCoordinate((int) carryY.dequeue());
		cn.getTextWindow().output(head.getxCoordinate(), head.getyCoordinate(), (char) head.getData());

		head = temp;

	}

	public int getxHead() {
		return head.getxCoordinate();
	}

	public int getyHead() {
		return head.getyCoordinate();
	}

	

	public String display() {
		String output = "";
		Node temp = head;
		while (temp != null) {
			output += temp.getData() + " ";
			temp = temp.getLink();
		}
		return output;
	}

	public String display2(int size) {// for only determine the amino codons.
		String output = "";
		Node temp = head;
		int i = 0;
		for(int j=0;j<size-3;j++)
		{
			temp=temp.getLink();
		}
		while (temp != null & i < 3) {
			output += temp.getData();
			temp=temp.getLink();
			i++;
		}

		return output;
	}

	public String displayOne() {

		return (String) head.getData();
	}


	public int size() {// for determine the size. 
		int counter = 0;
		if (head != null) {

			Node temp = head;
			while (temp != null) {
				counter++;
				temp = temp.getLink();
			}
		}
		return counter;
	}

	
	
	
}
