import java.awt.Color;
import java.awt.font.TextAttribute;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import enigma.core.Enigma;
import java.awt.Color.*;
import enigma.console.TextAttributes;
public class Management {
	
	public enigma.console.Console cn = Enigma.getConsole("Screen");
	Random random = new Random();
	char[][] Table = new char[28][63];//Table was created. 
	int time = 0; // Time zone
	int level = time % 20;// Level
	int score = 0;// Score
	boolean gameFlag = true; // for keep game situation (continue or stop)
	long startTime;
	long endTime;
	boolean Restart = false;
	static DoubleLinkedList keepscore = new DoubleLinkedList();//keepscore Lİnked list was created. 
	static int checkSetCurser = 0;
	static int checkSetCurser2 = 0;//this counter for set cursor. 
	static boolean checkFirstScreen=true;
	static int difficulty=1;
	MultiLinkedList amino = new MultiLinkedList();// amino Linked list was created. 
	
	public void firstScreen()
	{	// First Screen was designed. 
		
		Scanner scanner=new Scanner(System.in);
		
		int input;
		while(true) {
		
			Enigma.getConsole().setTextAttributes(new TextAttributes(Color.orange));
			cn.getTextWindow().setCursorPosition(0, 0);
		System.out.print("________________________________________________\n"
				+ "____________________ HELIX SNAKE MENU __________\n"+"   		 										  ____\n"		
				+" 							________________________/ O  \\___/\r\n" + 
				" 						   <_____________________________/   \\"						
				+ "\n"
				+ " 			1 - HARD\n"
				+ " 			2 - NORMAL\n"
				+ "			 3 - EASY\n"
				+ "\n");
				
			Enigma.getConsole().setTextAttributes(new TextAttributes(Color.lightGray));
			System.out.print(" How To Play\n"
				+ " You can use left(<-) and right(->) arrows on keyboard to play   the game\n"
				+ " Snake goes 1 box in 0.1 seconds(HARD)\n"
				+ " Snake goes 1 box in 0.5 seconds(NORMAL)\n"
				+ " Snake goes 1 box in 0.9 seconds(EASY)\n"
				+ " Don't touch walls at corners and surfaces\n"
				+ " Don't touch yourself\n"
				+ "\n");
			
			Enigma.getConsole().setTextAttributes(new TextAttributes(Color.WHITE));
			
			System.out.print("=> ");
			input=scanner.nextInt();
			Enigma.getConsole().setTextAttributes(new TextAttributes(Color.WHITE));
		if(input==1) {// game hardly choice was taken from players. 
		difficulty=input;
		break;
		}
		if(input==2) {
			difficulty=(input/2)*(5);
			break;
			}
		if(input==3) {
			difficulty=(input)*(3);
			break;
			}
		else
		{
			System.out.print("Invalid input");
			
		}
		for(int i=0;i<65;i++)  // for clear  the console. 
		{
			for(int j=0;j<30;j++)
			{
				cn.getTextWindow().setCursorPosition(i, j);
				System.out.print("          ");
			}
			
		}
		
		}
					
			}
	
	
	public void freeMain() throws IOException {  
		if(checkFirstScreen) {// First game was created. 
			firstScreen();
			checkFirstScreen=false;
			}
		
		amino = aminoAcids(amino); // amino are written from  txt . 

		cn.getTextWindow().setCursorPosition(0, -checkSetCurser);
		Enigma.getConsole("Game", 80, 30, 12, 0);  // Game Table. 
		screen();
		Scanner scanner=new Scanner(System.in);
		SingleLinkedList snake = new SingleLinkedList();
		Queue randomKey = new Queue(2880);
		
		snakeFirst(snake);// first was take was created. 
		createRandomVariable(randomKey, 3);// first random number was assigned to table . 

		Snake snakeclass = new Snake();
		
		showScreen(Table);// Table was showed.
		int checktempsize = 3;
		int numberOfFindAmino = 4;
		startTime = System.currentTimeMillis();
		for(int i=0;i<30;i++)// for clear console at every turn . 
		{
			cn.getTextWindow().setCursorPosition(65, i-checkSetCurser);
			System.out.print("          ");
		}
		while (gameFlag) {// game start
			endTime = System.currentTimeMillis();
			if ((endTime - startTime) >= 100*difficulty) { // Every 100 milliseconds the time will decreasing 1 second it depends on the difficulty variable . 
				startTime = System.currentTimeMillis();
				time++;
				if (snake.size() % checktempsize == 0) {// Amino chain was checked every snake was be multiples of three.
					
					SingleLinkedList tempSll = Revarsal(snake);

					score += amino.serach(amino, tempSll.display2(tempSll.size()));
					checktempsize += 3;
					if (amino.serach(amino, tempSll.display2(tempSll.size())) != 0) {
						cn.getTextWindow().setCursorPosition(65, numberOfFindAmino-checkSetCurser2-3);
						Enigma.getConsole().setTextAttributes(new TextAttributes(Color.lightGray));
						System.out.print(amino.serach2(amino, tempSll.display2(tempSll.size())));
						numberOfFindAmino++;

					}

				}

				if (snakeclass.checkTreeRandom()) { // This is provide table include  tree random numbers always. 
					createRandomVariable(randomKey, 1);
					snakeclass.TreeRandom();
					cn.getTextWindow().setCursorPosition(0, -checkSetCurser);
					showScreen(Table);
					score += 5;

				}

				if (time % 40 == 0 & !snakeclass.checkTreeRandom()) // level will be implement ..
				{
					level++;
					randomWall(); // random wall was added in every level loop .
					cn.getTextWindow().setCursorPosition(0, -checkSetCurser);
					showScreen(Table);
				} else if (time % 40 == 0) {
					randomWall();
					level++;
				}
				Table = snakeclass.takeKey(snake, Table);

				gameFlag = snakeclass.isGameFlag();

				showAttribute(time / 2, level, score);// Necessary attributed are showed. 

			}
		}

		cn.getTextWindow().setCursorPosition(65, 28- (checkSetCurser));
		Enigma.getConsole().setTextAttributes(new TextAttributes(Color.lightGray));
		System.out.println("Game over");
		cn.getTextWindow().setCursorPosition(0, 30 );
		System.out.print("Player name : ");
		String playerName;
		while(true) { // Player name was taken from player when game is end.
			playerName= scanner.nextLine();
			if(!playerName.equals("")) {
				break;}
			checkSetCurser++;
			checkSetCurser2++;
			System.out.print("Plase Enter Name : ");
			}
		keepscore.addPriority(score, playerName);// All turn player was added priority . 
		
		while (true) { // 'Try again' are asked.  
			System.out.println("Try Again ??  YES => Y NO =Q");
			System.out.print("Ask : ");
			String Ask = scanner.nextLine();
			if (Ask.equalsIgnoreCase("Y")) // start again !!!!!!!!!!!!!!!!!!!!!!!!!!!
			{

				Restart = true;
				checkSetCurser2 += 3;
				
				break;
			} else if (Ask.equalsIgnoreCase("Q")) {

			    
				keepscore = ScoreTable(keepscore);
				top10List(keepscore);
				break;
			} else {
				System.out.println("Try again");
				checkSetCurser+=3;
				checkSetCurser2+=3;
			}

		}
		checkSetCurser += 3;
		Enigma.getConsole().setTextAttributes(new TextAttributes(Color.white));

	}

