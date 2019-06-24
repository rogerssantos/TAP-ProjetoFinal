package principal;

import java.io.IOException;

import dao.JogarDAO;
import dao.MateriaDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Jogar;
import model.Materia;

public class RankingAcertadasController {
	
	@FXML ComboBox<Materia> cbMateria;
	@FXML TableView<Jogar> tblRankingAcertadas;
	@FXML TableColumn<Jogar, String> colNmAluno;
	@FXML TableColumn<Jogar, Number> colQtAcertadas;
	
	private MateriaDAO materiaDao = new MateriaDAO();
	private JogarDAO jogarDAO = new JogarDAO();
	private Jogar jogar = new Jogar();
	
	@FXML
	public void initialize() {
		preencheComboBoxMateria();
		filtrarTabela();
	}
	
	public void preencheComboBoxMateria() {
		cbMateria.setItems(FXCollections.observableArrayList(materiaDao.listaMaterias()));
	}
	
	@FXML
	public void voltarParaTelaInicial(ActionEvent event) throws IOException {
		Parent telaParent = FXMLLoader.load(getClass().getResource("Principal.fxml"));
		Scene telaScene = new Scene(telaParent);
		Stage telaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		telaStage.setScene(telaScene);
		telaStage.show();
	}
	
	@FXML
	private void filtrarTabela() {
		Jogar j = tela4ranking();
		colNmAluno.setCellValueFactory(cellData -> cellData.getValue().nmAlunoProperty());
		colQtAcertadas.setCellValueFactory(cellData -> cellData.getValue().qtAcertadasProperty());
		tblRankingAcertadas.setItems(FXCollections.observableArrayList(jogarDAO.buscaRankingPorMateria(j.getMateria().getCdMateria())));
	}
	
	private Jogar tela4ranking() {
		if (cbMateria.getSelectionModel().isEmpty()) {
			cbMateria.getSelectionModel().select(0);
			jogar.setMateria(cbMateria.getSelectionModel().getSelectedItem());
		}else {
			jogar.setMateria(cbMateria.getSelectionModel().getSelectedItem());
		}
		return jogar;
	}

}
