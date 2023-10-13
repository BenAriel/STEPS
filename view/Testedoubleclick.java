package view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
public class Testedoubleclick extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Clique Duplo");

        // Defina um manipulador de eventos para o clique do mouse
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            private long lastClickTime = 0;

            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(javafx.scene.input.MouseButton.PRIMARY)) {
                    long currentTime = System.currentTimeMillis();
                    if (currentTime - lastClickTime < 300) {
                        // Duplo clique detectado
                        System.out.println("Duplo clique!");
                    }
                    lastClickTime = currentTime;
                }
            }
        });

        Scene scene = new Scene(button, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
