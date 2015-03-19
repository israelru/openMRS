/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.basicexample.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.messagesource.MessageSourceService;
import org.openmrs.module.basicexample.openMRSnew;
import org.openmrs.module.basicexample.api.openMRSnewService;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

/**
 * The main controller.
 */
@Controller
public class  openMRSnewManageController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/module/basicexample/manage", method = RequestMethod.GET)
	public void manage(ModelMap model) {
		model.addAttribute("user", Context.getAuthenticatedUser());
	}
	
	@RequestMapping(value = "/module/basicexample/addDepartment", method = RequestMethod.GET)
	public void addDeprt(ModelMap model) {
		model.addAttribute("user", Context.getAuthenticatedUser());
	}
	
	
	@RequestMapping(value = "/module/basicexample/addDepartment.form", method = RequestMethod.POST)
    public String submitDepartment(WebRequest request, HttpSession httpSession, ModelMap model,
                                   @RequestParam(required = false, value = "action") String action,
                                   @ModelAttribute("department") openMRSnew department, BindingResult errors) {
        
        MessageSourceService mss = Context.getMessageSourceService();
        openMRSnewService departmentService = Context.getService(openMRSnewService.class);
        if (!Context.isAuthenticated()) {
            errors.reject("department.auth.required");
        } else if (mss.getMessage("department.purgeDepartment").equals(action)) {
            try {
                departmentService.purgeDepartment(department);
                httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "department.delete.success");
                return "redirect:departmentList.list";
            }
            catch (Exception ex) {
                httpSession.setAttribute(WebConstants.OPENMRS_ERROR_ATTR, "department.delete.failure");
                log.error("Failed to delete department", ex);
                return "redirect:departmentForm.form?departmentId=" + request.getParameter("departmentId");
            }
        } else {
            departmentService.saveDepartment(department);
            httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "department.saved");
        }
        return "redirect:departmentList.list";
    }
	
	
}
