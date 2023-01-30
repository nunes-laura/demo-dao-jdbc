package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	//conectar com o banco
	private static Connection conn = null; //conexão começa nula, não existe
	
	public static Connection getConnection() {
		if (conn == null) { //se a conxão for nula, tentamos abrir
			try {
			Properties props = loadProperties();
			String url = props.getProperty("dburl");
			conn = DriverManager.getConnection(url, props);
			System.out.println("Conexão bem sucedida!");}
			
			catch (SQLException e) {
				throw new DbException(e.getMessage()); }
		}
		return conn; }
	
	//ler e carregar os arquivos
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) { 
			Properties props = new Properties();
			props.load(fs);;
			return props; }
		
		catch (IOException e) {
			throw new DbException(e.getMessage()); }
	}
	
	//fechar conexão
	public static void closeConnections(Connection conn, Statement st) { 
		try {
		if (conn != null); //ja houve conexão, já foi aberta, então agora pode pedir para fechar
		conn.close();
		System.out.println("Conexão encerrada!");}
		
		catch(SQLException e) {
			throw new DbException(e.getMessage()); } 
		
		try {
		if (st != null);
		st.close();
		System.out.println("Conexão Statement encerrada!");}
	
		catch(SQLException e) {
		throw new DbException(e.getMessage()); }
		
		
		//Não precisa colocar também pois o rs foi iniciado dentro do if e não tem problema
		/*try {
			if (rs != null);
			rs.close();
			System.out.println("Conexão ResultSet encerrada!");}
			catch(SQLException e) {
			throw new DbException(e.getMessage()); }
		*/
		
		
	}

}
