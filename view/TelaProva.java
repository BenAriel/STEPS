package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import controller.ControllerProva;


public class TelaProva extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TelaProvas.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setTitle("Sistema de Geração de Provas(STEPS) ");
        primaryStage.setScene(cena);
        primaryStage.show();
    }

    // Método para passar o nome da disciplina para o controlador
    public void start(Stage primaryStage, String nomeDisciplina, String nomeUsuario) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaProvas.fxml"));
        Parent root = loader.load();
        
       
        // Obtenha uma referência para o controlador
        ControllerProva controller = loader.getController();
        if (nomeUsuario.equals("dr. Helihelcio da silva")) {
        	controller.getEditar().setVisible(true);
        	controller.getApagar().setVisible(true);
        }
        
        // Configure a disciplina no controlador
        controller.preencherDisciplina(nomeDisciplina);
        controller.preencherUsuario(nomeUsuario);
        
        System.out.println(nomeDisciplina);
        System.out.println(nomeUsuario);

        Scene cena = new Scene(root);
        primaryStage.setTitle("Sistema de Geração de Provas(STEPS) ");
        primaryStage.setScene(cena);
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch();
    }
}

