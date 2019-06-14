package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Resposta {

	
	private StringProperty alteranativaA = new SimpleStringProperty("");
	private StringProperty alteranativaB = new SimpleStringProperty("");
	private StringProperty alteranativaC = new SimpleStringProperty("");
	private StringProperty alteranativaD = new SimpleStringProperty("");
	private StringProperty flRepostaCertaA = new SimpleStringProperty("");
	private StringProperty flRepostaCertaB = new SimpleStringProperty("");
	private StringProperty flRepostaCertaC = new SimpleStringProperty("");
	private StringProperty flRepostaCertaD = new SimpleStringProperty("");
	
	public final StringProperty alteranativaAProperty() {
		return this.alteranativaA;
	}
	
	public final String getAlteranativaA() {
		return this.alteranativaAProperty().get();
	}
	
	public final void setAlteranativaA(final String alteranativaA) {
		this.alteranativaAProperty().set(alteranativaA);
	}
	
	public final StringProperty alteranativaBProperty() {
		return this.alteranativaB;
	}
	
	public final String getAlteranativaB() {
		return this.alteranativaBProperty().get();
	}
	
	public final void setAlteranativaB(final String alteranativaB) {
		this.alteranativaBProperty().set(alteranativaB);
	}
	
	public final StringProperty alteranativaCProperty() {
		return this.alteranativaC;
	}
	
	public final String getAlteranativaC() {
		return this.alteranativaCProperty().get();
	}
	
	public final void setAlteranativaC(final String alteranativaC) {
		this.alteranativaCProperty().set(alteranativaC);
	}
	
	public final StringProperty alteranativaDProperty() {
		return this.alteranativaD;
	}
	
	public final String getAlteranativaD() {
		return this.alteranativaDProperty().get();
	}
	
	public final void setAlteranativaD(final String alteranativaD) {
		this.alteranativaDProperty().set(alteranativaD);
	}

	public final StringProperty flRepostaCertaAProperty() {
		return this.flRepostaCertaA;
	}
	

	public final String getFlRepostaCertaA() {
		return this.flRepostaCertaAProperty().get();
	}
	

	public final void setFlRepostaCertaA(final String flRepostaCertaA) {
		this.flRepostaCertaAProperty().set(flRepostaCertaA);
	}
	

	public final StringProperty flRepostaCertaBProperty() {
		return this.flRepostaCertaB;
	}
	

	public final String getFlRepostaCertaB() {
		return this.flRepostaCertaBProperty().get();
	}
	

	public final void setFlRepostaCertaB(final String flRepostaCertaB) {
		this.flRepostaCertaBProperty().set(flRepostaCertaB);
	}
	

	public final StringProperty flRepostaCertaCProperty() {
		return this.flRepostaCertaC;
	}
	

	public final String getFlRepostaCertaC() {
		return this.flRepostaCertaCProperty().get();
	}
	

	public final void setFlRepostaCertaC(final String flRepostaCertaC) {
		this.flRepostaCertaCProperty().set(flRepostaCertaC);
	}
	

	public final StringProperty flRepostaCertaDProperty() {
		return this.flRepostaCertaD;
	}
	

	public final String getFlRepostaCertaD() {
		return this.flRepostaCertaDProperty().get();
	}
	

	public final void setFlRepostaCertaD(final String flRepostaCertaD) {
		this.flRepostaCertaDProperty().set(flRepostaCertaD);
	}
	
	
}
