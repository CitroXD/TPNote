package tpnote;

import java.math.BigDecimal;

public class Voyage {
	private Porte entree;
	private Porte sortie;
	private BigDecimal tarif;
	private CompagnieAutoroute autoroute;

	public Voyage(Porte Entree, Porte Sortie, CompagnieAutoroute Comp) {
		this.entree = Entree;
		this.sortie = Sortie;
		this.autoroute = Comp;
		this.tarif = this.autoroute.obtenirTarif(this.entree, this.sortie);
	}

	public Porte getEntree() {
		return entree;
	}

	public void setEntree(Porte entree) {
		this.entree = entree;
	}

	public Porte getSortie() {
		return sortie;
	}

	public void setSortie(Porte sortie) {
		this.sortie = sortie;
	}

	public BigDecimal getTarif() {
		return tarif;
	}

	public void setTarif(BigDecimal tarif) {
		this.tarif = tarif;
	}

	public CompagnieAutoroute getAutoroute() {
		return autoroute;
	}

	public void setAutoroute(CompagnieAutoroute autoroute) {
		this.autoroute = autoroute;
	}
}
