package com.harveynash.surveyapp.controller;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.harveynash.surveyapp.model.Survey;
import com.harveynash.surveyapp.service.SurveyManager;

@Controller
public class SurveyManagerController {
    private static final Logger logger = LoggerFactory.getLogger(SurveyManagerController.class);
    
    @Autowired
    private SurveyManager surveyManager;
    
    @RequestMapping(value = "/surveyMngr", method = RequestMethod.GET)
    public String surveyManagerDashboard(Model model) {
        
        logger.info("Survey Dashboard Manager");
        
        List<Survey> surveyList = surveyManager.getSurveyList();
        model.addAttribute("surveylist", surveyList);
        return "surveyMngr";
    }
    
    @RequestMapping(value = "/surveyMngr/surveyAdd", method = RequestMethod.GET)
    public String surveyAddingForm(Model model) {
        logger.info("survey add form");
        return "addSurvey";
    }
    @RequestMapping(value = "/surveyMngr/add", method = RequestMethod.POST)
    public String addSurveyPost(@ModelAttribute("survey") Survey survey) {
        logger.info("adding survey");
        return "redirect:/surveyMngr";
    }
    
    @RequestMapping(value = "/surveyMngr/surveyDel", method = RequestMethod.GET)
    public String surveyDeleting(Model model) {
        logger.info("survey deleting");
        
        return "redirect:/surveyMngr";
    }
    @RequestMapping(value = "/surveyMngr/xml", method = RequestMethod.GET)
    public String addSurveyFromXmlPage( Model model) {
        
        logger.info("show xml import page");
        
        return "xmlSurveyImport";
    }
    
    @RequestMapping(value = "/surveyMngr/xml/add", method = RequestMethod.POST)
    public String addingSurveyFromXml(@RequestParam(value="fileXml", required = false) MultipartFile files) {
        
        logger.info("posting xml survey file");
        
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
        
        surveyManager.createSurvey(survey);
        
        return "redirect:/surveyMngr";
    }
}

