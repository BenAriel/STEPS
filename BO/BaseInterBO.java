package BO;
import java.util.ArrayList;

public interface  BaseInterBO<entities> {
    public void cadastrar(entities entity);
	public void buscarPorId(entities entity);
	public ArrayList<entities> listar();
	public void alterar(entities entity);
	public void remover(entities entity);
}
