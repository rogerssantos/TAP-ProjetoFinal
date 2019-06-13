package principal;

import dao.MateriaDAO;
import dao.QuestaoDAO;
import dao.RespostaDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;
import model.Materia;
import model.Questao;

public class CadRespostaController {

	@FXML TextField txtResposta1;
	@FXML TextField txtResposta2;
	@FXML TextField txtResposta3;
	@FXML TextField txtResposta4;
	@FXML TextArea txtQuestao;
	
	//private RespostaDAO respostaDao = new RespostaDAO();
	//private RespostaDAO respostaDao = new RespostaDAO();
	private Questao questao = new Questao();
	
	@FXML
	public void initialize() {
	}
	
	@FXML
	public void inserirResposta() {
		if(validaCadastroResposta()) {
			//Questao q = tela4questao();
			//questaoDao.inserirQuestao(q);
			limpaTela();
		}
	}
	
	private Questao tela4resposta() {
		//questao.setMateria(cbMateria.getSelectionModel().getSelectedItem());
		//questao.setDescricaoQuestao(txtDescricaoQuestao.getText());
		questao.setTextoQuestao(txtQuestao.getText());
		return questao;
	}
	
	private void limpaTela() {
		//cbMateria.getSelectionModel().select(-1);
		//txtDescricaoQuestao.setText("");
		txtQuestao.setText("");
	}
	
	private boolean validaCadastroResposta() {
		if(txtResposta1.getText().equals("")) {
			mensagemErroValidacao("Resposta 1");
			return false;
		}
		if(txtResposta2.getText().equals("")) {
			mensagemErroValidacao("Resposta 2");
			return false;
		}
		if(txtResposta3.getText().equals("")) {
			mensagemErroValidacao("Resposta 3");
			return false;
		}
		if(txtResposta4.getText().equals("")) {
			mensagemErroValidacao("Resposta 4");
			return false;
		}
		return true;
	}
	
	private void mensagemErroValidacao(String erro) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Erro de validacao");
		alert.setContentText("Erro de validacao no campo: " +erro+"\nPreenchimento obrigatorio");
		alert.initStyle(StageStyle.UNDECORATED);
		alert.getDialogPane().setStyle("-fx-border-color: black; -fx-border-width: 3;");
		alert.show();
	}
	
}
