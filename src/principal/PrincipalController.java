package principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrincipalController {
	
	@FXML AnchorPane apRoot;
	@FXML Button btJogar;
	@FXML Button btNotas;
	@FXML Button btConfiguracoes;
	@FXML Button btSair;
	
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
		Parent telaParent = FXMLLoader.load(getClass().getResource("Jogar.fxml"));
		Scene telaScene = new Scene(telaParent);
		Stage telaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		telaStage.setScene(telaScene);
		telaStage.show();
	}
	
	@FXML
	public void telaDeRanking(ActionEvent event) throws IOException {
		Parent telaParent = FXMLLoader.load(getClass().getResource("RankingAcertadas.fxml"));
		Scene telaScene = new Scene(telaParent);
		Stage telaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		telaStage.setScene(telaScene);
		telaStage.show();
	}
	
}