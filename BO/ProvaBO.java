package BO;

import java.util.ArrayList;

import Exception.AlreadyExistsLoginEX;
import Exception.DeleteEX;
import Exception.InsertEX;
import Exception.ListEX;
import Exception.UpdateProofEX;
import connection.ProvaDAO;
import entities.Prova;

public class ProvaBO {
    private ProvaDAO provadao = new ProvaDAO();


    
     
       

        public void cadastrar(Prova prova) throws InsertEX {
            
            try{
           provadao.inserir(prova);
            }
            catch(Exception e) {
                throw new InsertEX();
            }
                
                
        }
        

        

    public void alterarProva(Prova prova) throws UpdateProofEX{
      
        try{
        provadao.alterar(prova);
        }
        catch(Exception e) {
            throw new UpdateProofEX();
        }
    
    }

    public void removerProva(Prova prova) throws DeleteEX {
        try{
        provadao.remover(prova);
    }
    catch(Exception e) {
        throw new DeleteEX();
    }
    }

   

    public ArrayList<Prova> listar() throws ListEX {
        try{
        return provadao.listar();
    }
    catch(Exception e) {
        throw new ListEX();
    }
    }

    
}

