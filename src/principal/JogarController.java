package principal;

import dao.MateriaDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Jogar;
import model.Materia;

public class JogarController {
	
	@FXML TextField txtAluno;
	@FXML ComboBox<Materia> cbMateria;
	
	private MateriaDAO materiaDao = new MateriaDAO();
	private Jogar jogar = new Jogar();
	
	@FXML
	public void initialize() {
		preencheComboBoxMateria();
	}
	
	@FXML
	public void comecarJogo() {
		Jogar j = tela4jogar();
		
	}
	
	public void preencheComboBoxMateria() {
		cbMateria.setItems(FXCollections.observableArrayList(materiaDao.listaMaterias()));
	}
	
	private Jogar tela4jogar() {
		jogar.setNmAluno(txtAluno.getText());
		jogar.setMateria(cbMateria.getSelectionModel().getSelectedItem());
		return jogar;
	}
	
}