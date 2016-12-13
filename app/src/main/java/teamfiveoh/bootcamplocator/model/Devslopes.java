package teamfiveoh.bootcamplocator.model;

/**
 * Created by andrewpat24 on 12/7/16.
 */

public class Devslopes {
	private float longitude;
	private float latitude;
	private String locationTitle;
	private String locationAddress;
	private String locationImgUrl;
	final String DRAWABLE = "drawable/";

	public String getImgUri() {
		return this.DRAWABLE + locationImgUrl;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public String getLocationTitle() {
		return locationTitle;
	}

	public void setLocationTitle(String locationTitle) {
		this.locationTitle = locationTitle;
	}

	public String getLocationAddress() {
		return locationAddress;
	}

	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}

	public String getLocationImgUrl() {
		return locationImgUrl;
	}

	public void setLocationImgUrl(String locationImgUrl) {
		this.locationImgUrl = locationImgUrl;
	}

	public Devslopes(float latitude, float longitude, String locationTitle, String locationAddress, String locationImgUrl) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.locationTitle = locationTitle;
		this.locationAddress = locationAddress;
		this.locationImgUrl = locationImgUrl;
	}
}
