package principal;

import dao.MateriaDAO;
import dao.QuestaoDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Materia;
import model.Questao;

public class EditarQuestaoController {

	@FXML ComboBox<Materia> cbMateria;
	@FXML TableView<Questao> tbQuestao;
	@FXML TableColumn<Questao, String> colDescricao;
	
	private MateriaDAO materiaDao = new MateriaDAO();
	private QuestaoDAO questaoDao = new QuestaoDAO();
	private Questao questao = new Questao();
		
	public void initialize() {
		preencheComboBoxMateria();
		filtraTabela();
	}
	
	public void preencheComboBoxMateria() {
		cbMateria.setItems(FXCollections.observableArrayList(materiaDao.listaMaterias()));
	}
	
	@FXML
	public void filtraTabela() {
		Questao q = tela4jogar();
		colDescricao.setCellValueFactory(cellData -> cellData.getValue().descricaoQuestaoProperty());
		tbQuestao.setItems(FXCollections.observableArrayList(questaoDao.filtraQuestoesPorMateria(q.getMateria().getCdMateria())));
	}
	
	private Questao tela4jogar() {
		if (cbMateria.getSelectionModel().isEmpty()) {
			cbMateria.getSelectionModel().select(+1);
			questao.setMateria(cbMateria.getSelectionModel().getSelectedItem());
		}else {
			questao.setMateria(cbMateria.getSelectionModel().getSelectedItem());
		}
		return questao;
	}
}
