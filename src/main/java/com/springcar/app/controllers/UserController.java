package com.springcar.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springcar.app.controllers.beans.LoginBean;
import com.springcar.app.models.entity.Car;
import com.springcar.app.models.entity.CarMake;
import com.springcar.app.models.entity.Images;
import com.springcar.app.models.entity.User;
import com.springcar.app.models.service.UserService;
import com.springcar.app.models.service.interfaces.ICarImagesService;
import com.springcar.app.models.service.interfaces.ICarService;

@Controller
public class UserController {

	@Autowired
	UserService clientService;
	@Autowired
	ICarService carService;
	
	@Autowired
	ICarImagesService carImagesService;

	@GetMapping("/user/login")
	public String showLoginForm(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/user/login/index";
	}

	@PostMapping("/user/login")
	public String loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") LoginBean login, HttpSession session) {

		Optional<User> userOption = clientService.findByUserName(login.getUserName());

		if (userOption.isPresent() && userOption.get().getPassword().equals(login.getPassword())) {
			session.setAttribute("client", userOption.get());
		} else {
			session.setAttribute("error_userAuthentification", "Username or password is wrong!");
			return "user/login/index";
		}
		return "redirect:/";
	}

	@GetMapping("/user/addcars")
	public String showAddCars(HttpServletRequest request, HttpServletResponse response, Model model) {
		Car car = new Car();

		HttpSession session = request.getSession(true);
		model.addAttribute("makeList", carService.getAllCarMakes());
		session.setAttribute("tempCar", car);
		return "user/addcars/index";
	}

	private void buildFileObjects(MultipartFile[] files, Long vehicleId) {

		try {
			List<Images> storedFile = new ArrayList<>();

			for (MultipartFile file : files) {
				// update new contents
				Images images = new Images();
				images.setMimetype(file.getContentType());
				images.setPhoto(file.getBytes());
				images.setIdCar(vehicleId.intValue());
				storedFile.add(images);
				
			}

			// Save all Files to database
			carImagesService.save(storedFile);

		} catch (Exception e) {
		}
	}

	@PostMapping("/user/addcars")
	public String registerProcess(HttpSession session, @ModelAttribute("car") Car car,
			@RequestParam("files") MultipartFile[] files) {

		if (car.getMake().split("=").length > 0) {
			car.setMake(car.getMake().split("=")[0]);
		}

		CarMake carMake = carService.findByMake(car.getMake(), car.getModel());
		car.setMakeId(carMake.getMakeId());

		

		if (Utils.isValidCar(car)) {

			carService.save(car);
			buildFileObjects(files, car.getIdCar());

		} else {
			session.setAttribute("errorMessage", "Sorry, make sure to fill all the fields before continue");
			return "user/addcars/index";

		}
		session.setAttribute("car", car);
		session.removeAttribute("tempCar");
		return "redirect:/";
	}

	@RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("/user/registration/index");
        return modelAndView;
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {

        if (clientService.findByEmail(user.getEmail()).isPresent()) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (clientService.findByUserName(user.getUserName()).isPresent()) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "There is already a user registered with the username provided");
        }

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/user/registration");
        } else {
            // Registration successful, save user
            // Set user role to USER and set it as active
        	clientService.saveUser(user);

            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("/user/registration");
        }
        return modelAndView;
    }

	public boolean exists(User client) {
		if (clientService.findByUserName(client.getUserName()) != null) {
			return true;
		}
		return false;
	}
}
