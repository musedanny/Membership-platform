package com.danny.andela.andelacode.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.danny.andela.andelacode.model.Member;
import com.danny.andela.andelacode.service.MemberService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MemberResource {

	private MemberService memberService= new MemberService();
	
	@GET
	public List<Member>getAllMembers(@PathParam("planId")long planId){
		return memberService.getAllMembers(planId);
	}
	@POST
	public Member addMember(@PathParam("planId")long planId, Member member){
		return memberService.addMember(planId, member);
	}
	@PUT
	@Path("/{memberId}")
	public Member updateMember(@PathParam("planId")long planId,@PathParam("memberId")long memberID, Member member){
		member.setId(memberID);
	    return memberService.updateMember(planId, member);
	}
	@DELETE
	@Path("/{memberId}")
	public Member deleteMember(@PathParam("planId")long planId,@PathParam("memberId")long memberId){
		
		return memberService.removeMember(planId, memberId);
	}
	@GET
	@Path("/{memberId}")
	public Member getMember(@PathParam("planId") long planId, @PathParam("memberId")long memberId){
		return memberService.getMember(planId, memberId);
	}
}