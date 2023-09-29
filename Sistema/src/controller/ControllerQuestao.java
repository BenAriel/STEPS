package controller;

import entities.Questao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.TelaDisciplina;
import view.TelaLogin;
import view.TelaNovaQuestao;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import connection.QuestaoDAO;

public class ControllerQuestao implements Initializable {
	
	private ObservableList<Questao> disciplinas;
    private ArrayList<Questao> retornoListar;
    Questao questaoSelecionada; //vai ficar detectando que disciplina o usuário selecionou!

	@FXML
	private Button adicionar;// NÃO FEITO

	@FXML
	private Button apagar;// NÃO FEITO

	@FXML
	private TableColumn<Questao, String> assunto;// FEITO

	@FXML
	private TextField buscar;// NÃO FEITO

	@FXML
	private TableColumn<Questao, Integer> codigo;// FEITO

	@FXML
	private ImageView sair;// feito

	@FXML
	private TableColumn<Questao, Integer> dificuldade;// FEITO

	@FXML
	private Label disciplina;// FEITO

	@FXML
	public Label nomeusuario;// FEITO

	@FXML
	private Button editar;// NÃO FEITO

	@FXML
	private TableColumn<Questao, String> enunciado;// FEITO

	@FXML
	private TableView<Questao> table;// FEITO

	@FXML
	private ImageView telagerarprovas;// NÃO FEITO

	@FXML
	private ImageView telaprovas;// NÃO FEITO

	@FXML
	private ImageView voltar;// feito

	@FXML
	void adicionarquestao(ActionEvent event) {
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // pega referencia da
		// atual janela
		primaryStage.close(); // fecha a atual janela
		TelaNovaQuestao nq = new TelaNovaQuestao();
		try {
			nq.start(new Stage()); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void apagarquestao(ActionEvent event) {

	}

	@FXML
	void buscarquestao(ActionEvent event) {
		
	}

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
	void editarquestao(ActionEvent event) {
		
	}

	@FXML
	void irtelagerarprovas(MouseEvent event) {

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
			telaDisciplina.start(new Stage(), this.disciplina.getText(), this.nomeusuario.getText()); // manda os nomes
																										// corretos para
																										// a tela de
																										// provas!
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private void initializeNodes() {
		codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		dificuldade.setCellValueFactory(new PropertyValueFactory<>("nome"));
		assunto.setCellValueFactory(new PropertyValueFactory<>("assunto"));		
		enunciado.setCellValueFactory(new PropertyValueFactory<>("enunciado"));
	}

	public void initialize(URL urln, ResourceBundle rb) {

		table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				// O objeto Disciplina selecionado está em newValue
				questaoSelecionada = newValue;
				table.refresh();
				System.out.println("Disciplina selecionada: " + questaoSelecionada.getCodigo());
			}
		});

		initializeNodes();
		codigo.setCellValueFactory(new PropertyValueFactory<Questao,Integer>("codigo"));
		dificuldade.setCellValueFactory(new PropertyValueFactory<Questao, Integer>("dificuldade"));
		assunto.setCellValueFactory(new PropertyValueFactory<Questao, String>("codigo"));
		enunciado.setCellValueFactory(new PropertyValueFactory<Questao, String>("enunciado"));
		atualizarDados();
	}

	public void preencherDisciplina(String nomeDisciplina) {
		this.disciplina.setText(nomeDisciplina);
	}

	public void preencherUsuario(String nomeUsuario) {
		this.nomeusuario.setText(nomeUsuario);

	}

	public void atualizarDados() {

		QuestaoDAO discDAO = new QuestaoDAO();
		retornoListar = discDAO.listar();
		disciplinas = FXCollections.observableArrayList(retornoListar);
		table.setItems(disciplinas);
	}

	public Button getEditar() {
		return editar;
	}

	public void setEditar(Button editar) {
		this.editar = editar;
	}

	public Button getApagar() {
		return apagar;
	}

	public void setApagar(Button apagar) {
		this.apagar = apagar;
	}
}
