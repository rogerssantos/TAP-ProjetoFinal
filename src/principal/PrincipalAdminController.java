package principal;

import java.io.IOException;

import dao.MateriaDAO;
import dao.RespostaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PrincipalAdminController {
	
	@FXML TabPane pane;
	
	private MateriaDAO materiaDao = new MateriaDAO();
	private RespostaDAO respostaDao = new RespostaDAO();
	
	@FXML
	public void abreCadMateria() {
		abreTab("CadMateria", "CadMateria.fxml");
	}
	
	@FXML
	public void abreCadQuestao() {
		int qtMaterias = materiaDao.quantidadeMateria();
		if (qtMaterias > 0) {
			abreTab("CadQuestao", "CadQuestao.fxml");
		} else {
			mensagemErroValidacao("Nenhuma matéria foi cadastrada, por favor cadastre para habilitar essa tela");
		}
	}
	
	@FXML
	public void abreEditarQuestao() {
		int qtRespostas = respostaDao.quantidadeRespostas();
		if (qtRespostas > 0) {
			abreTab("EditQuestao", "EditarQuestao.fxml");
		} else {
			mensagemErroValidacao("Nenhuma questão foi cadastrada para habilitar essa tela");
		}
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
	
	private void mensagemErroValidacao(String erro) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Erro");
		alert.setContentText(erro);
		alert.initStyle(StageStyle.UNDECORATED);
		alert.getDialogPane().setStyle("-fx-border-color: black; -fx-border-width: 3;");
		alert.show();
	}
	
}
