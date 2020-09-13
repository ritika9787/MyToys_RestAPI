package com.myToys.restAPI.consumerData.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

abstract public class AbstractCsvToJson {
	
	public <T> String getJSONResponse(String absolutePath) throws IOException {
		
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
	    String jsonResponse = mapper.writeValueAsString(readCSV(absolutePath));	
	    
	    return jsonResponse;
	}
	
	public <T> List<T> readCSV(String filePath) throws IOException {
		List<T> inputList = new ArrayList<T>();
		try{
		      File file = new File(filePath);
		      
		      InputStream inputStream = new FileInputStream(file);
		      BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		      Stream<String> fileStream = br.lines().skip(1);
		      inputList = mapCSVToObject(fileStream);
		      
		      br.close();
		      
		}catch(IOException e) {
	    	System.out.println(e.getMessage());
	    	throw e;
	    }
	    return inputList;
	}
	
	abstract <T> List<T> mapCSVToObject(Stream<String> fileDataStream);

}
