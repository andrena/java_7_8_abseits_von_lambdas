package teil1.allgemeines1.objects;

import java.time.LocalDateTime;

public class TerminEclipseGeneratedEquals {

	private final LocalDateTime zeitpunkt;
	private final String beschreibung;

	public TerminEclipseGeneratedEquals(LocalDateTime zeitpunkt, String beschreibung) {
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beschreibung == null) ? 0 : beschreibung.hashCode());
		result = prime * result + ((zeitpunkt == null) ? 0 : zeitpunkt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TerminEclipseGeneratedEquals other = (TerminEclipseGeneratedEquals) obj;
		if (beschreibung == null) {
			if (other.beschreibung != null)
				return false;
		} else if (!beschreibung.equals(other.beschreibung))
			return false;
		if (zeitpunkt == null) {
			if (other.zeitpunkt != null)
				return false;
		} else if (!zeitpunkt.equals(other.zeitpunkt))
			return false;
		return true;
	}

}
