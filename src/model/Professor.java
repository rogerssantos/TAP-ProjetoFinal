package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Professor {
	
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty login = new SimpleStringProperty("");

	public StringProperty nomeProperty() {
		return this.nome;
	}
	
	public String getNome() {
		return this.nomeProperty().get();
	}

	public void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}
	
	public StringProperty loginProperty() {
		return this.login;
	}
	
	public String getLogin() {
		return this.loginProperty().get();
	}

	public void setLogin(final String login) {
		this.loginProperty().set(login);
	}
	
}
