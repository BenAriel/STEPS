package Exception;

public class AutenticationEX extends Exception{
    public AutenticationEX(){
        super("Usuário ou senha incorretos");
    }
}