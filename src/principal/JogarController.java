package principal;

import java.io.IOException;

import dao.JogarDAO;
import dao.MateriaDAO;
import dao.QuestaoDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Jogar;
import model.Materia;

public class JogarController {
	
	@FXML TextField txtAluno;
	@FXML ComboBox<Materia> cbMateria;
	
	private MateriaDAO materiaDao = new MateriaDAO();
	private QuestaoDAO questaoDao = new QuestaoDAO();
	private JogarDAO jogarDao = new JogarDAO();
	private Jogar jogar = new Jogar();
	
	@FXML
	public void initialize() {
		preencheComboBoxMateria();
	}
	
	@FXML
	public void comecarJogo(ActionEvent event) throws IOException {
		if (validaCadastroJogo()) {
			Jogar j = tela4jogar();
			jogarDao.inserirJogo(j);
			int qtQuestoes = questaoDao.buscaQuantidadeDeQuestoes(j.getMateria().getCdMateria());
			if (qtQuestoes > 0) {
				Parent telaParent = FXMLLoader.load(getClass().getResource("JogarResposta.fxml"));
				Scene telaScene = new Scene(telaParent);
				Stage telaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				telaStage.setScene(telaScene);
				telaStage.show();
			} else {
				mensagemErroValidacao("A materia selecionada não possui nenhuma questão cadastrada");
			}
		}
	}
	
	public void preencheComboBoxMateria() {
		cbMateria.setItems(FXCollections.observableArrayList(materiaDao.listaMaterias()));
	}
	
	private Jogar tela4jogar() {
		jogar.setNmAluno(txtAluno.getText());
		jogar.setMateria(cbMateria.getSelectionModel().getSelectedItem());
		return jogar;
	}
	
	private boolean validaCadastroJogo() {
		if(cbMateria.getSelectionModel().isEmpty()) {
			mensagemErroValidacao("Campo não preenchido: Matéria");
			return false;
		}
		if(txtAluno.getText().equals("")) {
			mensagemErroValidacao("Campo não preenchido: Nome");
			return false;
		}
		return true;
	}
	
	private void mensagemErroValidacao(String erro) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Erro");
		alert.setContentText(erro);
		alert.initStyle(StageStyle.UNDECORATED);
		alert.getDialogPane().setStyle("-fx-border-color: black; -fx-border-width: 3;");
		alert.show();
	}
	
}