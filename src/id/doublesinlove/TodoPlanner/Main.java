package id.doublesinlove.TodoPlanner;

/**
 * @file    	: Main.java
 * @author 		: Novia Ismi Nuqoyati
 * @date		: 3 Jun 2017
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/id/doublesinlove/TodoPlanner/Main.fxml"));
			Scene scene = new Scene(root,644,503);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
