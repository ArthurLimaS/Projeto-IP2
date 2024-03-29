package gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.Fachada;
import negocio.beans.Classe;
import negocio.beans.Habilidade;

public class ControllerCriarClasse {
	Fachada fachada = Fachada.getInstance();
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nome;

    @FXML
    private TextField forca;

    @FXML
    private TextArea descricao;

    @FXML
    private TextField agilidade;

    @FXML
    private TextField inteligencia;

    @FXML
    private TextField vontade;

    @FXML
    private ComboBox<?> habAuto;

    @FXML
    private ComboBox<?> habFinal;

    @FXML
    private ListView<Habilidade> listHabBasicas;

    @FXML
    private ListView<Habilidade> listHabAvancadas;

    @FXML
    private Button voltar;

    @FXML
    private Button salvar;
    List<Habilidade> hab = null;
    
    @FXML
    void acaoSalvar(ActionEvent event) throws IOException {
    	ObservableList lista = listHabBasicas.getSelectionModel().getSelectedItems(); 
    	ObservableList  lista2  = listHabAvancadas.getSelectionModel().getSelectedItems();
    	
    	List<Habilidade> listaH = new ArrayList<>();
    	listaH.addAll(lista);
    	listaH.addAll(lista2);
    	listaH.add((Habilidade) habAuto.getSelectionModel().getSelectedItem());
    	listaH.add((Habilidade) habFinal.getSelectionModel().getSelectedItem());
    	
    	Classe classe = new Classe(null, 0, 0, 0, 0, null,listaH);
    	classe.setNome(nome.getText());
    	classe.setBonusForca(Integer.parseInt(forca.getText()));
    	classe.setBonusAgilidade(Integer.parseInt(agilidade.getText()));
    	classe.setBonusInteligencia(Integer.parseInt(inteligencia.getText()));
    	classe.setBonusVontade(Integer.parseInt(vontade.getText()));
    	classe.setHabilidadeAutomatica((Habilidade) habAuto.getValue());
    	fachada.adicionarClasse(classe);
    	fachada.salvarClasses();
    	Parent parent_voltar = FXMLLoader.load(getClass().getResource("/gui/fxmls/TelaInicial.fxml"));
    	Scene Criacao_Ficha_Scene = new Scene(parent_voltar);
    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	appStage.setScene(Criacao_Ficha_Scene);
    	appStage.show();
    	fachada.salvarTodosRepositórios();
    	
    }

    @FXML
    void acaoVoltar(ActionEvent event) throws IOException {
    	Parent parent_voltar = FXMLLoader.load(getClass().getResource("/gui/fxmls/TelaInicial.fxml"));
    	Scene Criacao_Ficha_Scene = new Scene(parent_voltar);
    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	appStage.setScene(Criacao_Ficha_Scene);
    	appStage.show();
    }

    void carregarHab()
    {
    	//Carregar Hab Auto
    	ObservableList obLista;
    	List<Habilidade> lista = new ArrayList<>();
    	lista.add(fachada.buscarHabilidade("Mestre de Armas 1"));
    	lista.add(fachada.buscarHabilidade("Conhecimento Arcano"));
    	lista.add(fachada.buscarHabilidade("Gatuno"));
    	obLista = FXCollections.observableArrayList(lista);
    	habAuto.getItems().addAll(obLista);
    	
    	//Carregar Hab final
    	ObservableList obLista1;
    	List<Habilidade> lista1 = new ArrayList<>();
    	for(Habilidade hab : fachada.listarTodasHabilidades())
    	{
    		if(hab.getRequisito().contains("Nível 10")) {
    			lista1.add(hab);
    		}
    	}
    	obLista1 = FXCollections.observableArrayList(lista1);
    	habFinal.getItems().addAll(obLista1);
    	
    	//Carregar Hab Basicas
    	ObservableList obLista2;
    	List<Habilidade> lista2 = new ArrayList<>();
    	for(Habilidade hab : fachada.listarTodasHabilidades())
    	{
    		
    		if(!hab.getRequisito().contains("Nível 10") && !hab.getRequisito().contains("Nível 5")) {
    			lista2.add(hab);
    		}
    		
    	}
    	obLista2 = FXCollections.observableArrayList(lista2);
    	listHabBasicas.getItems().addAll(obLista2);
    	listHabBasicas.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	
    	//Carregar Hab Avançadas
    	ObservableList obLista3;
    	List<Habilidade> lista3 = new ArrayList<>();
    	for(Habilidade hab : fachada.listarTodasHabilidades())
    	{
    		if(hab.getRequisito().contains("Nível 5"))
    		{
    			lista3.add(hab);
    		}
    		
    		
    	}
    	obLista3 = FXCollections.observableArrayList(lista3);
    	listHabAvancadas.getItems().addAll(obLista3);
    	listHabAvancadas.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    void soNumeros() {
    	forca.textProperty().addListener(new ChangeListener<String>() {
    	    @Override
    	    public void changed(ObservableValue<? extends String> observable, String oldValue, 
    	        String newValue) {
    	        if (!newValue.matches("\\d*")) {
    	            forca.setText(newValue.replaceAll("[^\\d]", ""));
    	        }
    	    }
    	});
    	
    	inteligencia.textProperty().addListener(new ChangeListener<String>() {
    	    @Override
    	    public void changed(ObservableValue<? extends String> observable, String oldValue, 
    	        String newValue) {
    	        if (!newValue.matches("\\d*")) {
    	            inteligencia.setText(newValue.replaceAll("[^\\d]", ""));
    	        }
    	    }
    	});
    	
    	agilidade.textProperty().addListener(new ChangeListener<String>() {
    	    @Override
    	    public void changed(ObservableValue<? extends String> observable, String oldValue, 
    	        String newValue) {
    	        if (!newValue.matches("\\d*")) {
    	            agilidade.setText(newValue.replaceAll("[^\\d]", ""));
    	        }
    	    }
    	});
    	
    	vontade.textProperty().addListener(new ChangeListener<String>() {
    	    @Override
    	    public void changed(ObservableValue<? extends String> observable, String oldValue, 
    	        String newValue) {
    	        if (!newValue.matches("\\d*")) {
    	            vontade.setText(newValue.replaceAll("[^\\d]", ""));
    	        }
    	    }
    	});
    }
    

    @FXML
    void initialize() {
    	carregarHab();
    	soNumeros();
    }

}
