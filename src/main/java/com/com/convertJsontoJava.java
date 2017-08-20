package com.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.simple.parser.ParseException;

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

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		Inventory i = new Inventory();
		try {
			String jsonStr = new String(Files.readAllBytes(Paths.get("/Users/waitroseteam/Documents/workspace/GsonTry/src/main/java/temp.json"))); 
			Object dataObject  = i.convertJSONtoDAO(jsonStr);
			
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
		
		System.out.println("out of try\n");
	}

}
