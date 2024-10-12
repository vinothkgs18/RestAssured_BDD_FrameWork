package PayloadData;

import googleMap_pojo.AddPlace;
import googleMap_pojo.Location;
import io.restassured.RestAssured;

public class AddPlacePayLoad {
	
	public AddPlace payloadForAddPlace(String name,String language, String address) {
		AddPlace ap= new AddPlace();
		ap.setAccuracy(500);
		ap.setName(name);
		ap.setPhone_number("9597359037");
		ap.setAddress(address);
		ap.setLanguage(language);
		ap.setWebsite("www.vinoth.com");
		Location l= new Location();
		l.setLat(200);
		l.setLng(300);
		ap.setLocation(l);
		
		
		return ap;
	}

}
