package com.mockito.project.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MyDictionary {

	private Map<String, String> wordMap = new HashMap<>();
	 
    public void add(String word, String meaning) {
        wordMap.put(word, meaning);
    }
 
    public String getMeaning(String word) {
        return wordMap.get(word);
    }
    
    public void voidMethodThrowingExcetion(boolean check) {
        if (check) {
          throw new IllegalArgumentException();
        }
      }
    
    public void calculateSumAndStore_1(String s,int arr[]){
    	StudentScoreUpdates s1=new StudentScoreUpdates();
    	s1.calculateSumAndStore(s,arr);
    }
}
