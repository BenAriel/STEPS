package controller;
import entities.Disciplina;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
public class ControllerTelaInicio implements Initializable {

    @FXML
    private Button adicionar;

    @FXML
    private Button apagar;

    @FXML
    private TableColumn<Disciplina, Integer> codigo;

    @FXML
    private TableColumn<Disciplina, String> descricao;

    @FXML
    private ImageView deslogar;

    @FXML
    private Button editar;

    @FXML
    private TableColumn<Disciplina, String> nome;

    @FXML
    private Label nomeusuario;

    @FXML
    private TableView<Disciplina> table;

    @FXML
    void adicionardisciplina(ActionEvent event) {

    }

    @FXML
    void apagardisciplina(ActionEvent event) {

    }

    @FXML
    void deslogar(MouseEvent event) {

    }
    @FXML
    void buscardisciplina(ActionEvent event) {

    }

    @FXML
    void editardisciplina(ActionEvent event) {

    }
    ObservableList<Disciplina> disciplinas = FXCollections.observableArrayList(
        new Disciplina("historia", "historia do brasil", 1),
        new Disciplina("matematica", "matematica basica", 2),
        new Disciplina("portugues", "portugues basico", 3)
    );
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nome.setCellValueFactory(new PropertyValueFactory<Disciplina,String>("nome"));
        descricao.setCellValueFactory(new PropertyValueFactory<Disciplina,String>("descricao"));
        codigo.setCellValueFactory(new PropertyValueFactory<Disciplina,Integer>("codigo"));

        table.setItems(disciplinas);
    }

}