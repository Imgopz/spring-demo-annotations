package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach") // Spring will automatically register this bean (i.e: Object)
@Component // The default bean id will be tennisCoach
public class TennisCoach implements Coach {

	private FortuneService fortuneService;
	
	// define default constructor to test
	public TennisCoach() {
		
		System.out.println(">> TennisCoach: Inside default constructor");
		
	}
	
	
	/*
	@Autowired 
//  Constructor Injection - There is only one fortune service which implements the interface FortuneServce i.e. HappyFortuneService. So this Autowire annotation just assign it to theForutnueService and we can call te function insed getDailyFortune as fortuneService.getFortune() as below 
	public TennisCoach(FortuneService theFortuneService) {
		
		fortuneService = theFortuneService;
				
	} 
	*/
	
	// define Setter mothod for setter Injection
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		
		System.out.println(">> TennisCoach: Inside setFortuneService() method");
		fortuneService = theFortuneService;
		
	}
	
	@Override
	public String getDailyWorkout() {

		return "Practice your backend volley";
		
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
		
	}

}
