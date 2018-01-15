package cn.itcast.core.bean.entity;

public class Pcat {

	 //省市编号及名称
	private int id;
    private String provinceName; // 名称
    private String cityName;
    private String areaName;
    private String townName;
    private String province; //编号
    private String city;
    private String area;
    private String town;
    private int memId;
	
	public Pcat() {
		super();
	}
	public Pcat(int id, String provinceName, String cityName, String areaName, String townName, String province,
			String city, String area, String town, int memId) {
		super();
		this.id = id;
		this.provinceName = provinceName;
		this.cityName = cityName;
		this.areaName = areaName;
		this.townName = townName;
		this.province = province;
		this.city = city;
		this.area = area;
		this.town = town;
		this.memId = memId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getTownName() {
		return townName;
	}
	public void setTownName(String townName) {
		this.townName = townName;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	@Override
	public String toString() {
		return "Pcat [id=" + id + ", provinceName=" + provinceName + ", cityName=" + cityName + ", areaName=" + areaName
				+ ", townName=" + townName + ", province=" + province + ", city=" + city + ", area=" + area + ", town="
				+ town + ", memId=" + memId + "]";
	}
    
    
	
}
