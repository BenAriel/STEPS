package connection;

import entities.Monitor;

public class Principal {

	public static void main(String[] args) {
		//BaseDAO dao = new BaseDAO();

		MonitorDAO dao2 = new MonitorDAO();
		Monitor monitor = new Monitor("Vinicius", "12342", "21ioj2d", 12345);
		//dao2.inserir(monitor);
		dao2.remover(monitor);
			
	}
}
