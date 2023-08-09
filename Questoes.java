package steps;

public class Questoes {
    private int codigo;
    private String disciplina;
    private String enunciado;
    private String gabarito;
    private String assunto;
    private enum NivelDeDificuldade {
        FACIL, MEDIO, DIFICIL
    }
    
    private NivelDeDificuldade nivel;

    public Questoes() { // construtor default
    }

    public Questoes(int codigo, String disciplina, String enunciado, String gabarito, String assunto, NivelDeDificuldade nivel) {
        setCodigo(codigo);
        setEnunciado(enunciado);
        setGabarito(gabarito);
        setAssunto(assunto);
        this.nivel = nivel;
    }
	
	public void setCodigo(int x) {
		if (x < 0) {
			System.out.println("Não existe código negativo");
		}
		else
		{
			this.codigo = x;
		}
	}
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setDisciplina(String x) {
		if(x != null) {
			this.disciplina = x;
		}
		else
		{
			System.out.println("Disciplina não pode ser vazia!");
		}
	}
	public String getDisciplina() {
		return this.disciplina;
	}
	
	public void setEnunciado(String x) {
		if(x != null)
		{
			this.enunciado = x;
		}
		else
		{
			System.out.println("Enunciado não pode ser vazio!");
		}
	}
    public String getEnunciado() {
    	return this.enunciado;
    }

    public void setGabarito(String x) {
    	if (x!= null)
    	{
    		this.gabarito = x;
    	}
    	else
    	{
    		System.out.println("Gabarito não pode ser vazio!");
    	}
    }
    public String getGabarito() {
    	return this.gabarito;
    }

    public void setAssunto(String x) {
    	if (x != null)
    	{
    		this.assunto = x;
    	}
    	else
    	{
    		System.out.println("Assunto não pode ser vazio!");
    	}
    }
    public String getAssunto() {
    	return this.assunto;
    }
    
    public NivelDeDificuldade getNivel() {
        return nivel;
    }

    public void setNivel(NivelDeDificuldade nivel) {
        this.nivel = nivel;
    }
}
