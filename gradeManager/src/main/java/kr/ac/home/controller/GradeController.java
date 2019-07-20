package kr.ac.home.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.home.model.Grade;
import kr.ac.home.service.GradeService;


@Controller
public class GradeController {
	@Autowired
	private GradeService gradeService;
	/*
	@RequestMapping("/grades")
	public String showGrades(Model model) {
		List<Grade> grades = gradeService.getCurrent();
		model.addAttribute("grades", grades);
		
		return "grades";
	}*/
	
	@RequestMapping("/lecture2019")
	public String showlecture2019(Model model) {
		List<Grade> grades = gradeService.getGrade2019();
		model.addAttribute("grades", grades);
		
		return "lecture2019";
	}
	@RequestMapping("/semesterView")
	public String showSemester(Model model) {
		List<Grade> grades = gradeService.getCurrent();
		model.addAttribute("grades", grades);
		
		return "semesterView";
	}
	
	@RequestMapping("/grades")
	public String showGrades(Model model) {
		List<Grade> grades = gradeService.getYears();
		model.addAttribute("grades", grades);
		
		return "grades";
	}
	
	@RequestMapping("/creategrade")
	public String createOffer(Model model) {
		
		model.addAttribute("grade", new Grade());
		
		return "creategrade";
	}
	
	@RequestMapping("/docreate")
	public String doCreate(Model model, @Valid Grade grade, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("===Form data does not Validated");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "creategrade";
		}
		
		gradeService.insert(grade);
		return "gradecreated";
	}
}
