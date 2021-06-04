package com.springcar.app.controllers;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springcar.app.models.entity.Car;
import com.springcar.app.models.entity.Images;
import com.springcar.app.models.entity.Reservation;
import com.springcar.app.models.entity.TypeTransmission;
import com.springcar.app.models.service.interfaces.ICarService;

@Controller
public class FleetController {

	@Autowired
	ICarService carService;

	@GetMapping("/fleet")
	public String showFleet(HttpSession session, Model model) {

		session.setAttribute("fleet", carService.findAll());
		model.addAttribute("makeList", carService.getAllCarMakes());
		return "fleet/index";
	}

	private Car buildToViewImages(Car car) {

		for (Images image : car.getImages()) {
			String base64 = Base64.getEncoder().encodeToString(image.getPhoto());
			image.setMimetype("data:" + image.getMimetype() + ";base64," + base64);
		}
		return car;
	}

	@GetMapping("/selectCar")
	public String showPeriodSelector(HttpSession session, @ModelAttribute("reservation") Reservation rent,
			@RequestParam("id") Long idCar) {

		Car car = buildToViewImages(carService.findById(idCar));
		session.setAttribute("car", car);
		session.setAttribute("reservation", rent);
		return "redirect:/reservation/dateselection/";
	}

	@PostMapping("/fleet/filter")
	public String filterCarFleet(HttpSession session,
			@RequestParam(name = "transmissionSelection") TypeTransmission transmissionValue,
			@RequestParam(name = "make") String make, @RequestParam(name = "model") String model) {
		
		if (make.split("=").length > 0) {
			make = make.split("=")[0];
		}
		

		List<Car> fleet = carService.findAll();
		List<Car> filteredFleet = new ArrayList<Car>();

		if (!make.isEmpty()) {
			session.setAttribute("make", make);
			for (Car c : fleet) {
				if(c.getMake().equals(make)) {
					filteredFleet.add(c);	
				}
				
			}
			fleet.clear();
			fleet.addAll(filteredFleet);
		} else {
			session.removeAttribute("make");
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

		if (model != null) {
			session.setAttribute("model", model);
			filteredFleet.clear();
			for (Car c : fleet) {
				if (c.getModel().equals(model)) {
					filteredFleet.add(c);
				}
			}
			fleet.clear();
			fleet.addAll(filteredFleet);
		} else {
			session.removeAttribute("model");
		}

		

		session.setAttribute("fleet", filteredFleet);

		return "redirect:/fleet";
	}

}
