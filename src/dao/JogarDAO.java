package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
	public int buscaMateriaJogar(int aluno){
		int cdMateria = 0;
		String sql = "select cdmateria from tbalunoacerto";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
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
	
}
