package escape;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, inventoryLabel, inventoryLabelNumber, charakterLabel, charakterLabelName,LocLabel, LocLabelName;
	Font titleFont = new Font("Return of Ganon", Font.PLAIN, 100 );
	Font startFont = new Font("return of Ganon", Font.PLAIN, 50);
	Font textFont = new Font("return of Ganon", Font.PLAIN, 30);
	Font headerFont = new Font("return of Ganon", Font.PLAIN, 20);
	JButton startButton, choice1,choice2,choice3,choice4; 
	JTextArea mainTextArea;
	int playerInventory;
	String Charakter, position,Location;
	String firstCave ="first cave", bigCave ="big cave",narrowPass ="narrow pass", highupCave ="highup cave", floodedCave ="flooded cave",floodedHallway ="flooded hallway",wetCave ="wet cave";
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	

	
  public static void main(String[] args) {	
		new Game();
     } 
	public Game() {
		
		window = new JFrame();
		window.setSize(800, 600);
		//2360 x 1640
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds( 100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel ("ZUUL'S ESCAPE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 250, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton=new JButton("Start?");
		// startButton.addMouseMotionListener(null);
		//startButton.addMouseListener(MouseListenerl);
		//{
		//	startButton.setForeground(Color.cyan);
		//}
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.cyan);
		startButton.setFont(startFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
	
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
	}
	
	public void createGameScreen() {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100,100,600,250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea ("oh my god it looks actually awful wtf cunt");
		mainTextArea.setBounds(100,100,600,250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(textFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250,350,300,150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton ("choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(textFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton ("choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(textFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton ("choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(textFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton ("choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(textFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice3);
		 
		playerPanel = new JPanel();
		playerPanel.setBounds(100,15,600,50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		
		inventoryLabel = new JLabel("Items:");
		inventoryLabel.setFont(headerFont);
		inventoryLabel.setForeground(Color.white);
		playerPanel.add(inventoryLabel);
		inventoryLabelNumber = new JLabel();
		inventoryLabelNumber.setForeground(Color.cyan);
		inventoryLabelNumber.setFont(headerFont);
		playerPanel.add(inventoryLabelNumber);
		
		LocLabel = new JLabel("Location:");
		LocLabel.setFont(headerFont);
		LocLabel.setForeground(Color.white);
		playerPanel.add(LocLabel);
		LocLabelName = new JLabel();
		LocLabelName.setForeground(Color.cyan);
		LocLabelName.setFont(headerFont);
		playerPanel.add(LocLabelName);
		
		charakterLabel = new JLabel("Charakter:");
		charakterLabel.setFont(headerFont);
		charakterLabel.setForeground(Color.white);
		playerPanel.add(charakterLabel);
		charakterLabelName = new JLabel();
		charakterLabelName.setForeground(Color.cyan);
		charakterLabelName.setFont(headerFont);
		playerPanel.add(charakterLabelName);
		

		
		playerSetup();
	}
	public void playerSetup() {
		playerInventory = 0 ;
		Charakter =  "Cat";
	    Location = firstCave;
		charakterLabelName.setText(Charakter);
		inventoryLabelNumber.setText("" +  playerInventory);
		LocLabelName.setText(Location);
		
		firstCave();
	}
	//caves//
	public void firstCave() {
		Location= firstCave;
		position= "firstCave";
		mainTextArea.setText("What? where am I? It's dark here, where are my Friends? "
				+ " \n BUNNYY!!! FRET??  CONNYYY, LUNAAAA!! Where are you :("
				+ "\n We got split up, i have to find them!! ");
		choice1.setText("next Cave");
		choice2.setText("look around");
		choice3.setVisible(false);
		choice4.setVisible(false);

	}
	public void bigCave() {
		Location= bigCave;
		position="bigCave";
		mainTextArea.setText("wow this one is hugeeee!! \n how will i find them :(");
		choice1.setText("next Cave");
		choice2.setVisible(true);
		choice2.setText("look around");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void narrowPass() {
		Location= narrowPass;
		position="narrowPass";
		mainTextArea.setText("its so cramped in here");
		choice1.setText("next Cave");
		choice2.setVisible(true);
		choice2.setText("look around");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void highupCave() {
		Location= highupCave;
		position="highupCave";
		mainTextArea.setText("wow it was really difficult to get up here! \n is someone hereeee??");
		choice1.setText("next Cave");
		choice2.setVisible(true);
		choice2.setText("look around");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void floodedCave() {
		Location= floodedCave;
		position="floodedCave";
		mainTextArea.setText("It's completly flooded!");
		choice1.setText("next Cave");
		choice2.setVisible(true);
		choice2.setText("look around");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void floodedHallway() {
		Location= floodedHallway;
		position="floodedHallway";
		mainTextArea.setText("this part is flooded aswell!!");
		choice1.setText("next Cave");
		choice2.setVisible(true);
		choice2.setText("look around");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void wetCave() {
		Location= "wet cave";
		position="wetCave";
		mainTextArea.setText("the floor is completly wet; Luna would hate this");
		choice1.setText("next Cave");
		choice2.setVisible(true);
		choice2.setText("look around");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void smallCave() {
		Location= "small cave";
		position="smallCave";
		mainTextArea.setText("this one is tiny");
		choice1.setText("next Cave");
		choice2.setVisible(true);
		choice2.setText("look around");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void emptyCave() {
		Location= "empty cave";
		position="emptyCave";
		mainTextArea.setText("helloooo?? are you guys here?");
		choice1.setText("next Cave");
		choice2.setVisible(true);
		choice2.setText("look around");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void longPath() {
		Location= "long path";
		position="longPath";
		mainTextArea.setText("woah this is a really long path");
		choice1.setText("next Cave");
		choice2.setVisible(true);
		choice2.setText("look around");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void smallHole() {
		Location= "small hole";
		position="smallhole";
		mainTextArea.setText("it's so tiny, is it even possible to hide here?");
		choice1.setText("next Cave");
		choice2.setVisible(true);
		choice2.setText("look around");
		choice3.setVisible(false);
		choice4.setVisible(false);
}

	//next cave /look around//
	public void  nextCave1() {
		position="nextCave1";
		mainTextArea.setText("where next?");
		choice1.setText("big Cave");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void lookAround1() {
		position="lookAround1";
		mainTextArea.setText("nothing here, only one opening");
		choice1.setText("next Cave");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void  nextCave2() {
		position="nextCave2";
		mainTextArea.setText("where next?");
		choice1.setText("narrow pass");
		choice2.setVisible(true);
		choice2.setText("small cave");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void lookAround2() {
		position="lookAround2";
		mainTextArea.setText("a huge cave!! with two oppenings\n huh whats that on the floor?");
		choice1.setText("next Cave");
		choice2.setVisible(true);
		choice2.setText("take closer look");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void  nextCave3() {
		position="nextCave3";
		mainTextArea.setText("where next?");
		choice1.setText("big Cave");
		choice2.setVisible(true);
		choice2.setText("highup cave");
		choice3.setVisible(true);
		choice2.setText("flooded cave");
		choice4.setVisible(false);
	}
	public void lookAround3() {
		position="lookAround3";
		mainTextArea.setText("there are 3 oppenings in total, \n i cant get through the flooded cave or the highup one... \n there semms to be something on the floor");
		choice1.setText(" go back");
                choice2.setVisible(true);
		choice2.setText("take closer look");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void  nextCave4() {
		position="nextCave4";
		mainTextArea.setText("where next?");
		choice1.setText("back");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void lookAround4() {
		position="lookAround4";
		mainTextArea.setText("CONNYYY!!! I FOUND YOU ");
		choice1.setText("go back");
                choice2.setVisible(true);
		choice2.setText("give Conny her 'bow'");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void  nextCave5() {
		position="nextCave5";
		mainTextArea.setText("where next?");
		choice1.setText("back");
		choice2.setVisible(true);
		choice2.setText("narrow pass");
		choice3.setVisible(true);
		choice2.setText("flooded hallway");
		choice4.setVisible(false);
	}
	public void lookAround5() {
		position="lookAround5";
		mainTextArea.setText("everything is underwater,but i see two openings \n and something sparkeling on the floor...");
		choice1.setText("next cave");
		choice2.setVisible(true);
                choice2.setText("take closer look");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void  nextCave6() {
		position="nextCave6";
		mainTextArea.setText("where next?");
		choice1.setText("flooded cave");
		choice2.setVisible(true);
                choice2.setText("wet cave");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void lookAround6() {
		position="lookAround6";
		mainTextArea.setText("this path is still underwater...\n two oppenings but nothing else");
		choice1.setText("go");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void  nextCave7() {
		position="nextCave7";
		mainTextArea.setText("where next?");
		choice1.setText("back");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void lookAround7() {
		position="lookAround7";
		mainTextArea.setText(" it's so humid here... yeah Luna would definitly hate it...\n .... LUNA !!!??? IS THIS YOU I FOUND YOU FINALLY!!");
		choice1.setText("go back");
		choice2.setVisible(true);
        choice2.setText("give Luna her 'chains'");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void  nextCave8() {
		position="nextCave8";
		mainTextArea.setText("where next?");
		choice1.setText("big Cave");
		choice2.setVisible(true);
		choice2.setText("empty cave");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void lookAround8() {
		position="lookAround8";
		mainTextArea.setText("FRETTTT?? are you here ??? I found your Locket,,, FRET!!! THERE YOU ARE!!");
		choice1.setText("go");
		choice2.setVisible(true);
		choice2.setText("give Fret their 'Locket'");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void  nextCave9() {
		position="nextCave9";
		mainTextArea.setText("where next?");
		choice1.setText("small Cave");
		choice2.setVisible(true);
		choice2.setText("long path");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void lookAround9() {
		position="lookAround9";
		mainTextArea.setText("two oppnenings, but it seems two be pretty empty \n i think there's nothing here \n i should move o-- wait whats there on the floor?? ");
		choice1.setText("go");
		choice2.setVisible(true);
                choice2.setText("take closer look");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
    public void  nextCave10() {
		position="nextCave10";
		mainTextArea.setText("where next?");
		choice1.setText("empty cave");		
        choice2.setVisible(true);
        choice2.setText("small hole");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void lookAround10() {
		position="lookAround10";
		mainTextArea.setText("wow this is a reallyyyyyyy long pass, but theres nothing here ");
		choice1.setText("go");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void  nextCave11() {
		position="nextCave11";
		mainTextArea.setText("where next?");
		choice1.setText("back");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void lookAround11() {
		position="lookAround11";
		mainTextArea.setText("AH BUN-BUN THERE YOU ARE!! HOW DID YOU GET IN THIS SMALL SPACE?");
		choice1.setText("go back");
		choice2.setVisible(true);
                choice2.setText("give Bun-Bun his 'Key'");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}	
	public void closerLook2() {
		position="closerLook2";
		mainTextArea.setText("looks like a locket... isnt this FRET'S LOCKET !!??");
		choice1.setText("pick up");
		choice2.setVisible(true);
		choice2.setText("drop");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void closerLook3() {
		position="closerLook3";
		mainTextArea.setText("a ribbon, i think this is CONNY'S BOW !!!");
		choice1.setText("pick up");
		choice2.setVisible(true);
		choice2.setText("drop");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void closerLook5() {
		position="closerLook5";
		mainTextArea.setText("IT'S THE CHAIN FROM LUNA'S CAPE!!");
		choice1.setText("pick up");
		choice2.setVisible(true);
		choice2.setText("drop");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void closerLook9() {
		position="closerLook9";
		mainTextArea.setText("a key , why is this here???\n is this maybe BUN-BUN'S KEY??");
		choice1.setText("pick up");
		choice2.setVisible(true);
		choice2.setText("drop");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void giveItem4() {
		position="giveItem4";
		mainTextArea.setText("Conny here is your Bow now let's find the other's");
		choice1.setText("go");
		choice2.setVisible(true);
		choice2.setText("change to 'Conny'");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void giveItem7() {
		position="giveItem7";
		mainTextArea.setText("Luna! i found youre chains! now let's find the other's");
		choice1.setText("go");
		choice2.setVisible(true);
		choice2.setText("change to 'Luna'");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void giveItem8() {
		position="giveItem8";
		mainTextArea.setText("Fret here is your locket, i found it on the floor, now let's find the other's");
		choice1.setText("go");
		choice2.setVisible(true);
		choice2.setText("change to 'Fret'");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void giveItem11() {
		position="giveItem11";
		mainTextArea.setText("Bun-Bun i found your Key!!");
		choice1.setText("go");
		choice2.setVisible(true);
		choice2.setText("change to 'Bun-BUn'");
		choice3.setVisible(false);
		choice4.setVisible(false);
	}

	public void drop2() {
		position="drop2";
		mainTextArea.setText("this is junk, i dont need it");
		choice1.setText("go");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void pickup2() {
		position="pickup2";
		mainTextArea.setText("i'll pick it up, just in case");
		choice1.setText("go");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void drop3() {
		position="drop3";
		mainTextArea.setText("this is junk, i dont need it");
		choice1.setText("go");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void pickup3() {
		position="pickup3";
		mainTextArea.setText("i'll pick it up, just in case");
		choice1.setText("go");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void drop5() {
		position="drop5";
		mainTextArea.setText("this is junk, i dont need it");
		choice1.setText("go");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void pickup5() {
		position="pickup5";
		mainTextArea.setText("i'll pick it up, just in case");
		choice1.setText("go");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void drop9() {
		position="drop9";
		mainTextArea.setText("this is junk, i dont need it");
		choice1.setText("go");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void pickup9() {
		position="pickup9";
		mainTextArea.setText("i'll pick it up, just in case");
		choice1.setText("go");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	public void whatnow2() {
		position="whatnow2";
		mainTextArea.setText("what now");
		choice1.setText("next cave");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void whatnow3() {
		position="whatnow3";
		mainTextArea.setText("what now");
		choice1.setText("next cave");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void whatnow5() {
		position="whatnow5";
		mainTextArea.setText("what now");
		choice1.setText("next cave");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void whatnow9() {
		position="whatnow9";
		mainTextArea.setText("what now");
		choice1.setText("next cave");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}	

	
	public void win() {
		position="win";
		mainTextArea.setText("you saved all of your companions just in time!!!!");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	
	
 	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			createGameScreen();
		}
		
	}
public class ChoiceHandler implements ActionListener{
	public void actionPerformed(ActionEvent event) {
		
		String yourChoice = event.getActionCommand();
		
		switch(position) {
		case "firstCave":
			switch(yourChoice) {
			case "c1": nextCave1(); break;
			case "c2": lookAround1 (); break;
			}
			break;
		case "bigCave":
			switch(yourChoice) {
			case "c1": nextCave2(); break;
			case "c2": lookAround2 (); break;
			}
			break;
		case "narrowPass":
			switch(yourChoice) {
			case "c1": nextCave3(); break;
			case "c2": lookAround3 (); break;
			}
			break;
		case "highupCave":
			switch(yourChoice) {
			case "c1": nextCave4(); break;
			case "c2": lookAround4 (); break;
			}
			break;
		case "floodedCave":
			switch(yourChoice) {
			case "c1": nextCave5(); break;
			case "c2": lookAround5 (); break;
			}
			break;
		case "floodedHallway":
			switch(yourChoice) {
			case "c1": nextCave6(); break;
			case "c2": lookAround6 (); break;
			}
			break;
		case "wetCave":
			switch(yourChoice) {
			case "c1": nextCave7(); break;
			case "c2": lookAround7 (); break;
			}
			break;
		case "smallCave":
			switch(yourChoice) {
			case "c1": nextCave8(); break;
			case "c2": lookAround8 (); break;
			}
			break;
		case "emptyCave":
			switch(yourChoice) {
			case "c1": nextCave9(); break;
			case "c2": lookAround9 (); break;
			}
			break;
		case "longPath":
			switch(yourChoice) {
			case "c1": nextCave10(); break;
			case "c2": lookAround10 (); break;
			}
			break;
		case "smallHole":
			switch(yourChoice) {
			case "c1": nextCave11(); break;
			case "c2": lookAround11 (); break;
			}
			break;
			//1
					case "nextCave1":
						switch (yourChoice) {
						case "c1" : bigCave(); break;
						}
						break;
					case "lookAround1":
						switch (yourChoice) {
						case "c1" : nextCave1(); break;
						}
			//2
					case "nextCave2":
						switch (yourChoice) {
						case "c1" : narrowPass(); break;
			            case "c2" : smallCave(); break;
						}
						break;
					case "lookAround2":
						switch (yourChoice) {
						case "c1" : bigCave(); break;
			            case "c2" : closerLook2(); break;
						}
			//3
					case "nextCave3":
						switch (yourChoice) {
						case "c1" : bigCave(); break;
						case "c2" : highupCave(); break;
						case "c3" : floodedCave(); break;
						}
						break;
					case "lookAround3":
						switch (yourChoice) {
						case "c1" : bigCave(); break;
						case "c2" : closerLook3(); break;
						}
			//4
					case "nextCave4":
						switch (yourChoice) {
						case "c1" : narrowPass(); break;

						}
						break;
					case "lookAround4":
						switch (yourChoice) {
						case "c1" : narrowPass(); break;
						case "c2" : giveItem4(); break;
						}
			//5
					case "nextCave5":
						switch (yourChoice) {
						case "c1" : bigCave(); break;
						case "c2" : highupCave(); break;
						case "c3" : floodedCave(); break;
						}
						break;
					case "lookAround5":
						switch (yourChoice) {
						case "c1" : nextCave5(); break;
						case "c2" : closerLook5(); break;
						}
			//6
					case "nextCave6":
						switch (yourChoice) {
						case "c1" : floodedCave(); break;
						case "c2" : wetCave(); break;
						}
						break;
					case "lookAround6":
						switch (yourChoice) {
						case "c1" : nextCave6(); break;
						}
			//7
					case "nextCave7":
						switch (yourChoice) {
						case "c1" : floodedHallway(); break;
						}
						break;
					case "lookAround7":
						switch (yourChoice) {
						case "c1" : floodedHallway(); break;
						case "c2" : giveItem7(); break;
						}
			//8
					case "nextCave8":
						switch (yourChoice) {
						case "c1" : bigCave(); break;
						case "c2" : emptyCave(); break;
						}
						break;
					case "lookAround8":
						switch (yourChoice) {
						case "c1" : nextCave8(); break;
						case "c2" : giveItem8(); break;
						}
			//9
					case "nextCave9":
						switch (yourChoice) {
						case "c1" : smallCave(); break;
						case "c2" : longPath(); break;
						}
						break;
					case "lookAround9":
						switch (yourChoice) {
						case "c1" : nextCave9(); break;
						case "c2" : closerLook9(); break;
						}
			//10
					case "nextCave10":
						switch (yourChoice) {
						case "c1" : emptyCave(); break;
						case "c2" : smallHole(); break;
						}
						break;
					case "lookAround10":
						switch (yourChoice) {
						case "c1" : nextCave10(); break;
						}
			//11
					case "nextCave11":
						switch (yourChoice) {
						case "c1" : longPath(); break;
						}
						break;
					case "lookAround11":
						switch (yourChoice) {
						case "c1" : longPath(); break;
						case "c2" : giveItem11(); break;
						}
					case "closerLook9":
						switch (yourChoice) {
						case "c1" : pickup9(); break;
						case "c2" : drop9(); break;
						}
						break;
					case "closerLook5":
						switch (yourChoice) {
						case "c1" : pickup5(); break;
						case "c2" : drop5(); break;
						}
					case "closerLook3":
						switch (yourChoice) {
						case "c1" : pickup3(); break;
						case "c2" : drop3(); break;
						}
						break;
					case "closerLook2":
						switch (yourChoice) {
						case "c1" : pickup2(); break;
						case "c2" : drop2(); break;
						}
					case " pickup2":
						switch (yourChoice) {
						case "c1" : whatnow2(); break;
						}
					case " drop2":
						switch (yourChoice) {
						case "c1" : whatnow2(); break;
						}
					case " pickup3":
						switch (yourChoice) {
						case "c1" : whatnow3(); break;
						}
					case " drop3":
						switch (yourChoice) {
						case "c1" : whatnow3(); break;
						}
					case " pickup5":
						switch (yourChoice) {
						case "c1" : whatnow5(); break;
						}
					case " drop5":
						switch (yourChoice) {
						case "c1" : whatnow5(); break;
						}
					case " pickup9":
						switch (yourChoice) {
						case "c1" : whatnow9(); break;
						}
					case " drop9":
						switch (yourChoice) {
						case "c1" : whatnow9(); break;
						}
					case " whatnow2":
						switch (yourChoice) {
						case "c1" : nextCave2(); break;
						}
					case " whatnow3":
						switch (yourChoice) {
						case "c1" : nextCave3(); break;
						}
					case " whatnow5":
						switch (yourChoice) {
						case "c1" : nextCave5(); break;
						}
					case " whatnow9":
						switch (yourChoice) {
						case "c1" : nextCave9(); break;
						}
						
			}
		
		}
	}
	
}

