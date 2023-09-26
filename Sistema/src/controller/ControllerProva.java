package controller;

import entities.Prova;
import entities.Questao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
public class ControllerProva implements Initializable{

    @FXML
    private Button adicionar;

    @FXML
    private Button apagar;

    @FXML
    private TextField buscar;

    @FXML
    private TableColumn<Prova, Integer> codigo;

    @FXML
    private TableColumn<Prova, LocalDate> data;

    @FXML
    private ImageView deslogar;

    @FXML
    private Label disciplina;

    @FXML
    private Button editar;


    @FXML
    private TableColumn<Prova, Integer> numeroquestoes;

    @FXML
    private TableView<Prova> table;

    @FXML
    private ImageView telagerarprovas;

    @FXML
    private ImageView telaquestoes;

    @FXML
    private ImageView voltar;

    @FXML
    void adicionarprova(ActionEvent event) {

    }

    @FXML
    void apagarprova(ActionEvent event) {

    }

    @FXML
    void buscarprova(ActionEvent event) {

    }

    @FXML
    void deslogar(MouseEvent event) {

    }

    @FXML
    void editarprova(ActionEvent event) {

    }

    @FXML
    void irparaquestoes(MouseEvent event) {

    }

    @FXML
    void irtelagerarprovas(MouseEvent event) {

    }

    @FXML
    void telaanterior(MouseEvent event) {

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

}



