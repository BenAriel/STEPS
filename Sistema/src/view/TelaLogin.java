package view;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class TelaLogin extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
			Parent root = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
			Scene cena = new Scene(root);
			primaryStage.setTitle("Sistema de Geração de Provas(STEPS) ");
			primaryStage.setScene(cena);
			primaryStage.show();
	}
	

	
	public static void main(String[] args) throws Exception {
		launch();
	}
}