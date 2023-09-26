package controller;

import connection.DisciplinaDAO;
import entities.Disciplina;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerNovaDisciplina {

	private int codigo;
	
    @FXML
    private Button adicionar;

    @FXML
    private TextField descricao;

    @FXML
    private ImageView deslogar;

    @FXML
    private TextField nomedisciplina;

    @FXML
    private Label nomeusuario;

    @FXML
    private ImageView voltar;

    @FXML
    void deslogar(MouseEvent event) {

    }

    @FXML
    void fimadddisciplina(ActionEvent event) {
    	Disciplina disciplinaAuxiliar = new Disciplina();
    	disciplinaAuxiliar.setCodigo(codigo);
    	disciplinaAuxiliar.setDescricao(this.descricao.getText());
    	disciplinaAuxiliar.setNome(this.nomedisciplina.getText());
    	DisciplinaDAO alterdarDisciplina = new DisciplinaDAO();
    	alterdarDisciplina.alterar(disciplinaAuxiliar);
    }

    @FXML
    void telaanterior(MouseEvent event) {

    }

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
