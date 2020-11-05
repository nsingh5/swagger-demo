package com.narendra.swagger.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.narendra.swagger.model.Student;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="Basic Controller", description="this is a basic test controller")
public class Controller {
	  List<Student> students = new ArrayList<Student>();
	    {
	        students.add(new Student("Sajal", "IV", "India"));
	        students.add(new Student("Lokesh", "V", "India"));
	        students.add(new Student("Kajal", "III", "USA"));
	        students.add(new Student("Sukesh", "VI", "USA"));
	    }
	    
	    @ApiOperation(tags="getStudentList",response =List.class,value="get list of all students" )
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Suceess|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"), 
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	    
	    
	    @RequestMapping(value="/students",method=RequestMethod.GET)
	    public List<Student> getStudentList(){
	    	return this.students;
	    }
	    
	    @ApiOperation(value="get details of input student",tags="getStudentList(name)", response = Student.class)
	    @ApiResponses(value= {
	    		@ApiResponse(code=200,message="wow you made it")
	    })
	    
	    @RequestMapping(value="/students/{name}",method=RequestMethod.GET)
	    public Student getStudentList(@PathVariable String name){
	    	return this.students.stream().filter(s->s.getName().equalsIgnoreCase(name)).limit(1).findFirst().get();
	    	
	    }
}
