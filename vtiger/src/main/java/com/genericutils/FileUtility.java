package com.genericutils;



import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

public class FileUtility {

	public String getPropertykeyValue(String Key) throws Throwable 
	{
		FileInputStream file=new FileInputStream(IPathConstant1.PROPERTY_FILEPATH);
		Properties p=new Properties();
		p.load(file);
		return p.getProperty(Key);
	}
	
		
		/*public String getDataFromJson(String jsonkey) throws Throwable
		{
		FileReader reader=new FileReader(IPathConstant1.jsonFILEPATH);
		JSONParser parser=  new JSONParser();
		Object object=parser.parse(reader);
		JSONObject jsobobj=(JSONObject)object;
		String value=jsobobj.get(jsonkey).toString();
		return value;		
	*/}

