package principal;

import java.io.IOException;
import java.util.ArrayList;

import dao.MateriaDAO;
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
import model.Materia;
import util.ConexaoDb;
import util.Constants;

public class CadMateriaController {
	
	@FXML private AnchorPane apMateria;
	@FXML TextField txtNome;
	@FXML CheckBox ckInativar;
	@FXML Button btAcao;
	@FXML Button btCancelar;
	@FXML TableView<Materia> tblMateria;
	@FXML TableColumn<Materia, String> colNome;
	
	private ArrayList<Materia> lista;
	private MateriaDAO dao = new MateriaDAO();
	
	@FXML
	public void loadInicio(ActionEvent event) throws IOException{
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Principal.fxml"));
		apMateria.getChildren().setAll(pane);
	}
	
	@FXML
	public void initialize() {
		Constants.conn = ConexaoDb.conectaBd();
		//btAcao.setText("Novo");
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		lista = dao.listaTudo();
		tblMateria.setItems(FXCollections.observableArrayList(lista));
	}

	
}