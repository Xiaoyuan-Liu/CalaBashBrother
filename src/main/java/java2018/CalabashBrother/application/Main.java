package java2018.CalabashBrother.application;
	
import java.io.File;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	Canvas canvas = null;
	GraphicsContext gc = null;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			primaryStage.setTitle("葫芦兄弟VS妖怪");
			MenuBar menuBar = new MenuBar();
			Menu fileMenu = new Menu("File");
			MenuItem newMenuItem = new MenuItem("New");
		    MenuItem saveMenuItem = new MenuItem("Save");
		    MenuItem exitMenuItem = new MenuItem("Exit");
		    exitMenuItem.setOnAction(actionEvent -> Platform.exit());
		    fileMenu.getItems().addAll(newMenuItem, saveMenuItem,
		            new SeparatorMenuItem(), exitMenuItem);

			menuBar.getMenus().add(fileMenu);
			/*
			//Canvas 
			canvas = new Canvas(1000, 500+menuBarHeight);
			//GraphicsContext 
			gc = canvas.getGraphicsContext2D();
			//root.setCenter(pictureRegion);
			*/
			MainCanvas canvas=new MainCanvas();
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
			
			menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

			root.setTop(menuBar);
			
			
			Scene scene = new Scene(root,1000,500+menuBarHeight);
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
