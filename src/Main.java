import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		while(true){// All turn is continue until player enter 'Q' at the end of the game . 
		Management management =new Management();
		Snake snake=new Snake();
		snake.setGameFlag(true);
		management.freeMain();
		if(!management.restart()) {
			break;
		}
	}
	}

}
