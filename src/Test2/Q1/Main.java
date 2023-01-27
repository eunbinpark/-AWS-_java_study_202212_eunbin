package Test2.Q1;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

	public static void main(String[] args) {
		Gson gson = new Gson();
		
		gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		
		Map<String, Object> company = new HashMap<>();
		
		company.put("companyName", "Apple");
		company.put("address", "Apple Computer Inc. 1 infinite Loop");
		company.put("city", "Cupertino");
		company.put("state", "CA");
		company.put("zipCode", "95014");
		
		String companyJson = gson.toJson(company);
		
		Company companyObj = gson.fromJson(companyJson, Company.class);
		
		System.out.println(companyJson);
		System.out.println(companyObj);
	}
}
