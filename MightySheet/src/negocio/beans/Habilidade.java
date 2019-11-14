package negocio.beans;

import java.util.HashMap;

public class Habilidade {
	
	/// Atributos
	private String nome;
	private String tipo;
	private String categoria;
	private String requisito;
	private int mana;
	private int dificuldade;
	private String descricao;
	
	
	/// Construtores
	public Habilidade(String nome, String tipo, String categoria, String requisito,
					int mana, int dificuldade, String descricao)
	{
		this.nome = nome;
		this.tipo = tipo;
		this.categoria = categoria;
		this.requisito = requisito;
		this.mana = mana;
		this.dificuldade = dificuldade;
		this.descricao = descricao;
	}
	
	
	/// M�todos
	public String toString()
	{
		String str = String.format("%s\n"
								   + "Habilidade ",
								   this.nome);
		
		if(categoria != null)
		{
			str += String.format("(%s) ", this.categoria);
		}

		str += String.format("- %s\n", this.tipo);
		
		if(requisito != null)
		{
			str += String.format("Requisito: %s\n", this.requisito);
		}
		
		if(mana >= 0)
		{
			if(mana == 0)
			{
				str += "Mana: Varia\n";
			}
			else
			{
				str += String.format("Mana: %d\n", this.mana);	
			}
		}
		
		if(dificuldade >= 0)
		{
			str += String.format("Dificuldade da Magia: %d\n", this.dificuldade);
		}
		
		str += String.format("Descricao: %s", this.descricao);
		
		return str;
	}
	
	public static HashMap<String, Habilidade> habilidadesExtrasHumano()
	{
		HashMap<String, Habilidade> ret = new HashMap<String, Habilidade>();
		
		ret.put(ASSUNTOS_DIVERSOS.getNome(), ASSUNTOS_DIVERSOS);
		ret.put(AUDACIA.getNome(), AUDACIA);
		ret.put(BARGANHA.getNome(), BARGANHA);
		ret.put(DIVERSIDADE.getNome(), DIVERSIDADE);
		ret.put(O_DOBRO_OU_NADA.getNome(), O_DOBRO_OU_NADA);
		ret.put(GREGARIO.getNome(), GREGARIO);
		ret.put(SORTE.getNome(), SORTE);
		
		return ret;
	}
	
	public static HashMap<String, Habilidade> habilidadesBasicasGuerreiro()
	{
		HashMap<String, Habilidade> ret = new HashMap<String, Habilidade>();
		
		ret.put(ANULAR_GOLPE.getNome(), ANULAR_GOLPE);
		ret.put(ATAQUE_DO_BUFALO.getNome(), ATAQUE_DO_BUFALO);
		ret.put(ATAQUE_GIRATORIO.getNome(), ATAQUE_GIRATORIO);
		ret.put(ATAQUE_SIMULTANEO.getNome(), ATAQUE_SIMULTANEO);
		ret.put(BRIGAO.getNome(), BRIGAO);
		ret.put(COMBATE_EM_GRUPO.getNome(), COMBATE_EM_GRUPO);
		ret.put(COMBATE_COM_DUAS_ARMAS_1.getNome(), COMBATE_COM_DUAS_ARMAS_1);
		ret.put(COMBATE_PESADO.getNome(), COMBATE_PESADO);
		
		ret.put(COMBATE_TATICO.getNome(), COMBATE_TATICO);
		ret.put(DEFESA_AGRESSIVA.getNome(), DEFESA_AGRESSIVA);
		ret.put(DEFLETOR.getNome(), DEFLETOR);
		ret.put(ESTABILIDADE.getNome(), ESTABILIDADE);
		ret.put(GOLPE_DEVASTADOR_1.getNome(), GOLPE_DEVASTADOR_1);
		ret.put(GOLPE_COM_ESCUDO.getNome(), GOLPE_COM_ESCUDO);
		ret.put(GRITO_DE_GUERRA_1.getNome(), GRITO_DE_GUERRA_1);
		ret.put(GUERREIRO_DE_A�O_1.getNome(), GUERREIRO_DE_A�O_1);
		ret.put(INVESTIDA_MORTAL.getNome(), INVESTIDA_MORTAL);

		ret.put(NOCAUTEAR.getNome(), NOCAUTEAR);
		ret.put(PAREDE_DE_ESCUDOS.getNome(), PAREDE_DE_ESCUDOS);
		ret.put(SEM_ESCAPATORIA.getNome(), SEM_ESCAPATORIA);
		ret.put(TRANSPOR.getNome(), TRANSPOR);
		
		return ret;
	}
	
