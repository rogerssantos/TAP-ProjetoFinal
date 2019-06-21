package principal;

import java.io.IOException;

import dao.JogarDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class NotaDoJogo {
	
	@FXML Label lbNota;
	
	private JogarDAO jogarDao = new JogarDAO();
	
	double qtAcertadas = jogarDao.buscaQtAcertadasDoMaxAluno(jogarDao.buscaMaxAluno());
	double resultado = (qtAcertadas/5.0)*10.0;
	
	@FXML
	public void initialize() {
		lbNota.setText(Double.toString(resultado));
	}
	
	@FXML
	public void voltarParaTelaInicial(ActionEvent event) throws IOException {
		Parent telaParent = FXMLLoader.load(getClass().getResource("Principal.fxml"));
		Scene telaScene = new Scene(telaParent);
		Stage telaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		telaStage.setScene(telaScene);
		telaStage.show();
	}
}