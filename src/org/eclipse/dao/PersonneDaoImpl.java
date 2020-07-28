package org.eclipse.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.model.Personne;


public class PersonneDaoImpl implements Dao<Personne> {
	
	@Override
	public int save(Personne personne) {
		// TODO Auto-generated method stub
		Connection c = MyConnection.getConnection();
		if (c !=null){
			try {
				PreparedStatement ps = c.prepareStatement("insert into personne (nom,prenom,photo,role,quality) values(?,?,?,?,?); ",
										PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1,personne.getNom());
				ps.setString(2,personne.getPrenom());
				ps.setString(3,personne.getPhoto());
				ps.setString(4,personne.getRole());
				ps.setString(5,personne.getQuality());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()){
					return resultat.getInt(1);
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return -1;
	}

	@Override
	public void remove(Personne personne) {
		// TODO Auto-generated method stub
		Connection c = MyConnection.getConnection();
		if(c!=null){
			try{
				PreparedStatement ps = c.prepareStatement("delete from personne where num = ?;");
				ps.setInt(1, personne.getId());
				ps.executeUpdate();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void removeById(int id) {
		// TODO Auto-generated method stub
		Connection c = MyConnection.getConnection();
		if(c!=null){
			try{
				PreparedStatement ps = c.prepareStatement("delete from personne where num = ?;");
				ps.setInt(1, id);
				ps.executeUpdate();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Personne personne) {
		// TODO Auto-generated method stub
		Connection c = MyConnection.getConnection();
		if(c!=null){
			try{
				PreparedStatement ps = c.prepareStatement("update personne set nom=?, prenom=?,photo=?,role=?,quality=? * where id = ?;");
				ps.setString(1, personne.getNom());
				ps.setString(2, personne.getPrenom());
				ps.setString(3, personne.getRole());
				ps.setString(4, personne.getQuality());
				ps.setInt(5, personne.getId());
				ps.executeUpdate();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Personne findById(int id) {
		// TODO Auto-generated method stub
		Connection c = MyConnection.getConnection();
		if(c !=null){
			try {
				PreparedStatement ps=  c.prepareStatement("select * from personne where num = ?;");
				ps.setInt(1,  id);;
				ResultSet r=ps.executeQuery();
				r.next();
				Personne p = new Personne(r.getInt("num"),r.getString("nom"),r.getString("prenom"),r.getString("photo"),r.getString("role"),r.getString("quality"));
				return p;
			}catch (SQLException e){
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public List<Personne> getAll() {
		// TODO Auto-generated method stub
		Connection c = MyConnection.getConnection();
		if(c !=null){
			try {
				PreparedStatement ps=  c.prepareStatement("select * from personne;");
				ResultSet r=ps.executeQuery();
				List<Personne> lesPersonnes = new ArrayList<Personne>();
				while(r.next()){
					lesPersonnes.add(new Personne(r.getInt("num"),r.getString("nom"),r.getString("prenom"),r.getString("photo"),r.getString("role"),r.getString("quality")));
				};
				return lesPersonnes;
			}catch (SQLException e){
				e.printStackTrace();
				return null;
			}
		}
		return null;
		
	}
}
