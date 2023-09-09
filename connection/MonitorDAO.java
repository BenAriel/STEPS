package connection;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import entities.Monitor;


public class MonitorDAO extends BaseDAO_IMP<Monitor> {
		
	public void remover(Monitor monitor) {
		String sql = "delete from Monitor where matricula = ?";
		con = getConnection();
		PreparedStatement ptst;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setInt(1, monitor.getMatricula());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void buscar(Monitor objeto) {
		// TODO Auto-generated method stub
		super.buscar(objeto);
	}



	@Override
	public void alterar(Monitor objeto) {
		// TODO Auto-generated method stub
		super.alterar(objeto);
	}



	@Override
	public void inserir(Monitor monitor) {
		String sql = "INSERT into Monitor(matricula,nome, login, senha) values (?,?,?,?)";
		con = getConnection();
		PreparedStatement ptst;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setInt(1, monitor.getMatricula());
			ptst.setString(2, monitor.getNomeMonitor());
			ptst.setString(3, monitor.getLogin());
			ptst.setString(4, monitor.getSenha());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
	}
}
