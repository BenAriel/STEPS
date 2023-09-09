package entities;


public class Prova {
	private String disciplina;
	private String questoes;
	private int numeroDeQuestoes;
	private String data;
	private int questoesFaceis;
	private int questoesMedias;
	private int questoesDificeis;
    private int codigo;
	
    public Prova(String disciplina,int codigo, String questoes, int numeroDeQuestoes, int questoesFaceis, int questoesMedias, int questoesDificeis,String data) {
        setDisciplina(disciplina);
        setCodigo(codigo);
        setQuestoes(questoes);
        setNumeroDeQuestoes(numeroDeQuestoes);
        setQuestoesFaceis(questoesFaceis);
        setQuestoesMedias(questoesMedias);
        setQuestoesDificeis(questoesDificeis);
        setData(data);
    }
		
	public void gerarProvas(int numeroDeQuestoes,int questoesFaceis, int questoesMedias, int questoesDificeis,String data) {
	    setNumeroDeQuestoes(numeroDeQuestoes);
		setQuestoesFaceis(questoesFaceis);
	    setQuestoesMedias(questoesMedias);
	    setQuestoesDificeis(questoesDificeis);  
	    setData(data); // coloca a data do momento da criação como data da prova
	}
	
    public String getDisciplina() {
    	
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
    	if(disciplina != null) {
			this.disciplina = disciplina;
		}
		else
		{
			System.out.println("Disciplina não pode ser vazia!");
		}
    }

    public String getQuestoes() {
        return questoes;
    }

    public void setQuestoes(String questoes) {
    	if(questoes != null) {
			this.questoes = questoes;
		}
		else
		{
			System.out.println("Questoes não pode ser vazia!");
		}
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        if(codigo!=0)
        this.codigo = codigo;
    }

    public int getNumeroDeQuestoes() {
        return numeroDeQuestoes;
    }

    public void setNumeroDeQuestoes(int numeroDeQuestoes) {
    	if(numeroDeQuestoes < 1 ) {
			System.out.println("Numero de questoes não pode ser negativo ou zero!");
			System.exit(1);
		}
		else
		{
			this.numeroDeQuestoes = numeroDeQuestoes;
		}
    }   public String getData() {
        return data;
    }

    public void setData(String data) {
    	if(data != null ) {
			this.data = data;
		}
		else
		{
			System.out.println("A data não pode ser vazio");
		}
    }

    public int getQuestoesFaceis() {
        return questoesFaceis;
    }

    public void setQuestoesFaceis(int questoesFaceis) {
        int somaQuestoes = this.questoesFaceis+ this.questoesMedias;
        int sobraQuestoes = this.numeroDeQuestoes - somaQuestoes;
        if (questoesFaceis + questoesMedias + questoesDificeis > numeroDeQuestoes) {
            System.out.println("O número de questões FACEIS ultrapassa o limite de: " + numeroDeQuestoes + " questoes.");
            System.out.println("Questões fáceis adicionadas: " + questoesFaceis);
            System.out.println("Questões medias adicionadas: " + this.questoesMedias);
            System.out.println("Questões dificeis adicionadas: " + this.questoesDificeis);
            System.out.println("Você adicionou " + questoesFaceis + " questoes fáceis e ultrapassou o limite das " + this.numeroDeQuestoes + " questões estipuladas. \nVocê poderia ter adicionado apenas mais " + sobraQuestoes  + " questões fáceis sem ultrapssar o limite.");
            System.exit(1);
        } else {
            this.questoesFaceis = questoesFaceis;
        }
    }

    public int getQuestoesMedias() {
        return questoesMedias;
    }

    public void setQuestoesMedias(int questoesMedias) {
        int somaQuestoes = this.questoesFaceis+ this.questoesMedias;
        int sobraQuestoes = this.numeroDeQuestoes - somaQuestoes;
        if (questoesFaceis + questoesMedias + questoesDificeis > numeroDeQuestoes) {
            System.out.println("O número de questões MEDIAS ultrapassa o limite de: " + numeroDeQuestoes + " questoes.");
            System.out.println("Questões fáceis adicionadas: " + this.questoesFaceis);
            System.out.println("Questões medias adicionadas: " + questoesMedias);
            System.out.println("Questões dificeis adicionadas: " + this.questoesDificeis);
            System.out.println("Você adicionou " + questoesMedias + " questoes médias e ultrapassou o limite das " + this.numeroDeQuestoes + " questões estipuladas. \nVocê poderia ter adicionado apenas mais " + sobraQuestoes  + " questões médias sem ultrapssar o limite.");
            System.exit(1);
        } else {
            this.questoesMedias = questoesMedias;
        }
        
    }

    public int getQuestoesDificeis() {
        return questoesDificeis;
    }

    public void setQuestoesDificeis(int questoesDificeis) {
        int somaQuestoes = this.questoesFaceis+ this.questoesMedias;
        int sobraQuestoes = this.numeroDeQuestoes - somaQuestoes;
        if (questoesFaceis + questoesMedias + questoesDificeis > numeroDeQuestoes ) {
            System.out.println("O número de questões DIFICEIS ultrapassa o limite de: " + numeroDeQuestoes + " questoes.");
            System.out.println("Questões fáceis adicionadas: " + this.questoesFaceis);
            System.out.println("Questões medias adicionadas: " + this.questoesMedias);
            System.out.println("Questões dificéis adicionadas: " + questoesDificeis);
            System.out.println("Você adicionou " + questoesDificeis + " questoes dificéis e ultrapassou o limite das " + this.numeroDeQuestoes + " questões estipuladas. \nVocê poderia ter adicionado apenas mais " + sobraQuestoes  + " questões dificéis sem ultrapssar o limite.");
            System.exit(1);
        } else {
            this.questoesDificeis = questoesDificeis;
        }
    }
}
