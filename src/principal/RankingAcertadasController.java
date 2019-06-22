package principal;

import java.io.IOException;

import dao.MateriaDAO;
import dao.RankingAcertadasDAO;
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
	@FXML TableColumn<Jogar, Integer> colQtAcertadas;
	
	private MateriaDAO materiaDao = new MateriaDAO();
	private RankingAcertadasDAO rankingAcertadasDAO = new RankingAcertadasDAO();
	
	@FXML
	public void initialize() {
		preencheComboBoxMateria();
		cbMateria.getSelectionModel().selectFirst();
		colNmAluno.setCellValueFactory(cellData -> cellData.getValue().nmAlunoProperty());
		colQtAcertadas.setCellValueFactory(cellData -> cellData.getValue().qtAcertadasProperty().asObject());
		tblRankingAcertadas.setItems(FXCollections.observableArrayList(rankingAcertadasDAO.buscaRankingPorMateria(cbMateria.getSelectionModel().getSelectedItem().getCdMateria())));
	}
	
	public void preencheComboBoxMateria() {
		cbMateria.setItems(FXCollections.observableArrayList(materiaDao.listaMaterias()));
	}
	
	public void jogar4Tela() {
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
	private void changeComboBox(ActionEvent event) {
		colNmAluno.setCellValueFactory(cellData -> cellData.getValue().nmAlunoProperty());
		colQtAcertadas.setCellValueFactory(cellData -> cellData.getValue().qtAcertadasProperty().asObject());
	    tblRankingAcertadas.setItems(FXCollections.observableArrayList(rankingAcertadasDAO.buscaRankingPorMateria(cbMateria.getValue().getCdMateria())));
	}

}
