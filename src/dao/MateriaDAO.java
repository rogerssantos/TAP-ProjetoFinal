package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.Constants;
import model.Materia;

public class MateriaDAO {

	public void inserir(Materia a) {
		String sql = "insert into tbmateria (materia) values (?)";
		try {
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ps.setString(1, a.getNome());
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
				m.setNome(rs.getString("nmmateria"));
				materias.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materias;
	}

	public void atualizar(Materia a) {
		String sql = "update tbmateria set nmmateria = ?, status = ? where id = ?";
		try {
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.setString(2, a.getStatus());
			ps.setInt(3, a.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Materia> listaFiltrado(String filtro) {
		ArrayList<Materia> materias = new ArrayList<Materia>();
		String sql = "select nmmateria from tbmateria where status = 'A' and nmmateria like ?";
		try {
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ps.setString(1, "%" + filtro + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Materia a = new Materia();
				a.setNome(rs.getString("nmmateria"));
				materias.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materias;
	}

}
