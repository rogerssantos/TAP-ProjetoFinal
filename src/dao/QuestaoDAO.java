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
			ps.setInt(2, q.getMateria().getCdMateria());
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
		String sql = "select count(*) as quantidade from tbquestao where cdmateria = ? and flativo = ?";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setInt(1, cdmateria);
			ps.setString(2, "S");
			ResultSet linha = ps.executeQuery();
			if(linha.next()) {
				qtQuestoes = (linha.getInt("quantidade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qtQuestoes;
	}
	
	public Questao[] listaQuestoes() {
		String sql = "select cdquestao, dsquestao, texto, cdmateria, flativo from tbquestao where flativo = 'S' order by random () limit 5";
		Questao[] questoes = new Questao[5];
		MateriaDAO materiaDao = new MateriaDAO();
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ResultSet linha = ps.executeQuery();
			int count = 0;
			while (linha.next()) {
				Questao q = new Questao();
				q.setIdQuestao(linha.getInt("cdquestao"));
				q.setDescricaoQuestao(linha.getString("dsquestao"));
				q.setTextoQuestao(linha.getString("texto"));
				q.setMateria(materiaDao.buscarPorId(linha.getInt("cdmateria")));
				q.setFlAtivo(linha.getString("flativo"));
				questoes[count] = q;
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questoes;
	}
	
	public ArrayList<Questao> filtraQuestoesPorMateria(int filtro){
		ArrayList<Questao> questoes = new ArrayList<Questao>();
		MateriaDAO materiaDao = new MateriaDAO();
		String sql = "select cdquestao, dsquestao, texto, cdmateria, flativo from tbquestao where flativo = 'S' and cdmateria = ?";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setInt(1, filtro);
			ResultSet linha = ps.executeQuery();
			while(linha.next()) {
				Questao q =new Questao();
				q.setIdQuestao(linha.getInt("cdquestao"));
				q.setDescricaoQuestao(linha.getString("dsquestao"));
				q.setTextoQuestao(linha.getString("texto"));
				q.setMateria(materiaDao.buscarPorId(linha.getInt("cdmateria")));
				q.setFlAtivo(linha.getString("flativo"));
				questoes.add(q);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questoes;
	}
	
	public Questao filtraQuestoesPorCdQuestao(int filtro){
		Questao questoes = new Questao();
		MateriaDAO materiaDao = new MateriaDAO();
		String sql = "select cdquestao, dsquestao, texto, cdmateria, flativo from tbquestao where flativo = 'S' and cdquestao = ?";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setInt(1, filtro);
			ResultSet linha = ps.executeQuery();
			while(linha.next()) {
				questoes.setIdQuestao(linha.getInt("cdquestao"));
				questoes.setDescricaoQuestao(linha.getString("dsquestao"));
				questoes.setTextoQuestao(linha.getString("texto"));
				questoes.setMateria(materiaDao.buscarPorId(linha.getInt("cdmateria")));
				questoes.setFlAtivo(linha.getString("flativo"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questoes;
	}
	

	public void editarQuestao(Questao q) {
		String sql = "update tbquestao set dsquestao = ?, texto = ? where cdquestao = ?";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setString(1, q.getDescricaoQuestao());
			ps.setString(2, q.getTextoQuestao());
			ps.setInt(3, q.getIdQuestao());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirQuestao(int idQuestao) {
		String sql = "delete from tbquestao where cdquestao = ?";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setInt(1, idQuestao);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}