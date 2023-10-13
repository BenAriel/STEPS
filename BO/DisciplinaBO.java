package BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Exception.AutenticationEX;
import Exception.DeleteEX;
import Exception.InsertEX;
import Exception.ListEX;
import Exception.UpdateDisciplineEX;
import connection.DisciplinaDAO;
import entities.Disciplina;
import entities.Questao;

public class DisciplinaBO {
    private DisciplinaDAO disciplinadao= new DisciplinaDAO();
    
        public void cadastrar(Disciplina disciplina) throws InsertEX {
            try{
           disciplinadao.inserir(disciplina);
            }
            catch(Exception e) {
                throw new InsertEX();
            }
                
                
        }

        

        

    public void alterarDisciplina(Disciplina disciplina) throws UpdateDisciplineEX {
        try{
        disciplinadao.alterar(disciplina);
        }
        catch(Exception e) {
            throw new UpdateDisciplineEX();
        }
}

    public void removerDisciplina(Disciplina disciplina) throws DeleteEX{
        try{
        disciplinadao.remover(disciplina);
        }
        catch(Exception e) {
            throw new DeleteEX();
        }
    }

   

    public ArrayList<Disciplina> listar() throws ListEX{
        try{
        return disciplinadao.listar();
    }
    catch(Exception e) {
        throw new ListEX();}
}


}
       

  
