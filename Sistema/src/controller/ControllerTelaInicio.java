package controller;
import entities.Disciplina;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.TelaDisciplina;
import view.TelaLogin;
import view.TelaNovaDisciplina;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import connection.DisciplinaDAO;
public class ControllerTelaInicio implements Initializable {

	private ObservableList<Disciplina> disciplinas;
    private ArrayList<Disciplina> retornoListar;
    Disciplina disciplinaSelecionada; //vai ficar detectando que disciplina o usuário selecionou!
	
    @FXML
    private Button adicionar;//NÃO FEITO

    @FXML
    private Button apagar;//FEITO
    
    @FXML
    private Button escolherSelecionada; //NÃO FEITO

    @FXML
    private TableColumn<Disciplina, Integer> codigo;//FEITO

    @FXML
    private TableColumn<Disciplina, String> descricao;//FEITO

    @FXML
    private ImageView deslogar;//FEITO

    @FXML
    private Button editar;//NÃO FEITO

    @FXML
    private TableColumn<Disciplina, String> nome;//FEITO

    @FXML
    private Label nomeusuario;//FEITO

    @FXML
    private TableView<Disciplina> table;//FEITO

    @FXML
    void adicionardisciplina(ActionEvent event) { 
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // pega referencia da
		// atual janela
    	primaryStage.close(); // fecha a atual janela
    	TelaNovaDisciplina telaNovaDisciplina = new TelaNovaDisciplina();
    	try {
			telaNovaDisciplina.start(new Stage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    @FXML
    void apagardisciplina(ActionEvent event) {
    	DisciplinaDAO apagarDisciplina = new DisciplinaDAO();
    	apagarDisciplina.remover(disciplinaSelecionada);
    	atualizarDados();
    }

    @FXML
    void deslogar(MouseEvent event) {
        	System.out.println("Clicou em deslogar!!!");
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
    void escolher(ActionEvent event) throws IOException {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // pega referencia da
		// atual janela
    	primaryStage.close(); // fecha a atual janela
    	TelaDisciplina telaDisciplina = new TelaDisciplina();
    	telaDisciplina.start(new Stage(),disciplinaSelecionada.getNome(),this.nomeusuario.getText());
    	
    }
   
    @FXML
    void editardisciplina(ActionEvent event)throws IOException {
    	System.out.println("Editando a disciplina!" + disciplinaSelecionada.getCodigo());
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // pega referencia da atual janela
    	primaryStage.close(); // fecha a atual janela
    	TelaNovaDisciplina telaNovaDisciplina = new TelaNovaDisciplina();
    	try {
			telaNovaDisciplina.start(new Stage(), disciplinaSelecionada.getCodigo());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Override
    public void initialize(URL urln, ResourceBundle rb) {
    	
    	table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // O objeto Disciplina selecionado está em newValue
                disciplinaSelecionada = newValue;
                table.refresh();
                System.out.println("Disciplina selecionada: " + disciplinaSelecionada.getNome());
            }
        });
    	
    	initializeNodes();
        nome.setCellValueFactory(new PropertyValueFactory<Disciplina,String>("nome"));
        descricao.setCellValueFactory(new PropertyValueFactory<Disciplina,String>("descricao"));
        codigo.setCellValueFactory(new PropertyValueFactory<Disciplina,Integer>("codigo"));
        atualizarDados();
    }
    
    private void initializeNodes() {
		codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));		
	}
    
    public void atualizarDados() {
    	
        DisciplinaDAO discDAO = new DisciplinaDAO();
        retornoListar = discDAO.listar();
    	disciplinas = FXCollections.observableArrayList(retornoListar);
    	table.setItems(disciplinas);
    }

	public void preencherNome(String nomeUsuario) {
		this.nomeusuario.setText(nomeUsuario);
		
	}

}
