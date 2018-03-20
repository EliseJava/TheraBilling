package edu.matc.breezeometer;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class AirQualityResults{

	@JsonProperty("dominant_pollutant_canonical_name")
	private String dominantPollutantCanonicalName;

	@JsonProperty("breezometer_aqi")
	private int breezometerAqi;

	@JsonProperty("country_description")
	private String countryDescription;

	@JsonProperty("breezometer_color")
	private String breezometerColor;

	@JsonProperty("data_valid")
	private boolean dataValid;

	@JsonProperty("datetime")
	private String datetime;

	@JsonProperty("country_aqi")
	private int countryAqi;

	@JsonProperty("dominant_pollutant_text")
	private DominantPollutantText dominantPollutantText;

	@JsonProperty("breezometer_description")
	private String breezometerDescription;

	@JsonProperty("random_recommendations")
	private RandomRecommendations randomRecommendations;

	@JsonProperty("country_name")
	private String countryName;

	@JsonProperty("country_aqi_prefix")
	private String countryAqiPrefix;

	@JsonProperty("dominant_pollutant_description")
	private String dominantPollutantDescription;

	@JsonProperty("country_color")
	private String countryColor;

	public void setDominantPollutantCanonicalName(String dominantPollutantCanonicalName){
		this.dominantPollutantCanonicalName = dominantPollutantCanonicalName;
	}

	public String getDominantPollutantCanonicalName(){
		return dominantPollutantCanonicalName;
	}

	public void setBreezometerAqi(int breezometerAqi){
		this.breezometerAqi = breezometerAqi;
	}

	public int getBreezometerAqi(){
		return breezometerAqi;
	}

	public void setCountryDescription(String countryDescription){
		this.countryDescription = countryDescription;
	}

	public String getCountryDescription(){
		return countryDescription;
	}

	public void setBreezometerColor(String breezometerColor){
		this.breezometerColor = breezometerColor;
	}

	public String getBreezometerColor(){
		return breezometerColor;
	}

	public void setDataValid(boolean dataValid){
		this.dataValid = dataValid;
	}

	public boolean isDataValid(){
		return dataValid;
	}

	public void setDatetime(String datetime){
		this.datetime = datetime;
	}

	public String getDatetime(){
		return datetime;
	}

	public void setCountryAqi(int countryAqi){
		this.countryAqi = countryAqi;
	}

	public int getCountryAqi(){
		return countryAqi;
	}

	public void setDominantPollutantText(DominantPollutantText dominantPollutantText){
		this.dominantPollutantText = dominantPollutantText;
	}

	public DominantPollutantText getDominantPollutantText(){
		return dominantPollutantText;
	}

	public void setBreezometerDescription(String breezometerDescription){
		this.breezometerDescription = breezometerDescription;
	}

	public String getBreezometerDescription(){
		return breezometerDescription;
	}

	public void setRandomRecommendations(RandomRecommendations randomRecommendations){
		this.randomRecommendations = randomRecommendations;
	}

	public RandomRecommendations getRandomRecommendations(){
		return randomRecommendations;
	}

	public void setCountryName(String countryName){
		this.countryName = countryName;
	}

	public String getCountryName(){
		return countryName;
	}

	public void setCountryAqiPrefix(String countryAqiPrefix){
		this.countryAqiPrefix = countryAqiPrefix;
	}

	public String getCountryAqiPrefix(){
		return countryAqiPrefix;
	}

	public void setDominantPollutantDescription(String dominantPollutantDescription){
		this.dominantPollutantDescription = dominantPollutantDescription;
	}

	public String getDominantPollutantDescription(){
		return dominantPollutantDescription;
	}

	public void setCountryColor(String countryColor){
		this.countryColor = countryColor;
	}

	public String getCountryColor(){
		return countryColor;
	}

	@Override
 	public String toString(){
		return 
			"AirQualityResults{" + 
			"dominant_pollutant_canonical_name = '" + dominantPollutantCanonicalName + '\'' + 
			",breezometer_aqi = '" + breezometerAqi + '\'' + 
			",country_description = '" + countryDescription + '\'' + 
			",breezometer_color = '" + breezometerColor + '\'' + 
			",data_valid = '" + dataValid + '\'' + 
			",datetime = '" + datetime + '\'' + 
			",country_aqi = '" + countryAqi + '\'' + 
			",dominant_pollutant_text = '" + dominantPollutantText + '\'' + 
			",breezometer_description = '" + breezometerDescription + '\'' + 
			",random_recommendations = '" + randomRecommendations + '\'' + 
			",country_name = '" + countryName + '\'' + 
			",country_aqi_prefix = '" + countryAqiPrefix + '\'' + 
			",dominant_pollutant_description = '" + dominantPollutantDescription + '\'' + 
			",country_color = '" + countryColor + '\'' + 
			"}";
		}
}