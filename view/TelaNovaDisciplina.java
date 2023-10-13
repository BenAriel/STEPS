package view;
	
import java.io.IOException;

import controller.ControllerNovaDisciplina;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class TelaNovaDisciplina extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
			Parent root = FXMLLoader.load(getClass().getResource("TelaNovaDisciplina.fxml"));
			Scene cena = new Scene(root);
			primaryStage.setTitle("Sistema de Geração de Provas(STEPS) ");
			primaryStage.setScene(cena);
			primaryStage.show();
	}
	
	 public void start(Stage primaryStage, int codigo) throws IOException {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaNovaDisciplina.fxml"));
	        Parent root = loader.load();
	        
	       
	        // Obtenha uma referência para o controlador
	        ControllerNovaDisciplina controller = loader.getController();
	        
	        controller.setCodigo(codigo);     //passa o codigo referente a disciplina que desejamos editar para o controller

	        Scene cena = new Scene(root);
	        primaryStage.setTitle("Sistema de Geração de Provas(STEPS) ");
	        primaryStage.setScene(cena);
	        primaryStage.show();
	    }
	

	
	public static void main(String[] args) throws Exception {
		launch();
	}
}