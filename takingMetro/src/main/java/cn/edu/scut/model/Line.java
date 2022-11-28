package cn.edu.scut.model;

public class Line {
    private String LineID;
    private int numOfStations;
    Station [] stations;

    public Line(String lineID, int numOfStations, Station[] stations) {
        LineID = lineID;
        this.numOfStations = numOfStations;
        this.stations = stations;
    }

    public Line(int ID, int numOfStations, Station[] stations) {
        LineID = "Line"+ID;
        this.numOfStations = numOfStations;
        this.stations = stations;
    }

    public Line(String lineID, Station[] stations) {
        LineID = lineID;
        this.stations = stations;
        this.numOfStations = stations.length;
    }

    public int getNumOfStations() {
        return numOfStations;
    }

    public Station getStationByIndex(int index){
        return this.stations[index];
    }
}
