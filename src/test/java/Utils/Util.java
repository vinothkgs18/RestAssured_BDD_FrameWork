package Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Util {
	
	
	public static RequestSpecification req;
	
	public RequestSpecification requestSpecfication () throws IOException {
		PrintStream stream= new PrintStream(new FileOutputStream("logging.txt"));
		if(req==null) {
			req=new RequestSpecBuilder().setBaseUri(readProperties("baseURI")).addQueryParam("key", "qaclick123")
			.addFilter(RequestLoggingFilter.logRequestTo(stream))
			.addFilter(ResponseLoggingFilter.logResponseTo(stream))
					.setContentType(ContentType.JSON).build();
			return req;
		}
		return req;
	}
	
	public String readProperties(String key) throws IOException {
		Properties properties=new Properties();
		FileInputStream inputStream= new FileInputStream("C:\\Users\\vinot\\eclipse-workspace\\RestAssured_BDD_API\\src\\test\\resources\\properties\\config.properties");
		properties.load(inputStream);
		String value = properties.getProperty(key);
		System.out.println(value);
		return value;
	}

}
