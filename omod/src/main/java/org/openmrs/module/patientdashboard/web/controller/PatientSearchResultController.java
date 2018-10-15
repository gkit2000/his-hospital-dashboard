package org.openmrs.module.patientdashboard.web.controller;

import org.openmrs.api.context.Context;
import org.openmrs.module.hospitalcore.HospitalCoreService;
import org.openmrs.module.hospitalcore.model.PatientSearch;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("PatientSearchResultController")
@RequestMapping("/module/patientdashboard/searchPatientByIdentifier.form")
public class PatientSearchResultController {
	@RequestMapping(method = RequestMethod.GET)
	public String firstView(@RequestParam(value = "identifier", required = false) String identifier,Model model){
		HospitalCoreService hcs = Context.getService(HospitalCoreService.class);
		PatientSearch patientSearch=hcs.getPatientSearchByIdentifier(identifier);
		model.addAttribute("patientSearch", patientSearch);
		return "module/patientdashboard/patientsearchresult";
	}
}
