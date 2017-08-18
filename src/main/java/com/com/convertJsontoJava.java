package com.com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import dataObjects.BranchInventory;
import dataObjects.Inventory;

public class convertJsontoJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inventory i = null;
		try {
//			Gson gson = new GsonBuilder().create();
//			Type type = new TypeToken <HashMap<String, HashMap<String, String>>>() {}.getType();
//	        Map<String, Map<String, String>> map = gson.fromJson(json, type);
//	        for (Map<String, String> data : map.values()) {
//	            System.out.println(Data.fromMap(data));
//	        }
	       
//			JsonParser parser = new JsonParser();
//			JsonObject obj = parser.parse(new FileReader("/Users/waitroseteam/Documents/workspace/GsonTry/src/main/java/temp.json")).getAsJsonObject();
//			Set<Entry<String,JsonElement>> set = obj.entrySet();
//
//			Iterator<Entry<String,JsonElement>> iter = set.iterator();
//			while (iter.hasNext()) {
//				Entry<String,JsonElement> e = iter.next();
//			    System.out.println(e);
//			    if(e.getKey().equals("branchInventory")){
//			    	BranchInventory b = BranchInventory.fromJSONString(e.getValue().toString());
//			    }
//			    		BranchInventory b = new Gson().fromJson(e.getValue(), BranchInventory.class);
//			}
			
			i = new Gson().fromJson(new FileReader("/Users/waitroseteam/Documents/workspace/GsonTry/src/main/java/temp.json"), Inventory.class);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("out of try\n" +i);
	}

}
