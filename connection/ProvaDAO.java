package connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entities.Prova;

public class ProvaDAO extends BaseDAO_IMP<Prova> {

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return super.getConnection();
	}

	@Override
	public void inserir(Prova prova) {
		String sql = "INSERT into Prova(disciplina,codigo,questoes, numeroDeQuestoes, data,questoesFaceis,questoesMedias,questoesDificeis) values (?,?,?,?)";
		con = getConnection();
		PreparedStatement ptst;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setString(1, prova.getDisciplina());
			ptst.setInt(2, prova.getCodigo());
			ptst.setString(3, prova.getQuestoes());
			ptst.setInt(4, prova.getNumeroDeQuestoes());
			ptst.setString(5, prova.getData());
			ptst.setInt(6, prova.getQuestoesFaceis());
			ptst.setInt(7, prova.getQuestoesMedias());
			ptst.setInt(8, prova.getQuestoesDificeis());
			ptst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void listar(Prova objeto) {
		// TODO Auto-generated method stub
		super.listar(objeto);
	}

	@Override
	public void buscar(Prova objeto) {
		// TODO Auto-generated method stub
		super.buscar(objeto);
	}

	@Override
	public void alterar(Prova objeto) {
		// TODO Auto-generated method stub
		super.alterar(objeto);
	}

	@Override
	public void remover(Prova prova) {
		String sql = "delete from Prova where codigo = ?";
		con = getConnection();
		PreparedStatement ptst;
		try {
			ptst = con.prepareStatement(sql);
			ptst.setInt(1, prova.getCodigo());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
