package view;
	
import java.io.IOException;
import controller.ControllerTelaInicio;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class TelaInicio extends Application {
	private String disciplina;
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public String getdisciplina() {
		return this.disciplina;
	}
	@Override
	public void start(Stage primaryStage) throws IOException {
		
			Parent root = FXMLLoader.load(getClass().getResource("TelaInicio.fxml"));
			Scene cena = new Scene(root);
			primaryStage.setTitle("Sistema de Geração de Provas(STEPS) ");
			primaryStage.setScene(cena);
			primaryStage.show();
	}
	
	 public void start(Stage primaryStage, String nomeDisciplina) throws IOException {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaInicio.fxml"));
	        Parent root = loader.load();

	        // Obtenha uma referência para o controlador
	        ControllerTelaInicio controller = loader.getController();

	        // Configure a disciplina no controlador
	        controller.preencherNome(nomeDisciplina);

	        Scene cena = new Scene(root);
	        primaryStage.setTitle("Sistema de Geração de Provas(STEPS) ");
	        primaryStage.setScene(cena);
	        primaryStage.show();
	    }
	

	
	public static void main(String[] args) throws Exception {
		launch();
	}
}