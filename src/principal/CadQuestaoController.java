package principal;

import java.io.IOException;

import dao.MateriaDAO;
import dao.QuestaoDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;
import model.Materia;
import model.Questao;

public class CadQuestaoController {

	@FXML ComboBox<Materia> cbMateria;
	@FXML TextField txtDescricaoQuestao;
	@FXML TextArea txtQuestao;
	@FXML TabPane pane;
	
	private MateriaDAO materiaDao = new MateriaDAO();
	private QuestaoDAO questaoDao = new QuestaoDAO();
	private Questao questao = new Questao();
	
	@FXML
	public void initialize() {
		preencheComboBoxMateria();
	}
	
	@FXML
	public void inserirQuestao(ActionEvent event) throws IOException {
		if(validaCadastroQuestao()) {
			Questao q = tela4questao();
			questaoDao.inserirQuestao(q);
		}
	}
	
	public void preencheComboBoxMateria() {
		cbMateria.setItems(FXCollections.observableArrayList(materiaDao.listaMaterias()));
	}
	
	private Questao tela4questao() {
		questao.setMateria(cbMateria.getSelectionModel().getSelectedItem());
		questao.setDescricaoQuestao(txtDescricaoQuestao.getText());
		questao.setTextoQuestao(txtQuestao.getText());
		return questao;
	}
	
	private boolean validaCadastroQuestao() {
		if(cbMateria.getSelectionModel().isEmpty()) {
			mensagemErroValidacao("Matérias");
			return false;
		}
		if(txtDescricaoQuestao.getText().equals("")) {
			mensagemErroValidacao("Descrição da pergunta");
			return false;
		}
		if(txtQuestao.getText().equals("")) {
			mensagemErroValidacao("Texto da pergunta");
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
