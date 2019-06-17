package principal;

import java.util.ArrayList;

import dao.JogarDAO;
import dao.QuestaoDAO;
import dao.RespostaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import model.Questao;

public class QuestaoAController {

	@FXML TextArea txtQuestao;
	@FXML RadioButton rdAlternativaA;
	@FXML RadioButton rdAlternativaB;
	@FXML RadioButton rdAlternativaC;
	@FXML RadioButton rdAlternativaD;
	
	private QuestaoDAO questaoDao = new QuestaoDAO();
	private RespostaDAO respostaDao = new RespostaDAO();
	private JogarDAO jogarDao = new JogarDAO();
	private Questao q = new Questao();
	
	int cdAluno = jogarDao.buscaMaxAluno();
	ArrayList<Questao> questao = new ArrayList<Questao>();
	
	public void initialize() {
		
	}
	
	public void preencheTela() {
		
	}
	
}