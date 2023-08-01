package controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.Persona;

public class Main {
	
	public static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, ParseException, SQLException {
		
		ArrayList<Persona>lista=new ArrayList<>();
		
		System.out.println("Quieres añadir algun usuario? Y/N");
		char resp=sc.nextLine().charAt(0);
		if(resp=='Y' || resp=='y') {
			
			System.out.println("Dime tu DNI usuario:");
			String dni=sc.nextLine();
			System.out.println("Dime tu nombre");
			String nombre =sc.nextLine();
			System.out.println("En que año naciste?");
			int anio=sc.nextInt();
			System.out.println("En que mes?");
			int mes=sc.nextInt();
			System.out.println("En que dia?");
			int dia=sc.nextInt();
			sc.nextLine();
			LocalDate fecha = LocalDate.of(anio, mes, dia);
			Date fechaDate=java.sql.Date.valueOf(fecha);
			System.out.println("Cual es tu direccion?");
			String direccion=sc.nextLine();
			System.out.println("Cual es tu numero de telefono");
			int tel=sc.nextInt();
			sc.nextLine();
			
			lista.add(new Persona(dni,nombre,fechaDate,direccion,tel));
			
			for(Persona p:lista) {
				p.insertar();
			}
		
		}
		
		System.out.println("Quieres mostrar la lista de personas? Y/N");
		char res=sc.nextLine().charAt(0);
		if(res=='Y' || res=='y') {
			lista=Persona.obtener();
			for(Persona p:lista) {
				System.out.println(p.toString());
				Persona.sumIndex();
			}
		}
		
		System.out.println("Quieres modificar algun nombre? Y/N");
		char res1=sc.nextLine().charAt(0);
		if(res1=='Y' || res1=='y') {
			System.out.println("Usuario dime el indice de la persona a modificar");
			int index=sc.nextInt();
			sc.nextLine();
			Persona.actualizarNombre(lista.get(index));
		}
		
		System.out.println("Quieres eliminar algun registro? Y/N");
		char res2=sc.nextLine().charAt(0);
		if(res2=='Y' || res2=='y') {
			Persona.eliminar();
		}
		
		
	}

}
