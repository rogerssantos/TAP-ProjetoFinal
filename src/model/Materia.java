package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Materia {
	
	private IntegerProperty cdMateria = new SimpleIntegerProperty(0);
	private StringProperty nmMateria = new SimpleStringProperty("");
	private StringProperty flAtivo = new SimpleStringProperty("");

	@Override
	public String toString() {
		return getNmMateria();
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
	

	public final StringProperty nmMateriaProperty() {
		return this.nmMateria;
	}
	

	public final String getNmMateria() {
		return this.nmMateriaProperty().get();
	}
	

	public final void setNmMateria(final String nmMateria) {
		this.nmMateriaProperty().set(nmMateria);
	}
	

	public final StringProperty flAtivoProperty() {
		return this.flAtivo;
	}
	

	public final String getFlAtivo() {
		return this.flAtivoProperty().get();
	}
	

	public final void setFlAtivo(final String flAtivo) {
		this.flAtivoProperty().set(flAtivo);
	}
	
}
