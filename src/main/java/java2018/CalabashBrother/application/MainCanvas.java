package java2018.CalabashBrother.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java2018.CalabashBrother.BattleField.BattleFields;
import java2018.CalabashBrother.Beings.CalabashBrother;
import java2018.CalabashBrother.Beings.CalabashBrothers;
import java2018.CalabashBrother.main.Director;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

public class MainCanvas extends Canvas{
	private BattleFields BFs;
	private Director director;
	private GraphicsContext gc;
	private String fileName;
	boolean play;
	private FileWriter writer;
	private  BufferedReader reader;
	static Image BG;// = new Image(new File("C:\\Users\\13668\\Desktop\\background.jpg").toURI().toURL().toString());
	
	static Image CB1 = null;// = new Image(new File("C:\\Users\\13668\\Desktop\\1.jpg").toURI().toURL().toString());
	static Image CB2 = null;
	static Image CB3 = null;
	static Image CB4 = null;
	static Image CB5 = null;
	static Image CB6 = null;
	static Image CB7 = null;
	static Image GP = null;
	static Image LL = null;
	static Image SC = null;
	static Image SN = null;
	static int menuBarHeight = 35;
	static {
		try {
			BG = new Image(new File("resource/background.jpg").toURI().toURL().toString());
			CB1 = new Image(new File("resource/1.jpg").toURI().toURL().toString());
			CB2 = new Image(new File("resource/2.jpg").toURI().toURL().toString());
			CB3 = new Image(new File("resource/3.jpg").toURI().toURL().toString());
			CB4 = new Image(new File("resource/4.jpg").toURI().toURL().toString());
			CB5 = new Image(new File("resource/5.jpg").toURI().toURL().toString());
			CB6 = new Image(new File("resource/6.jpg").toURI().toURL().toString());
			CB7 = new Image(new File("resource/7.jpg").toURI().toURL().toString());
			GP = new Image(new File("resource/Grandpa.jpg").toURI().toURL().toString());
			LL = new Image(new File("resource/LouLuo.jpg").toURI().toURL().toString());
			SC = new Image(new File("resource/Scopion.jpg").toURI().toURL().toString());
			SN = new Image(new File("resource/Snake.jpg").toURI().toURL().toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean isRunning = true;
	private long sleep = 100;
	
	private Thread thread = new Thread(new Runnable() {
		
		@Override
		public void run() {
			if(play)creatureThreadRun();
			while(true) {
				System.err.println("running "+play);
				//draw();
				//BFs.BFOutput();
				Platform.runLater(()->{
					if(play) {
						saveBattleField();
					draw();
					}
					else
						replay();
					//BFs.BFOutput();
					//System.err.println(" ");
				});
				/*
				Platform.runLater(new Runnable() {
					
					@Override
					public void run() {
						draw();
						//update();
						BFs.BFOutput();
						System.out.println(" ");
					}
				});
				*/
				try {
					Thread.sleep(50);
					
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});
	public MainCanvas() {
		super(1000, 500+menuBarHeight);
		play = true;
		BFs=new BattleFields();
		director = new Director(BFs,new CalabashBrothers());
		gc = this.getGraphicsContext2D();
		gc.drawImage(BG, 0, 0+menuBarHeight,1000,500);
		/*gc.drawImage(CB1, 0, 0+menuBarHeight,50,50);
		gc.drawImage(CB2, 50, 0+menuBarHeight,50,50);
		gc.drawImage(CB3, 100, 0+menuBarHeight,50,50);
		gc.drawImage(CB4, 150, 0+menuBarHeight,50,50);
		gc.drawImage(CB5, 200, 0+menuBarHeight,50,50);
		gc.drawImage(CB6, 250, 0+menuBarHeight,50,50);
		gc.drawImage(CB7, 300, 0+menuBarHeight,50,50);
		gc.drawImage(GP, 350, 0+menuBarHeight,50,50);
		gc.drawImage(SC, 400, 0+menuBarHeight,50,50);
		gc.drawImage(SN, 450, 0+menuBarHeight,50,50);
		gc.drawImage(LL, 500, 0+menuBarHeight,50,50);
		*/
		gc.setLineWidth(2);
		
		for(int i = 0; i <= 20; i++)
			gc.strokeLine(50*i, 0+menuBarHeight, 50*i, 500+menuBarHeight);
		for(int i = 0; i <= 10;i++)
			gc.strokeLine(0, 50*i+menuBarHeight, 1000, 50*i+menuBarHeight);
		


		//thread.start();
		//creatureThreadRun();
	}
	public void flashBegin() {
		thread.start();
	}
	public void drawBackground() {
		gc.drawImage(BG, 0, 0+menuBarHeight,1000,500);
		for(int i = 0; i <= 20; i++)
			gc.strokeLine(50*i, 0+menuBarHeight, 50*i, 500+menuBarHeight);
		for(int i = 0; i <= 10;i++)
			gc.strokeLine(0, 50*i+menuBarHeight, 1000, 50*i+menuBarHeight);
	}
	public void newWar() {
		director.setPos();
		
		draw();
	}
	public void draw() {
			//String frontStr = "java2018.CalabashBrother.Beings.";
			//gc.drawImage(BG, 0, 0+menuBarHeight,1000,500);
		System.err.println("drawing");
		
		gc.clearRect(0, 0, 1000, 500+menuBarHeight);
		gc.drawImage(BG, 0, 0+menuBarHeight,1000,500);
			for(int i = 0; i <= 20; i++)
				gc.strokeLine(50*i, 0+menuBarHeight, 50*i, 500+menuBarHeight);
			for(int i = 0; i <= 10;i++)
				gc.strokeLine(0, 50*i+menuBarHeight, 1000, 50*i+menuBarHeight);
			for(int i = 0; i < 10;i++) {
				for(int j = 0; j < 20;j++) {
					if(BFs.isEmpty(i, j)||(!BFs.getCreature(i, j).isLiving()))continue;
					switch(BFs.creatureType(i, j)) {
					case "java2018.CalabashBrother.Beings.CalabashBrother":
						switch(BFs.CBName(i, j)) {
						case "老大":
							gc.drawImage(CB1, 50*j+1, 50*i+menuBarHeight+1,48,48);
							break;
						case "老二":
							gc.drawImage(CB2, 50*j+1, 50*i+menuBarHeight+1,48,48);
							break;
						case "老三":
							gc.drawImage(CB3, 50*j+1, 50*i+menuBarHeight+1,48,48);
							break;
						case "老四":
							gc.drawImage(CB4, 50*j+1, 50*i+menuBarHeight+1,48,48);
							break;
						case "老五":
							gc.drawImage(CB5, 50*j+1, 50*i+menuBarHeight+1,48,48);
							break;
						case "老六":
							gc.drawImage(CB6, 50*j+1, 50*i+menuBarHeight+1,48,48);
							break;
						case "老七":
							gc.drawImage(CB7, 50*j+1, 50*i+menuBarHeight+1,48,48);
							break;
						}
						
						
						
						
						break;
					case "java2018.CalabashBrother.Beings.GrandPa":
						gc.drawImage(GP, 50*j+1, 50*i+menuBarHeight+1,48,48);
						break;
					case "java2018.CalabashBrother.Beings.LouLuo":
						gc.drawImage(LL, 50*j+1, 50*i+menuBarHeight+2,48,48);
						break;
					case "java2018.CalabashBrother.Beings.Snake":
						gc.drawImage(SN, 50*j+1, 50*i+menuBarHeight+1,48,48);
						break;
					case "java2018.CalabashBrother.Beings.Scorpion":
						gc.drawImage(SC, 50*j+1, 50*i+menuBarHeight+1,48,48);
						break;
					}
				}
			}
		
	}
	public void creatureThreadRun() {
		BattleFields BFs= director.getBFs();
		gc.clearRect(0, 0, 1000, 500+menuBarHeight);
		gc.drawImage(BG, 0, 0+menuBarHeight,1000,500);
			for(int i = 0; i <= 20; i++)
				gc.strokeLine(50*i, 0+menuBarHeight, 50*i, 500+menuBarHeight);
			for(int i = 0; i <= 10;i++)
				gc.strokeLine(0, 50*i+menuBarHeight, 1000, 50*i+menuBarHeight);
		//ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 10;i++) {
			for(int j = 0;j<20;j++) {
				if(!BFs.isEmpty(i, j)) {
					Thread th = new Thread(BFs.getCreature(i, j));
					th.setDaemon(true);
					th.start();
					//exec.execute(BFs.getCreature(i, j));
				}
			}
		}
		//exec.shutdown();
	}
	public void setPlay(boolean play) {
		this.play=play;
		System.err.println(play);
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
		try {
			reader = new BufferedReader(new FileReader(new File(fileName)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void replay() {
		System.err.println("replaying");
		//this.saveBattleField("1.txt");
		/*
		for(int i = 0;i<10;i++) {
			String line=null;
			try {
				if((line = reader.readLine())!=null)
					System.err.println(line);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		*/
			gc.clearRect(0, 0, 1000, 500+menuBarHeight);
			gc.drawImage(BG, 0, 0+menuBarHeight,1000,500);
			for(int i = 0; i <= 20; i++)
				gc.strokeLine(50*i, 0+menuBarHeight, 50*i, 500+menuBarHeight);
			for(int i = 0; i <= 10;i++)
				gc.strokeLine(0, 50*i+menuBarHeight, 1000, 50*i+menuBarHeight);
			//while(true) {
				
			for(int i = 0;i<10;i++) {
				String line=null;
				try {
					if((line = reader.readLine())==null)return;
				
				System.err.println(line);
				String[]BFsLine = line.split(" ");
				System.out.println(BFsLine[0]);
				
					
				for(int j = 0; j < 20; j++) {
					switch(BFsLine[j]) {
					case "R":
						gc.drawImage(CB1, 50*j+1, 50*i+menuBarHeight+1,48,48);
						break;
					case "O":
						gc.drawImage(CB2, 50*j+1, 50*i+menuBarHeight+1,48,48);
						break;
					case "Y":
						gc.drawImage(CB3, 50*j+1, 50*i+menuBarHeight+1,48,48);
						break;
					case "G":
						gc.drawImage(CB4, 50*j+1, 50*i+menuBarHeight+1,48,48);
						break;
					case "C":
						gc.drawImage(CB5, 50*j+1, 50*i+menuBarHeight+1,48,48);
						break;
					case "B":
						gc.drawImage(CB6, 50*j+1, 50*i+menuBarHeight+1,48,48);
						break;
					case "P":
						gc.drawImage(CB7, 50*j+1, 50*i+menuBarHeight+1,48,48);
						break;
					case "g":
						gc.drawImage(GP, 50*j+1, 50*i+menuBarHeight+1,48,48);
						break;
					case "S":
						gc.drawImage(SC, 50*j+1, 50*i+menuBarHeight+1,48,48);
						break;
					case "L":
						gc.drawImage(LL, 50*j+1, 50*i+menuBarHeight+2,48,48);
						break;
					case "s":
						gc.drawImage(SN, 50*j+1, 50*i+menuBarHeight+1,48,48);
						break;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			
		//}
	}
	public void saveBattleField() {
		try {
			//打开写文件器，第二个参数表示为append
			writer = new FileWriter(fileName,true);
			for(int i = 0; i < 10;i++) {
				for(int j = 0; j < 20;j++) {
					if(BFs.isEmpty(i, j))writer.write("* ");
					else {
						switch(BFs.getCreature(i, j).getClass().getName()) {
						
						case "java2018.CalabashBrother.Beings.CalabashBrother":
							switch(((CalabashBrother)BFs.getCreature(i, j)).getNameAndColor()) {
							case RED:
								writer.write("R ");
								break;
							case ORANGE:
								writer.write("O ");
								break;
							case YELLOW:
								writer.write("Y ");
								break;
							case GREEN:
								writer.write("G ");
								break;
							case CYAN:
								writer.write("C ");
								break;
							case BLUE:
								writer.write("B ");
								break;
							case PURPLE:
								writer.write("P ");
							}
							break;
						case "java2018.CalabashBrother.Beings.GrandPa":
							writer.write("g ");
							break;
						case "java2018.CalabashBrother.Beings.Scorpion":
							writer.write("S ");
							break;
						case "java2018.CalabashBrother.Beings.LouLuo":
							writer.write("L ");
							break;
						case "java2018.CalabashBrother.Beings.Snake":
							writer.write("s ");
							break;
						}
					}
				}
				writer.write("\r\n");
			}
			//writer.write("\r\n");
			writer.close();
		}catch (IOException e) {  
            e.printStackTrace();  
        }  

	}
}
