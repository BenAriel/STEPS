package controller;

import entities.Prova;
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
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BO.ProvaBO;
import Exception.ListEX;
import connection.ProvaDAO;
public class ControllerProva implements Initializable{

	private ObservableList<Prova> provaObservable;
	private ArrayList<Prova> retornoListar; //vai guardar o arraylist do listar!
	private ArrayList<Prova> filtrarListar; //vai escolher apenas as questões que têm código desejado
	Prova provaSelecionada; //vai ser usado para guardar a prova que o usuário selecionou!
	
    @FXML
    private Button apagar;//NÃO FEITO
    
    @FXML
    private TableColumn<Prova, String> disciplinaprova;//FEITO
    
    @FXML
    private TableColumn<Prova, Integer> questoesmedianas;//FEITO

    @FXML
    private TableColumn<Prova, Integer> questoesdificeis;//FEITO
    
    @FXML
    private TableColumn<Prova, Integer> questoesfaceis;//FEITO
    
    @FXML
    private TextField buscar;//NÃO FEITO

    @FXML
    private TableColumn<Prova, Integer> codigo;//FEITO

    @FXML
    private TableColumn<Prova, LocalDate> data;//FEITO

    @FXML
    private ImageView sair;//FEITO

    @FXML
    private Label disciplina;//FEITO
    
    @FXML
    private Label nomeusuario;//FEITO

    @FXML
    private Button editar;//NÃO FEITO

    @FXML
    private TableColumn<Prova, Integer> numeroquestoes;//FEITO

    @FXML
    private TableView<Prova> table;//FEITO

    @FXML
    private ImageView telagerarprovas;//NÃO FEITO

    @FXML
    private ImageView telaquestoes;//NÃO FEITO

    @FXML
    private ImageView voltar;//FEITO

    @FXML
    void adicionarprova(ActionEvent event) { //NÃO FEITO

    }

    @FXML
    void apagarprova(ActionEvent event) {//NÃO FEITO

    }

    @FXML
    void buscarprova(ActionEvent event) {//NÃO FEITO

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
    void editarprova(ActionEvent event) {//NÃO FEITO

    }

    @FXML
    void irparaquestoes(MouseEvent event) {//NÃO FEITO

    }

    @FXML
    void irtelagerarprovas(MouseEvent event) {//NÃO FEITO

    }
    
    @FXML
    void telaanterior(MouseEvent event) throws IOException {//NÃO FEITO
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaDisciplina retornar = new TelaDisciplina();
    	retornar.start(new Stage(), this.disciplina.getText(), nomeusuario.getText());
    }
    
     ObservableList<Prova> provas = FXCollections.observableArrayList(
        new Prova (1,"SÃO PAULO CAMPEAO",10,3,5,2)
    );

     private void initializeNodes() {
 		codigo.setCellValueFactory(new PropertyValueFactory<Prova, Integer>("codigo"));
 		disciplinaprova.setCellValueFactory(new PropertyValueFactory<Prova, String>("disciplina"));
 		questoesfaceis.setCellValueFactory(new PropertyValueFactory<Prova, Integer>("questoesFaceis"));
 		questoesmedianas.setCellValueFactory(new PropertyValueFactory<Prova, Integer>("questoesMedias"));
 		questoesdificeis.setCellValueFactory(new PropertyValueFactory<Prova, Integer>("questoesDificeis"));
 		numeroquestoes.setCellValueFactory(new PropertyValueFactory<Prova, Integer>("numeroDeQuestoes"));
 	    codigo.setCellValueFactory(new PropertyValueFactory<Prova, Integer>("codigo")); // Adicione esta linha
 	    data.setCellValueFactory(new PropertyValueFactory<Prova, LocalDate>("data"));
 	}
         
    @Override
	public void initialize(URL url, ResourceBundle rb) {
    	filtrarListar = new ArrayList<>();
		table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				// O objeto Disciplina selecionado está em newValue
				provaSelecionada = newValue;
				table.refresh();
				System.out.println("Disciplina selecionada: " + provaSelecionada.getCodigo());
			}
		});
		
	    initializeNodes();
	    codigo.setCellValueFactory(new PropertyValueFactory<Prova, Integer>("codigo"));
 		disciplinaprova.setCellValueFactory(new PropertyValueFactory<Prova, String>("disciplina"));
 		questoesfaceis.setCellValueFactory(new PropertyValueFactory<Prova, Integer>("questoesFaceis"));
 		questoesmedianas.setCellValueFactory(new PropertyValueFactory<Prova, Integer>("questoesMedias"));
 		questoesdificeis.setCellValueFactory(new PropertyValueFactory<Prova, Integer>("questoesDificeis"));
 		numeroquestoes.setCellValueFactory(new PropertyValueFactory<Prova, Integer>("numeroDeQuestoes"));
 	    codigo.setCellValueFactory(new PropertyValueFactory<Prova, Integer>("codigo")); // Adicione esta linha
 	    data.setCellValueFactory(new PropertyValueFactory<Prova, LocalDate>("data"));
 	    try {
			atualizarDados();
		} catch (ListEX e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void atualizarDados() throws ListEX {

		ProvaBO provaBO = new ProvaBO();
		retornoListar = provaBO.listar();
		System.out.println(disciplina.getText() + "Foi esse aqui que você mandou inicializar!");
		for (Prova questao : retornoListar) {
			System.out.println(questao.toString());
            if(questao.getDisciplina().equals(disciplina.getText())) {
            	System.out.println(questao.toString());
            	filtrarListar.add(questao); //se a questao escolhida estiver presente, vai adicionar ela a lista de questoes filtradas
            	System.out.println(questao.toString());
            }
        }
		provaObservable = FXCollections.observableArrayList(filtrarListar);
		table.setItems(provaObservable);
	}
    
    public void preencherDisciplina(String nomeDisciplina) throws ListEX {
		this.disciplina.setText(nomeDisciplina);
		System.out.println(disciplina.getText());
		initializeNodes();
		atualizarDados();
	}
    public void preencherUsuario(String usuario) { //vai iniciar a label usuario com o nome do usuáiro corretamente!
    	this.nomeusuario.setText(usuario);
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


