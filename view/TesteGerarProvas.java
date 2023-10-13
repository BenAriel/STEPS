package view;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TesteGerarProvas
{
    public static void main(String[] args) {
    
    try {
        // Lista de nomes de arquivos de entrada (substitua com seus nomes de arquivos)
        List<String> arquivosEntrada = new ArrayList<>();
        arquivosEntrada.add("C:\\Users\\Cliente\\Desktop\\projeto_poo_bd\\Sistema\\documentoTeste2.docx");
        arquivosEntrada.add("C:\\Users\\Cliente\\Desktop\\projeto_poo_bd\\Sistema\\Questão0.docx");
        // Adicione mais nomes de arquivos, se necessário

        // Nome do arquivo de saída
        String arquivoSaida = "provageradateste.docx";

        // Crie um novo documento Word de saída
        XWPFDocument documentoFinal = new XWPFDocument();

        for (String nomeArquivo : arquivosEntrada) {
            // Abra cada arquivo de entrada
            FileInputStream inputStream = new FileInputStream(nomeArquivo);
            XWPFDocument documentoEntrada = new XWPFDocument(inputStream);

            // Copie o conteúdo do arquivo de entrada para o arquivo de saída
            for (XWPFParagraph paragraph : documentoEntrada.getParagraphs()) {
                XWPFParagraph newParagraph = documentoFinal.createParagraph();
                for (XWPFRun run : paragraph.getRuns()) {
                    XWPFRun newRun = newParagraph.createRun();
                    newRun.setText(run.getText(0));
                }
            }

            // Feche o arquivo de entrada
            inputStream.close();
        }

        // Salve o documento final em um arquivo
        FileOutputStream outputStream = new FileOutputStream(arquivoSaida);
        documentoFinal.write(outputStream);
        outputStream.close();

        System.out.println("Documentos combinados com sucesso em " + arquivoSaida);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
