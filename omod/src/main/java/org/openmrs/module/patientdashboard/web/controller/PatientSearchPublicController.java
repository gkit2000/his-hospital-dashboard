package org.openmrs.module.patientdashboard.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("PatientSearchPublicController")
@RequestMapping("/module/patientdashboard/patientSearchPublic.htm")
public class PatientSearchPublicController {
	@RequestMapping(method = RequestMethod.GET)
	public String firstView(){
		return "module/patientdashboard/patientsearchpublic";
	}
}
