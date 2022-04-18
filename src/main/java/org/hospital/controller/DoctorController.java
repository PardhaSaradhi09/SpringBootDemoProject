package org.hospital.controller;

import java.util.List;
import org.hospital.doctors.services.DoctorServices;
import org.hospital.domain.DoctorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DoctorController {

	@Autowired
	DoctorServices service;
	ModelAndView mv = new ModelAndView();

	@GetMapping("/AddDoctorServlet")
	public String addDoctorForm(String pid, Model uiModel) {
		uiModel.addAttribute("pid", pid);
		return "NewDoctorData";

	}

	@PostMapping("/AddDoctorServlet")
	public String addDoctor(@ModelAttribute DoctorData doctorRecord, Model uiModel) {
		service.addDoctorRecord(doctorRecord);
		List<DoctorData> doctorList = service.getAllDoctorRecords();
		uiModel.addAttribute("doctorList", doctorList);
		return "GetAllDoctors";
	}

	@GetMapping("/GetDoctorServlet")
	public ModelAndView getAllDoctors() {
		List<DoctorData> doctorList = service.getAllDoctorRecords();
		mv.addObject("doctorList", doctorList);
		mv.setViewName("GetAllDoctors");
		return mv;

	}

	@GetMapping("/DeleteDoctorServlet")
	public ModelAndView deleteDoctorRecord(String did) {
		service.deleteDoctorRecord(Integer.parseInt(did));
		List<DoctorData> doctorList = service.getAllDoctorRecords();
		mv.addObject("doctorList", doctorList);
		mv.setViewName("GetAllDoctors");
		return mv;

	}

	@GetMapping("/EditDoctorServlet")
	public ModelAndView editDoctorRecord(String did) {
		DoctorData doctor = service.getDoctorByID(Integer.parseInt(did));
		mv.addObject("doctor", doctor);
		mv.setViewName("EditDoctorData");
		return mv;
	}

	@PostMapping("/EditDoctorServlet")
	public ModelAndView updateDoctorRecord(@ModelAttribute DoctorData doctorRecord) {
		service.updateDoctorData(doctorRecord);
		List<DoctorData> doctorList = service.getAllDoctorRecords();
		mv.addObject("doctorList", doctorList);
		mv.setViewName("GetAllDoctors");
		return mv;
	}

	@GetMapping("/SortDoctorList")
	public ModelAndView sortDoctorList() {
		return mv;

	}

}
