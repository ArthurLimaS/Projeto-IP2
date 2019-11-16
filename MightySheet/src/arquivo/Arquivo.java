package arquivo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import negocio.beans.Habilidade;


public class Arquivo {
	
	
	public static void lerArquivo(String Arquivo) {
	try {
	File arquivo = new File(Arquivo);
	Scanner sc = new Scanner(arquivo);
	while(sc.hasNext())
	{
		System.out.println(sc.nextLine());
	}
	sc.close();
	
	} catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	}
	
	public static ArrayList<Habilidade> listarHabilidade(String Arquivo)
	{
		ArrayList<Habilidade> lista = new ArrayList<>();
		try {
			
			File arquivo = new File(Arquivo);
			Scanner sc = new Scanner(arquivo);
			while(sc.hasNext()) {
			//System.out.println(sc.nextLine());
			String hb = sc.nextLine();
			//System.out.println(hb);
			String[] tipos = hb.split("/");
			int mana = Integer.parseInt(tipos[4]);
			int dificuldade = Integer.parseInt(tipos[5]);
			Habilidade habilidade = new Habilidade(tipos[0],tipos[1],tipos[2], tipos[3],mana,dificuldade,tipos[6]);
			lista.add(habilidade);
			
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		return lista;
	}
	
	public static void main(String[] args) {
		ArrayList<Habilidade> lista = listarHabilidade("Habilidades1.txt");
		for(int i=0;i<lista.size();i++)
		{
			System.out.println(lista.get(i).getNome());
		}
		
		
	}

}
