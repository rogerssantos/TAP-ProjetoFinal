package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Jogar;
import util.ConexaoDb;

public class JogarDAO {

	public void inserirJogo(Jogar j) {
		String sql = "insert into tbalunoacerto (nmaluno, cdmateria) values (?, ?)";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setString(1, j.getMateria().cdMateriaProperty()+"");
			ps.setString(2, j.getNmAluno());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int buscaMaxAluno(){
		int idMaxAluno = 0;
		String sql = "select max(cdaluno) as cdcadastro from tbquestao";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ResultSet linha = ps.executeQuery();
			if(linha.next()) {
				idMaxAluno = (linha.getInt("cdaluno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idMaxAluno;
	}
	
}