	public boolean restart() {// provide to restart game.

		return Restart;

	}

	public void top10List(DoubleLinkedList keepscore) {// When User decided to finish game this function is called. 
		System.out.println("---name--point---- ");
		keepscore.display2();// only show all table
		keepscore.addToTex(keepscore.displayList());

	}

	public void screen() {// screen function.
		
		for (int i = 0; i <= 27; i++) {
			for (int j = 0; j <= 62; j++) {
				if (i == 0 || i == 27) {

					Table[i][j] = '#';
				} else if (j == 0 || j == 62) {

					Table[i][j] = '#';
				} else
					Table[i][j] = ' ';
			}
		}
		
	}


	public void randomWall() {// Random wall cretaing  function . 
		for (int i = 0; i < 1; i++) {
			int randomNumber = random.nextInt(62) + 1;
			int randomNumber2 = random.nextInt(27) + 1;
			if (Table[randomNumber2][randomNumber] == ' ') {
				Table[randomNumber2][randomNumber] = '#';
			} else
				i--;

		}
	}

	public void showScreen(char[][] Table) { // Show Screen Function. 
		
		
		for (int i = 0; i <= 27; i++) {
			for (int j = 0; j <= 62; j++) {
				if(i==0||i==27||j==0||j==62) {
				Enigma.getConsole().setTextAttributes(new TextAttributes(Color.orange));
				System.out.print(Table[i][j]);
				Enigma.getConsole().setTextAttributes(new TextAttributes(Color.WHITE));
				}
				else
				System.out.print(Table[i][j]);
			}
			System.out.println();

		}
		Enigma.getConsole().setTextAttributes(new TextAttributes(Color.WHITE));
	}

