package principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dao.MateriaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PrincipalController {
	
	@FXML AnchorPane apRoot;
	@FXML Button btJogar;
	@FXML Button btNotas;
	@FXML Button btConfiguracoes;
	@FXML Button btSair;
	
	private MateriaDAO materiaDao = new MateriaDAO();
	
	public void initialize(URL url, ResourceBundle rb) {
	
	}
	
	@FXML
	public void botaoSair(ActionEvent event) {
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
	}
	
	@FXML
	public void telaDeConfiguracoes(ActionEvent event) throws IOException {
		Parent telaParent = FXMLLoader.load(getClass().getResource("LoginAdmin.fxml"));
		Scene telaScene = new Scene(telaParent);
		Stage telaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		telaStage.setScene(telaScene);
		telaStage.show();
	}
	
	@FXML
	public void telaDeJogar(ActionEvent event) throws IOException {
		int qtMaterias = materiaDao.quantidadeMateria();
		if (qtMaterias > 0) {
			Parent telaParent = FXMLLoader.load(getClass().getResource("Jogar.fxml"));
			Scene telaScene = new Scene(telaParent);
			Stage telaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			telaStage.setScene(telaScene);
			telaStage.show();
		} else {
			mensagemErroValidacao("Nenhuma matéria foi cadastrada, por favor cadastre para habilitar essa tela");
		}
	}
	
	@FXML
	public void telaDeRanking(ActionEvent event) throws IOException {
		Parent telaParent = FXMLLoader.load(getClass().getResource("RankingAcertadas.fxml"));
		Scene telaScene = new Scene(telaParent);
		Stage telaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		telaStage.setScene(telaScene);
		telaStage.show();
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