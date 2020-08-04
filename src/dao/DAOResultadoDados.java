package dao;

import factory.Conexao;
import model.Dados;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import factory.Conexao;

public class DAOResultadoDados {
	private Connection connection;
	private ResultSet rs;
	PreparedStatement stmt;

	public DAOResultadoDados() throws ClassNotFoundException {
		this.connection = new Conexao().getConnection();
	}
	
	//Contar os registros para definir ID
	public int contador(){ 
        String sql = "SELECT COUNT(*) FROM dados_resultados";
        int qtd=0;
        try { 
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.next();
            qtd = rs.getInt(1);
            stmt.close();
            return qtd;
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        }   
    }
	
	//Contar os registros para definir ID
		public int contadorExecucao(){ 
	        String sql = "SELECT MAX(execucao) FROM dados_resultados";
	        int qtd=0;
	        try { 
	            stmt = connection.prepareStatement(sql);
	            rs = stmt.executeQuery();
	            rs.next();
	            qtd = rs.getInt(1);
	            stmt.close();
	            return qtd;
	        } 
	        catch (SQLException u) { 
	            throw new RuntimeException(u);
	        }   
	    }
	
	//Inserir os resultados por método no BD
	public void inserir(Dados dadoM){ 
        String sql = "INSERT INTO dados_resultados(id_result, metodo, tipo, tempo, execucao) VALUES(?,?,?,?,?)";
        try { 
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, dadoM.getIdResult());
            stmt.setString(2, dadoM.getMetodo());
            stmt.setString(3, dadoM.getTipo());
            stmt.setLong(4, dadoM.getTempo());
            stmt.setInt(5, dadoM.getExecucaoResultado());
            stmt.execute();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        }   
    } 
}
