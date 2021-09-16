package com.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootController {

	@Autowired
	SpringBootService service;
	
	@Value("${spring.application.str1:default}")
	private String str1;
	
	@Value("${spring.application.str2:default}")
	private String str2;
	
	
	@GetMapping(value="/stringcomparison")
	public String compareTwoStrings() {
		return service.compareTwoStrings(this.str1,this.str2);
	}
	
	@GetMapping(value="/uncommon")
	public String unCommonCharacters() {
		return service.unCommonCharacters(this.str1,this.str2);
	}
	
	@GetMapping(value="/common")
	public String commonCharacters(){
		return service.commonCharacters(this.str1,this.str2);
	}
	
	@GetMapping(value="/helloWorld")
	public String getHelloWorld() {
		return "Hello World";
	}
	
	
	@PostMapping(value="/")
	public void createEmployee(@RequestBody SpringBootModel model) {
		service.addEmployee(model);
	}
	
	@GetMapping(value="/all")
	public List<SpringBootModel> getAllEmployees(){
		return service.getAll();
	}
	
	@GetMapping(value="/{id}")
	public SpringBootModel getEmployee(@PathVariable String id) {
		return service.getEmployee(id);
	}

	@PutMapping(value="/{id}")
	public SpringBootModel updateEmployee(@RequestBody SpringBootModel model,@PathVariable String id) {
		return service.updateEmployee(model,id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable String id) {
		service.deleteEmployee(id);
	}
	
	@PostMapping("/compareStrings")
	public void compareStrings() {
			service.compareStrings(this.str1,this.str2);
	}
	
	@GetMapping("/getOutput")
	public List<OutputModel> getOutput() {
		return service.getOutput();
	}
}
