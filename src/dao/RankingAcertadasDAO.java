package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Jogar;
import util.ConexaoDb;

public class RankingAcertadasDAO {

	public Jogar[] buscaRankingPorMateria(int cdMateria){
		String sql = "select nmaluno, qtacertadas from tbalunoacerto where cdmateria = ? order by qtacertadas desc limit 10";
		Jogar[] jogar = new Jogar[10];
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setInt(1, cdMateria);
			ResultSet linha = ps.executeQuery();
			int count = 0;
			while (linha.next()) {
				Jogar j = new Jogar();
				j.setNmAluno(linha.getString("nmaluno"));
				j.setQtAcertadas((int) ((linha.getInt("qtacertadas")/5.0)*10.0));
				jogar[count] = j;
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jogar;
	}
		
}