	public static HashMap<String, Habilidade> habilidadesAvancadasGuerreiro()
	{
		HashMap<String, Habilidade> ret = new HashMap<String, Habilidade>();
		
		ret.put(COMBATE_COM_DUAS_ARMAS_2.getNome(), COMBATE_COM_DUAS_ARMAS_2);
		ret.put(FORCA_DE_EXPLOSAO.getNome(), FORCA_DE_EXPLOSAO);
		ret.put(GOLPE_DEVASTADOR_2.getNome(), GOLPE_DEVASTADOR_2);
		ret.put(GRITO_DE_GUERRA_2.getNome(), GRITO_DE_GUERRA_2);

		ret.put(GRITO_DE_INTIMIDACAO.getNome(), GRITO_DE_INTIMIDACAO);
		ret.put(GUERREIRO_DE_ACO_2.getNome(), GUERREIRO_DE_ACO_2);
		ret.put(IMPLACAVEL.getNome(), IMPLACAVEL);
		ret.put(INVESTIDA_FORTE.getNome(), INVESTIDA_FORTE);
		ret.put(MESTRE_DE_ARMAS_2.getNome(), MESTRE_DE_ARMAS_2);
		ret.put(VALOR_DA_VITORIA.getNome(), VALOR_DA_VITORIA);
		
		return ret;
	}
	
	/// Gets e sets
	public String getNome()
	{
		return this.nome;
	}

	
	/// Instancias est�ticas
	/// Ra�as
	// Humano
	// Habilidade Autom�tica
	public final static Habilidade ADAPTABILIDADE = new Habilidade("Adaptabilidade", "Suporte", "Caracter�stica", null, -1, -1,
														"Voc� se adaptou ao ambiente em que cresceu ou � atividade que "
														+ "escolheu - ou precisou - desempenhar. Voc� tem +1 em qualquer "
														+ "um dos seus Atributos a sua escolha.");
	
