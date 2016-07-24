package com.geolocation.searchTest.model;

public class Place {

	private String nome;
	private Localization localization = new Localization();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Localization getLocalization() {
		return localization;
	}

	public void setLocalization(Localization localization) {
		this.localization = localization;
	}

}
