package com.springcar.app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springcar.app.models.entity.Car;
import com.springcar.app.models.entity.TypeTransmission;
import com.springcar.app.models.service.interfaces.ICarService;

@Controller
public class VehicleSelectionController {

	@Autowired
	ICarService carService;

	@GetMapping("/reservation/vehicleselect")
	public String showVehicleList(HttpSession session, Model model) {

		return "reservation/vehicleselect/index";
	}

	@GetMapping("/reservation/vehicleselect/selectCar")
	public String showPeriodSelector(HttpSession session, @RequestParam("id") Long idCar) {

		session.setAttribute("car", carService.findById(idCar));

		return "redirect:/reservation/extrasconfig";
	}

	

	@PostMapping("/reservation/vehicleselect/filter")
	public String filterCarFleet(HttpSession session, @RequestParam(name = "categorySelection") String categoryValue,
			@RequestParam(name = "transmissionSelection") TypeTransmission transmissionValue,
			@RequestParam(name = "priceOrderSelection") String priceOrderValue) {

		List<Car> fleet = carService.findAll();
		List<Car> filteredFleet = new ArrayList<Car>();

		if (!categoryValue.isEmpty()) {
			session.setAttribute("category", categoryValue);
			for (Car c : fleet) {
				filteredFleet.add(c);
			}
			fleet.clear();
			fleet.addAll(filteredFleet);
		} else {
			session.removeAttribute("category");
		}

		if (transmissionValue != null) {
			session.setAttribute("transmission", transmissionValue.toString());
			filteredFleet.clear();
			for (Car c : fleet) {
				if (c.getTransmission().equals(transmissionValue)) {
					filteredFleet.add(c);
				}
			}
			fleet.clear();
			fleet.addAll(filteredFleet);
		} else {
			session.removeAttribute("transmission");
		}

		if (priceOrderValue != null) {
			session.setAttribute("priceOrder", priceOrderValue);
			if (!fleet.isEmpty()) {
				filteredFleet = Utils.carSort(fleet, priceOrderValue);
			}
		} else {
			session.removeAttribute("priceOrder");
		}

		session.setAttribute("fleet", filteredFleet);

		return "redirect:/reservation/vehicleselect";
	}

}
