package com.myToys.restAPI.consumerData.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.json.JSONException;
import org.junit.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import com.myToys.restAPI.consumerData.dto.Product;
import com.myToys.restAPI.consumerData.utils.impl.ProductCsvToJson;

/**
 * Unit test for CSV to JSON Converter.
 */
public class ProductCSVToObjectTest{
	
	public String INVALID_FILE_PATH = "src/test/resources/abc.CSV";
	public String SAMPLE_PRODUCT_FILE_PATH = "src/test/resources/product_data_sample.CSV";

	ProductCsvToJson mapper = new ProductCsvToJson();
	AbstractCsvToJson absCls = Mockito.mock(AbstractCsvToJson.class, Mockito.CALLS_REAL_METHODS);
	
	@SuppressWarnings("unchecked")
	private <T> List<T> getProductList() {
		List<Product> products = new ArrayList<Product>();
		
		products.add(new Product(39697,"ESPRIT #2013944",39.99, 39.99,0,"LEGO"));
		products.add(new Product(1448,"LEGO #300348",32.99, 28.99,0,"LEGO"));
	
		return (List<T>)products;		
	}
	
	@Test
	public void testReadCSV() throws IOException {
		Mockito.when(absCls.mapCSVToObject(Mockito.any())).thenReturn(getProductList());
		List<Product> productList = absCls.readCSV(SAMPLE_PRODUCT_FILE_PATH);
		
		assertEquals(2, productList.size());
		assertEquals(39697, productList.get(0).getId());
		assertEquals(1448, productList.get(1).getId());

	}
	
	@Test(expected = IOException.class)
	public void testReadCSVthrowException() throws IOException {
		Mockito.when(absCls.mapCSVToObject(Mockito.any())).thenReturn(getProductList());
	    absCls.readCSV(INVALID_FILE_PATH);						
	}
	
	
	@Test
	public void testGetJSONResponse() throws IOException, JSONException {
		String expectedJSON = "[ {\n" + 
				"  \"id\" : 39697,\n" + 
				"  \"name\" : \"ESPRIT #2013944\",\n" + 
				"  \"price\" : 39.99,\n" + 
				"  \"old_price\" : 39.99,\n" + 
				"  \"stock\" : 0,\n" + 
				"  \"brand\" : \"LEGO\"\n" + 
				"}, {\n" + 
				"  \"id\" : 1448,\n" + 
				"  \"name\" : \"LEGO #300348\",\n" + 
				"  \"price\" : 32.99,\n" + 
				"  \"old_price\" : 28.99,\n" + 
				"  \"stock\" : 0,\n" + 
				"  \"brand\" : \"LEGO\"\n" + 
				"} ]";
		
		Mockito.when(absCls.readCSV(SAMPLE_PRODUCT_FILE_PATH)).thenReturn(getProductList());
		
		JSONAssert.assertEquals(expectedJSON, absCls.getJSONResponse(SAMPLE_PRODUCT_FILE_PATH), JSONCompareMode.LENIENT);

	}
	
	@Test
	public void testMapCSVToObject()
	{
		List<Product> inputList = new ArrayList<Product>();
		try{
		      File file = new File(SAMPLE_PRODUCT_FILE_PATH);
		      
		      InputStream inputStream = new FileInputStream(file);
		      BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		      Stream<String> fileStream = br.lines().skip(1);
		      inputList = mapper.mapCSVToObject(fileStream);
		      
		      br.close();
		      
		}catch(IOException e) {
	    	System.out.println(e.getMessage());	    	
	    }
		
		assertEquals(2, inputList.size());
		assertEquals(43664, inputList.get(0).getId());
		assertEquals(18450, inputList.get(1).getId());
	}
	
}