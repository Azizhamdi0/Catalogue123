package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.SingletonConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CategorieCrud implements Crud<Categorie> {

	@Override
	public  ObservableList<Categorie> getAll() {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		Categorie p;
		ObservableList<Categorie> produits=FXCollections.observableArrayList();
		try {
			ps = SingletonConnection.getCon().prepareStatement("Select * from categorie;");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				p=new Categorie(rs.getInt("id"),rs.getString("nom"));
				produits.add(p);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produits;
	}

	@Override
	public int add(Categorie o) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		try {
			ps=SingletonConnection.getCon().prepareStatement("insert into categorie (nom) values(?);");
			ps.setString(1, o.getNom());
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}

	@Override
	public int delete(Categorie o) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		
		try {
			ps = SingletonConnection.getCon().prepareStatement("delete from categorie where id= ?;");
			
			ps.setInt(1, o.getId());
			int  n= ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}

	@Override
	public int update(Categorie o) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
			
		try {
			ps = SingletonConnection.getCon().prepareStatement("update categorie set nom=? where id= ?;");
			ps.setString(1, o.getNom());
			ps.setInt(2, o.getId());
			int  n= ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}
}


