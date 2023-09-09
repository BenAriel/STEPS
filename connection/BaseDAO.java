package connection;

public interface BaseDAO<E> {
	public void buscar(E objeto);
	public void alterar(E objeto);
	public void remover(E objeto);
	public void listar(E objeto);
	public void inserir(E objeto);
}

