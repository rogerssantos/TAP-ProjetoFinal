package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.Constants;
import model.Materia;

public class MateriaDAO {

	public void inserir(Materia a) {
		String sql = "insert into tbmateria (nmmateria, flativo) values (?, ?)";
		try {
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ps.setString(1, a.getNmMateria());
			ps.setString(2, "S");
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Materia> listaTudo() {
		ArrayList<Materia> materias = new ArrayList<Materia>();
		String sql = "select nmmateria from tbmateria where flativo = 'S'";
		try {
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Materia m = new Materia();
				m.setNmMateria(rs.getString("nmmateria"));
				materias.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materias;
	}

	public void atualizar(Materia a) {
		String sql = "update tbmateria set nmmateria = ?, flativo = ? where cdmateria = ?";
		try {
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ps.setString(1, a.getNmMateria());
			ps.setString(2, a.getFlAtivo());
			System.out.println(a.getCdMateria());
			ps.setInt(3, a.getCdMateria());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Materia> listaFiltrado(String filtro) {
		ArrayList<Materia> materias = new ArrayList<Materia>();
		String sql = "select nmmateria from tbmateria where flativo = 'S' and nmmateria like ?";
		try {
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
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

}
