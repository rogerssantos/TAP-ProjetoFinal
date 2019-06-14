package principal;

import java.io.IOException;
import java.util.ArrayList;

import dao.MateriaDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Materia;

public class CadMateriaController {
	
	@FXML TextField txtNome;
	@FXML TextField txtFiltro;
	@FXML CheckBox ckInativar;
	@FXML Button btAcao;
	@FXML Button btCancelar;
	@FXML TableView<Materia> tblMateria;
	@FXML TableColumn<Materia, String> colNmMateria;
	
	private ArrayList<Materia> materias = new ArrayList<Materia>();
	
	private MateriaDAO materiaDao = new MateriaDAO();
	private Materia materia = new Materia();
	
	private final int ACAO_ATUALIZAR = 1;
	private final int ACAO_NOVO = 2;
	public int acao;
	
	@FXML
	public void loadInicio(ActionEvent event) throws IOException{
		Parent telaParent = FXMLLoader.load(getClass().getResource("PrincipalAdmin.fxml"));
		Scene telaScene = new Scene(telaParent);
		Stage telaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		telaStage.setScene(telaScene);
		telaStage.show();
	}
	
	@FXML
	public void initialize() {
		btAcao.setText("Novo");
		colNmMateria.setPrefWidth(856);
		colNmMateria.setCellValueFactory(cellData -> cellData.getValue().nmMateriaProperty());
		tblMateria.setItems(FXCollections.observableArrayList(materiaDao.listaMaterias()));
	}
	
	@FXML
	public void inserirAtualizarMateria() {
		if (validaCadastroMateria()) {
			Materia m = tela4Materia();
			if (acao != ACAO_ATUALIZAR) {
				materiaDao.inserirMateria(m);
			} else {
				materiaDao.atualizaMaterias(m);
				btCancelar.setDisable(true);
			}
			limpaTela();
			materias = materiaDao.listaMaterias();
			tblMateria.setItems(FXCollections.observableArrayList(materias));
			btAcao.setText("Novo");
			acao = ACAO_NOVO;
		}
	}
	
	@FXML
	public void selecionaRegistroMateria() {
		materia = tblMateria.getSelectionModel().getSelectedItem();
		if (materia != null) {
			btAcao.setText("Atualizar");
			materia4Tela(materia);
			acao = ACAO_ATUALIZAR;
		}
    }
	
	@FXML
	public void cancelarLinhaSelecionada() {
		limpaTela();
		ckInativar.setDisable(true);
		btCancelar.setDisable(true);
		acao = ACAO_NOVO;
	}
	
	@FXML
	public void filtrarMateria() {
		if (!txtFiltro.getText().equals("")) {
			tblMateria.setItems(FXCollections.observableArrayList(materiaDao.filtraMaterias(txtFiltro.getText())));
		} else {
			tblMateria.setItems(FXCollections.observableArrayList(materiaDao.listaMaterias()));
		}
	}
	
	private void limpaTela() {
		btAcao.setText("Novo");
		txtNome.setText("");
		txtNome.requestFocus();
		ckInativar.setDisable(true);
		ckInativar.setSelected(false);
	}
	
	private boolean validaCadastroMateria() {
		if (txtNome.getText().equals("")) {
			mensagemErroValidacao("Nome");
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

	private Materia tela4Materia() {
		materia.setNmMateria(txtNome.getText());
		if (ckInativar.isSelected()) {
			materia.setFlAtivo("N");
		} else {
			materia.setFlAtivo("S");
		}
		return materia;
	}
	
	public void materia4Tela(Materia materia) {
		txtNome.setText(materia.getNmMateria());
        ckInativar.setDisable(false);
        btCancelar.setDisable(false);
        if (materia.getFlAtivo().equals("S")) {
        	ckInativar.setSelected(false);
		}
	}
}
