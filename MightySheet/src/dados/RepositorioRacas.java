package dados;

import negocio.beans.Raca;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepositorioRacas {
	
	/// Singleton
	private static RepositorioRacas INSTANCE;
	
	
	/// Atributos
	private final Map<String, Raca> racasPreExistentes;
	private Map<String, Raca> racasCriadas;
	
	
	/// Construtor
	private RepositorioRacas()
	{
		racasPreExistentes = gerarRacasPreExistentes();
		racasCriadas = new HashMap<String, Raca>();
	}
	
	
	/// Metodos
	public String toString()
	{
		String str = "";
		
		for(Raca rc : racasPreExistentes.values())
		{
			str += rc.toString();
			str += "\n";
		}
		
		for(Raca rc : racasCriadas.values())
		{
			str += rc.toString();
			str += "\n";
		}
		
		return str;
	}
	
	public static RepositorioRacas getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new RepositorioRacas();
		}
		
		return INSTANCE;
	}
	
	private Map<String, Raca> gerarRacasPreExistentes()
	{
		RepositorioHabilidades repHab = RepositorioHabilidades.getInstance();
		
		Map<String, Raca> ret = new HashMap<String, Raca>();
		
		ret.put("An�o", new Raca("An�o", 4, 2, 3, 3, repHab.buscarHabilidade("Cora��o da Montanha"),
							repHab.listarHabilidadesPorRaca("An�o")));
		ret.put("Elfo", new Raca("Elfo", 2, 4, 3, 3, repHab.buscarHabilidade("Ben��o de Lathellanis"),
							repHab.listarHabilidadesPorRaca("Elfo")));
		ret.put("Humano", new Raca("Humano", 3, 3, 3, 3, repHab.buscarHabilidade("Adaptabilidade"),
								repHab.listarHabilidadesPorRaca("Humano")));
		ret.put("Metad�lio", new Raca("Metad�lio", 2, 4, 3, 3, repHab.buscarHabilidade("Tamanho Pequeno"),
								repHab.listarHabilidadesPorRaca("Metad�lio")));
		
		return ret;
	}
	
	public boolean adicionarRaca(Raca raca)
	{
		boolean ret = false;
		
		if(raca != null)
		{
			if(!racasPreExistentes.containsKey(raca.getNome()) &&
					!racasCriadas.containsKey(raca.getNome()))
			{
				racasCriadas.put(raca.getNome(), raca);
				ret = true;
			}
		}
		
		return ret;
	}
	
	public boolean removerRaca(String nome)
	{
		boolean ret = false;
		
		if(nome != null)
		{
			if(racasCriadas.containsKey(nome))
			{
				racasCriadas.remove(nome);
				ret = true;
			}
		}
		
		return ret;
	}
	
	public Raca buscarRaca(String nome)
	{
		Raca ret = null;
		
		if(racasPreExistentes.containsKey(nome))
		{
			ret = racasPreExistentes.get(nome);
		}
		
		if(racasCriadas.containsKey(nome))
		{
			ret = racasCriadas.get(nome);
		}
		
		return ret;
	}
	
	public boolean modificarRaca(Raca raca)
	{
		boolean ret = false;
		
		if(raca != null)
		{
			if(racasCriadas.containsKey(raca.getNome()))
			{
				racasCriadas.replace(raca.getNome(), raca);
				ret = true;
			}
		}
		
		return ret;
	}
	
	public List<Raca> listarTodasRacas()
	{
		List<Raca> ret = new ArrayList<Raca>();
		
		ret.addAll(racasPreExistentes.values());
		ret.addAll(racasCriadas.values());
		
		return ret;
	}
}
