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
        setDisciplina(disciplina);
        setQuestoes(questoes);
        setNumeroDeQuestoes(numeroDeQuestoes);
        setQuestoesFaceis(questoesFaceis);
        setQuestoesMedias(questoesMedias);
        setQuestoesDificeis(questoesDificeis);
        setData(LocalDate.now()); 
    }
		
    public void gerarProvas(int numeroDeQuestoes,int questoesFaceis, int questoesMedias, int questoesDificeis) {
	setNumeroDeQuestoes(numeroDeQuestoes);
	setQuestoesFaceis(questoesFaceis);
	setQuestoesMedias(questoesMedias);
	setQuestoesDificeis(questoesDificeis);  
	setData(LocalDate.now()); // coloca a data do momento da criação como data da prova
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

    public int getNumeroDeQuestoes() {
        return numeroDeQuestoes;
    }

    public void setNumeroDeQuestoes(int numeroDeQuestoes) {
    	if(numeroDeQuestoes < 1 ) {
			this.numeroDeQuestoes = numeroDeQuestoes;
		}
		else
		{
			System.out.println("Numero de questoes não pode ser negativo ou zero!");
		}
    }

    public void setData(LocalDate data) {
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
    	if(questoesFaceis + questoesMedias + questoesDificeis > numeroDeQuestoes) {
			this.questoesFaceis = questoesFaceis;
		}
		else
		{
			System.out.println(" número de questões FACEIS ultrapassa o limite de: \" + numeroDeQuestoes");
		}
    }

    public int getQuestoesMedias() {
        return questoesMedias;
    }

    public void setQuestoesMedias(int questoesMedias) {
    	if(questoesFaceis + questoesMedias + questoesDificeis > numeroDeQuestoes) {
			this.questoesMedias = questoesMedias;
		}
		else
		{
			System.out.println("O número de questões MEDIAS ultrapassa o limite de: " + numeroDeQuestoes);
		}
    }

    public int getQuestoesDificeis() {
        return questoesDificeis;
    }

    public void setQuestoesDificeis(int questoesDificeis) {
    	if(questoesFaceis + questoesMedias + questoesDificeis > numeroDeQuestoes) {
			this.questoesDificeis = questoesDificeis;
		}
		else
		{
			System.out.println("O número de questões DIFICEIS ultrapassa o limite de: " + numeroDeQuestoes);
		}
    }
}
