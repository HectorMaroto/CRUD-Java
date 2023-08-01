package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import model.Persona;

public class DaoPersonas {
	
	private ArrayList<Persona>list;
	private Connection conn;
	private static DaoPersonas instance=null;
	private static Scanner sc = new Scanner(System.in);
	
	public DaoPersonas() throws SQLException, ClassNotFoundException {
		conn=ConnDB.getConn();
		list=new ArrayList<>();
	}
	
	public static DaoPersonas getInstance() throws SQLException, ClassNotFoundException {
		if(instance==null) {
			instance=new DaoPersonas();
		}
		return instance;
	}
	
	public void insertarDao(Persona p) throws SQLException {
		String query = "INSERT INTO personas (dni,nombre,fecnac,dir,tfno) VALUES (?,?,?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, p.getDni());
		ps.setString(2, p.getNombre());
		ps.setDate(3, (Date) p.getFecnac());
		ps.setString(4, p.getDir());
		ps.setInt(5, p.getTfno());
		
		ps.executeUpdate();
		ps.close();
	}
	
	public ArrayList<Persona> obtener() throws SQLException {
		String query = "SELECT * FROM personas";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			list.add(new Persona(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getString(4),rs.getInt(5)));
		}
		
		ps.close();
		
		return list;
	}
	
	public void updateNombre(Persona p) {
		
			System.out.println("Dime el nuevo nombre:");
			String nombre=sc.nextLine();
			p.setNombre(nombre);
			
			String consultaSQL="update personas set nombre=? where dni=?";
		    try{ 
		            PreparedStatement ps=conn.prepareStatement(consultaSQL);
		            ps.setString(1, p.getNombre());
		            ps.setString(2, p.getDni()); 
		            ps.executeUpdate();
		            ps.close();
		    }
		    catch (SQLException ex) {            
		            System.out.println("error " + ex);            
		    }
		}
	
	public void delete() throws SQLException {
		String query = "DELETE FROM personas where dni=?";
		
		System.out.println("Que persona quieres eliminar de la Base? Dime su dni");
		String dni=sc.nextLine();
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, dni);
		ps.executeUpdate();
		ps.close();
	}

}
