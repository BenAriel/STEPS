public class Monitor {
  
    private String nome; 
    private String login;
    private String senha;
    private int matricula;
    final boolean NiveldeAcesso=false; //o nivel de acesso do monitor é sempre negado(false).

    public Monitor(){};

    public Monitor (String Name,String Log,String Pass,int mat)
    {
        setNomeMonitor(Name);
        setLogin(Log);
        setSenha(Pass);
        setMatricula(mat);
    }
    //métodos get e sets.
    public String getNomeMonitor() {
        return nome;
    }
    public void setNomeMonitor(String Name)
    {
         if(Name!= null && Name!= "\0")
        this.nome = Name;
        else
        System.out.println("digite um nome válido");
    }
     public int matricula() {
        return matricula;
    }
    public void setMatricula(int Mat)
    {
        int a = (int)(Math.log10(Mat)+1);//verifica se tem 10 digitos.
        System.out.println(a);
         if( Mat !=0  &&  a != 10 )
        this.matricula=Mat;
        else
        System.out.println("digite um nome válido");
    }


    public String getLogin()
    {
        return login;
    }
    public void setLogin(String Log)
    {
        if(Log != null && Log != "\0")
        this.login=Log;
        else
        System.out.println("digite um login válido");
    }

     public String getSenha()
    {
        return senha;
    }
    public void setSenha(String Password)
    {
        if(Password!= null && Password != "\0")
        this.senha=Password;
        else
        System.out.println("digite uma senha válida");
    }

    public void Login( String TentativaLogin,String TentativaSenha)
{
    String LoginAtual=getLogin(); //salva o login e a senha atuais em duas variáveis locais.
    String SenhaAtual=getSenha();
    setLogin(TentativaLogin); //chama os métodos set e get para verificar se os dados são válidos.
    setSenha(TentativaSenha);
    if(TentativaLogin==LoginAtual && TentativaSenha == SenhaAtual ) //verifica se o login e a senha inseridos são iguais as senhas atuais.
    {
        System.out.println("Login relalizado com sucesso"); //se for igual,o login é realizado.
    }
    else
    {
        System.out.println("Login ou senha incorretos"); //se nao for igual,o login é negado e volta para a senha e login anteriores.
        login=LoginAtual;
        senha=SenhaAtual;
    }

}
}

