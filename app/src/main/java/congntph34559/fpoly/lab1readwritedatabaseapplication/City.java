package congntph34559.fpoly.lab1readwritedatabaseapplication;

public class City {

    private String nameCity;
    private String stateCity;
    private String countryCity;
    private long populationCity;

    public City(String nameCity, String stateCity, String countryCity, long populationCity) {
        this.nameCity = nameCity;
        this.stateCity = stateCity;
        this.countryCity = countryCity;
        this.populationCity = populationCity;
    }

    public City() {
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getStateCity() {
        return stateCity;
    }

    public void setStateCity(String stateCity) {
        this.stateCity = stateCity;
    }

    public String getCountryCity() {
        return countryCity;
    }

    public void setCountryCity(String countryCity) {
        this.countryCity = countryCity;
    }

    public long getPopulationCity() {
        return populationCity;
    }

    public void setPopulationCity(long populationCity) {
        this.populationCity = populationCity;
    }

   public String toString(){
        return "Name: "+nameCity+"---"+"Country: "+countryCity;
   }
}
