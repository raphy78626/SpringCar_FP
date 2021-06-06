package com.springcar.app.controllers;

import java.util.List;

import com.springcar.app.models.entity.Car;
import com.springcar.app.models.entity.User;

public class Utils {

	public static boolean isValid(User newClient) {


		if (newClient != null) {
			

			if (!inputIsValid(newClient.getEmail())) {
				return false;
			}


			if (!inputIsValid(newClient.getPassword())) {
				return false;
			}
		}

		return true;
	}

	public static boolean isValidCar(Car car) {

		System.out.println(car.getMake());

		if (car != null) {
			if (!inputIsValid(car.getMake())) {
				return false;
			}

			if (!inputIsValid(car.getModel())) {
				return false;
			}

			if (!validateInt(car.getPrice())) {
				return false;
			}

		}

		return true;
	}

	public static boolean inputIsValid(String input) {
		if (input != null && !input.equals("") && !input.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean validateInt(int input) {
		if (input > 0) {
			return true;
		}
		return false;
	}

	public static List<Car> carSort(List<Car> fleet, String priceOrderValue) {
		int n = fleet.size() - 1;
		int k;

		if (priceOrderValue.equalsIgnoreCase("ASCENDANT")) {
			for (int m = n; m >= 0; m--) {
				for (int i = 0; i < n; i++) {
					k = i + 1;
					/*
					 * if (fleet.get(i).getCategory().getPriceBase() >
					 * fleet.get(k).getCategory().getPriceBase()) { Collections.swap(fleet, i, k); }
					 */
				}
			}
		} else {
			for (int m = n; m >= 0; m--) {
				for (int i = 0; i < n; i++) {
					k = i + 1;
					/*
					 * if (fleet.get(i).getCategory().getPriceBase() <
					 * fleet.get(k).getCategory().getPriceBase()) { Collections.swap(fleet, i, k); }
					 */
				}
			}
		}

		return fleet;
	}

}
