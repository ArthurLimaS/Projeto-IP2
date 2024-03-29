package dados.repositorios;

import negocio.beans.Classe;

import dados.interfaces.IRepoClasses;
import dados.interfaces.IRepoHabilidades;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.IOException;

public class RepositorioClasses implements IRepoClasses {
	
	/// Singleton
	private static IRepoClasses INSTANCE;
	
	
	/// Atributos
	private final Map<String, Classe> classesPreExistentes;
	private Map<String, Classe> classesCriadas;
	
	
	/// Construtor
	private RepositorioClasses()
	{
		classesPreExistentes = gerarClassesPreExistentes();
		classesCriadas = carregarClasses();
	}
	
	
	/// Metodos
	public String toString()
	{
		String str = "";
		
		for(Classe cls : classesPreExistentes.values())
		{
			str += cls.toString();
			str += "\n";
		}
		
		for(Classe cls : classesCriadas.values())
		{
			str += cls.toString();
			str += "\n";
		}
		
		return str;
	}
	
	public static IRepoClasses getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new RepositorioClasses();
		}
		
		return INSTANCE;
	}
	
	private Map<String, Classe> gerarClassesPreExistentes()
	{
		IRepoHabilidades repHab = RepositorioHabilidades.getInstance();
		
		Map<String, Classe> ret = new HashMap<String, Classe>();
		
		ret.put("Guerreiro", new Classe("Guerreiro", 1, 1, 0, 0, repHab.buscarHabilidade("Mestre de Armas 1"),
								repHab.listarHabilidadePorClasse("Guerreiro")));
		ret.put("Feiticeiro", new Classe("Feiticeiro", 0, 0, 1, 1, repHab.buscarHabilidade("Conhecimento Arcano"),
								repHab.listarHabilidadePorClasse("Feiticeiro")));
		ret.put("Ladino", new Classe("Ladino", 0, 1, 1, 0, repHab.buscarHabilidade("Gatuno"),
								repHab.listarHabilidadePorClasse("Ladino")));
		
		// Criar outras 2 classes b�sicas;
		
		return ret;
	}
	
	@Override
	public boolean adicionarClasse(Classe classe)
	{
		boolean ret = false;
		
		if(!classesPreExistentes.containsKey(classe.getNome()) &&
				!classesCriadas.containsKey(classe.getNome()))
		{
			classesCriadas.put(classe.getNome(), classe);
			ret = true;
		}	
		
		return ret;
	}
	
	@Override
	public boolean removerClasse(String nome)
	{
		boolean ret = false;
		
		if(classesCriadas.containsKey(nome))
		{
			classesCriadas.remove(nome);
			ret = true;
		}
		
		return ret;
	}
	
	@Override
	public Classe buscarClasse(String nome)
	{
		Classe ret = null;
		
		if(classesPreExistentes.containsKey(nome))
		{
			ret = classesPreExistentes.get(nome);
		}
		
		if(classesCriadas.containsKey(nome))
		{
			ret = classesCriadas.get(nome);
		}
		
		return ret;
	}
	
	@Override
	public boolean modificarClasse(Classe classe)
	{
		boolean ret = false;
		
		if(classesCriadas.containsKey(classe.getNome()))
		{
			classesCriadas.replace(classe.getNome(), classe);
			ret = true;
		}
			
		return ret;
	}
	
	@Override
	public List<Classe> listarTodasClasses()
	{
		List<Classe> ret = new ArrayList<Classe>();
		
		ret.addAll(classesPreExistentes.values());
		ret.addAll(classesCriadas.values());
		
		return ret;
	}
	
	private Map<String, Classe> carregarClasses()
	{
		File f = new File("Classes.rep");
		
		Map<String, Classe> ret = null;
		
		try
		{
			if(!f.exists())
			{
				f.createNewFile();
				ret = new HashMap<String, Classe>();
				return ret;
			}
			
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);

			try
			{
				if((ret = (Map<String, Classe>)ois.readObject()) == null)
				{
					ret = new HashMap<String, Classe>();
				}
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			ois.close();
		}
		catch(IOException e)
		{
			ret = new HashMap<String, Classe>();
		}
		
		return ret;
	}
	
	public boolean salvarClasses()
	{
		boolean ret = false;
		
		File f = new File("Classes.rep");
		
		try
		{
			if(!f.exists())
			{
				f.createNewFile();
			}
			
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			try
			{
				oos.writeObject(this.classesCriadas);
				ret = true;
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
			oos.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		return ret;
	}
}
