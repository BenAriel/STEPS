package controller;

import java.io.IOException;

import connection.MonitorDAO;
import entities.Monitor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.TelaLogin;

public class ControllerRedefinicao {

    @FXML
    private TextField login;//feito
    
    @FXML
    private TextField matricula;//feito

    @FXML
    private PasswordField novasenha;//feito
    
    @FXML
    private TextField nomecompleto;//feito

    @FXML
    private Button btRedefinicao;//feito

    @FXML
    private PasswordField repetirsenha;//feito

    @FXML
    private ImageView voltar;//feito

    @FXML
    void redefinicao(ActionEvent event) { //vai redefinir os valores e depois vai retornar para a tela principal
    	if( repetirsenha.getText().equals(novasenha.getText())){
    		System.out.println("Senhas iguais, iniciado redefinição!");
    		Monitor redefinicaoMonitor = new Monitor();
    		redefinicaoMonitor.setNomeMonitor(nomecompleto.getText());
    		redefinicaoMonitor.setLogin(login.getText());
    		redefinicaoMonitor.setMatricula(matricula.getText());
    		redefinicaoMonitor.setSenha(novasenha.getText());
    		MonitorDAO redefinidorMonitor = new MonitorDAO();
    		redefinidorMonitor.alterar(redefinicaoMonitor); //vai mandar alterar o monitor que tiver matrícula igual!
    		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // pega referencia da
    		// atual janela
        	primaryStage.close(); // fecha a atual janela
        	TelaLogin telaLogin = new TelaLogin();
        	try {
            	telaLogin.start(new Stage()); //manda os nomes corretos para a tela de provas!
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    	}
    }

    @FXML
    void telaanterior(MouseEvent event) {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // pega referencia da
		// atual janela
    	primaryStage.close(); // fecha a atual janela
    	TelaLogin telaLogin = new TelaLogin();
    	try {
        	telaLogin.start(new Stage()); //manda os nomes corretos para a tela de provas!
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
