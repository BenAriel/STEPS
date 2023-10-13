package BO;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.postgresql.util.PSQLException;
import org.w3c.dom.DOMException;

import Exception.AlreadyExistsLoginEX;
import Exception.AutenticationEX;
import Exception.DeleteEX;
import Exception.InsertEX;
import connection.MonitorDAO;
import entities.Monitor;
import javafx.geometry.Insets;

public class MonitorBO {
     private MonitorDAO monitordao=new MonitorDAO();


    
     public Monitor autenticar(Monitor monitor) throws AutenticationEX {
        Monitor autenticado = monitordao.buscarPorLogin(monitor); // Presumindo que monitordao.buscarPorLogin já retorna um objeto Monitor
        try {
            if (autenticado != null) {
                if (autenticado.getSenha().equals(monitor.getSenha())) {
                    return autenticado;
                } else {
                    throw new AutenticationEX();
                }
            } else {
                throw new AutenticationEX();
            }
        } catch (Exception e) {
            throw new AutenticationEX();
        }
		}
       

        public void cadastrar(Monitor monitor)  throws AlreadyExistsLoginEX {
           
                // Verifica se já existe um usuário com o mesmo login
                Monitor existingMonitor = monitordao.buscarPorLogin(monitor);
                try{
                if (existingMonitor != null) {
                    throw new AlreadyExistsLoginEX();
                }
                else{
                
                   monitordao.inserir(monitor);
                }
                
                }catch(AlreadyExistsLoginEX e) {
                    throw new AlreadyExistsLoginEX();
                }
                
                
        }
        

        

    public void alterarMonitor(Monitor monitor) throws Exception {
        Monitor existingMonitor = monitordao.buscarPorLogin(monitor);
        try {
             if (existingMonitor != null) {
                    throw new AlreadyExistsLoginEX();
             }
            monitordao.alterar(monitor);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        
    
    }

    public void removerMonitor(Monitor monitor) throws DeleteEX {
        try {
            monitordao.remover(monitor);
        } catch (Exception e) {
            throw new DeleteEX();
        }
    }

    public Monitor buscarMonitorPorMatricula(String matricula) {
        Monitor monitor = new Monitor();
        monitor.setMatricula(matricula);
        return monitordao.buscar(monitor);
    }

    public ArrayList<Monitor> listar() {
        return monitordao.listar();
    }

    
}

