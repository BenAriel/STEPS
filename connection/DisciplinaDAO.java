package connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Disciplina;

public class DisciplinaDAO extends BaseDAO_IMP<Disciplina> {

	@Override
	public void inserir(Disciplina disciplina) {
		String sql = "INSERT into Disciplina (nome, codigo, descricao) values (?,?,?,?)";
		con = getConnection();
		PreparedStatement ptst;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setString(1, disciplina.getNome());
			ptst.setInt(2, disciplina.getCodigo());
			ptst.setString(3, disciplina.getDescricao());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void listar(Disciplina objeto) {
		// TODO Auto-generated method stub
		super.listar(objeto);
	}

	@Override
	public void buscar(Disciplina objeto) {
		// TODO Auto-generated method stub
		super.buscar(objeto);
	}

	@Override
	public void alterar(Disciplina objeto) {
		// TODO Auto-generated method stub
		super.alterar(objeto);
	}

	@Override
	public void remover(Disciplina disciplina) {
	String sql = "delete from Disciplina where codigo = ?";
		con = getConnection();
		PreparedStatement ptst;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setInt(1, disciplina.getCodigo());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
