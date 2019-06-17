package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	public ArrayList<Resposta> listaRespostas() {
		ArrayList<Resposta> respostas = new ArrayList<Resposta>();
		String sql = "select cdresposta, cdquestao, texto, flcorreto, flativo from tbmateria where flativo = 'S'";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ResultSet linha = ps.executeQuery();
			while (linha.next()) {
				Resposta r = new Resposta();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respostas;
	}
}
