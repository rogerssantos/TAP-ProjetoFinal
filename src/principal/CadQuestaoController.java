package principal;

import dao.MateriaDAO;
import dao.QuestaoDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Materia;
import model.Questao;

public class CadQuestaoController {

	@FXML ComboBox<Materia> cbMateria;
	@FXML TextField txtDescricaoQuestao;
	@FXML TextArea txtQuestao;
	
	private MateriaDAO materiaDao = new MateriaDAO();
	private QuestaoDAO questaoDao = new QuestaoDAO();
	private Questao questao = new Questao();
	
	@FXML
	public void initialize() {
		preencheComboBoxMateria();
	}
	
	@FXML
	public void inserirQuestao() {
		if(validaCadastroQuestao()) {
			Questao q = tela4questao();
			questaoDao.inserirQuestao(q);
			limpaTela();
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
	
	private void limpaTela() {
		cbMateria.getSelectionModel().select(-1);
		txtDescricaoQuestao.setText("");
		txtQuestao.setText("");
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
	
	@FXML 
	public void abreCadResposta(){
		try {
				Stage stageJanela1 = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("CadResposta.fxml"));
				Parent root = loader.load();
				stageJanela1.setScene(new Scene(root));
				stageJanela1.initModality(Modality.WINDOW_MODAL);
				stageJanela1.initStyle(StageStyle.UNDECORATED);
				stageJanela1.setResizable(false);
				stageJanela1.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
