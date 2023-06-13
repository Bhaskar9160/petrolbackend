package com.akhm.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.akhm.repository.model.CompanyModel;
import com.akhm.repository.model.DispenserModel;
import com.akhm.repository.model.LocationModel;
import com.akhm.repository.model.PriceModel;
import com.akhm.repository.model.StationModel;
import com.akhm.repository.model.TankModel;
import com.akhm.repository.model.UserModel;
import com.akhm.service.CompanyService;
import com.akhm.service.DispenserService;
import com.akhm.service.LocationService;
import com.akhm.service.PriceService;
import com.akhm.service.StationService;
import com.akhm.service.TankService;
import com.akhm.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private DispenserService dispenserService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private StationService stationService;
	@Autowired
	private TankService tankService;
	@Autowired
	private UserService userService;
	@Autowired
	private PriceService priceService;
	
	@GetMapping("/reg")
	public String showRegistration() {

		return "registration";
	}

	@PostMapping("/reg")
	public String registration(CompanyModel companyModel) {
		log.info("In CompanyController .. registration started");
		CompanyModel companyModel2 = companyService.insertCompany(companyModel);
		log.info("In CompanyController .. registration successfully completed");
		return "redirect:login";
	}

	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}

	@PostMapping("/log")
	public String login(CompanyModel companyModel, HttpServletRequest request) {
		log.info("In CompanyController .. login() started");
		CompanyModel company = companyService.getCompany(companyModel.getCompanyContactEmailId(), companyModel.getPassword());
		System.out.println("user details are " + company);
		log.info("In CompanyController .. login successfully completed");
		System.out.println(company != null);
		if (company != null) {

			HttpSession session = request.getSession();
			System.out.println("If");
			session.setAttribute("AUTH_COMPANY", company);
			return "redirect:companyhome";
		} else {
			return "redirect:login?errorMessage=Invaid emailId or password";
		}

	}

	@GetMapping("/companyhome")
	public String companyHome(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {

			CompanyModel company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			System.out.println("AUTH_COMPANY" + company);
			if (company != null) {

				return "companyhome";
			}
		}
		return "redirect:login";
	}

	@GetMapping("/logout")
	public String logOut(HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:login";
	}

	@GetMapping("/changepassword")
	public String showChangePassword(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			CompanyModel auth_company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (auth_company != null) {
				return "changepassword";
			}
		}
		return "redirect:login";
	}

	@PostMapping("/changepassword")
	public String changePassword(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			CompanyModel auth_company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (auth_company != null) {
				String oldPassword = request.getParameter("oldPassword");
				String newPassword = request.getParameter("newPassword");
				String confirmPassword = request.getParameter("confirmPassword");
				if (oldPassword.equals(auth_company.getPassword()) && newPassword.equals(confirmPassword)) {
					auth_company.setPassword(newPassword);
					companyService.updateCompany(auth_company);
				}
				return "redirect:companyhome";
			}
		}
		return "redirect:login";

	}
	@GetMapping("/editcompany")
	public String showEditCompany(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			CompanyModel auth_company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (auth_company != null) {
				return "editcompany";
			}
		}
		return "redirect:login";
	}

	@PostMapping("/editcompany")
	public String updateCompany(HttpServletRequest request, CompanyModel companyModel) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			CompanyModel auth_company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (auth_company != null) {
				companyService.updateCompany(auth_company);
				return "redirect:editcompany";
			}
		}
		return "redirect:login";
	}
	

	
	@GetMapping("/companies")
	public String companies(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			CompanyModel company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (company != null) {
				List<CompanyModel> companies=companyService.getAllCompanies();
				
				
				
				return "companies";

			}

		}

		return "login";
	}
	
	@GetMapping("/adduser")
	public String showAddUser() {

		return "adduser";
	}

	
	@PostMapping("/adduser")
	public String addUser(UserModel userModel, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			CompanyModel company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (company != null) {

				userModel.setUserCreatedBy(company.getCompanyName());
				
				userModel.setUserCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
				
				
				userService.insertUser(userModel);
				return "redirect:show?companyId="+request.getParameter("companyId");
			}
			return "redirect:login";

		}

		return "login";
	}
	

	@GetMapping("/edituser")
	public String showEditUser(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			CompanyModel auth_company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (auth_company != null) {
				return "edituser";
			}
		}
		return "redirect:login";
	}

	@PostMapping("/edituser")
	public String updateUser(HttpServletRequest request, UserModel userModel) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			CompanyModel auth_company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (auth_company != null) {
				userService.updateUser(userModel);
				return "redirect:edituser";
			}
		}
		return "redirect:login";
	}
	
	
	@GetMapping("/users")
	public String showUsers(HttpServletRequest request,UserModel userModel) {
		HttpSession session = request.getSession();
		if (session != null) {
			CompanyModel company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (company != null) {
				List<UserModel> users=userService.getAllUsers();
				
				
				
				return "users";

			}

		}

		return "login";
	}
	
	@GetMapping("/addStation")
	public String showAddStation() {

		return "addstation";
	}
	
	@PostMapping("/addstation")
	public String addStation(StationModel stationModel, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			CompanyModel company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (company != null) {

				stationModel.setStationCreatedBy(company.getCompanyName());
				
				stationModel.setStationCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
				
				
				stationService.insertStation(stationModel);
				return "redirect:show?companyId="+request.getParameter("companyId");
			}
			return "redirect:login";

		}

		return "login";
	}
	
	
	@GetMapping("/editstation")
	public String showEditStation(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			CompanyModel auth_company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (auth_company != null) {
				return "editstation";
			}
		}
		return "redirect:login";
	}

	@PostMapping("/editstation")
	public String updateStation(HttpServletRequest request, StationModel stationModel) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			CompanyModel auth_company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (auth_company != null) {
				stationModel.setStationUpdatedBy(auth_company.getCompanyName());
				stationModel.setStationUpdatedOn(new java.sql.Date(new java.util.Date().getTime()));
				stationService.updateStation(stationModel);
				return "redirect:editstation";
			}
		}
		return "redirect:login";
	}

	@GetMapping("/stations")
	public String showStations(HttpServletRequest request,StationModel stationModel) {
		HttpSession session = request.getSession();
		if (session != null) {
			CompanyModel company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (company != null) {
				List<StationModel> stations=stationService.getAllStations();
				
				
				
				return "stations";

			}

		}

		return "login";
	}

	
	@GetMapping("/addPrice")
	public String showAddPrice() {

		return "addprice";
	}
	
	@PostMapping("/addprice")
	public String addPrice(PriceModel priceModel, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			CompanyModel company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (company != null) {

				priceModel.setPriceCreatedBy(company.getCompanyName());
				
				priceModel.setPriceCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
				
				
				priceService.insertPrice(priceModel);
				return "redirect:show?companyId="+request.getParameter("companyId");
			}
			return "redirect:login";

		}

		return "login";
	}
	
	
	@GetMapping("/editprice")
	public String showEditPrice(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			CompanyModel auth_company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (auth_company != null) {
				return "editprice";
			}
		}
		return "redirect:login";
	}

	@PostMapping("/editprice")
	public String updatePrice(HttpServletRequest request, PriceModel priceModel) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			CompanyModel auth_company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (auth_company != null) {
				priceModel.setPriceUpdatedBy(auth_company.getCompanyName());
				priceModel.setPriceUpdatedOn(new java.sql.Date(new java.util.Date().getTime()));
				priceService.updatePrice(priceModel);
				return "redirect:editstation";
			}
		}
		return "redirect:login";
	}

	@GetMapping("/prices")
	public String showPrices(HttpServletRequest request,StationModel stationModel) {
		HttpSession session = request.getSession();
		if (session != null) {
			CompanyModel company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			
			if (company != null) {
				List<PriceModel> prices=priceService.getAllPrices();
				
				
				
				return "stations";

			}

		}

		return "login";
	}


	@GetMapping("/addlocation")
	public String showAddLocation() {

		return "addLocation";
	}

	
	@PostMapping("/addlocation")
	public String addLocation(LocationModel locationModel, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			CompanyModel company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (company != null) {

				locationModel.setLocationCreatedBy(company.getCompanyName());
				
				locationModel.setLocationCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
				
				
				locationService.insertLocation(locationModel);
				return "redirect:show?companyId="+request.getParameter("companyId");
			}
			return "redirect:login";

		}

		return "login";
	}
	

	@GetMapping("/editlocation")
	public String showEditLocation(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			CompanyModel auth_company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (auth_company != null) {
				return "editlocation";
			}
		}
		return "redirect:login";
	}

	@PostMapping("/editlocation")
	public String updateLoation(HttpServletRequest request, LocationModel locationModel) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			CompanyModel auth_company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (auth_company != null) {
				locationModel.setLocationUpdatedBy(auth_company.getCompanyName());
				locationModel.setLocationUpdatedOn(new java.sql.Date(new java.util.Date().getTime()));
				locationService.updateLocation(locationModel);
				return "redirect:editlocation";
			}
		}
		return "redirect:login";
	}

	@GetMapping("/locations")
	public String showLocations(HttpServletRequest request,LocationModel locationModel) {
		HttpSession session = request.getSession();
		if (session != null) {
			CompanyModel company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (company != null) {
				List<LocationModel> locations=locationService.getAllLocations();
				
				
				
				return "locations";

			}

		}

		return "login";
	}



	@GetMapping("/addtank")
	public String showAddTank() {

		return "addTank";
	}

	
	@PostMapping("/addtank")
	public String addTank(TankModel tankModel, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			CompanyModel company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (company != null) {

				tankModel.setTankCreatedBy(company.getCompanyName());
				
				tankModel.setTankCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
				
				
				tankService.insertTank(tankModel);
				return "redirect:show?companyId="+request.getParameter("companyId");
			}
			return "redirect:login";

		}

		return "login";
	}


	@GetMapping("/edittank")
	public String showEditTank(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			CompanyModel auth_company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (auth_company != null) {
				return "edittank";
			}
		}
		return "redirect:login";
	}

	@PostMapping("/edittank")
	public String updateTank(HttpServletRequest request, TankModel tankModel) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			CompanyModel auth_company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (auth_company != null) {
				tankModel.setTankUpdatedBy(auth_company.getCompanyName());
				tankModel.setTankUpdatedOn(new java.sql.Date(new java.util.Date().getTime()));
				tankService.updateTank(tankModel);
				return "redirect:edittank";
			}
		}
		return "redirect:login";
	}

	@GetMapping("/tanks")
	public String showTanks(HttpServletRequest request,TankModel tankModel) {
		HttpSession session = request.getSession();
		if (session != null) {
			CompanyModel company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (company != null) {
				List<TankModel> tanks=tankService.getAllTanks();
				
				
				
				return "tanks";

			}

		}

		return "login";
	}



	@GetMapping("/adddispenser")
	public String showAddDispenser() {

		return "addDispenser";
	}

	
	@PostMapping("/adddispenser")
	public String addDispenser(DispenserModel dispenserModel, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			CompanyModel company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (company != null) {

				dispenserModel.setDispenserCreatedBy(company.getCompanyName());
				
				dispenserModel.setDispenserCreatedOn(new java.sql.Date(new java.util.Date().getTime()));
				
				
				dispenserService.insertDispenser(dispenserModel);
				return "redirect:show?companyId="+request.getParameter("companyId");
			}
			return "redirect:login";

		}

		return "login";
	}
	

	@GetMapping("/editdispenser")
	public String showEditDispenser(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			CompanyModel auth_company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (auth_company != null) {
				return "editdispenser";
			}
		}
		return "redirect:login";
	}

	@PostMapping("/editdispenser")
	public String updateDispenser(HttpServletRequest request, DispenserModel dispenserModel) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			CompanyModel auth_company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (auth_company != null) {
				dispenserModel.setDispenserUpdatedBy(auth_company.getCompanyName());
				dispenserModel.setDispenserUpdatedOn(new java.sql.Date(new java.util.Date().getTime()));
				dispenserService.updateDispenser(dispenserModel);
				return "redirect:editdispenser";
			}
		}
		return "redirect:login";
	}

	@GetMapping("/dispensers")
	public String showDispensers(HttpServletRequest request,DispenserModel dispenserModel) {
		HttpSession session = request.getSession();
		if (session != null) {
			CompanyModel company = (CompanyModel) session.getAttribute("AUTH_COMPANY");
			if (company != null) {
				List<DispenserModel> dispensers=dispenserService.getAllDispensers();
				
				
				
				return "dispensers";

			}

		}

		return "login";
	}


		
}