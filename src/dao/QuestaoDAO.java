package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Questao;
import util.ConexaoDb;

public class QuestaoDAO {

	public void inserirQuestao(Questao q) {
		String sql = "insert into tbquestao (dsquestao, cdmateria, texto, flativo) values (?, ?, ?, ?)";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setString(1, q.getDescricaoQuestao());
			ps.setString(2, q.getMateria().getCdMateria() + "");
			ps.setString(3, q.getTextoQuestao());
			ps.setString(4, q.getFlAtivo());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int buscaMaxQuestao(){
		int idQuestao = 0;
		String sql = "select max(cdquestao) as cdquestao from tbquestao";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ResultSet linha = ps.executeQuery();
			if(linha.next()) {
				idQuestao = (linha.getInt("cdquestao"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idQuestao;
	}
}