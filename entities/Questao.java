package entities;

public class Questao {
    private int codigo;
    private String disciplina;
    private String enunciado;
    private String gabarito;
    private String assunto;
    private NivelDeDificuldade nivelDeDificuldade;

    public enum NivelDeDificuldade {
        FACIL,
        MEDIO,
        DIFICIL
    }

    public Questao() { // construtor default
    }

    //construtor principal
    public Questao(int codigo, String disciplina, String enunciado, String gabarito, String assunto, int nivelDeDificuldade) {
        setCodigo(codigo);
        setDisciplina(disciplina);
        setEnunciado(enunciado);
        setGabarito(gabarito);
        setAssunto(assunto);
        setNivelDeDificuldade(nivelDeDificuldade);
    }

    //métodos set e get dos atributos
    public void setCodigo(int codigo) {
        if (codigo < 0) {
            System.out.println("Não existe código negativo");
            System.exit(1); //em caso de erro, sai do programa
        } else {
            this.codigo = codigo;
        }
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setDisciplina(String disciplina) {
        if (disciplina != null) {
            this.disciplina = disciplina;
        } else {
            System.out.println("Disciplina não pode ser vazia!");
            System.exit(1); //em caso de erro, sai do programa
        }
    }

    public String getDisciplina() {
        return this.disciplina;
    }

    public void setEnunciado(String enunciado) {
        if (enunciado != null) {
            this.enunciado = enunciado;
        } else {
            System.out.println("Enunciado não pode ser vazio!");
            System.exit(1); //em caso de erro, sai do programa
        }
    }

    public String getEnunciado() {
        return this.enunciado;
    }

    public void setGabarito(String gabarito) {
        if (gabarito != null) {
            this.gabarito = gabarito;
        } else {
            System.out.println("Gabarito não pode ser vazio!");
            System.exit(1); //em caso de erro, sai do programa
        }
    }

    public String getGabarito() {
        return this.gabarito;
    }

    public void setAssunto(String assunto) {
        if (assunto != null) {
            this.assunto = assunto;
        } else {
            System.out.println("Assunto não pode ser vazio!");
            System.exit(1); //em caso de erro, sai do programa
        }
    }

    public String getAssunto() {
        return this.assunto;
    }

    public NivelDeDificuldade getNivel() {
        return this.nivelDeDificuldade;
    }

    public void setNivelDeDificuldade(int nivel) {
        if (nivel < 1 || nivel > 3)
        {
            System.out.println("Valor inválido, nível vai de 1 até 3!");
        }
        else
        {
            if(nivel == 1){
                this.nivelDeDificuldade = nivelDeDificuldade.FACIL;
            }
            if(nivel == 2){
                this.nivelDeDificuldade = nivelDeDificuldade.MEDIO;
            }
            if(nivel == 3){
                this.nivelDeDificuldade = nivelDeDificuldade.DIFICIL;
            }
        
        }    
            
    }
}