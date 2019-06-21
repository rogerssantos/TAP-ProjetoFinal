package principal;

import dao.MateriaDAO;
import dao.QuestaoDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Materia;
import model.Questao;

public class EditarQuestaoController {

	@FXML ComboBox<Materia> cbMateria;
	@FXML TableView<Questao> tbQuestao;
	@FXML TableColumn<Questao, String> colDescricao;
	
	private MateriaDAO materiaDao = new MateriaDAO();
	private QuestaoDAO questaoDao = new QuestaoDAO();
	private Questao questao = new Questao();
	int idQuestao = 0;
	
	@FXML
	public void initialize() {
		preencheComboBoxMateria();
		filtraTabela();
	}
	
	@FXML
	public void filtraTabela() {
		Questao q = tela4jogar();
		colDescricao.setCellValueFactory(cellData -> cellData.getValue().descricaoQuestaoProperty());
		tbQuestao.setItems(FXCollections.observableArrayList(questaoDao.filtraQuestoesPorMateria(q.getMateria().getCdMateria())));
	}
	
	@FXML
	public void abreJanelaDeEdicaoDaQuestaoSelecionada() {
		Questao q = tbQuestao.getSelectionModel().getSelectedItem();
		idQuestao = q.getIdQuestao();
		try {
			Stage stageJanela = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EditarQuestaoJanela.fxml"));
			Parent root = loader.load();
			EditarQuestaoJanelaController controller = loader.getController();
			controller.recebeInformacoesDaQuestaoSelecionada(q.getIdQuestao());
			stageJanela.setScene(new Scene(root));
			stageJanela.initOwner(tbQuestao.getScene().getWindow());
			stageJanela.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void preencheComboBoxMateria() {
		cbMateria.setItems(FXCollections.observableArrayList(materiaDao.listaMaterias()));
	}
	
	private Questao tela4jogar() {
		if (cbMateria.getSelectionModel().isEmpty()) {
			cbMateria.getSelectionModel().select(0);
			questao.setMateria(cbMateria.getSelectionModel().getSelectedItem());
		}else {
			questao.setMateria(cbMateria.getSelectionModel().getSelectedItem());
		}
		return questao;
	}
}