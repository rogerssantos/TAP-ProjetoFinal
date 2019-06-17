package dao;

import java.sql.PreparedStatement;
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
}
