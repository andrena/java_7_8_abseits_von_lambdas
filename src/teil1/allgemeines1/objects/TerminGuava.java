package teil1.allgemeines1.objects;

import java.time.LocalDateTime;

import com.google.common.base.Objects;

public class TerminGuava {

	private final LocalDateTime zeitpunkt;
	private final String beschreibung;

	public TerminGuava(LocalDateTime zeitpunkt, String beschreibung) {
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
		return Objects.hashCode(zeitpunkt, beschreibung);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TerminGuava) {
			TerminGuava that = (TerminGuava) obj;
			return Objects.equal(this.zeitpunkt, that.zeitpunkt) //
					&& Objects.equal(this.beschreibung, that.beschreibung);
		}
		return false;
	}
}