	public DoubleLinkedList ScoreTable(DoubleLinkedList keepscore) throws IOException { // Score Table are read . Also Score Table created thanks to DoubleLinkedList. 
		
		FileReader fileReader = new FileReader("Top10");
		String line;
		Enigma.getConsole().setTextAttributes(new TextAttributes(Color.ORANGE));
		BufferedReader br = new BufferedReader(fileReader);
		
		String[] split = null;
		while ((line = br.readLine()) != null) {
			line=line.trim();
			split = line.split(";",-1);
			if(split!=null) {
				for (int i = 0; i < split.length / 2; i++) {
					keepscore.addPriority(Integer.parseInt(split[i * 2+ 1]), split[(i * 2 )]);

				}
				
				}
				

		}
		br.close();
		
		return keepscore;
	}

	public MultiLinkedList aminoAcids(MultiLinkedList amino) throws IOException {// Amino Acids  are reed from txt which we have and  creted thank to  MultiLinkedList.
		FileReader fileReader = new FileReader("Amino");
		String line;

		BufferedReader br = new BufferedReader(fileReader);
		while ((line = br.readLine()) != null) {
			line = line.trim();
			String[] split = line.split(",", -1);
			amino.addCategory(split[0]);
			for (int i = 2; i < split.length; i++) {
				String[] split2 = split[i].split("-", -1);
				amino.addItem(split[0], split2[0], Integer.parseInt(split2[1]));

			}

		}
		return amino;

	}

	public void showAttribute(int time, int level, int score) {// Attribute was showed. 
		Enigma.getConsole().setTextAttributes(new TextAttributes(Color.green));
		cn.getTextWindow().setCursorPosition(65, 27 - (checkSetCurser));
		System.out.print("Time :" + time);
		cn.getTextWindow().setCursorPosition(65, 26 - (checkSetCurser));
		System.out.print("Level :" + level);
		cn.getTextWindow().setCursorPosition(65, 0 - (checkSetCurser));
		System.out.print("Score :" + score);
		cn.getTextWindow().setCursorPosition(0, 0 - (checkSetCurser)); 
		Enigma.getConsole().setTextAttributes(new TextAttributes(Color.white));
	}

	public SingleLinkedList snakeFirst(SingleLinkedList snake) {  //First snake was created randomly. 

		for (int i = 0; i < 3; i++) {
			Random random = new Random();
			int randomNumber = random.nextInt(4) + 1;
			if (randomNumber == 1) {
				snake.add('A');
			} else if (randomNumber == 2) {
				snake.add('T');
			} else if (randomNumber == 3) {
				snake.add('G');
			} else if (randomNumber == 4) {
				snake.add('C');
			}
		}
		return snake;
	}

	public Queue createRandomVariable(Queue randomKey, int countRandomKey)//Created random variable for table . 
	{
		for (int i = 0; i < countRandomKey; i++) {

			Random random = new Random();
			int randomNumber = random.nextInt(4) + 1;
			if (randomNumber == 1) {
				randomKey.enqueue('A');
			} else if (randomNumber == 2) {
				randomKey.enqueue('T');
			} else if (randomNumber == 3) {
				randomKey.enqueue('G');
			} else if (randomNumber == 4) {
				randomKey.enqueue('C');
			}
		}
		for (int i = 0; i < countRandomKey; i++) {
			int randomNumber = random.nextInt(62) + 1;
			int randomNumber2 = random.nextInt(27) + 1;
			if (Table[randomNumber2][randomNumber] == ' ') {
				Table[randomNumber2][randomNumber] = (char) randomKey.dequeue();
			} else
				i--;

		}
		return randomKey;

	}

	public SingleLinkedList Revarsal(SingleLinkedList Sll) {// it is reversal snake every turn for  calculate amino acid point . 
		SingleLinkedList tempSll = new SingleLinkedList();
		Node temp = Sll.getHead();
		while (temp != null) {

			tempSll.addFront2(temp.getData());
			temp = temp.getLink();

		}
		return tempSll;
	}

}
