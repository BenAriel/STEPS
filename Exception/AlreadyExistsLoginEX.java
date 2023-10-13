package Exception;

public class AlreadyExistsLoginEX extends Exception{
    public AlreadyExistsLoginEX(){
        super("Já existe um usuário com esse Login");
    }
}