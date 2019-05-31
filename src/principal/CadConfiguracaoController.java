package principal;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class CadConfiguracaoController {
	
	@FXML
	private AnchorPane apConfiguracao;
	
	@FXML
	public void loadInicio(ActionEvent event) throws IOException{
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Principal.fxml"));
		apConfiguracao.getChildren().setAll(pane);
	}
	
}