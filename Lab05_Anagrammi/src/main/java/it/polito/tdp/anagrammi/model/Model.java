package it.polito.tdp.anagrammi.model;

import java.util.List;

public class Model {
	RicercaAnagrammi ricerca=new RicercaAnagrammi();
	
	public List<String> cercaAnagrammi(String parola){
		return ricerca.trovaAnagrammi(parola);
	}
}
