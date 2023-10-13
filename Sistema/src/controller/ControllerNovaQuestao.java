package controller;

import java.io.IOException;

import connection.QuestaoDAO;
import entities.Questao;
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
	
	private int codigoQuestao;
	
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
    @FXML
    private Button adicionar;//FEITO
    
    @FXML
    private Label questao;//FEITO

    @FXML
    private TextField assunto;//FEITO

    @FXML
    private ImageView deslogar;//FEITO
    
    @FXML
	private Button editar;//FEITO
    
    @FXML
    private TextField enunciado;//FEITO

    @FXML
    private TextField gabarito;//FEITO

    @FXML
    private TextField niveldificuldade;//FEITO

    @FXML
    private Label nomeusuario;//FEITO

    @FXML
    private ImageView voltar;//FEITO

    @FXML
    void deslogar(MouseEvent event) {//NÃO FEITO

    }

    @FXML
    void fimaddquestao(ActionEvent event) throws IOException {//NÃO FEITO
    	QuestaoDAO inserirNovaQuestao = new QuestaoDAO();
    	Questao novaQuestao = new Questao();
    	int nivelDificuldade = Integer.parseInt(niveldificuldade.getText()); //faz o casting do nivel de dificuldade para inteiro
    	novaQuestao.setNivelDeDificuldade(nivelDificuldade); 
    	novaQuestao.setDisciplina(this.disciplina);
    	novaQuestao.setAssunto(assunto.getText()); 
    	novaQuestao.setEnunciado(enunciado.getText());
    	novaQuestao.setGabarito(gabarito.getText());
    	inserirNovaQuestao.inserir(novaQuestao);
   
    	//ao terminar de inserir a nova questão, volta para a tela anterior!
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaQuestao retornar = new TelaQuestao();
    	retornar.start(new Stage(), this.disciplina, nomeusuario.getText());
    	
    }
    
    @FXML
	void editarquestao(ActionEvent event) throws IOException {
    	QuestaoDAO inserirNovaQuestao = new QuestaoDAO();
    	Questao novaQuestao = new Questao();
    	int nivelDificuldade = Integer.parseInt(niveldificuldade.getText()); //faz o casting do nivel de dificuldade para inteiro
    	novaQuestao.setCodigo(getCodigoQuestao());
    	novaQuestao.setNivelDeDificuldade(nivelDificuldade); 
    	novaQuestao.setDisciplina(this.disciplina);
    	novaQuestao.setAssunto(assunto.getText()); 
    	novaQuestao.setEnunciado(enunciado.getText());
    	novaQuestao.setGabarito(gabarito.getText());
    	inserirNovaQuestao.alterar(novaQuestao);
    	
    	//ao terminar de alterar a nova questão, volta para a tela anterior!
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaQuestao retornar = new TelaQuestao();
    	retornar.start(new Stage(), this.disciplina, nomeusuario.getText());
	}

    @FXML
    void telaanterior(MouseEvent event) throws IOException {//NÃO FEITO
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaQuestao retornar = new TelaQuestao();
    	retornar.start(new Stage(), this.disciplina, nomeusuario.getText());
    }

	public void preencherNome(String nomeUsuario) { //preenche o nome do usuário
		this.nomeusuario.setText(nomeUsuario);
		
	}
	
	public void preencherDisciplina(String nomeDisciplina) {
		this.disciplina = nomeDisciplina;
	}
	
	public void preencherQuestao(int Codigo) {
		this.questao.setText("Codigo: " + Codigo);
	}

	public Button getAdicionar() {
		return adicionar;
	}

	public void setAdicionar(Button adicionar) {
		this.adicionar = adicionar;
	}

	public Button getEditar() {
		return editar;
	}

	public int getCodigoQuestao() {
		return codigoQuestao;
	}

	public void setCodigoQuestao(int codigoQuestao) {
		this.codigoQuestao = codigoQuestao;
	}
}
