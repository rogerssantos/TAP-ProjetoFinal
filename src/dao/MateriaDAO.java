package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Materia;
import util.ConexaoDb;


public class MateriaDAO {

	public void inserirMateria(Materia a) {
		String sql = "insert into tbmateria (nmmateria, flativo) values (?, ?)";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setString(1, a.getNmMateria());
			ps.setString(2, a.getFlAtivo());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Materia> listaMaterias() {
		ArrayList<Materia> materias = new ArrayList<Materia>();
		String sql = "select cdmateria, nmmateria, flativo from tbmateria where flativo = 'S'";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Materia m = new Materia();
				m.setCdMateria(rs.getInt("cdmateria"));
				m.setNmMateria(rs.getString("nmmateria"));
				m.setFlAtivo(rs.getString("flativo"));
				materias.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materias;
	}

	public void atualizaMaterias(Materia a) {
		String sql = "update tbmateria set nmmateria = ?, flativo = ? where cdmateria = ?";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setString(1, a.getNmMateria());
			ps.setString(2, a.getFlAtivo());
			ps.setInt(3, a.getCdMateria());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Materia> filtraMaterias(String filtro) {
		ArrayList<Materia> materias = new ArrayList<Materia>();
		String sql = "select nmmateria from tbmateria where flativo = 'S' and nmmateria like ?";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setString(1, "%" + filtro + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Materia a = new Materia();
				a.setNmMateria(rs.getString("nmmateria"));
				materias.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materias;
	}

	public Materia buscarPorId(int cdmateria){
		Materia m = new Materia();
		String sql = "select cdmateria, nmmateria, flativo from tbmateria where cdmateria = ?";
		try {
			PreparedStatement ps = ConexaoDb.getInstance().prepareStatement(sql);
			ps.setInt(1, cdmateria);
			ResultSet linha = ps.executeQuery();
			if (linha.next()) {
				m.setCdMateria(linha.getInt("cdmateria"));
				m.setNmMateria(linha.getString("nmmateria"));
				m.setFlAtivo(linha.getString("flativo"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
}
