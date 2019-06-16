package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Jogar {

	private Materia materia = new Materia();
	private StringProperty nmAluno = new SimpleStringProperty("");
	
	public final StringProperty nmAlunoProperty() {
		return this.nmAluno;
	}
	
	public final String getNmAluno() {
		return this.nmAlunoProperty().get();
	}
	
	public final void setNmAluno(final String nmAluno) {
		this.nmAlunoProperty().set(nmAluno);
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
}
