package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import view.TelaGerarProva;
import view.TelaInicio;
import view.TelaLogin;
import view.TelaProva;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.TelaQuestao;

public class ControllerDisciplina {
	
    @FXML
    private Button abrirprovas;//feito

    @FXML
    private Button abrirquestoes;//feito

    @FXML
    private ImageView sair;//feito

    @FXML
	public Label disciplina;//feito

    @FXML
    private Button abrirgeraradorprovas;//feito

    @FXML
    private Label nomeusuario;//feito
    
    @FXML
    private ImageView voltar;//feito
    
    @FXML
    void abrirprovas(ActionEvent event) throws IOException {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaProva telaProva = new TelaProva();
    	telaProva.start(new Stage(),this.disciplina.getText(), this.nomeusuario.getText()); //manda os nomes corretos para a tela de provas!
    	
    }

    @FXML
    void abrirquestoes(ActionEvent event) throws IOException {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaQuestao telaQuestao = new TelaQuestao();
    	telaQuestao.start(new Stage(),this.disciplina.getText(), this.nomeusuario.getText()); //manda os nomes corretos para a tela de provas!
    }

    @FXML
    void deslogar(MouseEvent event) {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // pega referencia da
		// atual janela
    	primaryStage.close(); // fecha a atual janela
    	TelaLogin telaLogin = new TelaLogin();
    	try {
			telaLogin.start(new Stage()); //abre de volta a primeira tela de login!
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }	
    

    @FXML
    void gerarprovas(ActionEvent event) throws IOException {//NÃO FEITO
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaGerarProva retornar = new TelaGerarProva();
    	retornar.start(new Stage(),this.disciplina.getText(), this.nomeusuario.getText() );
    }

    @FXML
    void telaanterior(MouseEvent event) {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // pega referencia da
		// atual janela
    	primaryStage.close(); // fecha a atual janela
    	TelaInicio telaInicio = new TelaInicio();
    	try {
        	telaInicio.start(new Stage(), this.nomeusuario.getText()); //manda os nomes corretos para a tela de provas!
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void preencherDisciplina(String disciplina) { //vai iniciar a disciplina com o nome correto!
    	this.disciplina.setText(disciplina);
    }
    public void preencherUsuario(String usuario) { //vai iniciar a label usuario com o nome do usuáiro corretamente!
    	this.nomeusuario.setText(usuario);
    }

}
