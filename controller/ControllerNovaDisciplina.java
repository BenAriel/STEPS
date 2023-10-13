package controller;

import java.io.IOException;

import connection.DisciplinaDAO;
import entities.Disciplina;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.TelaInicio;
import view.TelaLogin;

public class ControllerNovaDisciplina {

	private int codigo;//não está no scene builder, logo não precisa do @FXML
	
    @FXML
    private Button adicionar;//FEITO

    @FXML
    private TextField descricao;//FEITO

    @FXML
    private ImageView deslogar;//FEITO

    @FXML
    private TextField nomedisciplina;//FEITO

    @FXML
    private Label nomeusuario;//FEITO
    
    @FXML
    private Label disciplina;//FEITO

    @FXML
    private ImageView voltar;//FEITO

    @FXML
    void deslogar(MouseEvent event) {
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
    void fimadddisciplina(ActionEvent event) throws IOException { //ALTERA A DISCIPLINA
    	Disciplina disciplinaAuxiliar = new Disciplina();
    	DisciplinaDAO alterdarDisciplina = new DisciplinaDAO();
    	if (this.nomedisciplina.getText() != null) { //se nomedisciplina não for nulo, então significa que você está editando, se não, está adicionando
    		disciplinaAuxiliar.setCodigo(codigo);
    		disciplinaAuxiliar.setDescricao(this.descricao.getText());
        	disciplinaAuxiliar.setNome(this.nomedisciplina.getText());
        	alterdarDisciplina.inserir(disciplinaAuxiliar);
    	}
    	else
    	{
    		disciplinaAuxiliar.setDescricao(this.descricao.getText());
        	disciplinaAuxiliar.setNome(this.nomedisciplina.getText());
        	alterdarDisciplina.alterar(disciplinaAuxiliar);
    	}
    	
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaInicio retornar = new TelaInicio();
    	retornar.start(new Stage(), nomeusuario.getText());
    }

    @FXML
    void telaanterior(MouseEvent event) throws IOException {
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaInicio retornar = new TelaInicio();
    	retornar.start(new Stage(), nomeusuario.getText());
    }

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeusuario.setText(nomeUsuario);
	}
	
	public void setNomeDisciplina(String nomeDisciplina) {
		this.disciplina.setText(nomeDisciplina);
	}

}
