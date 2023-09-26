package controller;

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
import java.util.ResourceBundle;
public class ControllerQuestao implements Initializable {

        @FXML
        private Button adicionar;
    
        @FXML
        private Button apagar;
    
        @FXML
        private TableColumn<Questao, String> assunto;
    
        @FXML
        private TextField buscar;
    
        @FXML
        private TableColumn<Questao, Integer> codigo;
    
        @FXML
        private ImageView deslogar;
    
        @FXML
        private TableColumn<Questao, Integer> dificuldade;
    
        @FXML
        private Label disciplina;
    
        @FXML
        private Button editar;
    
        @FXML
        private TableColumn<Questao, String> enunciado;
    
        @FXML
        private TableView<Questao> table;
    
        @FXML
        private ImageView telagerarprovas;
    
        @FXML
        private ImageView telaprovas;
    
        @FXML
        private ImageView voltar;
    
        @FXML
        void adicionarquestao(ActionEvent event) {
    
        }
    
        @FXML
        void apagarquestao(ActionEvent event) {
    
        }
    
        @FXML
        void buscarquestao(ActionEvent event) {
    
        }
    
        @FXML
        void deslogar(MouseEvent event) {
    
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
    
        }
         ObservableList<Questao> questoes = FXCollections.observableArrayList(
        new Questao(1,"matematica", "qual a raiz quadrada de 4?", "Dois(2)","calculos para apenas aumentar as linahs e ver como fica",3),
        new Questao(2,"portugues", "qual o significado do nome Ariel?", "Leao de Deus","esse pode ser curto",2),
        new Questao(3,"historia", "qual o nome do primeiro presidente do brasil?", "Deodoro da Fonseca","esse pode ser longo",1),
        new Questao(4,"geografia", "qual o nome do maior rio do mundo?", "Amazonas","esse pode ser longo",1),
        new Questao(5,"matematica", "qual a raiz quadrada de 4?", "Dois(2)","calculos para apenas aumentar as linahs e ver como fica",3),
        new Questao(6,"portugues", "qual o significado do nome Ariel?", "Leao de Deus","esse pode ser curto",2),
        new Questao(7,"historia", "qual o nome do primeiro presidente do brasil?", "Deodoro da Fonseca","esse pode ser longo",1),
        new Questao(8,"geografia", "qual o nome do maior rio do mundo?", "Amazonas","esse pode ser longo",1),
        new Questao(9,"matematica", "qual a raiz quadrada de 4?", "Dois(2)","calculos para apenas aumentar as linahs e ver como fica",3),
        new Questao(10,"portugues", "qual o significado do nome Ariel?", "Leao de Deus","esse pode ser curto",2),
        new Questao(11,"historia", "qual o nome do primeiro presidente do brasil?", "Deodoro da Fonseca","esse pode ser longo",1)
    );
    @Override
    public void initialize (URL location, ResourceBundle resources) {
        codigo.setCellValueFactory(new PropertyValueFactory<Questao,Integer>("codigo"));
       dificuldade.setCellValueFactory(new PropertyValueFactory<Questao,Integer>("NivelDeDificuldade"));
        assunto.setCellValueFactory(new PropertyValueFactory<Questao,String>("assunto"));
        enunciado.setCellValueFactory(new PropertyValueFactory<Questao,String>("enunciado"));

        table.setItems(questoes);
    }
    }
