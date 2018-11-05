package main;

public class Address {

	/*
	 * Zaprojektuj encje(klasę) przechowującą dane adresowe (numer budynku, ulicę ,
	 * miasto, kod pocztowy) oraz napisz walidację ich poprawności sprawdzającą czy:
	 * - numer budynku jest większy od 0 - kod pocztowy jest w formacie dd-ddd -
	 * miasto jest zapisane z wielkiej litery Wszystkie pola w klasie są wymagane.
	 */

	private String street;
	private int buildingNumber;
	private String postalCode;
	private String city;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(int buildingNumber) {
		if (Address.validBuildingNumber(buildingNumber)) {
			this.buildingNumber = buildingNumber;
		} else {
			throw new NumberFormatException("Building number should be a number greater than zero.");
		}
	}

	public static boolean validBuildingNumber(int buildingNumber) {
		return (buildingNumber > 0);
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		if (Address.validPostalCode(postalCode)) {
			this.postalCode = postalCode;
		} else {
			throw new IllegalArgumentException("Wrong format of postal code.");
		}
	}

	public static boolean validPostalCode(String postalCode) {
		return postalCode.matches("\\d\\d-\\d\\d\\d");
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		if (Address.validCity(city)) {
			this.city = city;
		} else {
			throw new IllegalArgumentException("Wrong city name.");
		}
	}

	public static boolean validCity(String city) {
		String patternPart = "[A-ZĆŁÓŚŹŻ][a-ząćęłńóśźż]+";
		return city.matches("^" + patternPart + "(( |-)" + patternPart + ")*( nad " + patternPart + ")?"); // matches to all polish cities
	}

	public Address(String street, int buildingNumber, String postalCode, String city) {
		this.setStreet(street);
		this.setBuildingNumber(buildingNumber);
		this.setPostalCode(postalCode);
		this.setCity(city);
	}
}
