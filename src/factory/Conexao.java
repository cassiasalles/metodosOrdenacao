package factory;

import java.sql.Connection; 
//conexão SQL para Java 
import java.sql.DriverManager; 
//driver de conexão SQL para Java 
import java.sql.SQLException; 
//classe para tratamento de exceções 

public class Conexao {
	public static Connection getConnection() throws ClassNotFoundException {
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:system/1234@//localhost:1521/XE","system","1234");
		 }         
		 catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		 }
    }
}
