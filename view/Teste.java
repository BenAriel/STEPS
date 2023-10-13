package view;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Teste {
    public static void main(String[] args) throws IOException {
        FileOutputStream out =null;
        XWPFDocument document = new XWPFDocument();
        try {
            out = new FileOutputStream(new File("documentoTeste2.docx"));
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("Sistema de Provas ");
            run.setBold(true);

            run.addBreak();
            run.addBreak();
            XWPFParagraph paragraph2 = document.createParagraph();
            XWPFRun run2 = paragraph2.createRun();
            run2.addTab();
            run2.setText("aqui deveria ser o enunciado ");
            run2.addBreak();
             XWPFParagraph paragraph3 = document.createParagraph();
            XWPFRun run3 = paragraph3.createRun();
            run3.addTab();
            run3.setText("aqui deveria a pergunta e as alternativas");

            document.write(out);
            out.close();
            document.close();
            String caminho= "documentoTeste2.docx";
            File file = new File(caminho);
            if (file.exists()) {
                //abre o arquivo automaticamente
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("O arquivo não existe: " + caminho);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }         
    }
}
