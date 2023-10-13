package controller;

import BO.MonitorBO;
import Exception.AlreadyExistsLoginEX;
import connection.MonitorDAO;
import entities.Monitor;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerCadastro {
	@FXML private TextField nome;
	@FXML private TextField novologin;
	@FXML private TextField novasenha;
	@FXML private TextField matricula;
	@FXML private TextField repetirsenha;
	@FXML private TextField loginprofessor;
	@FXML private TextField senhaprofessor;
	@FXML private Label error;
	@FXML private Button btCadastrar;
	
	public void cadastrar() throws AlreadyExistsLoginEX {
		Monitor monitor = new Monitor();
		MonitorBO buscador = new MonitorBO();
		monitor.setLogin(novologin.getText());
		monitor.setSenha(novasenha.getText());
		monitor.setNomeMonitor(nome.getText());
		monitor.setMatricula(matricula.getText());
		String textoRepitirSenha = repetirsenha.getText();
		String loginProfessor = loginprofessor.getText();
		String senhaProfessor = senhaprofessor.getText();
		if (textoRepitirSenha.equals(monitor.getSenha()) && loginProfessor.equals("admin123") && senhaProfessor.equals("administrador123")) {
		    System.out.println("As senhas são iguais!");
		    buscador.cadastrar(monitor);
		} else {
		    System.out.println("As senhas não são iguais!");
		    error.setVisible(true);
		}
	}
}
