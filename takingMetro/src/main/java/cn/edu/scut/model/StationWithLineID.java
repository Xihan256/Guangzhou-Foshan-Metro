package cn.edu.scut.model;

public class StationWithLineID {
    public String lineIDs;
    public Station station;

    int uniformID;

    public StationWithLineID(String lineIDs, Station station,int uniformID) {
        this.lineIDs = lineIDs;
        this.station = station;
        this.uniformID = uniformID;
    }

    public int getUniformID() {
        return this.uniformID;
    }

    @Override
    public int hashCode() {
        return station.hashCode();
    }

    @Override
    public String toString() {
        if(lineIDs.length() == 1 ||lineIDs.length() == 2){
            return  lineIDs + "号线 , " + station.getName() ;
        }else{
            return  lineIDs + " , " + station.getName() ;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return this.hashCode() == o.hashCode();
    }

    public Station getStation() {
        return station;
    }
}
