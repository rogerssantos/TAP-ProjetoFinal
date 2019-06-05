package principal;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrincipalAdminController {
	
	@FXML
	public void abreCadMateria(ActionEvent event) throws IOException {
		Parent telaParent = FXMLLoader.load(getClass().getResource("CadMateria.fxml"));
		Scene telaScene = new Scene(telaParent);
		Stage telaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		telaStage.setScene(telaScene);
		telaStage.show();
	}

}
