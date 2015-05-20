package teil1.allgemeines1.objects;

import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class TerminCommonsLang {

	private final LocalDateTime zeitpunkt;
	private final String beschreibung;

	public TerminCommonsLang(LocalDateTime zeitpunkt, String beschreibung) {
		this.zeitpunkt = zeitpunkt;
		this.beschreibung = beschreibung;
	}

	public String getWert() {
		return beschreibung;
	}

	public LocalDateTime getZeitpunkt() {
		return zeitpunkt;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(zeitpunkt).append(beschreibung).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TerminCommonsLang) {
			TerminCommonsLang that = (TerminCommonsLang) obj;
			return new EqualsBuilder() //
					.append(this.zeitpunkt, that.zeitpunkt) //
					.append(this.beschreibung, that.beschreibung) //
					.isEquals();
		}
		return false;
	}
}
