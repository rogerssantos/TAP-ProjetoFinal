package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	public int buscaQuantidadeDeQuestoes(int cdmateria) {
		int qtQuestoes = 0;
		String sql = "select count(*) as quantidade from tbquestao where cdmateria = ?";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setInt(1, cdmateria);
			ResultSet linha = ps.executeQuery();
			if(linha.next()) {
				qtQuestoes = (linha.getInt("quantidade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qtQuestoes;
	}
	
	public ArrayList<Questao> listaQuestoes() {
		ArrayList<Questao> questoes = new ArrayList<Questao>();
		MateriaDAO materiaDao = new MateriaDAO();
		String sql = "select cdquestao, dsquestao, texto, cdmateria, flativo from tbmateria where flativo = 'S'";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ResultSet linha = ps.executeQuery();
			while (linha.next()) {
				Questao q = new Questao();
				q.setIdQuestao(linha.getInt("cdquestao"));
				q.setDescricaoQuestao(linha.getString("dsquestao"));
				q.setTextoQuestao(linha.getString("texto"));
				q.setMateria(materiaDao.buscarPorId(linha.getInt("cdmateria")));
				q.setFlAtivo(linha.getString("flativo"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questoes;
	}
}