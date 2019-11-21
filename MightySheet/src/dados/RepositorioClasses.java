package dados;

import negocio.beans.Classe;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class RepositorioClasses {
	
	/// Singleton
	private static RepositorioClasses INSTANCE;
	
	
	/// Atributos
	private final Map<String, Classe> classesPreExistentes;
	private Map<String, Classe> classesCriadas;
	
	
	/// Construtor
	private RepositorioClasses()
	{
		classesPreExistentes = gerarClassesPreExistentes();
		classesCriadas = new HashMap<String, Classe>();
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
	
	public static RepositorioClasses getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new RepositorioClasses();
		}
		
		return INSTANCE;
	}
	
	private Map<String, Classe> gerarClassesPreExistentes()
	{
		RepositorioHabilidades repHab = RepositorioHabilidades.getInstance();
		
		Map<String, Classe> ret = new HashMap<String, Classe>();
		
		ret.put("Guerreiro", new Classe("Guerreiro", 1, 1, 0, 0, repHab.buscarHabilidade("Mestre de Armas 1"),
								repHab.listarHabilidadePorClasse("Guerreiro")));
		ret.put("Feiticeiro", new Classe("Feiticeiro", 0, 0, 1, 1, repHab.buscarHabilidade("Conhecimento Arcano"),
								repHab.listarHabilidadePorClasse("Feiticeiro")));
		
		// Criar outras 2 classes b�sicas;
		
		return ret;
	}
	
	public boolean adicionarClasse(Classe classe)
	{
		boolean ret = false;
		
		if(classe != null)
		{
			if(!classesPreExistentes.containsKey(classe.getNome()) &&
					!classesCriadas.containsKey(classe.getNome()))
			{
				classesCriadas.put(classe.getNome(), classe);
				ret = true;
			}	
		}
		
		return ret;
	}
	
	public boolean removerClasse(String nome)
	{
		boolean ret = false;
		
		if(nome != null)
		{
			if(classesCriadas.containsKey(nome))
			{
				classesCriadas.remove(nome);
				ret = true;
			}
		}
		
		return ret;
	}
	
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
	
	public boolean modificarClasse(Classe classe)
	{
		boolean ret = false;
		
		if(classe != null)
		{
			if(classesCriadas.containsKey(classe.getNome()))
			{
				classesCriadas.replace(classe.getNome(), classe);
				ret = true;
			}
		}
		
		return ret;
	}
	
	public List<Classe> listarTodasClasses()
	{
		List<Classe> ret = new ArrayList<Classe>();
		
		ret.addAll(classesPreExistentes.values());
		ret.addAll(classesCriadas.values());
		
		return ret;
	}
}