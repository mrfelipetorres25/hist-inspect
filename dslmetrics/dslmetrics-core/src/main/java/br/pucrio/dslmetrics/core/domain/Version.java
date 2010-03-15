package br.pucrio.dslmetrics.core.domain;

public class Version implements Comparable<Version> {

	private Integer number;

	private String name;

	public Version() {

	}
	
	public Version(Integer number, String name) {
		this.number = number;
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Version o) {
		return this.number - o.number;
	}
}
