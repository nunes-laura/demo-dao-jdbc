package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
			}
			
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
	public static void closeConnection(Connection conn) { 
		try {
		if (conn != null); //ja houve conexão, já foi aberta, então agora pode pedir para fechar
		conn.close();
		}
		
		catch(SQLException e) {
			throw new DbException(e.getMessage()); }  }
		
		
	public static void closeStatment(Statement st) {	
		try {
		if (st != null);
		st.close();
		}
	
		catch(SQLException e) {
		throw new DbException(e.getMessage()); }
	}
	
	public static void closeResultSet (ResultSet rs) {
		try {
			if (rs != null);
			rs.close();
			}
		
			catch(SQLException e) {
			throw new DbException(e.getMessage()); }
	}
		
		
		
	}


