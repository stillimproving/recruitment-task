package main;

import java.util.Scanner;

public class TestingAddress {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String street;
		int buildingNumber;
		String postalCode;
		String city;

		System.out.print("Enter street name: ");
		street = scan.nextLine();
		System.out.print("Enter house number: ");
		buildingNumber = Integer.parseInt(scan.nextLine());
		System.out.print("Enter postal code: ");
		postalCode = scan.nextLine();
		System.out.print("Enter city name: ");
		city = scan.nextLine();

		scan.close();

		try {
			Address address = new Address(street, buildingNumber, postalCode, city);
			System.out.println("\n" + address.getStreet() + " " + address.getBuildingNumber() + "\n"
					+ address.getPostalCode() + " " + address.getCity());
		} catch (Exception e) {
			System.err.println("Wrong address data, please try again.");
			e.printStackTrace();
		}
	}
}