	// Habilidades Extras
	// Habilidades Extras
	public final static Habilidade ASSUNTOS_DIVERSOS = new Habilidade("Assuntos Diversos", "A��o", "Caracter�stica", null, 30, -1,
														"Voc� estudou e praticou um pouco de tudo ao longo de sua vida. Voc� "
														+ "pode rolar +1d6 em um teste � sua escolha");
	public final static Habilidade AUDACIA = new Habilidade("Aud�cia", "Suporte", "Caracter�stica", null, -1, -1,
														"Voc� enfrenta amea�as e situa��es de perigo com entusiasmo. Sempre que "
														+ "estiver frente � uma situa��o de risco eminente - saltar entre duas "
														+ "bordas de um precip�cio, equilibrar-se em uma corda sobre um rio de "
														+ "lava, entrar em um combate ou qualquer situa�o em que voc� possa "
														+ "potencialmente perder a vida (ou pelo menos se ferir seriamente), "
														+ "voc� recupera imediatamente 10 Pontos de Vida ou 10 Pontos de Mana, � "
														+ "sua escolha.\n"
														+ "\tEssa Habilidade s� pode ser usada uma vez para cada situa��o de risco, "
														+ "e apenas quando o risco se apresentar - n�o depois da sua primeira "
														+ "a��o em um combate ou depois de cair, por exemplo.");
	public final static Habilidade BARGANHA = new Habilidade("Barganha", "Suporte", "Caracter�stica", null, -1, -1,
														"Voc� � um praticante das artes da negoci��o, orat�ria, ret�rica, e "
														+ "sofisma. Voc� pode rolar +1d6 em todos os seus testes que envolvam "
														+ "com�rcio e outras negocia��es.");
	public final static Habilidade DIVERSIDADE = new Habilidade("Diversidade", "Suporte", "Caracter�stica", null, -1, -1,
														"Voc� focou seus esfor�os e interesse em uma ampla gama de atividades. "
														+ "Escolha um Atributo diferente do que escolheu para Adaptabilidade. "
														+ "Voc� tem +1 nesse Atributo.");
	public final static Habilidade O_DOBRO_OU_NADA = new Habilidade("O Dobro ou Nada", "Rea��o", "Caracter�stica", "Sorte",
														20, -1,
														"Voc� est� acostumado � dar chance para sua sorte - �s vezes, al�m do "
														+ "que seria considerado saud�vel. Quando falhar em um teste, voc� pode "
														+ "fazer o teste novamente, ignorando completamente o primeiro resultado. "
														+ "No cso de sucesso, al�m de passar no teste, qualquer efeito num�rico "
														+ "proveniente do sucesso (dano causado por um ataque, dura��o de uma "
														+ "magia, PVs curados com uso de primeiros socorros, etc.) � dobrado. "
														+ "Mas se o teste for uma falha, ela deve ser considerada como uma falha "
														+ "cr�tica, com todos os seus poss�veis efeitos num�ricos dobrados. No "
														+ "caso de uma falha cr�tica nesse teste, o Mestre deve considerar que o "
														+ "fracasso foi uma falha cr�tica particularmente desastrosa - com efeitos "
														+ "limitados apenas pela sua imagina��o s�dica.\n"
														+ "\tVoc� s� pode usar essa Habilidade uma vez por turno.");
	public final static Habilidade GREGARIO = new Habilidade("Greg�rio", "Suporte", "Caracter�stica", null, -1, -1,
														"Voc� consegue compreender muito rapidamente as estruturas sociais de uma "
														+ "cultura e seus indiv�duos e � capaz de fazer amigos em qualquer lugar. "
														+ "Depois de cinco minutos de conversa, a pessoa com quem voc� estaja "
														+ "interagindo - e que n�o seja obviamente hostil a voc�, como um captor "
														+ "ou um inimigo jurado - torna-se propensa a ajud�-lo. Essa Habilidade "
														+ "geralmente serve para colher informa��es gerais (apesar de segredos "
														+ "n�o serem poss�veis de conseguir) ou pequenos favores - como ser "
														+ "apresentado a algu�m ou conseguir uma cerveja de gra�a. Voc� tamb�m "
														+ "recebe +2 em testes de seduzir, mentir, detectar mentiras ou qualquer "
														+ "outra intera��o social.");
	public final static Habilidade SORTE = new Habilidade("Sorte", "Rea��o", "Caracter�stica", null, 10, -1,
														"Voc� est� acostumado a contar com a sorte - e ela costuma lhe sorrir. "
														+ "Voc� pode rolar novamente um dado cujo resultado seja 1. Voc� s� "
														+ "");
	
	
	/// Classes
	// Guerreiro
	
	// Habilidade Autom�tica
	public final static Habilidade MESTRE_DE_ARMAS_1 = new Habilidade("Mestre de Armas 1", "Suporte", "T�cnica", null, -1, -1,
														"Voc� � particulamente eficiente no uso de armas brancas. Sempre que "
														+ "realizar um ataque corporal bem sucedido, adicione 3 ao dano do ataque.");
	// Habilidades B�sicas
	
