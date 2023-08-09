package steps;
import java.time.LocalDate;

public class Provas {
	private String disciplina;
	private String questoes;
	private int numeroDeQuestoes;
	private LocalDate data;
	private int questoesFaceis;
	private int questoesMedias;
	private int questoesDificeis;
	
    public Provas(String disciplina, String questoes, int numeroDeQuestoes, LocalDate data, int questoesFaceis, int questoesMedias, int questoesDificeis) {
        this.disciplina = disciplina;
        this.questoes = questoes;
        this.numeroDeQuestoes = numeroDeQuestoes;
        this.data = data;
        this.questoesFaceis = questoesFaceis;
        this.questoesMedias = questoesMedias;
        this.questoesDificeis = questoesDificeis;
    }
		
	public void gerarProvas(int numQuestoesFaceis, int numQuestoesMedias, int numQuestoesDificeis) {
	    this.questoesFaceis = numQuestoesFaceis;
	    this.questoesMedias = numQuestoesMedias;
	    this.questoesDificeis = numQuestoesDificeis;  
	    this.numeroDeQuestoes = numQuestoesFaceis + numQuestoesMedias + numQuestoesDificeis;
	    this.data = LocalDate.now(); //coloca a data do momento da criação como data da prova
	}
	
    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getQuestoes() {
        return questoes;
    }

    public void setQuestoes(String questoes) {
        this.questoes = questoes;
    }

    public int getNumeroDeQuestoes() {
        return numeroDeQuestoes;
    }

    public void setNumeroDeQuestoes(int numeroDeQuestoes) {
        this.numeroDeQuestoes = numeroDeQuestoes;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getQuestoesFaceis() {
        return questoesFaceis;
    }

    public void setQuestoesFaceis(int questoesFaceis) {
        this.questoesFaceis = questoesFaceis;
    }

    public int getQuestoesMedias() {
        return questoesMedias;
    }

    public void setQuestoesMedias(int questoesMedias) {
        this.questoesMedias = questoesMedias;
    }

    public int getQuestoesDificeis() {
        return questoesDificeis;
    }

    public void setQuestoesDificeis(int questoesDificeis) {
        this.questoesDificeis = questoesDificeis;
    }
	
}
