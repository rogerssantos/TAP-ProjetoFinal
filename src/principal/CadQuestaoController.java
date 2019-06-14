package principal;

import java.io.IOException;
import java.util.ArrayList;

import dao.MateriaDAO;
import dao.QuestaoDAO;
import dao.RespostaDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;
import model.Materia;
import model.Questao;

public class CadQuestaoController {

	@FXML ComboBox<Materia> cbMateria;
	@FXML TextField txtDescricaoQuestao;
	@FXML TextField txtAlternativaA;
	@FXML TextField txtAlternativaB;
	@FXML TextField txtAlternativaC;
	@FXML TextField txtAlternativaD;
	@FXML RadioButton rdAlternativaA;
	@FXML RadioButton rdAlternativaB;
	@FXML RadioButton rdAlternativaC;
	@FXML RadioButton rdAlternativaD;
	@FXML TextArea txtQuestao;
	@FXML TabPane pane;
	
	private MateriaDAO materiaDao = new MateriaDAO();
	private QuestaoDAO questaoDao = new QuestaoDAO();
	private RespostaDAO respostaDao = new RespostaDAO();
	private Questao questao = new Questao();
	ArrayList<Questao> questoes = new ArrayList<Questao>();
	
	@FXML
	public void initialize() {
		preencheComboBoxMateria();
	}
	
	@FXML
	public void inserirQuestao(ActionEvent event) throws IOException {
		if(validaCadastroQuestao()) {
			Questao q = tela4questao();
			questaoDao.inserirQuestao(q);
			iserirRepostas();
			limpaTela();
		}
	}
	
	private void limpaTela() {
		txtDescricaoQuestao.setText("");
		txtQuestao.setText("");
		txtAlternativaA.setText("");
		txtAlternativaB.setText("");
		txtAlternativaC.setText("");
		txtAlternativaD.setText("");
		rdAlternativaA.setSelected(false);
		rdAlternativaB.setSelected(false);
		rdAlternativaC.setSelected(false);
		rdAlternativaD.setSelected(false);
		preencheComboBoxMateria();
		txtDescricaoQuestao.requestFocus();
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
		if(txtAlternativaA.getText().equals("")) {
			mensagemErroValidacao("Alternativa A");
			return false;
		}
		if(txtAlternativaB.getText().equals("")) {
			mensagemErroValidacao("Alternativa B");
			return false;
		}
		if(txtAlternativaC.getText().equals("")) {
			mensagemErroValidacao("Alternativa C");
			return false;
		}
		if(txtAlternativaD.getText().equals("")) {
			mensagemErroValidacao("Alternativa D");
			return false;
		}
		if (!(rdAlternativaA.isSelected() || rdAlternativaB.isSelected() || rdAlternativaC.isSelected() || rdAlternativaD.isSelected())) {
			mensagemErroValidacao("Resposta correta não selecionada");
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
	
	public void iserirRepostas() {
		int idQuestao = questaoDao.buscaMaxQuestao();
		respostaDao.inserirRespostas(1, idQuestao, txtAlternativaA.getText(), rdAlternativaA.isSelected() ? "S" : "N");
		respostaDao.inserirRespostas(2, idQuestao, txtAlternativaB.getText(), rdAlternativaB.isSelected() ? "S" : "N");
		respostaDao.inserirRespostas(3, idQuestao, txtAlternativaC.getText(), rdAlternativaC.isSelected() ? "S" : "N");
		respostaDao.inserirRespostas(4, idQuestao, txtAlternativaD.getText(), rdAlternativaD.isSelected() ? "S" : "N");
	}
}
