package example;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Site {
	@Id
	private Integer id;
	private String name;
	private double latitude;
	private double longitude;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public Site(Integer id, String name, double d, double e) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = d;
		this.longitude = e;
	}
	public Site() {
		super();
	}
	
}



































