package controller;

import java.io.IOException;

import connection.QuestaoDAO;
import entities.Questao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.TelaQuestao;
<<<<<<< HEAD
import entities.Questao;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.scene.Node;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import BO.QuestaoBO;
import Exception.InsertEX;
import Exception.UpdateDisciplineEX;
import connection.QuestaoDAO;

public class ControllerNovaQuestao {
    private String disciplina;
=======

public class ControllerNovaQuestao {
	
	//serve para guardar o nome da disciplina, apenas
	private String disciplina;
>>>>>>> 1c8254e14b6b2a5a6c163f7b2721234736889526
	
	private int codigoQuestao;
	
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
<<<<<<< HEAD
=======
	
    @FXML
    private Button adicionar;//FEITO
    
    @FXML
    private Label questao;//FEITO

>>>>>>> 1c8254e14b6b2a5a6c163f7b2721234736889526
    @FXML
    private TextField assunto;//FEITO

    @FXML
    private ImageView deslogar;//FEITO
    
    @FXML
	private Button editar;//FEITO
    
    @FXML
    private TextField enunciado;//FEITO

    @FXML
    private TextField gabarito;//FEITO

    @FXML
    private TextField niveldificuldade;//FEITO

    @FXML
    private Label nomeusuario;//FEITO

    @FXML
    private ImageView voltar;//FEITO

    @FXML
<<<<<<< HEAD
    private Label nomeusuario;

    @FXML
    private TextField pergunta;

    @FXML
    private TextField titulo;

    @FXML
    private ImageView voltar;

    private Label questao;

