package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Jogar;
import util.ConexaoDb;

public class JogarDAO {

	public void inserirJogo(Jogar j) {
		String sql = "insert into tbalunoacerto (nmaluno, cdmateria, qtacertadas) values (?, ?, ?)";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setString(1, j.getNmAluno());
			ps.setInt(2, j.getMateria().getCdMateria());
			ps.setInt(3, 0);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int buscaMaxAluno(){
		int idMaxAluno = 0;
		String sql = "select max(cdalunoacerto) as cdalunoacerto from tbalunoacerto";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ResultSet linha = ps.executeQuery();
			if(linha.next()) {
				idMaxAluno = (linha.getInt("cdalunoacerto"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idMaxAluno;
	}
	
	public int buscaQtAcertadasDoMaxAluno(int aluno){
		int qtAcertadas = 0;
		String sql = "select qtacertadas from tbalunoacerto where cdalunoacerto=?";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setInt(1, aluno);
			ResultSet linha = ps.executeQuery();
			if(linha.next()) {
				qtAcertadas = (linha.getInt("qtacertadas"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qtAcertadas;
	}
	
	public int buscaMateriaJogar(int cdAluno){
		int cdMateria = 0;
		String sql = "select cdmateria from tbalunoacerto where cdalunoacerto = ?";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setInt(1, cdAluno);
			ResultSet linha = ps.executeQuery();
			if(linha.next()) {
				cdMateria = (linha.getInt("cdMateria"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cdMateria;
	}
	
	public void atualizaPontuacao(int cdAlunoAcerto) {
		String sql = "update tbalunoacerto set qtacertadas = qtacertadas + 1 where cdalunoacerto = ?";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setInt(1, cdAlunoAcerto);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Jogar> buscaRankingPorMateria(int cdMateria) {
		ArrayList<Jogar> jogos = new ArrayList<Jogar>();
		String sql = "select nmaluno, qtacertadas from tbalunoacerto where cdmateria = ? order by qtacertadas desc limit 10";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setInt(1, cdMateria);
			ResultSet linha = ps.executeQuery();
			while (linha.next()) {
				Jogar j = new Jogar();
				j.setNmAluno(linha.getString("nmaluno"));
				j.setQtAcertadas((int) ((linha.getInt("qtacertadas")/5.0)*10.0));
				jogos.add(j);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jogos;
	}
	
}
