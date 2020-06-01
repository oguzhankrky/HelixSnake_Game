import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import enigma.console.TextAttributes;
import java.awt.Color;
public class Snake {
	
	public enigma.console.Console cn = Enigma.getConsole("SNAKE GAME");
	boolean treeCheckFlag=false;
	public  int tempkey;
	public int keypr = 0;
	public int a = 1;
	public int rkey;
	private static boolean gameFlag = true;
	
	public  boolean isGameFlag() {
		return gameFlag;
	}

	public  void setGameFlag(boolean gameFlag) {
		Snake.gameFlag = gameFlag;
	}
	
	
	public  char[][] takeKey(SingleLinkedList snake , char[][] Table ) // key  is taken from player. 
	{
		KeyListener klis; 
		
		keypr = 0;
		klis=new KeyListener() {
	         public void keyTyped(KeyEvent e) {}
	         public void keyPressed(KeyEvent e) {
	            
				if(keypr==0) {
	               keypr=1;
	               rkey = e.getKeyCode();
	            }
	         }
	         public void keyReleased(KeyEvent e) {}
	      };
	      cn.getTextWindow().addKeyListener(klis);
	      
		return move(snake , Table);
	      
	}
	
	public  char[][] move(SingleLinkedList snake , char[][] Table) // move events
	{
		
		
		if (rkey == KeyEvent.VK_RIGHT) {
			a++;
		}
			
		else if (rkey == KeyEvent.VK_LEFT) {
			a--;
		}
		
		rkey = -1;

		
		
	
		if (a == 1) //right
		{	
			if (Table[snake.getyHead()][snake.getxHead()+1] == '#') 
			{
				gameFlag = false; // when snake bump the wall game was finished.
			}
			else if (Table[snake.getyHead()][snake.getxHead()+1] == ' ') 
			{
				snake.setHeadXYCoordinate(snake.getxHead()+1,snake.getyHead());	//new coordinate was defined.
			}
			else 
			{
				snake.addFront(Table[snake.getyHead()][snake.getxHead()+1],snake.getxHead(),snake.getyHead());//when snake eat amino,new coordinate was determined.
				Table[snake.getyHead()][snake.getxHead()+1] = ' ';
				snake.setHeadXYCoordinate(snake.getxHead()+1,snake.getyHead());
				treeCheckFlag=true;
				
			}
		   
			
		}
				
		else if (a == 2) //down
		{	
			if (Table[snake.getyHead()+1][snake.getxHead()] == '#') 
			{
				gameFlag = false;// when snake bump the wall game was finished.
			}
			else if (Table[snake.getyHead()+1][snake.getxHead()] == ' ') 
			{
				snake.setHeadXYCoordinate(snake.getxHead(),snake.getyHead()+1);//new coordinate was defined.
			}
			else 
			{
				snake.addFront(Table[snake.getyHead()+1][snake.getxHead()],snake.getxHead(),snake.getyHead());//when snake eat amino,new coordinate was determined.
				Table[snake.getyHead()+1][snake.getxHead()] = ' ';
				snake.setHeadXYCoordinate(snake.getxHead(),snake.getyHead()+1);
				treeCheckFlag=true;
			
			}
		}
			
		else if (a == 3) //left
		{
			if (Table[snake.getyHead()][snake.getxHead()-1] == '#') 
			{
				gameFlag = false;// when snake bump the wall game was finished.
			}
			else if (Table[snake.getyHead()][snake.getxHead()-1] == ' ') 
			{
				snake.setHeadXYCoordinate(snake.getxHead()-1,snake.getyHead());	//new coordinate was defined.
			}
			else 
			{
				snake.addFront(Table[snake.getyHead()][snake.getxHead()-1],snake.getxHead(),snake.getyHead());//when snake eat amino,new coordinate was determined.
				Table[snake.getyHead()][snake.getxHead()-1] = ' ';
				snake.setHeadXYCoordinate(snake.getxHead()-1,snake.getyHead());	
				treeCheckFlag=true;
				
			}
			
		}	
		else if (a == 4) //top
		{
			if (Table[snake.getyHead()-1][snake.getxHead()] == '#') 
			{
				gameFlag = false;// when snake bump the wall game was finished.
			}
			else if (Table[snake.getyHead()-1][snake.getxHead()] == ' ') 
			{
				snake.setHeadXYCoordinate(snake.getxHead(),snake.getyHead()-1);	//new coordinate was defined.		
			}
			else 
			{
				snake.addFront(Table[snake.getyHead()-1][snake.getxHead()],snake.getxHead(),snake.getyHead());
				Table[snake.getyHead()-1][snake.getxHead()] = ' ';//when snake eat amino,new coordinate was determined.
				snake.setHeadXYCoordinate(snake.getxHead(),snake.getyHead()-1);		
				treeCheckFlag=true;
				
			}
		}
		if (snake.checkSnakeParts()) // if snake try to eat self, game flag turn false;
		{
			gameFlag = false;
		}
		
		if (a > 4)
			a = 1;
		if (a < 1)
			a = 4;
		
		
		return Table;
		
		
	}
	public boolean checkTreeRandom()// when snake eat a amino it is provide to call createRandomVariable.
	{
		
		return treeCheckFlag;
		
	}
	public void TreeRandom()
	{
		
		 treeCheckFlag=false;
		
	}
	
	

	
}

