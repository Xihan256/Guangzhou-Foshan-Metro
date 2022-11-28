package cn.edu.scut.control;

import cn.edu.scut.model.Line;
import cn.edu.scut.model.StationWithLineID;

import java.util.ArrayList;
public class LoadAll {
    private static final int NUM_LINES = 19;
    /* TODO 改线路数 */


    private Line[] lines;
    private StationWithLineID[] allStation;

    private static LoadAll instance;

    private LoadAll() {
        lines = new Line[NUM_LINES];
        this.loadLines();
        this.loadStations();
    }

    public static LoadAll getInstance(){
        if(instance==null){
            instance = new LoadAll();
        }
        return instance;
    }

    private void loadLines() {
        this.lines = new Line[NUM_LINES];
        MakeStationArr make = MakeStationArr.getInstance();
        //TODO 加线路时候这里要加
        this.lines[0] = new Line("Line1",make.getArrByLineID("Line1"));
        this.lines[1] = new Line("Line2",make.getArrByLineID("Line2"));
        this.lines[2] = new Line("Line3",make.getArrByLineID("Line3"));
        this.lines[3] = new Line("Line3b",make.getArrByLineID("Line3b"));
        this.lines[4] = new Line("Line4",make.getArrByLineID("Line4"));
        this.lines[5] = new Line("Line5",make.getArrByLineID("Line5"));
        this.lines[6] = new Line("Line6",make.getArrByLineID("Line6"));
        this.lines[7] = new Line("Line7",make.getArrByLineID("Line7"));
        this.lines[8] = new Line("Line8",make.getArrByLineID("Line8"));
        this.lines[9] = new Line("Line9",make.getArrByLineID("Line9"));
        this.lines[10]= new Line("Guangfo", make.getArrByLineID("Guangfo"));
        this.lines[11]= new Line("Line13", make.getArrByLineID("Line13"));
        this.lines[12]= new Line("Line14", make.getArrByLineID("Line14"));
        this.lines[13]= new Line("Line14b", make.getArrByLineID("Line14b"));
        this.lines[14]= new Line("Line18", make.getArrByLineID("Line18"));
        this.lines[15]= new Line("Line21", make.getArrByLineID("Line21"));
        this.lines[16]= new Line("Line22", make.getArrByLineID("Line22"));
        this.lines[17]= new Line("Foshan2", make.getArrByLineID("Foshan2"));
        this.lines[18]= new Line("Foshan3", make.getArrByLineID("Foshan3"));
    }

    private void loadStations() {

        ArrayList<StationWithLineID>arrayList = new ArrayList<>();
        int uniformID =0;
        for (int i = 0 ; i < NUM_LINES ; i++){
            for (int j = 0; j < this.lines[i].getNumOfStations(); j++) {

                switch (i){
                    case 0:
                    case 1:
                    case 2:{
                        arrayList.add(new StationWithLineID(Integer.toString(1+i),lines[i].getStationByIndex(j),uniformID));
                        break;
                    }
                    case 3:{
                        arrayList.add(new StationWithLineID("3号线支线",lines[i].getStationByIndex(j),uniformID));
                        break;
                    }
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:{
                        arrayList.add(new StationWithLineID(Integer.toString(i),lines[i].getStationByIndex(j),uniformID));
                        break;
                    }
                    case 10:{
                        arrayList.add(new StationWithLineID("广佛线",lines[i].getStationByIndex(j),uniformID));
                        break;
                    }
                    case 11:{
                        arrayList.add(new StationWithLineID("13",lines[i].getStationByIndex(j),uniformID));
                        break;
                    }
                    case 12:{
                        arrayList.add(new StationWithLineID("14",lines[i].getStationByIndex(j),uniformID));
                        break;
                    }
                    case 13:{
                        arrayList.add(new StationWithLineID("14号线知识城支线",lines[i].getStationByIndex(j),uniformID));
                        break;
                    }
                    case 14:{
                        arrayList.add(new StationWithLineID("18",lines[i].getStationByIndex(j),uniformID));
                        break;
                    }
                    case 15:{
                        arrayList.add(new StationWithLineID("21",lines[i].getStationByIndex(j),uniformID));
                        break;
                    }
                    case 16:{
                        arrayList.add(new StationWithLineID("22",lines[i].getStationByIndex(j),uniformID));
                        break;
                    }
                    case 17:{
                        arrayList.add(new StationWithLineID("佛山2号线",lines[i].getStationByIndex(j),uniformID));
                        break;
                    }
                    case 18:{
                        arrayList.add(new StationWithLineID("佛山3号线",lines[i].getStationByIndex(j),uniformID));
                        break;
                    }
                    default:
                        break;
                }

                uniformID++;
            }
        }

        this.allStation = new StationWithLineID[arrayList.size()];
        arrayList.toArray(this.allStation);
    }

    public void showAll(){
        for (int i = 0; i < allStation.length; i++) {
            System.out.println(allStation[i]);
        }
    }


    public int getNumofStations(){
        return this.allStation.length;
    }

    public Line[] getLines() {
        return lines;
    }

    public StationWithLineID[] getAllStation() {
        return allStation;
    }
}

