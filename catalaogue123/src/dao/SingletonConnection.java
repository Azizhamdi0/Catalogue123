package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/voiture"
					+ "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC","root","");
			System.out.println("Connexion �tablie avec succ�s");
		}
	 catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public static Connection getCon() {
		return con;
	}
	
}
