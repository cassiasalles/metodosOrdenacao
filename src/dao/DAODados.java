package dao;

import factory.Conexao;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Dados;
import factory.Conexao;

public class DAODados {
	private Connection connection;
	ResultSet rs;
	PreparedStatement stmt;
	Dados dadoM = new Dados();

	public DAODados() throws ClassNotFoundException {
		this.connection = new Conexao().getConnection();
	}
	
	//INT//
	
		//Contar os registros para definir ID
		public int contadorInt(){ 
	        String sql = "SELECT COUNT(*) FROM dados_int";
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
		
		//Inserir os dados INT no BD
		public void inserirInt(Dados dadoM){ 
	        String sql = "INSERT INTO dados_int(id_dado, dado) VALUES(?,?)";
	        try { 
	            stmt = connection.prepareStatement(sql);
	            stmt.setInt(1, dadoM.getIdDadosInt());
	            stmt.setInt(2, dadoM.getDados_int());
	            stmt.executeUpdate();
	            stmt.close();
	        } 
	        catch (SQLException u) { 
	            throw new RuntimeException(u);
	        }   
	    }
		
		//Selecionar os dados INT no BD
		public void selecionarInt(Dados dadoM){ 
	        String sql = "SELECT dado FROM dados_int WHERE id_dado = ?";
	        try { 
	            stmt = connection.prepareStatement(sql);
	            stmt.setInt(1, dadoM.getIdDadosInt());
	            rs = stmt.executeQuery();
	            rs.next();
	            dadoM.setDados_int(rs.getInt("dado"));
	            stmt.close();
	        } 
	        catch (SQLException u) { 
	            throw new RuntimeException(u);
	        }  
	    }


	//FIM-INT//
	
	//DOUBLE//
	
		//Contar os registros para definir ID
		public int contadorDouble(){ 
	        String sql = "SELECT COUNT(*) FROM dados_double";
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
		
		//Inserir os dados DOUBLE no BD
		public void inserirDouble(Dados dadoM){ 
	        String sql = "INSERT INTO dados_double(id_dado, dado) VALUES(?,?)";
	        try { 
	            stmt = connection.prepareStatement(sql);
	            stmt.setInt(1, dadoM.getIdDadosDouble());
	            stmt.setDouble(2, dadoM.getDados_double());
	            stmt.execute();
	            stmt.close();
	        } 
	        catch (SQLException u) { 
	            throw new RuntimeException(u);
	        }   
	    }
		
		//Selecionar os dados DOUBLE no BD
		public void selecionarDouble(Dados dadoM){ 
	        String sql = "SELECT dado FROM dados_double WHERE id_dado = ?";
	        try { 
	            stmt = connection.prepareStatement(sql);
	            stmt.setInt(1, dadoM.getIdDadosDouble());
	            rs = stmt.executeQuery();
	            rs.next();
	            dadoM.setDados_double(rs.getDouble("dado"));
	            stmt.close();
	        } 
	        catch (SQLException u) { 
	            throw new RuntimeException(u);
	        }   
	    }
	
	//FIM-DOUBLE//
	
	//STRING//
	
		//Contar os registros para definir ID
		public int contadorString(){ 
	        String sql = "SELECT COUNT(*) FROM dados_String";
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
		
		//Inserir os dados STRING no BD
		public void inserirString(Dados dadoM){ 
	        String sql = "INSERT INTO dados_String(id_dado, dado) VALUES(?,?)";
	        try { 
	            stmt = connection.prepareStatement(sql);
	            stmt.setInt(1, dadoM.getIdDadosString());
	            stmt.setString(2, dadoM.getDados_String());
	            stmt.execute();
	            stmt.close();
	        } 
	        catch (SQLException u) { 
	            throw new RuntimeException(u);
	        }   
	    }
		
		//Selecionar os dados STRING no BD
		public void selecionarString(Dados dadoM){ 
	        String sql = "SELECT dado FROM dados_String WHERE id_dado = ?";
	        try { 
	            stmt = connection.prepareStatement(sql);
	            stmt.setInt(1, dadoM.getIdDadosString());
	            rs = stmt.executeQuery();
	            rs.next();
	            dadoM.setDados_String(rs.getString("dado"));
	            stmt.close();
	        } 
	        catch (SQLException u) { 
	            throw new RuntimeException(u);
	        }   
	    }
		
	//FIM-STRING//
	
	
}
