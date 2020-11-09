package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Genero;

public class GeneroDAO {
	private DataSource datasource;
	private String tabela;
	
	public GeneroDAO(DataSource datasource){
		this.datasource = datasource;
		this.tabela = "genero";
	}
	
	
	public Genero busca(int id){
		try {
			String SQL = "SELECT * FROM " + tabela + " WHERE id = '" + id + "'";
			java.sql.PreparedStatement ps = datasource.getConnection().prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			Genero genero = new Genero();
			while(rs.next()) {
				genero.setId(rs.getInt("id"));
				genero.setNome(rs.getString("nome"));
			}
			
			ps.close();
			return genero;
			
		} catch(SQLException ex) {
			System.err.println("Erro ao Recuperar genero " + ex.getMessage());
		} catch(Exception ex) {
			System.err.println("Erro Geral " + ex.getMessage());
		}
		return null;
	}
	
	
	public ArrayList<Genero> readAll(){
		try {
			String SQL = "SELECT * FROM " + tabela + " ORDER BY nome";
			java.sql.PreparedStatement ps = datasource.getConnection().prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Genero> lista = new ArrayList<Genero>();
			
			while(rs.next()) {
				Genero gen = new Genero();
				gen.setId(rs.getInt("id"));
				gen.setNome(rs.getString("nome"));
		
				lista.add(gen);
			}
			ps.close();
			return lista;
			
		} catch(SQLException ex) {
			System.err.println("Erro ao Recuperar " + ex.getMessage());
		} catch(Exception ex) {
			System.err.println("Erro Geral " + ex.getMessage());
		}
		return null;
	}
	
	public void inserir(Genero genero) {
		try {
			
			String SQL = "INSERT INTO " + tabela + " (nome) VALUES ('" + genero.getNome() + "');";
			java.sql.PreparedStatement ps = datasource.getConnection().prepareStatement(SQL);
			ps.executeUpdate(SQL);						// Usado para fazer qualquer alteração. Não tem nenhum retorno
			ps.close();
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void editar(Genero genero) {
		try {
			
			String SQL = "UPDATE " + tabela + " SET nome = '" + genero.getNome() + "' WHERE id = " + genero.getId() + ";" ;			// id é int, não colocar aspassimples
			java.sql.PreparedStatement ps = datasource.getConnection().prepareStatement(SQL);
			ps.executeUpdate(SQL);
			ps.close();
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void apagar(Genero genero) {
		try {
			
			String SQL = "DELETE FROM " + tabela + " WHERE id = " + genero.getId() + ";" ;			// id é int, não colocar aspassimples
			java.sql.PreparedStatement ps = datasource.getConnection().prepareStatement(SQL);
			ps.executeUpdate(SQL);												// Usado para fazer qualquer alteração. Não tem nenhum retorno
			ps.close();
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
