package negocio.beans;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.io.Serializable;

public class Classe implements Serializable{
	
	/// Atributos
	private String nome;
	private int bonusForca;
	private int bonusAgilidade;
	private int bonusInteligencia;
	private int bonusVontade;
	private Habilidade habilidadeAutomatica;
	private Map<String, Habilidade> habilidades;
  
	
	/// Construtor
	public Classe(String nome, int bonusForca, int bonusAgilidade, int bonusInteligencia, int bonusVontade,
			 Habilidade habilidadeAutomatica, List<Habilidade> habilidades) {
		this.nome = nome;
		this.bonusForca = bonusForca;
		this.bonusAgilidade = bonusAgilidade;
		this.bonusInteligencia = bonusInteligencia;
		this.bonusVontade = bonusVontade;
		this.habilidadeAutomatica = habilidadeAutomatica;
		this.habilidades = new HashMap<String, Habilidade>();
		
		for(Habilidade hab : habilidades)
		{
			this.habilidades.put(hab.getNome(), hab);
		}
	}
	
	
	/// Metodos
	public boolean equals(Classe another)
	{
		boolean ret = false;
		
		if(this.getNome().equals(another.getNome()))
		{
			ret = true;
		}
		
		return ret;
	}
	
	public String toString()
	{
		return this.nome;
	}
	
	public String descricaoCompleta()
	{
		String str = String.format("%s\n"
			+ "Bônus de Atributo:\n", this.nome);
	
		if(this.bonusForca != 0)
		{
			str += String.format("Força +%d\n", this.bonusForca);
		}
		if(this.bonusAgilidade != 0)
		{
			str += String.format("Agilidade +%d\n", this.bonusAgilidade);
		}
		if(this.bonusInteligencia != 0)
		{
			str += String.format("Inteligencia +%d\n", this.bonusInteligencia);
		}
		if(this.bonusVontade != 0)
		{
			str += String.format("Vontade +%d\n", this.bonusVontade);
		}
			
		str += String.format("Habilidade Automática:\n%s", this.habilidadeAutomatica);
			
		return str;
	}
	
	/// Getters
	public String getNome() {
		return nome;
	}
	public int getBonusForca() {
		return bonusForca;
	}
	public int getBonusAgilidade() {
		return bonusAgilidade;
	}
	public int getBonusInteligencia() {
		return bonusInteligencia;
	}
	public int getBonusVontade() {
		return bonusVontade;
	}
	public Habilidade getHabilidadeAutomatica() {
		return habilidadeAutomatica;
	}
	public Map<String, Habilidade> getHabilidades() {
		return habilidades;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setBonusForca(int bonusForca) {
		this.bonusForca = bonusForca;
	}
	public void setBonusAgilidade(int  bonusAgilidade) {
		this.bonusAgilidade = bonusAgilidade;
	}
	public void setBonusInteligencia(int bonusInteligencia) {
		this.bonusInteligencia = bonusInteligencia;
	}
	public void setBonusVontade(int bonusVontade) {
		this.bonusVontade = bonusVontade;
	}
	public void setHabilidadeAutomatica(Habilidade habilidade) {
		this.habilidadeAutomatica = habilidade;
	}
	public void setHabilidades(Map<String,Habilidade> habilidades) {
		this.habilidades = habilidades;
	}
	
}
