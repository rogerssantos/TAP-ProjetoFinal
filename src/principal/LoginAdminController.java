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
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginAdminController {

	@FXML AnchorPane apRoot;
	@FXML Button btEntrar;
	@FXML Button btVoltar;
	@FXML PasswordField txtSenha;
	
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	@FXML
	public void voltaParaTelaPrincipal(ActionEvent event) throws IOException {
		Parent telaParent = FXMLLoader.load(getClass().getResource("Principal.fxml"));
		Scene telaScene = new Scene(telaParent);
		Stage telaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		telaStage.setScene(telaScene);
		telaStage.show();
	}
	
	@FXML
	public void abreTelaPrincipalAdmin(ActionEvent event) throws IOException {
		if (txtSenha.getText().equals("admin123")){
			Parent telaParent = FXMLLoader.load(getClass().getResource("PrincipalAdmin.fxml"));
			Scene telaScene = new Scene(telaParent);
			Stage telaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			telaStage.setScene(telaScene);
			telaStage.show();
		}
	}
}
