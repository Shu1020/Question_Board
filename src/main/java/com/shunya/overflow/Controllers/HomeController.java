package com.shunya.overflow.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shunya.overflow.Models.Answer;
import com.shunya.overflow.Models.Question;
import com.shunya.overflow.Services.OverflowService;
import com.shunya.overflow.Validators.TagValidator;

@Controller
public class HomeController {
	@Autowired
	private OverflowService oService;
	@Autowired TagValidator validator;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("allqs", this.oService.getAllQuestions());
		return "dashboard.jsp";
	}
	
	@GetMapping("/new")
	public String newQuest(@ModelAttribute("question") Question question) {
		return  "new.jsp";
	}
	
	@PostMapping("/newQuestion")
	public String addQuest(@Valid @ModelAttribute("question") Question question, BindingResult result) {
		validator.validate(question, result);
		if(result.hasErrors()) {
			return "new.jsp";
		}
		this.oService.createQuestion(question);
		return "redirect:/";
	}
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("answer") Answer answer) {
		viewModel.addAttribute("question", this.oService.findOneQuestion(id));
		return "show.jsp";
	}
	
	@PostMapping("/addAnswer")
	public String addAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("question", this.oService.findOneQuestion(answer.getQuest().getId()));
			return "show.jsp";
		}
		this.oService.createAnswer(answer);
		return "redirect:/show/" + answer.getQuest().getId();
	}
	
}