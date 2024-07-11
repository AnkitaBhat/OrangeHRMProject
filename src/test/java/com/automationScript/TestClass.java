package com.automationScript;



import com.utils.ConstantValue;
import com.utils.ReadPropertiesFiles;

public class TestClass implements ConstantValue{
	

			final static String filename="Write.properties";
			final static String path=System.getProperty("user.dir")+pathSeparator+"src"+pathSeparator+"main"+pathSeparator+"resources"+pathSeparator+filename;
			



	
	public static void main(String[] args) {
	ReadPropertiesFiles rd=new ReadPropertiesFiles(path);
	String key = "Ankita";
	String value = "Bhat";
	rd.WriteFile(key,value);
	}
}
