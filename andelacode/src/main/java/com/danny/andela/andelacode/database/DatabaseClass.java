package com.danny.andela.andelacode.database;

import java.util.HashMap;
import java.util.Map;

import com.danny.andela.andelacode.model.*;


public class DatabaseClass {
	private static Map<Long,Plan> plans= new HashMap<>();
	private static Map<String,Member> members= new HashMap<>();
	
    public static Map<Long,Plan> getPlans(){
		
		return plans;
	}
	public static Map<String,Member> getMembers(){
	return members;	
	}
	
}
