package principal;

import java.util.ArrayList;

import dao.JogarDAO;
import dao.QuestaoDAO;
import dao.RespostaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;
import model.Questao;
import model.Resposta;

public class JogarRespostaController {

	@FXML TextArea txtQuestao;
	@FXML Label lbDescQuestao;
	@FXML Label lbResposta;
	@FXML Label lbAlternativaA;
	@FXML Label lbAlternativaB;
	@FXML Label lbAlternativaC;
	@FXML Label lbAlternativaD;
	@FXML Button btResponder;
	@FXML Button btProximo;
	@FXML RadioButton rdAlternativaA;
	@FXML RadioButton rdAlternativaB;
	@FXML RadioButton rdAlternativaC;
	@FXML RadioButton rdAlternativaD;
	
	private QuestaoDAO questaoDao = new QuestaoDAO();
	private JogarDAO jogarDao = new JogarDAO();
	private RespostaDAO respostaDao = new RespostaDAO();
	private Questao[] questaoArray = new Questao[5];
	private Resposta resposta = new Resposta();
	ArrayList<Questao> questoes = new ArrayList<Questao>();
	int countQuestao = 0;
	int cdAlunoAcerto;
	
	public void initialize() {
		cdAlunoAcerto = jogarDao.buscaMaxAluno();
		preencheTela();
	}
	
	public void preencheTela() {
		if (countQuestao != questaoArray.length) {
			if (countQuestao == 0) {
				questaoArray = questaoDao.listaQuestoes();
			}
			System.out.println(countQuestao);
			resposta = respostaDao.listaRespostas(questaoArray[countQuestao].getIdQuestao());
			txtQuestao.setText(questaoArray[countQuestao].getTextoQuestao());
			lbDescQuestao.setText(questaoArray[countQuestao].getDescricaoQuestao());
			lbAlternativaA.setText(resposta.getAlteranativaA());
			lbAlternativaB.setText(resposta.getAlteranativaB());
			lbAlternativaC.setText(resposta.getAlteranativaC());
			lbAlternativaD.setText(resposta.getAlteranativaD());
			habilitaResposta();
		} else {
			lbResposta.setText("Não há mais perguntas!");
		}
	}
	
	@FXML
	public void salvarResposta() {
		if (validaRespostaSelecionada()) {
			if (rdAlternativaA.isSelected() && resposta.getFlRepostaCertaA().equals("S")) {
				lbResposta.setText("Parabéns você acertou!");
				bloqueiaResposta();
				jogarDao.atualizaPontuacao(cdAlunoAcerto);
			}
			if (rdAlternativaB.isSelected() && resposta.getFlRepostaCertaB().equals("S")) {
				lbResposta.setText("Parabéns você acertou!");
				bloqueiaResposta();
				jogarDao.atualizaPontuacao(cdAlunoAcerto);
			}
			if (rdAlternativaC.isSelected() && resposta.getFlRepostaCertaC().equals("S")) {
				lbResposta.setText("Parabéns você acertou!");
				bloqueiaResposta();
				jogarDao.atualizaPontuacao(cdAlunoAcerto);
			}
			if (rdAlternativaD.isSelected() && resposta.getFlRepostaCertaD().equals("S")) {
				lbResposta.setText("Parabéns você acertou!");
				bloqueiaResposta();
				jogarDao.atualizaPontuacao(cdAlunoAcerto);
			}
			lbResposta.setText("Infelizmente você errou :(");
			bloqueiaResposta();
		}
	}
	
	public boolean validaRespostaSelecionada() {
		if (!(rdAlternativaA.isSelected() || rdAlternativaB.isSelected() || rdAlternativaC.isSelected() || rdAlternativaD.isSelected())) {
			mensagemErroValidacao("Você deve informar uma reposta");
			return false;
		}
		return true;
	}
	
	public void proximaQuestao() {
		countQuestao++;
		preencheTela();
		lbResposta.setText("");
	}
	
	private void mensagemErroValidacao(String erro) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Erro de validacao");
		alert.setContentText("Erro de validacao: " + erro);
		alert.initStyle(StageStyle.UNDECORATED);
		alert.getDialogPane().setStyle("-fx-border-color: black; -fx-border-width: 3;");
		alert.show();
	}
	
	public void bloqueiaResposta() {
		btResponder.setDisable(true);
		btProximo.setVisible(true);
		rdAlternativaA.setDisable(true);
		rdAlternativaB.setDisable(true);
		rdAlternativaC.setDisable(true);
		rdAlternativaD.setDisable(true);
	}
	
	public void habilitaResposta() {
		rdAlternativaA.setDisable(false);
		rdAlternativaB.setDisable(false);
		rdAlternativaC.setDisable(false);
		rdAlternativaD.setDisable(false);
		rdAlternativaA.setSelected(false);
		rdAlternativaB.setSelected(false);
		rdAlternativaC.setSelected(false);
		rdAlternativaD.setSelected(false);
		btResponder.setDisable(false);
		btProximo.setVisible(false);
	}
	
}