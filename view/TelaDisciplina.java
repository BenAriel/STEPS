package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import controller.ControllerDisciplina;

public class TelaDisciplina extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TelaDisciplina.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setTitle("Sistema de Geração de Provas(STEPS) ");
        primaryStage.setScene(cena);
        primaryStage.show();
    }

    // Método para passar o nome da disciplina para o controlador
    public void start(Stage primaryStage, String nomeDisciplina, String nomeUsuario) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaDisciplina.fxml"));
        Parent root = loader.load();

        // Obtenha uma referência para o controlador
        ControllerDisciplina controller = loader.getController();

        // Configure a disciplina no controlador
        controller.preencherDisciplina(nomeDisciplina);
        controller.preencherUsuario(nomeUsuario);

        Scene cena = new Scene(root);
        primaryStage.setTitle("Sistema de Geração de Provas(STEPS) ");
        primaryStage.setScene(cena);
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch();
    }
}
