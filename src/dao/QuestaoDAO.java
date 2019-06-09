package dao;

import java.sql.PreparedStatement;

import model.Questao;
import util.ConexaoDb;

public class QuestaoDAO {

	public void inserirQuestao(Questao q) {
		String sql = "insert into tbquestao (dsquestao, texto, flativo) values (?,?,?)";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setString(1, q.getDescricaoQuestao());
			ps.setString(2, q.getTextoQuestao());
			ps.setString(3, q.getFlAtivo());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}