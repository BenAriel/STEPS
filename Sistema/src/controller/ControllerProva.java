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
import java.util.ResourceBundle;
public class ControllerProva implements Initializable{

    @FXML
    private Button adicionar;//NÃO FEITO

    @FXML
    private Button apagar;//NÃO FEITO

    @FXML
    private TextField buscar;//NÃO FEITO

    @FXML
    private TableColumn<Prova, Integer> codigo;//NÃO FEITO

    @FXML
    private TableColumn<Prova, LocalDate> data;//NÃO FEITO

    @FXML
    private ImageView sair;//FEITO

    @FXML
    private Label disciplina;//FEITO
    
    @FXML
    private Label nomeusuario;//FEITO

    @FXML
    private Button editar;//NÃO FEITO


    @FXML
    private TableColumn<Prova, Integer> numeroquestoes;//NÃO FEITO

    @FXML
    private TableView<Prova> table;//NÃO FEITO

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        codigo.setCellValueFactory(new PropertyValueFactory<Prova,Integer>("codigo"));
        data.setCellValueFactory(new PropertyValueFactory<Prova,LocalDate>("data"));
         numeroquestoes.setCellValueFactory(new PropertyValueFactory<Prova,Integer>("numeroDeQuestoes"));
 
         table.setItems(provas);
    }
    
    public void preencherDisciplina(String disciplina) { //vai iniciar a disciplina com o nome correto!
    	this.disciplina.setText(disciplina);
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
