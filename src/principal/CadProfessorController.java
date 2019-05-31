package principal;

import java.io.IOException;
import java.util.ArrayList;

import dao.ProfessorDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Professor;
import util.ConexaoDb;
import util.Constants;

public class CadProfessorController {
	
	@FXML private AnchorPane apProfessor;
	@FXML TextField txtNome;
	@FXML TextField txtLogin;
	@FXML TextField txtFiltro;
	@FXML CheckBox ckInativar;
	@FXML Button btAcao;
	@FXML Button btCancelar;
	@FXML TableView<Professor> tblProfessor;
	@FXML TableColumn<Professor, String> colNome;
	@FXML TableColumn<Professor, String> colLogin;
	
	private ArrayList<Professor> lista;
	private ProfessorDAO dao = new ProfessorDAO();
	
	@FXML
	public void loadInicio(ActionEvent event) throws IOException{
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Principal.fxml"));
		apProfessor.getChildren().setAll(pane);
	}
	
	@FXML
	public void initialize() {
		Constants.conn = ConexaoDb.conectaBd();
		//btAcao.setText("Novo");
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colLogin.setCellValueFactory(cellData -> cellData.getValue().loginProperty());
		lista = dao.listaTudo();
		tblProfessor.setItems(FXCollections.observableArrayList(lista));
	}

	
}