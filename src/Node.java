

public class Node {
	 private Object data;
	 private Node link;
	 private int xCoordinate;
	 private int yCoordinate;
	 
	 
	 public Node (Object dataToAdd , int xCoordinate2 , int yCoordinate2 ) {// it is for  snake. 
		 data  =dataToAdd;
		 this.xCoordinate = xCoordinate2;
		 this.yCoordinate = yCoordinate2;
		 link=null;
		 
	 }
	 public Node (Object dataToAdd ) {// for created temp snake . coordinate is not necessary for it . 
		 data  =dataToAdd;
		 
		 
	 }
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	
	
}

