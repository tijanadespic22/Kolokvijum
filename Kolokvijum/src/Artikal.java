import java.io.Serializable;

public class Artikal implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String naziv;
	private int cena;
	private boolean popust;
	private float popustSnizenje;

	public Artikal() {
		super();
	}

	public Artikal(int id, String naziv, int cena, boolean popust, float popustSnizenje) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
		this.popust = popust;
		this.popustSnizenje = popustSnizenje;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public boolean isPopust() {
		return popust;
	}

	public void setPopust(boolean popust) {
		this.popust = popust;
	}

	public float getPopustSnizenje() {
		return popustSnizenje;
	}

	public void setPopustSnizenje(float popustSnizenje) {
		this.popustSnizenje = popustSnizenje;
	}

	@Override
	public String toString() {
		return "Artikal [id=" + id + ", naziv=" + naziv + ", cena=" + cena + ", popust=" + popust + ", popustSnizenje="
				+ popustSnizenje + "]";
	}

}
