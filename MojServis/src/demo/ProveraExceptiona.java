package demo;

import java.util.InputMismatchException;
import java.util.Scanner;

import racunar.TipKucista;
import serviser.Status;

public class ProveraExceptiona {

	//ILLEGAL ARGUMENT EXCEPTION
	public static Status proveraEnumaStatus (String tekts1) {
	
		Status s = Status.PRIJEM;
		Scanner unos2 = new Scanner(System.in);
		boolean uslov2 = true;
		
		do {
			try {
				System.out.println(tekts1);   
				String status = unos2.nextLine().toUpperCase();  
				s = Status.valueOf(status);
				uslov2 = false;
		
				
			}catch (IllegalArgumentException e) {
				System.err.println("Status koji ste uneli ne postoji!");
				uslov2 = true;
				
			}
			
		}while (uslov2 == true);
		
		return s;
	}
	
	
	////ILLEGAL ARGUMENT EXCEPTION 
	public static TipKucista proveraEnumaTipKuciste (String tekst2) {
		
		TipKucista tk = TipKucista.ATX;
		Scanner unos3 = new Scanner(System.in);
		boolean uslov3 = false;
		
		do {
			
			try {
				System.out.println(tekst2);
				String s = unos3.nextLine().toUpperCase();
				tk = TipKucista.valueOf(s);
				uslov3 = false;
				
			}catch(IllegalArgumentException e) {
				System.err.println("Pogresan unos! Pokusajte ponovo: ");
				uslov3 = true;
			}
			
		}while (uslov3 == true);
		
		
		return tk;
	}
	
	
	//INPUT MISMATCH EXCEPTION	
	public static Integer proveraBroja (String tekst) {
		
		Integer broj = 0;
		Scanner unos = new Scanner(System.in);
		
		boolean uslov = true;
		
		do {
			try {
				System.out.println(tekst);
				broj = unos.nextInt();
				uslov = true;
				
			}catch(InputMismatchException e) {
				System.err.println("Pogresan unos! Pokusajte ponovo.");
				uslov = false;
				unos.next();  //*
				
			}
			
		}while(uslov == false);
		
		return broj;
	}
	
	
	//INPUT MISMATCH EXCEPTION	
	public static Long proveraBrojaLongZaCenuS (String s) {
		
		Long br = 0L;
		Scanner ulaz = new Scanner(System.in);
		boolean b = true;
		
		do {
			try {
				System.out.println(s);
				br = ulaz.nextLong();
				b = true;
			}catch(InputMismatchException e) {
				System.err.println("Pogresan unos! Pokusajte ponovo.");
				b = false;
			}
			
		}while(b == false);
		
		return br;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
