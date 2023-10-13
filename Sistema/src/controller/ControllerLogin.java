package controller;

import java.io.IOException;

import BO.MonitorBO;
import connection.MonitorDAO;
import entities.Monitor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.TelaCadastro;
import view.TelaInicio;
import view.TelaRedefinicao;

public class ControllerLogin {
	@FXML
	private Label error; //feito
	@FXML
	private TextField login; //feito
	@FXML
	private TextField senha; //feito
	@FXML
	private Button btEntrar; //feito
	@FXML
	private Button btCadastrar; //feito
	@FXML
	private Button redefinirSenha;//feito
	

	public void autenticar(ActionEvent event) {
		System.out.println("Clicou em entrar!");
		Monitor monitor = new Monitor();
		MonitorBO buscador = new MonitorBO();
		monitor.setLogin(login.getText());
		monitor.setSenha(senha.getText());

		if ("admin123".equals(monitor.getLogin()) && "administrador123".equals(monitor.getSenha())) {
			TelaInicio telaInicio = new TelaInicio();
			try {
				Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // pega referencia da  atual janela
				primaryStage.close(); // fecha a atual janela!
				telaInicio.start(new Stage(), "dr. Helihelcio da silva"); //também envia o nome do monitor como parâmetro
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Abrindo tela do administrador!");
		} else {

			System.out.println(monitor.getLogin());
			System.out.println(monitor.getSenha());
			try {
				Monitor monitorAutenticado =buscador.autenticar(monitor);
				if (monitorAutenticado.getNomeMonitor() == null) {
					// indicar que houve um erro
					error.setVisible(true);
				} else {
					Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // pega referencia
					TelaInicio telaInicio = new TelaInicio();	
					primaryStage.close(); // fecha a atual janela!
					telaInicio.start(new Stage(), monitorAutenticado.getNomeMonitor()); //também envia o nome do monitor como parâmetro
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Monitor não encontrado!");
				e.printStackTrace();
			}
			// abrir tela do Monitor
		}

	}

	public void cadastrar(ActionEvent event) {
		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();// pega referencia da atual
																						// janela

		TelaCadastro telaCadastro = new TelaCadastro();
		try {
			primaryStage.close(); // Fecha a janela atual (TelaLogin)
			telaCadastro.start(new Stage());
			System.out.println("Clicou em cadastrar!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void redefinir(MouseEvent event) {
	    Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();// pega referencia da atual
	                                                                                    // janela

	    TelaRedefinicao telaRedefinicao = new TelaRedefinicao();
	    try {
	        primaryStage.close(); // Fecha a janela atual (TelaLogin)
	        telaRedefinicao.start(new Stage()); //abre a janela de redefinicao
	        System.out.println("Clicou em redefinir!");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


	
}