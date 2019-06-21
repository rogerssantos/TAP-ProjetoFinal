package principal;

import dao.QuestaoDAO;
import dao.RespostaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Questao;
import model.Resposta;

public class EditarQuestaoJanelaController {

	@FXML TextField txtDescricaoQuestao;
	@FXML TextField txtAlternativaA;
	@FXML TextField txtAlternativaB;
	@FXML TextField txtAlternativaC;
	@FXML TextField txtAlternativaD;
	@FXML RadioButton rdAlternativaA;
	@FXML RadioButton rdAlternativaB;
	@FXML RadioButton rdAlternativaC;
	@FXML RadioButton rdAlternativaD;
	@FXML TextArea txtQuestao;
	@FXML Button btnFechar;
	
	QuestaoDAO questaoDao = new QuestaoDAO();
	RespostaDAO respostaDao = new RespostaDAO();
	Questao questao = new Questao();
	Resposta resposta = new Resposta();
	int idQuestao = 0;
	
	public void recebeInformacoesDaQuestaoSelecionada(int q) {
		questao = questaoDao.filtraQuestoesPorCdQuestao(q);
		resposta = respostaDao.listaRespostas(q);
		idQuestao = questao.getIdQuestao();
		txtDescricaoQuestao.setText(questao.getDescricaoQuestao());
		txtQuestao.setText(questao.getTextoQuestao());
		txtAlternativaA.setText(resposta.getAlteranativaA());
		txtAlternativaB.setText(resposta.getAlteranativaB());
		txtAlternativaC.setText(resposta.getAlteranativaC());
		txtAlternativaD.setText(resposta.getAlteranativaD());
		rdAlternativaA.setSelected(resposta.getFlRepostaCertaA().equals("S") ? true : false);
		rdAlternativaB.setSelected(resposta.getFlRepostaCertaB().equals("S") ? true : false);
		rdAlternativaC.setSelected(resposta.getFlRepostaCertaC().equals("S") ? true : false);
		rdAlternativaD.setSelected(resposta.getFlRepostaCertaD().equals("S") ? true : false);
	}
	
	@FXML
	public void atualizaQuestaoResposta() {
		Questao q = tela4questao();
		Resposta r = tela4resposta();
		questaoDao.editarQuestao(q);
		editarRespostas(q, r);
	}
	
	@FXML
	public void excluiRegistroQuestaoResposta() {
		questaoDao.excluirQuestao(idQuestao);
		respostaDao.excluirQuestaoResposta(idQuestao);
		fechaJanela();
	}
	
	@FXML
	public void fechaJanela() {
		Stage stage = (Stage) btnFechar.getScene().getWindow();
		stage.close();
	}
	
	public void editarRespostas(Questao q, Resposta r) {
		respostaDao.editarResposta(1, q.getIdQuestao(), r.getAlteranativaA(), r.getFlRepostaCertaA());
		respostaDao.editarResposta(2, q.getIdQuestao(), r.getAlteranativaB(), r.getFlRepostaCertaB());
		respostaDao.editarResposta(3, q.getIdQuestao(), r.getAlteranativaC(), r.getFlRepostaCertaC());
		respostaDao.editarResposta(4, q.getIdQuestao(), r.getAlteranativaD(), r.getFlRepostaCertaD());
	}
	
	private Questao tela4questao() {
		questao.setDescricaoQuestao(txtDescricaoQuestao.getText());
		questao.setTextoQuestao(txtQuestao.getText());
		questao.setIdQuestao(idQuestao);
		return questao;
	}
	
	private Resposta tela4resposta() {
		resposta.setAlteranativaA(txtAlternativaA.getText());
		resposta.setAlteranativaB(txtAlternativaB.getText());
		resposta.setAlteranativaC(txtAlternativaC.getText());
		resposta.setAlteranativaD(txtAlternativaD.getText());
		resposta.setFlRepostaCertaA(rdAlternativaA.isSelected() ? "S" : "N");
		resposta.setFlRepostaCertaB(rdAlternativaB.isSelected() ? "S" : "N");
		resposta.setFlRepostaCertaC(rdAlternativaC.isSelected() ? "S" : "N");
		resposta.setFlRepostaCertaD(rdAlternativaD.isSelected() ? "S" : "N");
		return resposta;
	}
	
}