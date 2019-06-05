package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Materia {
	
	private SimpleIntegerProperty cdMateria = new SimpleIntegerProperty(0);
	private StringProperty nmMateria = new SimpleStringProperty("");
	private StringProperty flAtivo = new SimpleStringProperty("");

	@Override
	public String toString() {
		return getCdMateria()+" - "+getNmMateria();
	}

	public SimpleIntegerProperty cdMateriaProperty() {
		return this.cdMateria;
	}
	
	public int getCdMateria() {
		return this.cdMateriaProperty().get();
	}

	public void setCdMateria(int cdMateria) {
		this.cdMateriaProperty().set(cdMateria);
	}
	
	public StringProperty nmMateriaProperty() {
		return this.nmMateria;
	}
	
	public String getNmMateria() {
		return this.nmMateriaProperty().get();
	}

	public void setNmMateria(final String nmMateria) {
		this.nmMateriaProperty().set(nmMateria);
	}

	public StringProperty flAtivoProperty() {
		return this.flAtivo;
	}
	
	public String getFlAtivo() {
		return this.flAtivoProperty().get();
	}

	public void setFlAtivo(final String flAtivo) {
		this.flAtivoProperty().set(flAtivo);
	}
	
}
