package BO;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import Exception.ListEX;
import Exception.UpdateDisciplineEX;

import org.postgresql.util.PSQLException;

import Exception.AutenticationEX;
import Exception.DeleteEX;
import Exception.InsertEX;
import connection.QuestaoDAO;
import entities.Questao;

public class QuestaoBO {
     private QuestaoDAO questaodao = new QuestaoDAO();


    
     
       

        public void cadastrar(Questao questao) throws InsertEX {
            try{
           questaodao.inserir(questao);
            }
            catch(Exception e) {
                throw new InsertEX();
            }
                
        }
        

        

    public void alterarQuestao(Questao questao) throws UpdateDisciplineEX {
      try{
        
        questaodao.alterar(questao);
      }
      catch(Exception e) {
          throw new UpdateDisciplineEX();
      }
    
}

    public void removerQuestao(Questao questao) throws DeleteEX {
        try{
        questaodao.remover(questao);
        }
        catch(Exception e) {
            throw new DeleteEX();
        }
    }

    public ArrayList<Questao> listar() throws ListEX {
        try{
        return questaodao.listar();
    } catch (Exception e) {
        throw new ListEX();
    }
    }

    
}