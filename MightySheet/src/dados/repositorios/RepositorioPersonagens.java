package dados.repositorios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import negocio.beans.Classe;
import negocio.beans.Raca;
import negocio.beans.Personagem;
import negocio.beans.Habilidade;
import negocio.beans.Arma;
import negocio.beans.Equipamento;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import dados.interfaces.IRepoPersonagens;

public class RepositorioPersonagens implements IRepoPersonagens {
	
	///Singleton
	private static IRepoPersonagens INSTANCE;
	
	
	///Atributos
	private List<Personagem> fichas;
	
	///Contrutor
	private RepositorioPersonagens()
	{
		if(carregarPersonagens() == null) {
			fichas = new ArrayList<>();
		}
		else {
		fichas = carregarPersonagens();
		}
	}

	
	///Metodos
	public static IRepoPersonagens getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new RepositorioPersonagens();
		}
		return INSTANCE;
	}
	

	@Override
	public List<Personagem> todas()
	{
		 List<Personagem> saida = new ArrayList<Personagem>();
		 try {
		 saida.addAll(fichas);
		 }catch (Exception e)
		 {
			 e.printStackTrace();
		 }
		 return saida;
	}
	
	
	
	@Override
	public void AdicionarFicha(Personagem novo)
	{
		this.fichas.add(novo);
	}
	
	@Override
	public void removerFicha(Personagem remover)
	{
		this.fichas.remove(remover);	
	}
	
	@Override
	public List<Personagem> listarPorClasse(Classe classe)
	{
		String buscado = classe.getNome();
		List<Personagem> saida = new ArrayList<Personagem>();
		for(Personagem p: this.fichas)
		{
			if(p.getClasse().getNome().equals(buscado))
			{
				
				saida.add(p);
			}
		}
		return saida;
	}
	
	
	@Override
	public List<Personagem> listarPorRaca(Raca raca)
	{
		List<Personagem> saida = new ArrayList<Personagem>();
		for(Personagem p: this.fichas)
		{
			if(p.getRaca().getNome().equals(raca.getNome()))
			{
				saida.add(p);
			}
		}
		return saida;
	}
	
	
	@Override
	public List<Personagem> listarPorJogador(String nome)
	{
		List<Personagem> saida = new ArrayList<Personagem>();
		for(Personagem p: this.fichas)
		{
			if(p.getNomeJogador().equals(nome))
			{
				saida.add(p);
			}
		}
		return saida;
	}
	
	@Override
	public Personagem buscaPorPers(String nome)
	{
		Personagem saida;
		for(Personagem p: this.fichas)
		{
			if(p.getNomePersonagem().equals(nome))
			{
				saida = p;
				return saida;
			}
		}
		return null;
	}
	
	@Override
	public void editarFicha(String nomePer, int nivel, int experiencia, int inteligencia, 
			int forca, int vontade, int vida, int mana, HashMap<String, Integer> pericias, 
			Habilidade[] habilidadesAutomaticas,ArrayList<Habilidade> habilidades,  int quantHabilidades,
			ArrayList<Arma> ataques, ArrayList<Equipamento> equipamentos, int ouro)
	{
		Personagem editado = this.buscaPorPers(nomePer);
		this.removerFicha(editado);
		editado.setNivel(nivel);
		editado.setExperiencia(experiencia);
		editado.setInteligencia(inteligencia);
		editado.setForca(forca);
		editado.setVontade(vontade);
		editado.setVida(vida);
		editado.setMana(mana);
		editado.setPericias(pericias);
		editado.setHabilidadesAutomaticas(habilidadesAutomaticas);
		editado.setHabilidades(habilidades);
		editado.setQuantHabilidades();
		//editado.setAtaques(ataques);
		editado.setEquipamentos(equipamentos);
		editado.setOuro(ouro);
		
		this.AdicionarFicha(editado);
	}
	

	
	
	/// Metodos de Arquivo
	private List<Personagem> carregarPersonagens() {
		List<Personagem> ret = null;
		try {
			File f = new File("Personagem.rep");
			
			if(!f.exists())
			{
				f.createNewFile();
				ret = new ArrayList<Personagem>();
			}
			
			FileInputStream fis = new FileInputStream("Personagem.rep");
			ObjectInputStream ois = new ObjectInputStream(fis);

			// Le um objeto do arquivo
			ret = (List<Personagem>)ois.readObject();

			ois.close();
			fis.close();
			
			
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			
		}
		
		return ret;
	}
	
	@Override
	public boolean guardar()
	{
		try {
			FileOutputStream fos = new FileOutputStream("Personagem.rep");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// Escreve o objeto no arquivo
			oos.writeObject(this.fichas);
			//oos.flush();

			oos.close();
			fos.close();
			
			return true;
		} catch(IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	

}
