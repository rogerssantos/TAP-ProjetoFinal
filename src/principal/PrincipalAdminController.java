package principal;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class PrincipalAdminController {
	
	@FXML TabPane pane;
	
	@FXML
	public void abreCadMateria() {
		abreTab("CadMateria", "CadMateria.fxml");
	}
	
	@FXML
	public void abreCadQuestao() {
		abreTab("CadQuestao", "CadQuestao.fxml");
	}
	
	@FXML
	public void abreEditarQuestao() {
		abreTab("EditQuestao", "EditarQuestao.fxml");
	}
	
	@FXML
	public void voltarParaTelaInicial(ActionEvent event) throws IOException {
		Parent telaParent = FXMLLoader.load(getClass().getResource("Principal.fxml"));
		Scene telaScene = new Scene(telaParent);
		Stage telaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		telaStage.setScene(telaScene);
		telaStage.show();
	}
	
	private void abreTab(String titulo, String path) {
		try {
			Tab tab = tabAberta(titulo);
			if(tab == null) {
				tab = new Tab(titulo);
				tab.setClosable(true);
				pane.getTabs().add(tab);
				tab.setContent((Node) FXMLLoader.load(getClass().getResource(path)));
			}
			selecionaTab(tab);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Tab tabAberta(String titulo) {
		for (Tab tb : pane.getTabs()) {
			if(tb.getText().equals(titulo)) 
				return tb;
		}
	return null;
	}

	private void selecionaTab(Tab tab) {
		pane.getSelectionModel().select(tab);
	}
	
}
