package com.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringBootService {

	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private OutputRepository outputRepository;
	
	@Autowired
	private OutputModel outputModel;
	
	List<SpringBootModel> modelList = new ArrayList<SpringBootModel>();

	public void addEmployee(SpringBootModel model) {
		repository.save(model);
	}

	public List<SpringBootModel> getAll() {
		repository.findAll().forEach(modelList::add);
		return modelList;
	}

	public SpringBootModel getEmployee(String id) {
		return repository.findById(id).get();
	}

	public SpringBootModel updateEmployee(SpringBootModel model, String id) {
		if(model.getId().equals(id))
			return repository.save(model);
		else
			return null;
	}
	
	public void deleteEmployee(String id) {
		repository.deleteById(id);
	}
	
	public void compareStrings(String str1, String str2) {
			String compareOutput = compareTwoStrings(str1,str2);
			String unCommonOutput = unCommonCharacters(str1,str2);
			String commonOutput = commonCharacters(str1,str2);
			outputModel.setCommonOutput(commonOutput);
			outputModel.setCompareOutput(compareOutput);
			outputModel.setUnCommonOutput(unCommonOutput);
			outputRepository.save(outputModel);
		
	}

	public String compareTwoStrings(String str1, String str2) {
		
		if(str1.equals(str2)) {
			return "Strings are equal";
		}
		else {
			return "Strings are not equal, check for common and uncommon characters";
		}
		
	}
	
	public String unCommonCharacters(String str1,String str2) {
		StringBuilder objStringBuilder = new StringBuilder();
		Set<Character> charSet = new HashSet<Character>();
		
		for(int i=0;i<str1.length();i++) {
			char ch = str1.charAt(i);
			if(str2.indexOf(ch) == -1 ) {
				charSet.add(Character.valueOf(ch));
			}
		}
		
		for(int i=0;i<str2.length();i++) {
			char ch2 = str2.charAt(i);
			if(str1.indexOf(ch2) == -1 ) {
				charSet.add(Character.valueOf(ch2));
			}
		}
		
		Iterator<Character> charsIterator = charSet.iterator();
		while(charsIterator.hasNext()) {
			objStringBuilder.append(charsIterator.next().charValue());
		}
		outputModel.setUnCommonOutput(objStringBuilder.toString());
		
		return objStringBuilder.toString();
	}

	public String commonCharacters(String str1, String str2) {
		StringBuilder objStringBuilder = new StringBuilder();
		Set<Character> charSet = new HashSet<Character>();
		
		for(int i=0;i<str1.length();i++) {
			char ch = str1.charAt(i);
			if(str2.indexOf(ch) != -1) {
				charSet.add(Character.valueOf(ch));
			}
		}
		
		for(int j=0;j<str2.length();j++) {
			char ch2 = str2.charAt(j);
			if(str1.indexOf(ch2) != -1) {
				charSet.add(Character.valueOf(ch2));
			}
		}
		
		Iterator<Character> charsIterator = charSet.iterator();
		while(charsIterator.hasNext()) {
			objStringBuilder.append(charsIterator.next().charValue());
		}
		
		outputModel.setCommonOutput(objStringBuilder.toString());
		
		return objStringBuilder.toString();
	}

	public List<OutputModel> getOutput() {
		return outputRepository.findAll();
	}
	
	
}
