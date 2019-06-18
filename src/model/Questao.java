package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Questao {

	private Materia materia = new Materia();
	private IntegerProperty idQuestao = new SimpleIntegerProperty(0);
	private StringProperty descricaoQuestao = new SimpleStringProperty("");
	private StringProperty textoQuestao = new SimpleStringProperty("");
	private StringProperty flAtivo = new SimpleStringProperty("");
	
	public final IntegerProperty idQuestaoProperty() {
		return this.idQuestao;
	}
	
	public final int getIdQuestao() {
		return this.idQuestaoProperty().get();
	}
	
	public final void setIdQuestao(final int idQuestao) {
		this.idQuestaoProperty().set(idQuestao);
	}
	
	public final StringProperty textoQuestaoProperty() {
		return this.textoQuestao;
	}
	
	public final String getTextoQuestao() {
		return this.textoQuestaoProperty().get();
	}
	
	public final void setTextoQuestao(final String textoQuestao) {
		this.textoQuestaoProperty().set(textoQuestao);
	}
	public final StringProperty descricaoQuestaoProperty() {
		return this.descricaoQuestao;
	}
	
	public final String getDescricaoQuestao() {
		return this.descricaoQuestaoProperty().get();
	}
	
	public final void setDescricaoQuestao(final String descricaoQuestao) {
		this.descricaoQuestaoProperty().set(descricaoQuestao);
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

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
}
