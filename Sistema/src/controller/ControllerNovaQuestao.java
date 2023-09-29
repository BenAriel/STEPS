package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import entities.Questao;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class ControllerNovaQuestao {

    @FXML
    private Button adicionar;

    @FXML
    private TextField assunto;

    @FXML
    private ImageView deslogar;

    @FXML
    private TextField enunciado;

    @FXML
    private TextField gabarito;

    @FXML
    private TextField niveldificuldade;

    @FXML
    private Label nomeusuario;

    @FXML
    private TextField pergunta;

    @FXML
    private TextField titulo;

    @FXML
    private ImageView voltar;

    @FXML
    void deslogar(MouseEvent event) {

    }

    @FXML
    void fimaddquestao(ActionEvent event) throws IOException {
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

            document.write(out);
            out.close();
            document.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 




    }

    @FXML
    void telaanterior(MouseEvent event) {

    }

}

