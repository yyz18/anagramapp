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

	public List<String> findAnagrams(String word) throws Exception {

		Map<String, String> map = new HashMap<String, String>();

		Resource resource = new ClassPathResource("static/american-english.txt");
		InputStream inputStream = resource.getInputStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

		try {
			while (br.readLine() != null) {
				map.put(br.readLine(), null);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// handle uppercase/lowercase
		List<String> results = new ArrayList<String>();

		results = permutation(word);
		results.remove(word);

		List<String> anagrams = new ArrayList<String>();

		for (String key : results) {
			if (map.containsKey(key))
				anagrams.add(key);
		}
		
        return anagrams.size() < 1 ? Arrays.asList("Sorry, no anagram is found") : anagrams;
	}

	// return the list of permutations
	public static ArrayList<String> permutation(String s) {
		ArrayList<String> res = new ArrayList<String>();
		// If input string's length is 1, return {s}
		if (s.length() == 1) {
			res.add(s);
		} else if (s.length() > 1) {
			int lastIndex = s.length() - 1;
			// Find out the last character
			String last = s.substring(lastIndex);
			// Rest of the string
			String rest = s.substring(0, lastIndex);
			// Perform permutation on the rest string and
			// merge with the last character
			res = merge(permutation(rest), last);
		}
		return res;
	}

	// return a merged list
	public static ArrayList<String> merge(ArrayList<String> list, String c) {
		ArrayList<String> res = new ArrayList<>();
		// Loop through all the string in the list
		for (String s : list) {
			// For each string, insert the last character to all possible positions
			// and add them to the new list
			for (int i = 0; i <= s.length(); ++i) {
				String ps = new StringBuffer(s).insert(i, c).toString();
				if (!res.contains(ps))
					res.add(ps);
			}
		}
		return res;
	}
}
