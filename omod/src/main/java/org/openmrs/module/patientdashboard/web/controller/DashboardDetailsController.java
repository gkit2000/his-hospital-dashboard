/**
 *  Copyright 2010 Society for Health Information Systems Programmes, India (HISP India)
 *
 *  This file is part of Patient-dashboard module.
 *
 *  Patient-dashboard module is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.

 *  Patient-dashboard module is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Patient-dashboard module.  If not, see <http://www.gnu.org/licenses/>.
 *
 **/

package org.openmrs.module.patientdashboard.web.controller;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.hospitalcore.HospitalCoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("DashboardDetailsController")
@RequestMapping("/module/patientdashboard/dashboarddetails.htm")
public class DashboardDetailsController {
	
	@SuppressWarnings("deprecation")
	@RequestMapping(method = RequestMethod.GET)
	public String firstView(@RequestParam("identifier") String identifier, Model model) {
		HospitalCoreService hcs = Context.getService(HospitalCoreService.class);
		Patient patient=hcs.getPatientIdentifier(identifier).getPatient();
		model.addAttribute("patient", patient);
		
			return "module/patientdashboard/dashboardDetails";
	}

}
