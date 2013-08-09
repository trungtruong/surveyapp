package com.harveynash.surveyapp.controller;

import java.io.IOException;
import java.security.Provider.Service;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.harveynash.surveyapp.model.Survey;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
	    return "redirect:/xml";
	}
	
	@RequestMapping(value = "/xml", method = RequestMethod.GET)
	public String showXmlPage(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/xml/add", method = RequestMethod.POST)
	public String addXmlFromForm(@RequestParam(value="fileXml", required = false) MultipartFile files) {
	    Survey survey = new Survey();
	    try {
            JAXBContext context = JAXBContext.newInstance(Survey.class);
            survey = (Survey) context.createUnmarshaller().unmarshal(files.getInputStream());
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
	    
	    return "redirect:/xml";
	}

}
