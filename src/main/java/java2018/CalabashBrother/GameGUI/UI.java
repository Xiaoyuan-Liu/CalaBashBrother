package java2018.CalabashBrother.GameGUI;

import java.io.File;

import java2018.CalabashBrother.BattleField.BattleFields;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UI {

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
	Stage primaryStage = new Stage();
	public void initiaize() {
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
			//Canvas 
			canvas = new Canvas(1000, 500+menuBarHeight);
			//GraphicsContext 
			gc = canvas.getGraphicsContext2D();
			//root.setCenter(pictureRegion);
			
			System.out.println(menuBar.getWidth());
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
			
			root.getChildren().add(canvas);
			
			menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

			root.setTop(menuBar);
			
			
			Scene scene = new Scene(root,1000,500+menuBarHeight);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void showBF(BattleFields BFs) {
		//String frontStr = "java2018.CalabashBrother.Beings.";
		gc.drawImage(BG, 0, 0+menuBarHeight,1000,500);
		for(int i = 0; i < 10;i++) {
			for(int j = 0; j < 20;j++) {
				if(BFs.isEmpty(i, j))continue;
				switch(BFs.creatureType(i, j)) {
				case "java2018.CalabashBrother.Beings.CalabashBrother":
					break;
				case "java2018.CalabashBrother.Beings.GrandPa":
					gc.drawImage(GP, 50*i, 50*j+menuBarHeight,50,50);
					break;
				case "java2018.CalabashBrother.Beings.LouLuo":
					gc.drawImage(LL, 50*i, 50*j+menuBarHeight,50,50);
					break;
				case "java2018.CalabashBrother.Beings.Snake":
					gc.drawImage(SN, 50*i, 50*j+menuBarHeight,50,50);
					break;
				case "java2018.CalabashBrother.Beings.Scorpion":
					gc.drawImage(CB1, 50*i, 50*j+menuBarHeight,50,50);
					break;
				}
			}
		}
	}
	
	
	
}
