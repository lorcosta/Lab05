package it.polito.tdp.anagrammi.model;

import java.util.List;
import java.util.Map;

public class Model {
	RicercaAnagrammi ricerca=new RicercaAnagrammi();
	
	public Map<String,String> cercaAnagrammi(String parola){
		return ricerca.trovaAnagrammi(parola);
	}
}
