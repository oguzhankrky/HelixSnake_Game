public class Queue {
	private int rear, front;
	private Object[] elements;
	public Queue (int capacity) {
		elements=new Object[capacity];
		rear=-1;
		front=0;
	}
	public boolean isEmpty() {
		return rear<front;
	}
	public boolean isFull() {
		return (rear+1==elements.length);
	}
	public int Size() {
		return (rear-front +1);
	}
	public void enqueue(Object data) {
		if(!isFull()) {
			rear++;
			elements[rear]=data;
		}
	}
	public Object dequeue() 
	{
		if(!isEmpty()) {
			Object data =elements[front];
			elements[front]=null;
			front++;
			return data;
		}
		else
			return null;
	}
	public Object peek() {
		return  elements[front];
	}
	
	
	}

