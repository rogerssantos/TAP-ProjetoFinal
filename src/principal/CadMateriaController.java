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
	
	private final int ACAO_ATUALIZAR = 1;
	private final int ACAO_NOVO = 2;
	public int acao;
	
	@FXML private AnchorPane apMateria;
	@FXML TextField txtNome;
	@FXML TextField txtFiltro;
	@FXML CheckBox ckInativar;
	@FXML Button btAcao;
	@FXML Button btCancelar;
	@FXML TableView<Materia> tblMateria;
	@FXML TableColumn<Materia, String> colNmMateria;
	@FXML TableColumn<Materia, Integer> colCdMateria; 
	
	private ArrayList<Materia> lista;
	private MateriaDAO dao = new MateriaDAO();
	private Materia m = new Materia();
	
	@FXML
	public void loadInicio(ActionEvent event) throws IOException{
		AnchorPane pane = FXMLLoader.load(getClass().getResource("PrincipalAdmin.fxml"));
		apMateria.getChildren().setAll(pane);
	}
	
	@FXML
	public void initialize() {
		Constants.conn = ConexaoDb.conectaBd();
		btAcao.setText("Novo");
		colNmMateria.setCellValueFactory(cellData -> cellData.getValue().nmMateriaProperty());
		colCdMateria.setCellValueFactory(cellData -> cellData.getValue().cdMateriaProperty().asObject());
		lista = dao.listaTudo();
		tblMateria.setItems(FXCollections.observableArrayList(lista));
	}
	
	@FXML
	public void filtrarMateria() {
		if (txtFiltro.getText().equals("")) {
			lista = dao.listaTudo();
			tblMateria.setItems(FXCollections.observableArrayList(lista));
		} else {
			lista = dao.listaFiltrado(txtFiltro.getText());
			tblMateria.setItems(FXCollections.observableArrayList(lista));
		}
	}
	
	@FXML
	public void btAcao() {
		System.out.println("Entrou");
		Materia m = tela4Materia();
		if (acao != ACAO_ATUALIZAR) {
			dao.inserir(m);
		} else {
			dao.atualizar(m);
			btCancelar.setDisable(true);
		}
		limpaTela();
		lista = dao.listaTudo();
		tblMateria.setItems(FXCollections.observableArrayList(lista));
		btAcao.setText("Novo");
		acao = ACAO_NOVO;
	}
	
	@FXML
	public void btCancelar() {
		System.out.println("Entrou no cancelar");
		limpaTela();
		ckInativar.setDisable(true);
		btCancelar.setDisable(true);
		acao = ACAO_NOVO;
	}
	
	private Materia tela4Materia() {
		m.setNmMateria(txtNome.getText());
		if (ckInativar.isSelected()) {
			m.setFlAtivo("S");
		} else {
			m.setFlAtivo("N");
		}
		return m;
	}
	
	private void materia4Tela(Materia m) {
		txtNome.setText(m.getNmMateria());
        ckInativar.setDisable(false);
        btCancelar.setDisable(false);
	}
	
	private void limpaTela() {
		btAcao.setText("Novo");
		txtNome.setText("");
		txtNome.requestFocus();
		ckInativar.setDisable(true);
		ckInativar.setSelected(false);
	}
	
	@FXML
	public void clickLinha() {
		m = tblMateria.getSelectionModel().getSelectedItem();
		System.out.println(m.getCdMateria());
		System.out.println(m.getFlAtivo());
		if (m != null) {
			btAcao.setText("Atualizar");
			materia4Tela(m);
			acao = ACAO_ATUALIZAR;
		}
    }

}
