package com.zubayer.webapp.anagram.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

//import com.zubayer.webapp.anagram.model.AnagramModel;

@Service
public class AnagramService {
	
	public String findAnagrams(String word) throws Exception {
		
		//Scanner scanner = new Scanner(new File("src/main/webapp/WEB-INF/dict/american-english.txt"));
		//Scanner scanner = new Scanner(new File("static/american-english.txt"));
		//Scanner scanner = new Scanner(new File("/usr/share/dict/american-english"));
		
//		while (scanner.hasNext()) {
//        map.put(scanner.next(),null);
//    }
		
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
		
		
		//handle uppercase/lowercase
       
        
        List<String> results = new ArrayList<String>();
        
        //Find all permutations of the word
        char[] chars = word.toCharArray();
        results.add(new String("" + chars[0]));
        for(int j=1; j<chars.length; j++) {
            char c = chars[j];
            int cur_size = results.size();
            //create new permutations combing char 'c' with each of the existing permutations
            for(int i=cur_size-1; i>=0; i--) {
                String str = results.remove(i);
                for(int l=0; l<=str.length(); l++) {
                	
                	if(!results.contains(str.substring(0,l) + c + str.substring(l)))
                		results.add(str.substring(0,l) + c + str.substring(l));
                }
            }
        }
        
        //Remove the word itself from permutations list
        results.remove(word);
        
        
        String anagramStr = "";
        
        for(String key : results) {
        	
        	//If the permute is found in the dictionary it is an anagram
        	if(map.containsKey(key))
        	
        	//Create a string of anagrams
        	anagramStr = anagramStr + " " + key;
        	
        }

        return anagramStr;			
	}
}
