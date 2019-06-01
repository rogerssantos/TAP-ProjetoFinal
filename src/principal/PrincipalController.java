package principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrincipalController {
	
	@FXML AnchorPane apRoot;
	@FXML Button btEntrar;
	@FXML Button btSair;
	@FXML TextField txtUsuario;
	@FXML PasswordField txtSenha;
	
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	@FXML
	public void botaoSair(ActionEvent event) {
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
	}
	
	@FXML
	public void controlaMudancaDeTelaEntreUsuarios(ActionEvent event) throws IOException {
		if (txtUsuario.getText().equals("aluno") && txtSenha.getText().equals("aluno")) {
			AnchorPane pane = FXMLLoader.load(getClass().getResource("PrincipalAluno.fxml"));
			apRoot.getChildren().setAll(pane);
		}
		if (txtUsuario.getText().equals("admin") && txtSenha.getText().equals("admin")){
			AnchorPane pane = FXMLLoader.load(getClass().getResource("PrincipalAdmin.fxml"));
			apRoot.getChildren().setAll(pane);
		}
	}
	
}