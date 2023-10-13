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
    private ArrayList<Questao> filtrarListar; //vai escolher apenas as questões que têm código desejado
    Questao questaoSelecionada; //vai ficar detectando que disciplina o usuário selecionou!  
    
	@FXML
	private Button adicionar;// FEITO

	@FXML
	private Button apagar;// NÃO FEITO

	@FXML
	private TableColumn<Questao, String> assunto;// FEITO

	@FXML
	private TableColumn<Questao, String> gabarito;// FEITO
	
	@FXML
	private TableColumn<Questao, String> disciplinaQuestao;// FEITO
	
	@FXML
	private TextField buscar;// NÃO FEITO

	@FXML
	private TableColumn<Questao, Integer> codigo;// FEITO

	@FXML
	private ImageView sair;// FEITO

	@FXML
	private TableColumn<Questao, Integer> dificuldade;// FEITO

	@FXML
	private Label disciplina;// FEITO

	@FXML
	public Label nomeusuario;// FEITO

	@FXML
	private Button editar;// FEITO

	@FXML
	private TableColumn<Questao, String> enunciado;// FEITO

	@FXML
	private TableView<Questao> table;// FEITO

	@FXML
	private ImageView telagerarprovas;// NÃO FEITO

	@FXML
	private ImageView telaprovas;// FEITO

	@FXML
	private ImageView voltar;// FEITO
	
	public void preencherDisciplina(String nomeDisciplina) {
		this.disciplina.setText(nomeDisciplina);
		System.out.println(disciplina.getText());
		atualizarDados();
	}

	@FXML
	void adicionarquestao(ActionEvent event) throws IOException {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaNovaQuestao telaQuestao = new TelaNovaQuestao();
    	telaQuestao.start(new Stage(),this.disciplina.getText(), this.nomeusuario.getText()); //manda os nomes corretos para a tela de provas!
    	
    }

	@FXML
	void apagarquestao(ActionEvent event) {
		QuestaoDAO apagarQuestao = new QuestaoDAO();
    	apagarQuestao.remover(questaoSelecionada);
    	atualizarDados();
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
	void editarquestao(ActionEvent event) throws IOException {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaNovaQuestao telaQuestao = new TelaNovaQuestao();
    	telaQuestao.start(new Stage(),this.disciplina.getText(), this.nomeusuario.getText(), this.questaoSelecionada.getCodigo());
    	//vai mandar o código da questão selecionada para ser editada!
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
		codigo.setCellValueFactory(new PropertyValueFactory<Questao, Integer>("codigo"));
		dificuldade.setCellValueFactory(new PropertyValueFactory<Questao, Integer>("nivelDeDificuldade"));
		disciplinaQuestao.setCellValueFactory(new PropertyValueFactory<Questao, String>("disciplina"));
	    enunciado.setCellValueFactory(new PropertyValueFactory<Questao, String>("enunciado"));
	    assunto.setCellValueFactory(new PropertyValueFactory<Questao, String>("assunto"));
	    gabarito.setCellValueFactory(new PropertyValueFactory<Questao, String>("gabarito")); // Adicione esta linha

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				// O objeto Disciplina selecionado está em newValue
				questaoSelecionada = newValue;
				table.refresh();
				System.out.println("Disciplina selecionada: " + questaoSelecionada.getCodigo());
			}
		});
		
	    initializeNodes();
	    codigo.setCellValueFactory(new PropertyValueFactory<Questao, Integer>("codigo"));
	    dificuldade.setCellValueFactory(new PropertyValueFactory<Questao, Integer>("nivelDeDificuldade"));
	    assunto.setCellValueFactory(new PropertyValueFactory<Questao, String>("assunto"));
	    enunciado.setCellValueFactory(new PropertyValueFactory<Questao, String>("enunciado"));
	    gabarito.setCellValueFactory(new PropertyValueFactory<Questao, String>("gabarito"));
	    disciplinaQuestao.setCellValueFactory(new PropertyValueFactory<Questao, String>("disciplina"));
	    // Inicialize a lista filtrarListar
	    filtrarListar = new ArrayList<>();
	}




	public void atualizarDados() {

		QuestaoDAO discDAO = new QuestaoDAO();
		retornoListar = discDAO.listar();
		System.out.println(disciplina.getText() + "Foi esse aqui que você mandou inicializar!");
		for (Questao questao : retornoListar) {
			System.out.println(questao.toString());
            if(questao.getDisciplina().equals(disciplina.getText())) {
            	filtrarListar.add(questao); //se a questao escolhida estiver presente, vai adicionar ela a lista de questoes filtradas
            	System.out.println(questao.toString());
            }
        }
		disciplinas = FXCollections.observableArrayList(filtrarListar);
		table.setItems(disciplinas);
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
	
	public void preencherUsuario(String nomeUsuario) {
		this.nomeusuario.setText(nomeUsuario);

	}

	public Button getEditar() {
		return editar;
	}
	
	
}
