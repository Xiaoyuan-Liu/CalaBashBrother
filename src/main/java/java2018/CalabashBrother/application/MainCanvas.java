package java2018.CalabashBrother.application;

import java.io.File;

import java2018.CalabashBrother.BattleField.BattleFields;
import java2018.CalabashBrother.Beings.CalabashBrothers;
import java2018.CalabashBrother.main.Director;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class MainCanvas extends Canvas{
	private BattleFields BFs;
	private Director director;
	private GraphicsContext gc;
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
			BG = new Image(new File("C:\\Users\\13668\\Desktop\\background.jpg").toURI().toURL().toString());
			CB1 = new Image(new File("C:\\Users\\13668\\Desktop\\1.jpg").toURI().toURL().toString());
			CB2 = new Image(new File("C:\\Users\\13668\\Desktop\\2.jpg").toURI().toURL().toString());
			CB3 = new Image(new File("C:\\Users\\13668\\Desktop\\3.jpg").toURI().toURL().toString());
			CB4 = new Image(new File("C:\\Users\\13668\\Desktop\\4.jpg").toURI().toURL().toString());
			CB5 = new Image(new File("C:\\Users\\13668\\Desktop\\5.jpg").toURI().toURL().toString());
			CB6 = new Image(new File("C:\\Users\\13668\\Desktop\\6.jpg").toURI().toURL().toString());
			CB7 = new Image(new File("C:\\Users\\13668\\Desktop\\7.jpg").toURI().toURL().toString());
			GP = new Image(new File("C:\\Users\\13668\\Desktop\\Grandpa.jpg").toURI().toURL().toString());
			LL = new Image(new File("C:\\Users\\13668\\Desktop\\LouLuo.jpg").toURI().toURL().toString());
			SC = new Image(new File("C:\\Users\\13668\\Desktop\\Scopion.jpg").toURI().toURL().toString());
			SN = new Image(new File("C:\\Users\\13668\\Desktop\\Snake.jpg").toURI().toURL().toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean isRunning = true;
	private long sleep = 100;
	
	private Thread thread = new Thread(new Runnable() {
		
		@Override
		public void run() {
			while(isRunning) {
				
				Platform.runLater(new Runnable() {
					
					@Override
					public void run() {
						draw();
						//update();
					}
				});
				try {
					Thread.sleep(1000);
					
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});
	public MainCanvas() {
		super(1000, 500+menuBarHeight);
		BFs=new BattleFields();
		director = new Director(BFs,new CalabashBrothers());
		gc = this.getGraphicsContext2D();
		gc.drawImage(BG, 0, 0+menuBarHeight,1000,500);
		gc.drawImage(CB1, 0, 0+menuBarHeight,50,50);
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
		
		gc.setLineWidth(2);
		
		for(int i = 0; i <= 20; i++)
			gc.strokeLine(50*i, 0+menuBarHeight, 50*i, 500+menuBarHeight);
		for(int i = 0; i <= 10;i++)
			gc.strokeLine(0, 50*i+menuBarHeight, 1000, 50*i+menuBarHeight);
		draw();
		thread.start();
	}
	public void draw() {
			//String frontStr = "java2018.CalabashBrother.Beings.";
			//gc.drawImage(BG, 0, 0+menuBarHeight,1000,500);
		
		director.setPos();
		gc.clearRect(0, 0, 1000, 500+menuBarHeight);
		gc.drawImage(BG, 0, 0+menuBarHeight,1000,500);
			for(int i = 0; i <= 20; i++)
				gc.strokeLine(50*i, 0+menuBarHeight, 50*i, 500+menuBarHeight);
			for(int i = 0; i <= 10;i++)
				gc.strokeLine(0, 50*i+menuBarHeight, 1000, 50*i+menuBarHeight);
			for(int i = 0; i < 10;i++) {
				for(int j = 0; j < 20;j++) {
					if(BFs.isEmpty(i, j))continue;
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
}
