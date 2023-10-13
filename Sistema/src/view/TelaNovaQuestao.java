package view;
	
import java.io.IOException;

import controller.ControllerNovaQuestao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class TelaNovaQuestao extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("TelaNovaQuestao.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setTitle("Sistema de Geração de Provas(STEPS) ");
		primaryStage.setScene(cena);
			primaryStage.show();
	}
	//adicionar nova questão
	 public void start(Stage primaryStage, String nomeDisciplina, String nomeUsuario) throws IOException {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaNovaQuestao.fxml"));
	        Parent root = loader.load();

	        // Obtenha uma referência para o controlador
	        ControllerNovaQuestao controller = loader.getController();

	        // Configure a disciplina no controlador
	        controller.preencherNome(nomeUsuario);
	        controller.setDisciplina(nomeDisciplina);
	        controller.getAdicionar().setVisible(true);

	        Scene cena = new Scene(root);
	        primaryStage.setTitle("Sistema de Geração de Provas(STEPS) ");
	        primaryStage.setScene(cena);
	        primaryStage.show();
	    }
	 //editar questão
	 public void start(Stage primaryStage, String nomeDisciplina, String nomeUsuario, int codigo) throws IOException {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaNovaQuestao.fxml"));
	        Parent root = loader.load();

	        // Obtenha uma referência para o controlador
	        ControllerNovaQuestao controller = loader.getController();

	        // Configure a disciplina no controlador
	        controller.setCodigoQuestao(codigo);
	        controller.preencherNome(nomeUsuario);
	        controller.preencherDisciplina(nomeDisciplina);
	        controller.getEditar().setVisible(true);
	        controller.preencherQuestao(codigo);

	        Scene cena = new Scene(root);
	        primaryStage.setTitle("Sistema de Geração de Provas(STEPS) ");
	        primaryStage.setScene(cena);
	        primaryStage.show();
	    }

	
	public static void main(String[] args) throws Exception {
		launch();
	}
}