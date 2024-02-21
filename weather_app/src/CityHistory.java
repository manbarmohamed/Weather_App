import java.time.LocalDate;

public class CityHistory {
    private int historicalDataId;
    private int cityId;

    private LocalDate eventDate;
    private int temperature;
    public CityHistory(int historicalDataId, int cityId, LocalDate eventDate, int temperature) {
        this.historicalDataId = historicalDataId;
        this.cityId = cityId;
        this.eventDate = eventDate;
        this.temperature = temperature;
    }

    public int getHistoricalDataId() {
        return historicalDataId;
    }

    public void setHistoricalDataId(int historicalDataId) {
        this.historicalDataId = historicalDataId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "CityHistory Information\n" +
                "-----------------------\n"+
                "historicalDataId= " + historicalDataId +
                "\n cityId= " + cityId +
                "\n eventDate= " + eventDate +
                "\n temperature= " + temperature +" °C"+
                "\n-----------------------";


    }

}
