package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Jogar {

	private IntegerProperty cdMateria = new SimpleIntegerProperty(0);
	private StringProperty nmAluno = new SimpleStringProperty("");
	private IntegerProperty qtAcertadas = new SimpleIntegerProperty(0);
	
	public final StringProperty nmAlunoProperty() {
		return this.nmAluno;
	}
	
	public final String getNmAluno() {
		return this.nmAlunoProperty().get();
	}
	
	public final void setNmAluno(final String nmAluno) {
		this.nmAlunoProperty().set(nmAluno);
	}

	public final IntegerProperty cdMateriaProperty() {
		return this.cdMateria;
	}

	public final int getCdMateria() {
		return this.cdMateriaProperty().get();
	}
	
	public final void setCdMateria(final int cdMateria) {
		this.cdMateriaProperty().set(cdMateria);
	}

	public final IntegerProperty qtAcertadasProperty() {
		return this.qtAcertadas;
	}

	public final int getQtAcertadas() {
		return this.qtAcertadasProperty().get();
	}
	
	public final void setQtAcertadas(final int qtAcertadas) {
		this.qtAcertadasProperty().set(qtAcertadas);
	}
	
}
