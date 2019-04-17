package com.danny.andela.andelacode.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import com.danny.andela.andelacode.model.Plan;
import com.danny.andela.andelacode.service.PlanService;



@Path("/plans")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON) 
public class PlanResources {
	@Autowired
	PlanService planService ;

@GET
public List<Plan> getPlan(@BeanParam PlanFilterBean filterBean )
{
	if(filterBean.getYear()>0){
		return planService.getAllPlansForYear(filterBean.getYear());	
	}
	if(filterBean.getStart()>0&& filterBean.getSize()>0){
		
		return planService.getPlanPaginated(filterBean.getStart(), filterBean.getSize());
	}
	
	return planService.getAllPlans();
}
@POST
public Response addPlan(Plan plan,@Context UriInfo uriInfo){
Plan newPlan = planService.addPlan(plan);
String newId= String.valueOf(newPlan.getId());
URI uri= uriInfo.getAbsolutePathBuilder().path(newId).build();
 return Response.created(uri)
		   .entity(newPlan)
		   .build();
	 
}
@PUT
@Path("/{planId}")
public Plan updatePlan(@PathParam("planId") long id, Plan plan){
	plan.setId(id);
	return planService.updatePlan(plan);
}
@DELETE
@Path("/{planId}")
public void deletePlan(@PathParam("planId") long id){
	planService.removeMethod(id);
}

@GET
@Path("/{planId}")
public Plan getPlan(@PathParam("planId") long Id){
	return planService.getPlan(Id);
}

@Path("/{planId}/members")
public MemberResource getMemberResource(){
	return new MemberResource();
}
}

