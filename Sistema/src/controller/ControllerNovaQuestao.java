package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.TelaQuestao;

public class ControllerNovaQuestao {
	
	//serve para guardar o nome da disciplina, apenas
	private String disciplina;
	
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
    @FXML
    private Button adicionar;//NÃO FEITO
    
    @FXML
    private Label questao;//NÃO FEITO

    @FXML
    private TextField assunto;//NÃO FEITO

    @FXML
    private ImageView deslogar;//NÃO FEITO

    @FXML
    private TextField enunciado;//NÃO FEITO

    @FXML
    private TextField gabarito;//NÃO FEITO

    @FXML
    private TextField niveldificuldade;//NÃO FEITO

    @FXML
    private Label nomeusuario;//NÃO FEITO

    @FXML
    private ImageView voltar;//feito

    @FXML
    void deslogar(MouseEvent event) {//NÃO FEITO

    }

    @FXML
    void fimaddquestao(ActionEvent event) {//NÃO FEITO

    }

    @FXML
    void telaanterior(MouseEvent event) throws IOException {//feito
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaQuestao retornar = new TelaQuestao();
    	retornar.start(new Stage(), this.disciplina, nomeusuario.getText());
    }

	public void preencherNome(String nomeUsuario) { //preenche o nome do usuário
		this.nomeusuario.setText(nomeUsuario);
		
	}
	
	public void preencherQuestao(int Codigo) {
		this.questao.setText("Codigo: " + Codigo);
	}

}
