package com.zubayer.webapp.anagram.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zubayer.webapp.anagram.service.AnagramService;

@Controller
public class AnagramController {
	
	@Autowired
	AnagramService anagramService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		return "form";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String showAnagrams(ModelMap model, @RequestParam String word) throws FileNotFoundException, Exception{
		
		//Call anagramService to find all anagrams for the word
		//Store the word and its anagrams in ModelMap
		model.put("word", word);		
		model.put("result", anagramService.findAnagrams(word));

		return "anagram";
	}
}
