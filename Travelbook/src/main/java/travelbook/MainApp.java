package main.java.travelbook;
import java.io.IOException;
import java.util.Optional;
import javafx.scene.control.ButtonType;
import main.java.travelbook.view.LoginViewController;
import main.java.travelbook.view.MenuBar;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
public class MainApp extends Application {
   //This is just a test in order to show how explore page work but no methods is implemented for the graphic controller of this view
	private Stage rootStage;
	private BorderPane rootLayout;
	private LoginViewController controller;
	@Override
	public void start(Stage rootStage) {
		this.rootStage=rootStage;
		this.rootStage.setTitle("Travelbook");
		
		initRootLayout();
		controller.setMain(rootLayout);
		
	}
	private void initRootLayout() {
		try {
		AnchorPane exploreLayout;
		FXMLLoader loader= new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
		this.rootLayout=(BorderPane) loader.load();
		Scene scene=new Scene(rootLayout);
		rootStage.setScene(scene);
		FXMLLoader loader2=new FXMLLoader();
		loader2.setLocation(MainApp.class.getResource("view/LoginView.fxml"));
		exploreLayout=(AnchorPane) loader2.load();
		this.rootLayout.setCenter(exploreLayout);
		this.rootStage.show();
		controller=loader2.getController();
		System.out.println("1");
	}catch (IOException e){
		e.printStackTrace();
	}
	}
	public BorderPane getPane() {
		return this.rootLayout;
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
