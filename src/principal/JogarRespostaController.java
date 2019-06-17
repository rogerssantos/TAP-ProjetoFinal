package principal;

import java.util.ArrayList;

import dao.JogarDAO;
import dao.QuestaoDAO;
import dao.RespostaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import model.Questao;
import model.Resposta;

public class JogarRespostaController {

	@FXML TextArea txtQuestao;
	@FXML Label lbDescQuestao;
	@FXML Label lbAlternativaA;
	@FXML Label lbAlternativaB;
	@FXML Label lbAlternativaC;
	@FXML Label lbAlternativaD;
	@FXML RadioButton rdAlternativaA;
	@FXML RadioButton rdAlternativaB;
	@FXML RadioButton rdAlternativaC;
	@FXML RadioButton rdAlternativaD;
	
	private QuestaoDAO questaoDao = new QuestaoDAO();
	private RespostaDAO respostaDao = new RespostaDAO();
	private JogarDAO jogarDao = new JogarDAO();
	private Questao questao = new Questao();
	private Resposta resposta = new Resposta();
	
	ArrayList<Questao> questoes = new ArrayList<Questao>();
	
	int cdAluno = jogarDao.buscaMaxAluno();
	
	public void initialize() {
		
	}
	
	public void preencheTela() {
			
	}
	
}