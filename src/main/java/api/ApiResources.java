package api;

public enum ApiResources {
	
	
	AddPlace("maps/api/place/add/json"),
	DeletePlace("maps/api/place/delete/json"),
	GetPlace("maps/api/place/get/json"),
	PutPlace("maps/api/place/update/json");
	
	private String resources;
	ApiResources(String resources){
		this.resources=resources;
	}
	
	public String getResources() {
		return resources;
	}

}
