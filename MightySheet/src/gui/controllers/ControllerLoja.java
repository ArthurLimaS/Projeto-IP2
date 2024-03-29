package gui.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import dados.interfaces.IRepoEquipamentos;
import dados.repositorios.RepositorioEquipamentos;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import negocio.Fachada;
import negocio.beans.Arma;
import negocio.beans.Equipamento;
import negocio.beans.Personagem;
import negocio.beans.Protecao;

public class ControllerLoja {

	Fachada fachada = Fachada.getInstance();
	@FXML
    private TableView<Equipamento> tabela;
	
	@FXML
    private TableColumn<Equipamento, String> nome;

    @FXML
    private TableColumn<Equipamento, String> ouro;

    @FXML
    private TableColumn<Equipamento, String> tipo;

    @FXML
    private TableColumn<Equipamento, String> compra;

    @FXML
    private Label ouros;
    
    @FXML
    private TextArea descricao;

    @FXML
    private Button terminar;

    @FXML
    private Button cancelar;

    @FXML
    private RadioButton armadura;

    @FXML
    private CheckBox armas;

    @FXML
    private CheckBox equipamento;

    @FXML
    private CheckBox itensConjuracao;

    @FXML
    private ListView<?> compras;
    
    @FXML
    private ToggleGroup grupo;
    
    List<Equipamento> lista = new ArrayList<>();
    
    Personagem novoPerson = Personagem.novoPerson;

    @FXML
    void armaduras(ActionEvent event) {
    	
    	List<Protecao> lista = fachada.listarTodasArmaduras();
    	
    	ObservableList obLista = FXCollections.observableArrayList(lista);
    	
    	nome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
    	ouro.setCellValueFactory(data -> new SimpleStringProperty(String.format("%d",data.getValue().getCusto())));
    	tipo.setCellValueFactory(data -> new SimpleStringProperty(String.format("%d", data.getValue().getfN())));
    	tabela.setItems(obLista);
    	

    }
    
    @FXML
    void armas(ActionEvent event) {
    
    	List<Arma> lista = fachada.listarTodasArmas();
    	
    	ObservableList obLista = FXCollections.observableArrayList(lista);
    	
    	nome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
    	ouro.setCellValueFactory(data -> new SimpleStringProperty(String.format("%d",data.getValue().getCusto())));
    	tipo.setCellValueFactory(data -> new SimpleStringProperty(String.format("%d", data.getValue().getfN())));
    	tabela.setItems(obLista);
    	

    	
    }
    
    @FXML
    void itensConjuracao(ActionEvent event) {
    	
    	List<Equipamento> lista = fachada.listarTodosCanalizadores();
    	
    	ObservableList obLista = FXCollections.observableArrayList(lista);
    	
    	nome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
    	ouro.setCellValueFactory(data -> new SimpleStringProperty(String.format("%d",data.getValue().getCusto())));
    	tipo.setCellValueFactory(data -> new SimpleStringProperty(String.format("%d", data.getValue().getfN())));
    	
    	tabela.setItems(obLista);
    	
    }

    @FXML
    void equipamentos(ActionEvent event) {

List<Equipamento> lista = fachada.listarItensComuns();
    	
    	ObservableList obLista = FXCollections.observableArrayList(lista);
    	
    	nome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
    	ouro.setCellValueFactory(data -> new SimpleStringProperty(String.format("%d",data.getValue().getCusto())));
    	tipo.setCellValueFactory(data -> new SimpleStringProperty(String.format("%d", data.getValue().getfN())));
    	tabela.setItems(obLista);
    	
    }

    
    @FXML
    void acao(ActionEvent event) {
    	//List<Equipamento> lista = new ArrayList<>();
    	
    	if(novoPerson.getOuro() > 0 && novoPerson.getOuro() >= tabela.getSelectionModel().getSelectedItem().getCusto()) {
    		lista.add(tabela.getSelectionModel().getSelectedItem());
    		novoPerson.setOuro(novoPerson.getOuro() - tabela.getSelectionModel().getSelectedItem().getCusto());
    		}
    			
    	ObservableList obLista;
		obLista = FXCollections.observableArrayList(lista);
		compras.setItems(obLista);
		ouros.setText(String.format("%d", novoPerson.getOuro()));
    }
    
    @FXML
    void visualizarEquip(ActionEvent event) {
    	
    	
    	if(tabela.getSelectionModel().getSelectedItem().getClass().equals(Protecao.class))
    	{
    		Protecao prot = (Protecao) tabela.getSelectionModel().getSelectedItem();
    		String str = String.format("%s\n"
					+ "Custo: %d\n"
					+ "Defesa: ", prot.getNome(), prot.getCusto());

    		if(prot.isEscudo())
    		{
    			str += String.format("+%d\n", prot.getBloqueio());
    		}
    		else
    		{
    			str += String.format("%d\n", prot.getEsquiva());
    		}

    		str += String.format("FN: %d\n"
    				+ "Peso: %.2f\n", prot.getfN(), prot.getPeso());
    		descricao.setText(str);
    		
    	}else if(tabela.getSelectionModel().getSelectedItem().getClass().equals(Arma.class))
    	{
    		Arma arma = (Arma) tabela.getSelectionModel().getSelectedItem();
    		String str = String.format("%s\n"
					+ "Custo: %d\n"
					+ "Dano: ", arma.getNome(), arma.getCusto());	

    		if(arma.isCarregar())
    		{
    			str += String.format("%d\n", arma.getDano());
    		}
    		else
    		{
    			str += String.format("For+%d\n", arma.getDano());
    		}

    		str += String.format("Tipo: %s\n"
    				+ "FN: %d\n"
    				+ "Peso: %.2f\n"
    				+ "Distância: %s\n",
    				arma.getTipoDano(), arma.getfN(), arma.getPeso(), arma.getDistancia());
    		descricao.setText(str);
    	}
    	else {
    	String str = String.format("%s\n"
				+ "Custo: %d\n", tabela.getSelectionModel().getSelectedItem().getNome(), tabela.getSelectionModel().getSelectedItem().getCusto());

    			if(tabela.getSelectionModel().getSelectedItem().getfN() > 0)
    			{
    				str += String.format("FN: %d\n", tabela.getSelectionModel().getSelectedItem().getfN());
    			}

    			str += String.format("Peso: %.2fkg\n"
    					+ "Descrição: %s\n",
    					tabela.getSelectionModel().getSelectedItem().getPeso(), tabela.getSelectionModel().getSelectedItem().getDescricao());
    	
    			descricao.setText(str);
    	}
    	}
    
    void carregarValor()
    {
    	ouros.setText(String.format("%d", novoPerson.getOuro()));
    }
    
    @FXML
    void terminarCompra(ActionEvent event) {
    	List<Equipamento> lista = (List<Equipamento>) compras.getItems();
        ArrayList<Equipamento> showing;
        if (lista instanceof ArrayList<?>) {
            showing = (ArrayList<Equipamento>) lista;
        } else {
            showing = new ArrayList<>(lista);
        }
    	novoPerson.setEquipamentos(showing);
    	Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	stage.close();
    	
    	
    }
    
    @FXML
    void mostraDescricao(ActionEvent event) {
    	if(tabela.getSelectionModel().isSelected(tabela.getSelectionModel().getSelectedIndex())) {
    		
    		descricao.setText(tabela.getSelectionModel().getSelectedItem().getNome());
    	
    	}
    }

    @FXML
    void cancelar(ActionEvent event) {
    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	
    	appStage.close();
    }
    
    @FXML
    void initialize() {
    	carregarValor();
    	
    
    }
}
