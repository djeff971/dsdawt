package menu;

import java.util.HashMap;
import java.util.List;

public class BusinessLogic {
	private List<String> message;
	private HashMap donnees;
	
	public List<String> getMessage() {
		return this.message;
	}
	public void setMessage(List<String> list){
		this.message = list;
	}
	
	public HashMap<String, List<String>> getDonnees() {
		return this.donnees;
	}
	public void setDonnees(HashMap<String, List<String>> donnees) {
		this.donnees = donnees;
	}
}
