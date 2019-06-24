package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Resposta;
import util.ConexaoDb;


public class RespostaDAO {

	public void inserirRespostas(int op, int id, String texto, String fl) {
		String sql = "insert into tbresposta (cdresposta, cdquestao, texto, flcorreto, flativo) values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setInt(1, op);
			ps.setInt(2, id);
			ps.setString(3, texto);
			ps.setString(4, fl);
			ps.setString(5, "S");
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Resposta listaRespostas(int cdQuestao) {
		Resposta r = new Resposta();
		String sql = "select cdresposta, cdquestao, texto, flcorreto, flativo from tbresposta where flativo = 'S' and cdquestao = ? order by cdresposta asc";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setInt(1, cdQuestao);
			ResultSet linha = ps.executeQuery();
			while (linha.next()) {
				if (linha.getInt("cdresposta") == 1) {
					r.setAlteranativaA(linha.getString("texto"));
					r.setFlRepostaCertaA(linha.getString("flcorreto"));
				}
				if (linha.getInt("cdresposta") == 2) {
					r.setAlteranativaB(linha.getString("texto"));
					r.setFlRepostaCertaB(linha.getString("flcorreto"));
				}
				if (linha.getInt("cdresposta") == 3) {
					r.setAlteranativaC(linha.getString("texto"));
					r.setFlRepostaCertaC(linha.getString("flcorreto"));
				}
				if (linha.getInt("cdresposta") == 4) {
					r.setAlteranativaD(linha.getString("texto"));
					r.setFlRepostaCertaD(linha.getString("flcorreto"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public void editarResposta(int cdResposta, int cdQuestao, String texto, String flCorreto) {
		String sql = "update tbresposta set texto = ?, flcorreto = ? where cdquestao = ? and cdresposta = ?";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setString(1, texto);
			ps.setString(2, flCorreto);
			ps.setInt(3, cdQuestao);
			ps.setInt(4, cdResposta);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirQuestaoResposta(int idQuestao) {
		String sql = "delete from tbresposta where cdquestao = ?";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setInt(1, idQuestao);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int quantidadeRespostas(){
		int qtRespostas = 0;
		String sql = "select count(*) as quantidade from tbresposta";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ResultSet linha = ps.executeQuery();
			if (linha.next()) {
				qtRespostas = linha.getInt("quantidade");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qtRespostas;
	}
}
