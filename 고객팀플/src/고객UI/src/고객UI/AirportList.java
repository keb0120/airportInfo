package 고객UI;

public class AirportList {
	private String engName;
	private String korName;
	private String IATACode;
	private String ICAOCode;
	private String region;
	private String engNation;
	private String korNation;
	private String engCity;
	
	
	public AirportList(String engName, String korName, String iATACode, String iCAOCode, String region,
			String engNation, String korNation, String engCity) {
		super();
		this.engName = engName;
		this.korName = korName;
		this.IATACode = iATACode;
		this.ICAOCode = iCAOCode;
		this.region = region;
		this.engNation = engNation;
		this.korNation = korNation;
		this.engCity = engCity;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public String getKorName() {
		return korName;
	}
	public void setKorName(String korName) {
		this.korName = korName;
	}
	public String getIATACode() {
		return IATACode;
	}
	public void setIATACode(String iATACode) {
		IATACode = iATACode;
	}
	public String getICAOCode() {
		return ICAOCode;
	}
	public void setICAOCode(String iCAOCode) {
		ICAOCode = iCAOCode;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getEngNation() {
		return engNation;
	}
	public void setEngNation(String engNation) {
		this.engNation = engNation;
	}
	public String getKorNation() {
		return korNation;
	}
	public void setKorNation(String korNation) {
		this.korNation = korNation;
	}
	public String getEngCity() {
		return engCity;
	}
	public void setEngCity(String engCity) {
		this.engCity = engCity;
	}
	
	
}