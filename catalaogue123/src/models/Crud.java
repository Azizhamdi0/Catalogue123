package models;

import java.util.List;

public interface Crud<Objet>{
	public  List<Objet> getAll() ;
	public int add(Objet o);
	public int delete(Objet o);
	public int update(Objet o);

}
