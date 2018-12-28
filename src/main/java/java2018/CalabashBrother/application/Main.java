package java2018.CalabashBrother.application;
	
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Rectangle2D; 
import java2018.CalabashBrother.BattleField.*;
import java2018.CalabashBrother.Beings.*;
import java2018.CalabashBrother.main.Director;
public class Main extends Application {
	Director director = new Director(new BattleFields(), new CalabashBrothers());
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
	Canvas canvas = null;
	GraphicsContext gc = null;
	@Override
	public void start(Stage primaryStage) {
		try {
			//响应空格
			SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");//设置日期格式
	          System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
	          String fileName=df.format(new Date())+".txt";
			TextField tf = new TextField();
			tf.setOnKeyReleased(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					System.err.println("setOnKeyReleased=");
					System.err.println("event.getChar()="+event.getCharacter());
					System.err.println("event.getText()="+event.getText());
					System.err.println("event.getCode()="+event.getCode());
				}
			});
			
			
			BorderPane root = new BorderPane();
			MainCanvas canvas=new MainCanvas();
			canvas.setFileName(fileName);
			primaryStage.setTitle("葫芦兄弟VS妖怪");
			MenuBar menuBar = new MenuBar();
			Menu fileMenu = new Menu("游戏");
			MenuItem newMenuItem = new MenuItem("历史对局");
		    newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
		    	public void handle(ActionEvent arg0) {
		    		
		    		FileChooser fileChooser1 = new FileChooser();
		    		fileChooser1.setTitle("Open");
		    		File file = fileChooser1.showOpenDialog(primaryStage);
		    		canvas.setFileName(file.getAbsolutePath());
		    		canvas.setPlay(false);
		    		//canvas.readBattleFields(file.getAbsolutePath());
		    	}
		    });
		    MenuItem saveMenuItem = new MenuItem("新对局");
		    saveMenuItem.setOnAction(new EventHandler<ActionEvent>() {
		    	public void handle(ActionEvent arg0) {
		    		canvas.newWar();
		    		//FileChooser fileChooser1 = new FileChooser();
		    		//fileChooser1.setTitle("new");
		    		//File file = fileChooser1.showSaveDialog(primaryStage);
		    	}
		    });
		    
		    
		    
		    
		    
		    MenuItem exitMenuItem = new MenuItem("退出");
		    exitMenuItem.setOnAction(actionEvent -> Platform.exit());
		    fileMenu.getItems().addAll( saveMenuItem,newMenuItem,
		            new SeparatorMenuItem(), exitMenuItem);

			menuBar.getMenus().add(fileMenu);
			/*
			//Canvas 
			canvas = new Canvas(1000, 500+menuBarHeight);
			//GraphicsContext 
			gc = canvas.getGraphicsContext2D();
			//root.setCenter(pictureRegion);
			*/
			
			System.out.println(menuBar.getWidth());
			/*
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
			*/
			
			
			root.getChildren().add(canvas);
			canvas.drawBackground();
			menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

			root.setTop(menuBar);
			
			
			Scene scene = new Scene(root,1000,500+menuBarHeight);
			//scene.addEventHandler(eventType, eventHandler);
			scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
				public void handle(KeyEvent event) {
					if(event.getCode()==KeyCode.SPACE) {
						canvas.flashBegin();
						//canvas.creatureThreadRun();
					}
					System.err.println("setOnKeyReleased=");
					System.err.println("event.getChar()="+event.getCharacter());
					System.err.println("event.getText()="+event.getText());
					System.err.println("event.getCode()="+event.getCode());
				}
			});
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			//while(true) {
			//primaryStage.show();
			//try {
			//	Thread.sleep(10000);
				
			//}catch(InterruptedException e) {
			//	e.printStackTrace();
			//}
			//}
			//gc.drawImage(GP, 600, 0+menuBarHeight,50,50);
			//while(true) {
			//	director.setPos();
			//	showBF(director.getBFs());
			//	primaryStage.show();
			//}
		} catch(Exception e) {
			e.printStackTrace();
		}//
		//while(true) {
			
		//}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
