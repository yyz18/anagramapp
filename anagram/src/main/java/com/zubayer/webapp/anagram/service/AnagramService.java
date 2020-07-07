package com.zubayer.webapp.anagram.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class AnagramService {
	
	static List<String> permutationWords = new ArrayList<String>();

	public List<String> findAnagrams(String word) throws Exception {
		
		//Empty anagrams list
		permutationWords.clear();

		Map<String, String> map = new HashMap<String, String>();

		//Read in a local dictionary of English words
		Resource resource = new ClassPathResource("static/american-english.txt");
		InputStream inputStream = resource.getInputStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

		//Create a map of English words
		try {
			while (br.readLine() != null) {
				map.put(br.readLine(), null);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Find all permutations of the word
		permutation("", word);
		permutationWords.remove(word);

		//Check if the permutation word exists in the English word map
		//If the word exists add it to anagarms list
		List<String> anagrams = new ArrayList<String>();		
		for (String key : permutationWords) {
			if (map.containsKey(key))
				anagrams.add(key);
		}
		
        return anagrams.size() < 1 ? Arrays.asList("Sorry, no anagram is found") : anagrams;
	}

	
	//Return all permutations of a given string
	static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) {
	    	if (!permutationWords.contains(prefix))
	    	permutationWords.add(prefix);
	    }
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
}
