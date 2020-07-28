package org.eclipse.model;
public class Personne {
	private int id;
	private String nom;
	private String prenom;
	private String photo;
	private String role;
	private String quality;
	
	public Personne(int id, String nom, String prenom, String photo, String role, String quality){
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
		this.role = role;
		this.quality = quality;
	}
	
	public Personne( String nom, String prenom, String photo, String role, String quality){
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
		this.role = role;
		this.quality = quality;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public String getPrenom(){
		return this.prenom;
	}
	
	public String getPhoto(){
		return this.photo;
	}
	
	public String getRole(){
		return this.role;
	}
	
	public String getQuality(){
		return this.quality;
	}
	
	public void setNom(String nom){
		this.nom=nom;
	}
	
	public void setPrenom(String prenom){
		this.prenom=prenom;
	}
	
	public void setRole(String role){
		this.role=role;
	}
	
	public void setQuality(String quality){
		this.quality=quality;
	}
	
}
