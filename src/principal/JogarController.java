package principal;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class JogarController {
	
	@FXML
	private AnchorPane apJogar;
	
	@FXML
	public void loadInicio(ActionEvent event) throws IOException{
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Principal.fxml"));
		apJogar.getChildren().setAll(pane);
	}
	
	//teste
	
}