	// Habilidades B�sicas
	public final static Habilidade ANULAR_GOLPE = new Habilidade("Anular Golpe", "Rea��o", "T�cnica", "Defesa Agressiva", 0, -1,
														"Voc� se especializou em perceber e evitar os ataques mais complexos dos "
														+ "seus advers�rios. Sempre que um oponente utilizar uma Habilidade de "
														+ "A�o do tipo T�cnica, voc� pode evitar totalmente seus efeitos "
														+ "(incluindo o dano). O custo dessa Habilidade � o mesmo da T�cnica a "
														+ "ser evitada.\n"
														+ "\tVoc� s� pode utilizar essa Habilidade 1 vez por turno.");
	public final static Habilidade ATAQUE_DO_BUFALO = new Habilidade("Ataque do B�falo", "A��o", "T�cnica", null, 10, -1,
														"Fa�a uma manobra de encontr�o. Se acertar o ataque, al�m de causar o dano "
														+ "normal pelo encontr�o, o alvo precisa vencer um teste de For�a "
														+ "(Dificuldade igual � sua Determina��o mais a FN da arma que estiver "
														+ "usando) ou ser� derruvado. Alvos com o dobro do seu peso n�o s�o afetados.");
	public final static Habilidade ATAQUE_GIRATORIO = new Habilidade("Ataque Girat�rio", "A��o", "T�cnica", null, 10, -1,
														"Voc� realiza um ataque amplo, girando sua arma para atingir todos os "
														+ "oponentes pr�ximos. Fa�a um ataque corporal contra cada alvo dentro do "
														+ "seu alcance corporal.");
	public final static Habilidade ATAQUE_SIMULTANEO = new Habilidade("Ataque Simult�neo", "A��o", "T�cnica", "Combate em Grupo", 20, -1,
														"Voc� est� acostumado a lutar em grupo e sabe como abrir a guarda de um "
														+ "advers�rio para que seus aliados possam atingi-lo. Fa�a um ataque corporal "
														+ "contra um oponente. Se acertar, todos aliados que estiverem adjacentes ao "
														+ "mesmo oponente poder�o fazer um ataque corporal normal contra ele "
														+ "imediatamente.");
	public final static Habilidade BRIGAO = new Habilidade("Brig�o", "Suporte", "Caracter�stica", null, -1, -1,
														"Voc� est� acostumado � combater desarmado. Voc� rola +1 em seus ataques "
														+ "desarmados e adiciona +2 nos danos desses ataques.");
	public final static Habilidade COMBATE_EM_GRUPO = new Habilidade("Combate em Grupo", "Rea��o", "T�cnica", null, -1, -1,
														"Voc� ganha +1 nos testes de ataques corporais para cada aliado que "
														+ "estaja em combate corporal com o alvo");
	public final static Habilidade COMBATE_COM_DUAS_ARMAS_1 = new Habilidade("Combate com Duas Armas 1", "Suporte", "T�cnica", null, -1, -1,
														"Voc� treinou para usar duas armas em combate de forma eficiente. Voc� pode fazer "
														+ "um ataque para cada arma que estiver segurando, desde que pelo menos uma delas "
														+ "tenha uma FN igual � metade (ou menos) do que a For�a do personagem.\n"
														+ "\tEspecial: Se voc� utilizar uma Habilidade de A��o, seus efeitos se aplicam a "
														+ "apenas um dos seus ataques - mas voc� ainda pode fazer um ataque normal com a "
														+ "outra arma no mesmo turno, antes ou depois de utilizar a Habilidade de A��o.");
	public final static Habilidade COMBATE_PESADO = new Habilidade("Combate Pesado", "Rea��o", "T�cnica", "Combate T�tico", 10, -1,
														"Sempre que voc� fizer uma manobra de encontr�o ou um ataque corporal "
														+ "enquanto estiver portando uma arma de duas m�os ou um escudo, voc� pode "
														+ "rolar novamente 1 dos dados em seus testes de ataque.\n"
														+ "\tVoc� pode escolher com qual dos resultados vai ficar.\n"
														+ "\tVoc� s� pode usar esta Habilidade 1 vez por turno.");
	public final static Habilidade COMBATE_TATICO = new Habilidade("Combate T�tico", "Rea��o", "T�cnica", null, -1, -1,
														"Se voc� derrotar um oponente com um ataque corporal, voc� pode "
														+ "imediatamente realizar outro ataque corporal normal.");
	public final static Habilidade DEFESA_AGRESSIVA = new Habilidade("Defesa Agressiva", "Suporte", "T�cnica", "Defletor", -1, -1,
														"Voc� entende que a melhor defesa � uma ataque eficiente. Quando estiver "
														+ "empunhando uma arma corporal de duas m�os, duas armas corporais ou "
														+ "um escudo, voc� recebe +1 em seus testes de ataque corporal e +1 na "
														+ "sua Defesa.\n"
														+ "\tEsse b�nus de Defesa � considerado um b�nus de Bloqueio.");
	public final static Habilidade DEFLETOR = new Habilidade("Defletor", "Suporte", "T�cnica", null, -1, -1,
														"Voc� est� acostumado a se defender de proj�teis. Enquanto estiver "
														+ "empunhando uma arma corporal de duas m�os, duas armas corporais ou "
														+ "um escudo, voc� receber +2 no seu b�nus de Bloqueio contra ataques � "
														+ "dist�ncia.\n"
														+ "\tEsse b�nus de Defesa � considerado um b�nus de Bloqueio.");
	public final static Habilidade ESTABILIDADE = new Habilidade("Estabilidade", "Suporte", "Caracter�stica", null, -1, -1,
														"Voc� gosta de ter os dois p�s solidamente plantados no ch�o - e faz isso "
														+ "muito bem! Voc� sempre rola +1d6 em todos os seus testes de evitar "
														+ "quedas e manter o equil�brio.");
	public final static Habilidade GOLPE_DEVASTADOR_1 = new Habilidade("Golpe Devastador 1", "A��o", "T�cnica", "Nocautear", 30, -1,
														"Voc� pode fazer um ataque corporal que causa o dobro de dano, e se "
														+ "acertar, o alvo precisa vencer um confronto de For�a (adicione a FN "
														+ "da arma que estiver usando no seu teste) contra voc� ou ficar� Paralisado "
														+ "(veja Condi��es na p�gina 169) por um turno.");
	public final static Habilidade GOLPE_COM_ESCUDO = new Habilidade("Golpe com Escudo", "A��o", "T�cnica", null, 5, -1,
														"Se voc� estiver portando um escudo e errar um ataque corporal com sua "
														+ "arma, voc� poder imediatamente fazer um ataque corporal normal contra "
														+ "o mesmo alvo com seu escudo. Um ataque com um escudo causa dano igual "
														+ "� For�a + FN do escudo/Contus�o.");
	public final static Habilidade GRITO_DE_GUERRA_1 = new Habilidade("Grito de Guerra 1", "A��o", null, null, 10, -1,
														"Voc� pode dar um grito fervoroso que motiva todos seus aliados que "
														+ "estiverem em um raio de 5 metros recebem +1 em todas as rolagens "
														+ "at� o final da batalha. Al�m disso, remova todos os efeitos de Medo "
														+ "de todos os aliados dentro da �rea dessa Habilidade.\n"
														+ "\tVoc� n�o pode usar esta Habilidade se estiver sob qualquer "
														+ "efeito de medo.");
	public final static Habilidade GUERREIRO_DE_A�O_1 = new Habilidade("Guerreiro de A�o 1", "Suporte", "Caracter�stica", null, -1, -1,
														"Voc� est�a acostumado a usar armaduras pesadas. Voc� considera a FN de "
														+ "qualuqer armadura com a Caracter�stica Pesada com tendo FN-1 para "
														+ "todos os prop�sitos.");
	public final static Habilidade INVESTIDA_MORTAL = new Habilidade("Investida Mortal", "A��o", "T�cnica", null, 10, -1,
														"Fa�a uma manobra de encontr�o contra um alvo. Se acertar, esse ataque "
														+ "causa +10 de dano e deia o alvo Atordoado (veja Condi��es na p�gina "
														+ "169) por 1 turno.");
	public final static Habilidade NOCAUTEAR = new Habilidade("Nocautear", "A��o", "T�cnica", null, 10, -1,
														"Fa�� um ataque corporal que causa dano por Contus�o. Se acertar, al�m de sofrer o dano normal "
														+ "do ataque, o alvo fica Paralisado (veja Condi��es na p�gina 169) por 1 turno.");
	public final static Habilidade PAREDE_DE_ESCUDOS = new Habilidade("Parede de Escudos", "Suporte", "T�cnica", null, -1, -1,
														"Voc� est� acostumado a lutar em grupo e usar seu escudo para proteger seus aliados. Enquanto "
														+ "voc� estiver usando um escudo, todos os aliados adjacentes a voc� recebem um b�nus de +1 "
														+ "na Defesa.\n"
														+ "\tEste � um b�nus de Bloqueio.");
	public final static Habilidade SEM_ESCAPATORIA = new Habilidade("Sem Escapat�ria", "Rea��o", "T�cnica", "Combate T�tico", -1, -1,
														"Se um oponente que est� adjacente a voc� tentar se afastar ou se levantar, voc� pode "
														+ "imediatamente fazer um ataque corporal normal contra ele. Se acertar, al�m de sofrer o dano "
														+ "normal pelo ataque, o oponente n�o poder� se movimentar neste turno.");
	public final static Habilidade TRANSPOR = new Habilidade("Transpor", "Suporte", "T�cnica", "Defesa Agressiva", -1, -1,
														"Voc� sabe encontrar os espa�os deiados pelo escudo do advers�rio. Ignore sempre o b�nus "
														+ "de Bloqueio da Defesa do oponente.");
	
