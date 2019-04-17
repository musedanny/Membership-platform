package com.danny.andela.andelacode.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.danny.andela.andelacode.database.DatabaseClass;
import com.danny.andela.andelacode.model.Plan;

public class PlanService {
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	private static Map<Long,Plan> plans= DatabaseClass.getPlans();
	public PlanService() throws ParseException{
		
		plans.put(1L,new Plan(1,"SD Interview",format.parse("02-12-2001"),format.parse("02-12-2005"),true));
		plans.put(2L,new Plan (2,"Java Inteview",format.parse("02-12-2001"),format.parse("02-12-2001"),true));
		plans.put(3L,new Plan (3,"Board Meeting",format.parse("02-12-2001"),format.parse("02-12-2001"),true));		
	}
	public List<Plan>getAllPlans(){
		return new ArrayList<Plan>(plans.values());
		}
	public List<Plan> getAllPlansForYear(int year){
		List<Plan>planForYear=new ArrayList<>();
		Calendar cal=Calendar.getInstance();
		for(Plan plan:plans.values()){
			cal.setTime(plan.getStartDate());
			if(cal.get(Calendar.YEAR)==year){
				planForYear.add(plan);	
			}
		}
		return planForYear;
	}
	public List<Plan>getPlanPaginated(int start , int size){
		ArrayList<Plan>list=new ArrayList<Plan>(plans.values());
		if(start + size> list.size())return new ArrayList<Plan>();
		return list.subList(start, start+ size);
	
	}
	public Plan getPlan(long id){
		return plans.get(id);	
	}
	public Plan addPlan(Plan plan){
		plan.setId(plans.size()+1);
		plans.put(plan.getId(), plan);
		return plan;
	}
	public Plan updatePlan(Plan plan){
		if(plan.getId()<=0){
			return null;
		}
		plans.put(plan.getId(), plan);
			return plan;
		
	}
	public Plan removeMethod(long id){
		return plans.remove(id);
	}

	

}
