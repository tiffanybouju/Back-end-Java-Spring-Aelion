/**
 * 
 */
package com.aelion.suivi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aelion.suivi.services.SkillsService;

/**
 * @author Aelion
 *
 */
@Controller
public class SkillsController {

	@Autowired
	private SkillsService service;

	public SkillsService getService() {
		return service;
	}

	public void setService(SkillsService service) {
		this.service = service;
	}
}
