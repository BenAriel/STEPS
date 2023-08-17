public class Disciplina {
    private String nome;
    private int codigo;
    private String descricao;

    //construtor para inicializar a discilina
    public Disciplina(){};
    public Disciplina(String name,int codigo,String discri)
    {
        setNome(name);
        setCodigo(codigo);
        setDescricao(discri);
    }
     //métodos gets e sets
    public String getNome ()
    {
        return nome;
    }

    public void setNome(String name)
    {
        if(name!= null && name!= "\0")
        this.nome=name;
        else
        System.out.println("Digite um nome válido");
    }

    
    public int  getCodigo ()
    {
        return codigo;
    }

    public void setCodigo(int code)
    {
        if(code!= 0)
        this.codigo=code;
        else
        System.out.println("Digite um código válido");
    }
    
    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String desc)
    {
        if(desc!= null && desc!= "\0")
        this.descricao=desc;
        else
        System.out.println("Digite uma descrição válida");
    }
    //visualiza disciplina e sobrescreve o ToString padrão
    @Override
    public String toString ()
    {
       return ("Nome da disciplina: " + this.nome + "\n código da disciplina: " + this.codigo +"\n descrição da disciplina:" + this.descricao);  
    }
        
}
