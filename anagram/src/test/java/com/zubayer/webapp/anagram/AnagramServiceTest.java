package com.zubayer.webapp.anagram;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.zubayer.webapp.anagram.service.AnagramService;

class AnagramServiceTest {

	@Test
	@DisplayName("Anagaram generation service test - no match found ")
	void testGetAnagramWhenNoAnagramIsFound() throws Exception {		   
		
		AnagramService anagramServices= new AnagramService();

		String word = "book";

		List<String> anagrams = anagramServices.findAnagrams(word);
		assertEquals(anagrams, Arrays.asList("Sorry, no anagram is found"));
	}
	
	@Test
	@DisplayName("Anagaram generation service test - matches found")
	void testGetAnagramWhenMatchedWithExpectedOutput() throws Exception {
		   AnagramService anagramServices= new AnagramService();

		String word = "pool";

		List<String> anagrams = anagramServices.findAnagrams(word);
		assertEquals(anagrams, Arrays.asList("loop"));
	}
	
	@Test
	@DisplayName("Anagaram generation service test - Uppercase")
	void testGetAnagramWhenSearchTermIsUpperCase() throws Exception {
		   AnagramService anagramServices= new AnagramService();

		   String word = "Pool";

		List<String> anagrams = anagramServices.findAnagrams(word);
		assertEquals(anagrams, Arrays.asList("pool", "loop"));
	}
	
}
