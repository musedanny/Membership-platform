package com.danny.andela.andelacode.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.danny.andela.andelacode.database.DatabaseClass;
import com.danny.andela.andelacode.model.Member;
import com.danny.andela.andelacode.model.Plan;

public class MemberService {
private Map<Long, Plan> plans = DatabaseClass.getPlans();
	
	public List<Member>getAllMembers(long planId){
	Map<Long, Member> members=plans.get(planId).getMembers();
	return new ArrayList<Member>(members.values());
	}
	
	public Member getMember(long planId, long memberId){
		Map<Long,Member> members= plans.get(planId).getMembers();
		return members.get(memberId);
	}
	public Member addMember(long planId,Member member){
		Map<Long ,Member> members= plans.get(planId).getMembers();
		member.setId(members.size()+1);
		members.put(member.getId(), member);
		return member;
		
	}
	public Member updateMember(long planId, Member member){
	Map<Long,Member> members=plans.get(planId).getMembers();
	if(member.getId()<=0){
		return null;
	}
	members.put(member.getId(), member);
	return member;
		
	}
	public Member removeMember(long planId, long memberId){
		Map<Long, Member> members=plans.get(planId).getMembers();
		return members.remove(memberId);
		
		
	}

}
