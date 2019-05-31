package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Professor;
import util.Constants;

public class ProfessorDAO {
	
	public ArrayList<Professor> listaTudo(){
		ArrayList<Professor> professores = new ArrayList<Professor>();
		String sql = "select nmprofessor, dslogin from tbprofessor where flativo = 'S'";
		try{
			PreparedStatement ps = Constants.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Professor p = new Professor();
				p.setNome(rs.getString("nmprofessor"));
				p.setLogin(rs.getString("dslogin"));
				professores.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return professores;
	}
	
}
