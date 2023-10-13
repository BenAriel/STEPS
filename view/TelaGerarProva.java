package view;

import java.io.IOException;

import controller.ControllerGerarProva;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class TelaGerarProva extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TelaGerarProva.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setTitle("Sistema de Geração de Provas(STEPS)");
        primaryStage.setScene(cena);
        primaryStage.show();
    }

    // Corrigi a assinatura deste método para aceitar parâmetros
    public void start(Stage primaryStage, String disciplinaNome, String usuarioNome) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaGerarProva.fxml")); // Corrigido para usar o FXML correto
        Parent root = loader.load();
        
        ControllerGerarProva controller = loader.getController();
        
        controller.setDisciplina(disciplinaNome);
        controller.setNomeusuario(usuarioNome);
        System.out.println(controller.getDisciplina());
        System.out.println(controller.getNomeusuario());
        
        Scene cena = new Scene(root);
        primaryStage.setTitle("Sistema de Geração de Provas(STEPS)");
        primaryStage.setScene(cena);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}