	// Habilidade Avan�adas
	// Habilidades Avan�adas
	public final static Habilidade COMBATE_COM_DUAS_ARMAS_2 = new Habilidade("Combate com Duas Armas 2", "Suporte", "T�cnica", "N�vel 5, Combater com Duas Armas 1", -1, -1,
														"Como em Combate com Duas Armas 1, mas voc� pode usar duas armas com a mesma FN.\n"
														+ "\tEspecial: Se voc� utilizar uma Habilidade de A��o, seus efeitos se aplicam a apenas "
														+ "um dos seus ataques - mas voc� ainda pode fazer um ataque normal com a outra arma no mesmos "
														+ "turno, antes ou depois de utilizar a Habilidade de A��o");
	public final static Habilidade FORCA_DE_EXPLOSAO = new Habilidade("For�a de Explos�o", "Suporte", "Caracter�stica", "N�vel 5, Ataque do B�falo", -1, -1,
														"Quando fizer ataques que t�m chance de derrubar o oponente voc� pode afetar alvos at� 10 vezes "
														+ "mais pesados do que voc� (a maioria dos ataques que derrubam oponentes s� afetam alvos com at� "
														+ "o dobro do seu peso).\n"
														+ "\tAl�m disso, se voc� usar qualquer Habilidade que derrube o oponente, a dificuldade para "
														+ "resistir ao efeito � aumentada em +2.");
	public final static Habilidade GOLPE_DEVASTADOR_2 = new Habilidade("Golpe Devastador 2", "A��o", "T�cnica", "N�vel 5, Golpe Devastador 1", 60, -1,
														"Fa�a um ataque corporal contra o alvo. Se acertar, o ataque causa o triplo do dano normal e o "
														+ "alvo precisa vencer um confronto de For�a (adicione a FN da arma que estiver usando no seu "
														+ "teste) contra voc� ou ficar� Paralisado (veja Condi��es na p�gina 169) por um turno.");
	public final static Habilidade GRITO_DE_GUERRA_2 = new Habilidade("Grito de Guerra 2", "A��o", null, "N�vel 5, Grito de Guerra 1", 15, -1,
														"Voc� pode dar um grito fervoroso que motiva todos seus aliados. Voc� e todos os seus aliados em "
														+ "um raio de 10 metros recebem +2 em todas as rolagens at� o final da batalha. Al�m disso, "
														+ "remova todos os efeitos de Medo de todos os aliados dentro da �rea dessa Habilidade.\n"
														+ "\tVoc� n�o pode usar esta Habilidade se estiver sob qualquer efeito de Medo.");
	public final static Habilidade GRITO_DE_INTIMIDACAO = new Habilidade("Grito de Intimida��o", "A��o", null, "N�vel 5, Grito de Guerra 1", 35, -1,
														"Voc� pode dar um grito para intimidar seus inimigos. Todos os oponentes que estiverem a at� "
														+ "10 metros � sua frente que tiverem uma Determina��o menor do que a sua ficam Paralisados "
														+ "(veja Condi��es na p�gina 169) por 2 turnos.\n"
														+ "\tEsse � um efeito de Medo.");
	public final static Habilidade GUERREIRO_DE_ACO_2 = new Habilidade("Guerreiro de A�o 2", "Suporte", "Caracter�stica", "N�vel 5, Guerreiro de A�o 1", -1, -1,
														"Voc� est� extremamente acostumado a usar armaduras pesadas e se sente confort�vel quando verga uma. "
														+ "Voc� considera a FN de Qualquer armadura com a Caracter�stica Pesada como tendo FN-1 para todos os "
														+ "prop�sitos.\n"
														+ "\tEssa redu��o se acumula com a redu��o fornecida por Guerreiro de A�o 1.");
	public final static Habilidade IMPLACAVEL = new Habilidade("Implac�vel", "Suporte", "Caracter�stica", "N�vel 5, Sem Escapat�ria", -1, -1,
														"Sempre que errar um ataque corporal, voc� causa metade do dano normal do ataque (arredondando "
														+ "para baixo).");
	public final static Habilidade INVESTIDA_FORTE = new Habilidade("Investida Forte", "Suporte", null, "N�vel 5, Golpe com Escudo", -1, -1,
														"Sempre que acertar uma manobra de encontr�o usando um esudo, o alvo precisa vencer um teste de "
														+ "Resist�ncia (Dificuldade igual � sua Determina��o + a FN do escudo que voc� estiver usando) "
														+ "ou ser� derrubado. Alvos com o dobro do seu peso n�o s�o afetados. Um ataque com um escudo "
														+ "causa dano igual � For�a + FN do escudo/Contus�o.");
	public final static Habilidade MESTRE_DE_ARMAS_2 = new Habilidade("Mestre de Armas 2", "Suporte", "T�cnica", "N�vel 5", -1, -1,
														"Voc� � extremamente eficaz no uso de armas brancas. Sempre que acertar um ataque corporal "
														+ "adicione 3 ao dano do ataque.\n"
														+ "\tEsse b�nus de dano se acumula com o b�nus fornecido por Mestre das Armas 1.");
	public final static Habilidade VALOR_DA_VITORIA = new Habilidade("Valor da Vit�ria", "Rea��o", "Caracter�stica", "N�vel 5", -1, -1,
														"Cada vez que voc� derrota um oponente (isso inclui se ele se render ou fugir ap�s a batalha) "
														+ "voc� recupera 5 pontos de vida e 5 pontos de mana.");
	
	// Habilidade Final
	// Habilidade Final
	public final static Habilidade MESTRE_DE_ARMAS_3 = new Habilidade("Mestre em Armas 3", "A��o", "T�cnica", "N�vel 10, Mestre de Armas 2", 50, -1,
														"Fa�a um ataque corporal contra uma criatura. Se o ataque acertar o alvo, ao inv�s do dano normal "
														+ "da arma, os Pontos de Vida atuais dele s�o reduzidos � metade. No caso de um sucesso cr�tico "
														+ "no ataque, o oponente � morto instantaneamente.");
}
