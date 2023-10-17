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
	
	//serve para guardar o nome da disciplina, apenas
	private String disciplina;
	
	private int codigoQuestao;
	
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
    @FXML
    private Button adicionar;//FEITO
    
    @FXML
    private Label questao;//FEITO

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
    private TextField pergunta;

    @FXML
    private TextField título;

    @FXML
    private ImageView voltar;//FEITO

    @FXML
    void deslogar(MouseEvent event) {//NÃO FEITO

    }

    @FXML
    void fimaddquestao(ActionEvent event) throws IOException, InsertEX {//NÃO FEITO
    	
        Questao questao = new Questao();
        if (niveldificuldade.getText().equals("fácil")) {
            questao.setNivelDeDificuldade(1);
        } else if (niveldificuldade.getText().equals("médio")) {
            questao.setNivelDeDificuldade(2);
        } else if (niveldificuldade.getText().equals("difícil")) {
            questao.setNivelDeDificuldade(3);
        }

    	questao.setAssunto(assunto.getText());
         String enunciadoparcial = título.getText();
          enunciadoparcial += "\n"+ enunciado.getText();
         enunciadoparcial  += "\n " + pergunta.getText();
            questao.setEnunciado(enunciadoparcial);
         questao.setGabarito(gabarito.getText()); 
         questao.setDisciplina(this.disciplina);

         QuestaoBO questaobo= new QuestaoBO();
         questaobo.cadastrar(questao);
      FileOutputStream out =null;
     XWPFDocument document = new XWPFDocument();
     System.out.println(questao.getCodigo());
     String nomearquivo ="Questão" + questao.getCodigo() + ".docx";
     try {
         out = new FileOutputStream(new File(nomearquivo));
         XWPFParagraph paragraph = document.createParagraph();
         paragraph.setAlignment(ParagraphAlignment.CENTER);
         XWPFRun run = paragraph.createRun();
         run.setText(título.getText());
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
         
   
    	//ao terminar de inserir a nova questão, volta para a tela anterior!
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaQuestao retornar = new TelaQuestao();
    	retornar.start(new Stage(), this.disciplina, nomeusuario.getText());
    	
    }
    
    @FXML
	void editarquestao(ActionEvent event) throws InsertEX, IOException, UpdateDisciplineEX {
    	QuestaoBO questaobo= new QuestaoBO();
    	Questao novaQuestao = new Questao();
    	novaQuestao.setCodigo(getCodigoQuestao());
        if (niveldificuldade.getText().equals("fácil")) {
            novaQuestao.setNivelDeDificuldade(1);
        } else if (niveldificuldade.getText().equals("médio")) {
            novaQuestao.setNivelDeDificuldade(2);
        } else if (niveldificuldade.getText().equals("difícil")) {
            novaQuestao.setNivelDeDificuldade(3);
        }
    	novaQuestao.setDisciplina(this.disciplina);
    	novaQuestao.setAssunto(assunto.getText()); 
    	novaQuestao.setEnunciado(enunciado.getText());
    	novaQuestao.setGabarito(gabarito.getText());
    	questaobo.alterarQuestao(novaQuestao);
    	
    	//ao terminar de alterar a nova questão, volta para a tela anterior!
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //pega a tela atual como referencia
    	primaryStage.close(); //fecha a tela atual para abrir a nova!
    	TelaQuestao retornar = new TelaQuestao();
    	retornar.start(new Stage(), this.disciplina, nomeusuario.getText());
	}

    @FXML
    void telaanterior(MouseEvent event) throws IOException {//NÃO FEITO
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
