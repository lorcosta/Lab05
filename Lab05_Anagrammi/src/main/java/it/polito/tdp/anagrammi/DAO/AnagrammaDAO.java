package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {

	/**
	 * Riceve una parola e controlla se questa appartiene al database 'dizionario'
	 * @param anagramma
	 * @return {@code true} o {@code false}
	 */
	public boolean isCorrect(String anagramma) {
		String sql="SELECT * FROM parola WHERE nome=? ";
		boolean ritorno=false;
		try {
			Connection conn= ConnectDB.getConnection();
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs=st.executeQuery();
			
			if(rs.next()) {
				ritorno=true;
			}
			conn.close();
			
		}catch(RuntimeException e){
			System.out.println("Errore di connessione del DB");
		}catch(SQLException e) {
			System.out.println("Errore di connessione del DB"); ;
		}
		return ritorno;
	}
}
