package teil1.allgemeines1.objects;

import java.time.LocalDateTime;
import java.util.Objects;

public class TerminJava7 {

	private final LocalDateTime zeitpunkt;
	private final String beschreibung;

	public TerminJava7(LocalDateTime zeitpunkt, String beschreibung) {
		this.zeitpunkt = zeitpunkt;
		this.beschreibung = beschreibung;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public LocalDateTime getZeitpunkt() {
		return zeitpunkt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(zeitpunkt, beschreibung);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TerminJava7) {
			TerminJava7 that = (TerminJava7) obj;
			return Objects.equals(this.zeitpunkt, that.zeitpunkt)//
					&& Objects.equals(this.beschreibung, that.beschreibung);
		}
		return false;
	}
}
