package principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrincipalController {
	
	@FXML private AnchorPane apRoot;
	@FXML public Button btSair;
	
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	@FXML
	private void loadTelaJogo(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Jogar.fxml"));
		apRoot.getChildren().setAll(pane);
	}
	
	@FXML
	private void loadTelaProfessor(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Professor.fxml"));
		apRoot.getChildren().setAll(pane);
	}
	
	@FXML
	private void loadTelaConfiguracao(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Configuracao.fxml"));
		apRoot.getChildren().setAll(pane);
	}
	
	@FXML
	public void botaoSair(ActionEvent event) {
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
	}
	
}
