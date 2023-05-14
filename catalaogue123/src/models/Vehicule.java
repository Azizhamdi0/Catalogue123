package models;

public class Vehicule {
	private int id;
	private String model;
	private String couleur;
	private int categ;
	
	public Vehicule(int id) {
		super();
		this.id = id;
	}
	public Vehicule(String model,String couleur, int categ) {
		super();
		this.model = model;
		this.couleur = couleur;
		this.categ = categ;
	}
	public Vehicule(int id,String model,String couleur, int categ) {
		super();
		this.id = id;
		this.model = model;
		this.couleur = couleur;
		this.categ = categ;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public int getCateg() {
		return categ;
	}
	public void setCateg(int categ) {
		this.categ = categ;
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + ", model=" + model + ", couleur=" + couleur + ""
				+ ", categ=" + categ + "]";
	}
	
	
	
}
