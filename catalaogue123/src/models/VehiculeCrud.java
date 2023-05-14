package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.SingletonConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VehiculeCrud implements Crud<Vehicule> {

	@Override
	public  ObservableList<Vehicule> getAll() {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		Vehicule p;
		ObservableList<Vehicule> vehicule=FXCollections.observableArrayList();
		try {
			ps = SingletonConnection.getCon().prepareStatement("Select * from Vehicule;");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				p=new Vehicule(rs.getInt("id"),rs.getString("model"),rs.getString("couleur"),rs.getInt("categ"));
				vehicule.add(p);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vehicule;
	}

	@Override
	public int add(Vehicule o) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		try {
			ps=SingletonConnection.getCon().prepareStatement("insert into vehicule (model,couleur,categ) values(?,?,?);");
			ps.setString(1, o.getModel());
			ps.setString(2, o.getCouleur());
			ps.setInt(3,o.getCateg());
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}

	@Override
	public int delete(Vehicule o) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		
		try {
			ps = SingletonConnection.getCon().prepareStatement("delete from vehicule where id= ?;");
			
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
	public int update(Vehicule o) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
			
		try {
			ps = SingletonConnection.getCon().prepareStatement("update vehicule set model=?, couleur=?,categ=? where id= ?;");
			ps.setString(1, o.getModel());
			ps.setString(2, o.getCouleur());
			ps.setInt(3, o.getCateg());
			ps.setInt(4, o.getId());
			int  n= ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}
}


