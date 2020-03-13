package com.mockito.project.service;

import org.springframework.stereotype.Service;

@Service
public class StudentScoreUpdates {

	public void calculateSumAndStore(String studentId, int[] scores)
	{
		int total = 0;
		for(int score : scores)
		{
			total = total + score;
		}
		updateScores(studentId, total);
	}

	public void updateScores(String studentId, int total) {
		System.out.println(total);
	}
	
	
}