    @FXML
    void deslogar(MouseEvent event) {
=======
    void deslogar(MouseEvent event) {//NÃO FEITO
>>>>>>> 1c8254e14b6b2a5a6c163f7b2721234736889526

    }

    @FXML
<<<<<<< HEAD
    void fimaddquestao(ActionEvent event) throws IOException, InsertEX {
        Questao questao = new Questao();
        if(niveldificuldade.getText()=="fácil"){
            questao.setNivelDeDificuldade(1);
        }else if(niveldificuldade.getText()=="médio"){
            questao.setNivelDeDificuldade(2);
        }else if(niveldificuldade.getText()=="difícil"){
            questao.setNivelDeDificuldade(3);
        }
        questao.setAssunto(assunto.getText());
         String enunciadoparcial = titulo.getText();
          enunciadoparcial += "\n"+ enunciado.getText();
         enunciadoparcial  += "\n " + pergunta.getText();
            questao.setEnunciado(enunciadoparcial);
         questao.setGabarito(gabarito.getText()); 
         questao.setDisciplina(this.disciplina);
         
         QuestaoBO questaobo= new QuestaoBO();
            questaobo.cadastrar(questao);
         FileOutputStream out =null;
        XWPFDocument document = new XWPFDocument();
        String nomearquivo ="Questão" + questao.getCodigo() + ".docx";
        try {
            out = new FileOutputStream(new File(nomearquivo));
            XWPFParagraph paragraph = document.createParagraph();
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run = paragraph.createRun();
            run.setText(titulo.getText());
            run.setBold(true);

            run.addBreak();
            run.addBreak();
            XWPFParagraph paragraph2 = document.createParagraph();
            paragraph2.setAlignment(ParagraphAlignment.BOTH);
            XWPFRun run2 = paragraph2.createRun();
            run2.addTab();
            run2.setText(enunciado.getText());
            run2.addBreak();
             XWPFParagraph paragraph3 = document.createParagraph();
             paragraph3.setAlignment(ParagraphAlignment.BOTH);
            XWPFRun run3 = paragraph3.createRun();
            run3.addTab();
            run3.setText(pergunta.getText());
            run3.addBreak();
            run3.addBreak();

            document.write(out);
            out.close();
            document.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaQuestao retornar = new TelaQuestao();
    	retornar.start(new Stage(), this.disciplina, nomeusuario.getText());


=======
    void fimaddquestao(ActionEvent event) throws IOException {//NÃO FEITO
    	QuestaoDAO inserirNovaQuestao = new QuestaoDAO();
    	Questao novaQuestao = new Questao();
    	int nivelDificuldade = Integer.parseInt(niveldificuldade.getText()); //faz o casting do nivel de dificuldade para inteiro
    	novaQuestao.setNivelDeDificuldade(nivelDificuldade); 
    	novaQuestao.setDisciplina(this.disciplina);
    	novaQuestao.setAssunto(assunto.getText()); 
    	novaQuestao.setEnunciado(enunciado.getText());
    	novaQuestao.setGabarito(gabarito.getText());
    	inserirNovaQuestao.inserir(novaQuestao);
   
    	//ao terminar de inserir a nova questão, volta para a tela anterior!
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaQuestao retornar = new TelaQuestao();
    	retornar.start(new Stage(), this.disciplina, nomeusuario.getText());
    	
>>>>>>> 1c8254e14b6b2a5a6c163f7b2721234736889526
    }
    
    @FXML
	void editarquestao(ActionEvent event) throws IOException {
    	QuestaoDAO inserirNovaQuestao = new QuestaoDAO();
    	Questao novaQuestao = new Questao();
    	int nivelDificuldade = Integer.parseInt(niveldificuldade.getText()); //faz o casting do nivel de dificuldade para inteiro
    	novaQuestao.setCodigo(getCodigoQuestao());
    	novaQuestao.setNivelDeDificuldade(nivelDificuldade); 
    	novaQuestao.setDisciplina(this.disciplina);
    	novaQuestao.setAssunto(assunto.getText()); 
    	novaQuestao.setEnunciado(enunciado.getText());
    	novaQuestao.setGabarito(gabarito.getText());
    	inserirNovaQuestao.alterar(novaQuestao);
    	
    	//ao terminar de alterar a nova questão, volta para a tela anterior!
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaQuestao retornar = new TelaQuestao();
    	retornar.start(new Stage(), this.disciplina, nomeusuario.getText());
	}

    @FXML
<<<<<<< HEAD
    void telaanterior(MouseEvent event) throws IOException {
        	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
=======
    void telaanterior(MouseEvent event) throws IOException {//NÃO FEITO
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
>>>>>>> 1c8254e14b6b2a5a6c163f7b2721234736889526
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaQuestao retornar = new TelaQuestao();
    	retornar.start(new Stage(), this.disciplina, nomeusuario.getText());
    }
		
	
    @FXML
    void editarquestao(ActionEvent event) throws IOException, UpdateDisciplineEX {
        Questao questao = new Questao();
    	if(niveldificuldade.getText()=="fácil"){
            questao.setNivelDeDificuldade(1);
        }else if(niveldificuldade.getText()=="médio"){
            questao.setNivelDeDificuldade(2);
        }else if(niveldificuldade.getText()=="difícil"){
            questao.setNivelDeDificuldade(3);
        }
        questao.setAssunto(assunto.getText());
         String enunciadoparcial = titulo.getText();
          enunciadoparcial += "\n"+ enunciado.getText();
         enunciadoparcial  += "\n " + pergunta.getText();
            questao.setEnunciado(enunciadoparcial);
         questao.setGabarito(gabarito.getText()); 
         questao.setDisciplina(this.disciplina);
         questao.setCodigo(getCodigoQuestao());
         QuestaoBO questaobo= new QuestaoBO();
            questaobo.alterarQuestao(questao);
    	
    	//ao terminar de alterar a nova questão, volta para a tela anterior!
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaQuestao retornar = new TelaQuestao();
    	retornar.start(new Stage(), this.disciplina, nomeusuario.getText());
	}
    public void preencherNome(String nomeUsuario) { //preenche o nome do usuário
		this.nomeusuario.setText(nomeUsuario);
		
	}
	
	public void preencherDisciplina(String nomeDisciplina) {
		this.disciplina = nomeDisciplina;
	}
	
	public void preencherQuestao(int Codigo) {
		this.questao.setText("Codigo: " + Codigo);
	}
    public int getCodigoQuestao() {
		return codigoQuestao;
	}

	public void setCodigoQuestao(int codigoQuestao) {
		this.codigoQuestao = codigoQuestao;
	}

	
	

	public void preencherNome(String nomeUsuario) { //preenche o nome do usuário
		this.nomeusuario.setText(nomeUsuario);
		
	}
	
	public void preencherDisciplina(String nomeDisciplina) {
		this.disciplina = nomeDisciplina;
	}
	
	public void preencherQuestao(int Codigo) {
		this.questao.setText("Codigo: " + Codigo);
	}

	public Button getAdicionar() {
		return adicionar;
	}

	public void setAdicionar(Button adicionar) {
		this.adicionar = adicionar;
	}

	public Button getEditar() {
		return editar;
	}

	public int getCodigoQuestao() {
		return codigoQuestao;
	}

	public void setCodigoQuestao(int codigoQuestao) {
		this.codigoQuestao = codigoQuestao;
	}
}
