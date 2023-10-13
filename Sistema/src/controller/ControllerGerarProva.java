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
import view.TelaDisciplina;
import view.TelaLogin;
<<<<<<< HEAD
import entities.Prova;
=======
>>>>>>> 1c8254e14b6b2a5a6c163f7b2721234736889526

public class ControllerGerarProva {
	
	private String nomeusuario; //servem apenas para guardar o nome e a disciplina para o retorno
	private String disciplina;

    @FXML
    private TextField assuntos;

    @FXML
    private ImageView deslogar;

    @FXML
    private Label geracaodequestoes;

    @FXML
    private Button gerar;

    @FXML
    private TextField numerodificeis;

    @FXML
    private TextField numerofaceis;

    @FXML
    private TextField numeromedias;

    @FXML
    private TextField numeroquestoes;

    @FXML
    private ImageView telaprovas;

    @FXML
    private ImageView telaquestoes;

    @FXML
    private ImageView voltar;

    @FXML
	void deslogar(MouseEvent event) {
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // pega referencia da
		// atual janela
		primaryStage.close(); // fecha a atual janela
		TelaLogin telaLogin = new TelaLogin();
		try {
			telaLogin.start(new Stage()); // abre de volta a primeira tela de login!
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

    @FXML
    void gerarprova(ActionEvent event) {
		Prova prova= new Prova();
		if(numeroquestoes.getText().isEmpty()) {
			System.out.println("Preencha o número de questões!");
		}
		

    }

    @FXML
    void irparaquestoes(MouseEvent event) {

    }

    @FXML
    void irtelaprovas(MouseEvent event) {

    }

    @FXML
	void telaanterior(MouseEvent event) {
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // pega referencia da
		// atual janela
		primaryStage.close(); // fecha a atual janela
		TelaDisciplina telaDisciplina = new TelaDisciplina();
		try {
			telaDisciplina.start(new Stage(), getDisciplina(), getNomeusuario()); // manda os nomes
																										// corretos para
																										// a tela de
																										// provas!
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getNomeusuario() {
		return nomeusuario;
	}

	public void setNomeusuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}

}
