package io03_serializable;

import java.io.Serializable;

public class Teilnehmer implements Serializable {

	/**
	 * Generierte serialVersionUID
	 */
	//private static final long serialVersionUID = -9040252416340073389L;
	//private static final long serialVersionUID = -9040252416340073389L;
	//private static final long serialVersionUID = 7266342928359092458L;
	
	/**
	 * Teilnehmer Version 1
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String vorname;
//	private int alter;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Teilnehmer() {
		this("", "");
	}

	public Teilnehmer(String name, String vorname) {
		this.setName(name);
		this.setVorname(vorname);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
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
		Teilnehmer other = (Teilnehmer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Teilnehmer [getName()=" + getName() + ", getVorname()=" + getVorname()
				+ "]";
	}

}
