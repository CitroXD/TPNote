package tpnote;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CompagnieAutoroute {

	List<Route> routes;
	List<Tarif> tarifs;

	CompagnieAutoroute() {
		routes = new ArrayList<Route>();
		tarifs = new ArrayList<Tarif>();
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	public List<Tarif> getTarifs() {
		return tarifs;
	}

	public void setTarifs(List<Tarif> tarifs) {
		this.tarifs = tarifs;
	}

	/**
	 * Retourne le prix d'un trajet entre les portes Entree et Sortie. Fait appel aux méthodes getTarifExact et getTarifCalcule
	 * @param Entree
	 * @param Sortie
	 * @return
	 */
	public BigDecimal obtenirTarif(Porte Entree, Porte Sortie) {
		Tarif tarif = null;
		tarif = getTarifExact(Entree, Sortie);
		if (tarif == null) {
			tarif = getTarifCalcule(Entree, Sortie);
		}
		return tarif.getPrix();
	}
	
	/**
	 * Calcule et retourne le tarif associé à un trajet entre les portes Entree et Sortie en le calculant
	 * Ajoute aussi le nouveau tarif à la liste des tarifs connus
	 * @param Entree 
	 * @param Sortie
	 * @return
	 */

	public Tarif getTarifCalcule(Porte Entree, Porte Sortie) {
		Tarif Calc;
		BigDecimal prix = new BigDecimal(0);

		// for (int i = Entree.getNumero(); i < Sortie.getNumero(); i++) {
		// prix = prix.add(getTarifExact(new Porte(i), new Porte(i + 1)).getPrix());

		for (Tarif t : this.tarifs) {
			if ((t.getEntree().getNumero() >= Entree.getNumero()) && t.getSortie().getNumero() <= Sortie.getNumero()) {
				prix=prix.add(t.getPrix());
			}
		}
		Calc = new Tarif(Entree, Sortie, prix);
		tarifs.add(Calc);
		return (Calc);
	}
/**
 * Retourne le tarif entre les deux portes s'il existe déja dans la liste des tarifs
 * @param Entree
 * @param Sortie
 * @return
 */
	public Tarif getTarifExact(Porte Entree, Porte Sortie) {
		Tarif trouve = null;
		for (Tarif t : tarifs) {
			if (t.getEntree().equals(Entree)&&(t.getSortie().equals(Sortie))){
					trouve = t;
				}
			}
		return (trouve);
	}

	void ajouterTarif(Tarif t) {
		this.tarifs.add(t);
	}

	void ajouterRoute(Route r) {
		this.routes.add(r);
	}
}
