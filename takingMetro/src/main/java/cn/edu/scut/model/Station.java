package cn.edu.scut.model;


public class Station {
    private String ID;
    private String name;

    public Station(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }



    @Override
    public String toString() {
        return "Station{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }


}
