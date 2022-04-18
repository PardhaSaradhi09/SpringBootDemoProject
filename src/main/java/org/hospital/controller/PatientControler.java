package org.hospital.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hospital.doctors.services.DoctorServices;
import org.hospital.domain.DoctorData;
import org.hospital.domain.PatientData;
import org.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class PatientControler {

	@Autowired
	PatientService service;
	@Autowired
	DoctorServices docService;

	Logger logger = Logger.getLogger(PatientControler.class.getName());

	@GetMapping("/AddPatientServlet")
	public String addPatientFrom(Model uiModel, HttpSession session) {
		String username = (String) session.getAttribute("username");

		if (username == null) {
			uiModel.addAttribute("loginError", "your session is expired. Please reenter your credentials");
			return "index";

		}

		return "AddPatientData";
	}

	@PostMapping("/AddPatientServlet")
	public String addPatient(@Valid @ModelAttribute PatientData patient, Model uiModel, HttpSession session,
			BindingResult result) throws SQLException {
//		String username = (String) session.getAttribute("username");
//
//		if (username == null) {
//			uiModel.addAttribute("loginError", "your session is expired. Please reenter your credentials");
//			return "index";
//
//		}
		if (result.hasErrors()) {
			logger.info("errors");
			uiModel.addAttribute("errors", result.getFieldError());
			return "AddPatientData";
		}
		service.addPatient(patient);
		logger.info("Added Patient data ");
		List<PatientData> patientList = service.getAllPatients();
		uiModel.addAttribute("patientList", patientList);
		return "GetAllPatientss";

	}

	@GetMapping("/EditPatientServlet")
	public String editPatient(String pid, Model uiModel, HttpSession session) {
		String username = (String) session.getAttribute("username");

		if (username == null) {
			uiModel.addAttribute("loginError", "your session is expired. Please reenter your credentials");
			return "index";

		}
		PatientData patient = service.getPatient(Integer.parseInt(pid));
		uiModel.addAttribute("patient", patient);
		return "EditPatientData";

	}

	@GetMapping("/GetPatientServlet")
	public String getAllPatient(Model uiModel, HttpSession session) {
		String username = (String) session.getAttribute("username");

		if (username == null) {
			uiModel.addAttribute("loginError", "your session is expired. Please reenter your credentials");
			return "index";
		}
		List<PatientData> patientList = service.getAllPatients();
		uiModel.addAttribute("patientList", patientList);
		return "GetAllPatientss";

	}

	@PostMapping("/EditPatientServlet")
	public String updatePatientData(PatientData patient, Model uiModel, HttpSession session) {
		String username = (String) session.getAttribute("username");

		if (username == null) {
			uiModel.addAttribute("loginError", "your session is expired. Please reenter your credentials");
			return "index";

		}
		PatientData updatedPatient = service.updatePatientRecord(patient);
		logger.info("updated Patient record: " + updatedPatient);
		List<PatientData> patientList = service.getAllPatients();
		uiModel.addAttribute("patientList", patientList);
		return "GetAllPatientss";

	}

	@GetMapping("/SearchPatient")
	public String searchPatientRecord(String pid, Model uiModel, HttpSession session) {
		String username = (String) session.getAttribute("username");

		if (username == null) {
			uiModel.addAttribute("loginError", "your session is expired. Please reenter your credentials");
			return "index";

		}

		PatientData patient = service.getPatient(Integer.parseInt(pid));
		if (patient == null) {
			return "SearchPatientByPid";
		}
		uiModel.addAttribute("searchPatient", patient);
		return "SearchPatientByPid";
	}

	@GetMapping("/SortPatientList")
	public String sortByAge(Model uiModel, HttpSession session) {
		String username = (String) session.getAttribute("username");

		if (username == null) {
			uiModel.addAttribute("loginError", "your session is expired. Please reenter your credentials");
			return "index";

		}

		List<PatientData> patientList = service.sortByAge();
		uiModel.addAttribute("patientList", patientList);
		return "GetAllPatientss";
	}

	@GetMapping("/ViewServlet")
	public String viewPage(String pid, Model uiModel) {
		List<DoctorData> doctors = docService.getDoctorsByPID(Integer.parseInt(pid));
		System.out.println("list size:" + doctors.size());
		uiModel.addAttribute("doctorList", doctors);
		return "GetAllDoctors";

	}

	@GetMapping("/DeleteServlet")
	public String deletePatientRecord(String pid, Model uiModel, HttpSession session) {
		String username = (String) session.getAttribute("username");

		if (username == null) {
			uiModel.addAttribute("loginError", "your session is expired. Please reenter your credentials");
			return "index";

		}
		service.deletePatient(Integer.parseInt(pid));
		logger.info("From Servlet Deleted Patient record with " + pid + "patient ID");
		List<PatientData> patientList = service.getAllPatients();
		uiModel.addAttribute("patientList", patientList);
		return "GetAllPatientss";

	}

}
