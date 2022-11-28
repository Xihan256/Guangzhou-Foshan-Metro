package cn.edu.scut.control;
import cn.edu.scut.model.Line;
import cn.edu.scut.model.StationWithLineID;

import java.util.ArrayList;

public class FindWayPrepare {

    private int [][] adjacencyMatrix;
    private Line[]lines;
    private StationWithLineID[] allStation;

    private static final int INF = 1000;

    private static FindWayPrepare instance;

    public static FindWayPrepare getInstance(){
        if(instance == null){
            instance = new FindWayPrepare();
        }
        return instance;
    }

    public int getSize(){
        return this.allStation.length;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    private FindWayPrepare() {
        LoadAll loadAll = LoadAll.getInstance();
        this.allStation = loadAll.getAllStation();
        this.lines = loadAll.getLines();

        this.makeAdjacencyMatrix(loadAll.getNumofStations());
    }

    private void makeAdjacencyMatrix(int size){
        this.adjacencyMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.adjacencyMatrix[i][j] =INF;
            }
        }

        int index = 0;
        for (int i = 0; i < this.lines.length; i++) {
            for (int j = 0; j < this.lines[i].getNumOfStations() - 1; j++) {
                connect(index,index,0);
                connect(index,index+1,1);
                index++;
            }
            connect(index,index,0);
            index++;
        }

        /* TODO 在这里配置换乘的连接,来这里调参数 */
        this.connectInterchange("公园前",4);
        this.connectInterchange("体育西路",10);
        this.connectInterchange("广州东站",8);
        this.connectInterchange("嘉禾望岗",4);
        this.connectInterchange("大学城南",8);
        this.connectInterchange("万胜围",5);
        this.connectInterchange("车陂南",10);
        this.connectInterchange("坦尾",12);
        this.connectInterchange("西村",9);
        this.connectInterchange("广州火车站",15);
        this.connectInterchange("区庄",6);
        this.connectInterchange("珠江新城",10);
        this.connectInterchange("黄沙",8);
        this.connectInterchange("陈家祠",10);
        this.connectInterchange("文化公园",7);
        this.connectInterchange("海珠广场",6);
        this.connectInterchange("东山口",9);
        this.connectInterchange("燕塘",10);
        this.connectInterchange("天河客运站",10);
        this.connectInterchange("广州南站",20);
        this.connectInterchange("石壁",8);
        this.connectInterchange("汉溪长隆",15);
        this.connectInterchange("昌岗",8);
        this.connectInterchange("客村",8);
        this.connectInterchange("高增",4);
        this.connectInterchange("西塱",10);
        this.connectInterchange("宝岗大道",8);
        this.connectInterchange("南洲",8);
        this.connectInterchange("沥滘",12);
        this.connectInterchange("鱼珠",8);
        this.connectInterchange("新和",6);
        this.connectInterchange("番禺广场",6);
        this.connectInterchange("南村万博",20);
        this.connectInterchange("磨碟沙",20);
        this.connectInterchange("员村",14);
        this.connectInterchange("黄村",14);
        this.connectInterchange("苏元",12);
        this.connectInterchange("镇龙",14);
        this.connectInterchange("魁奇路",10);
        this.connectInterchange("湾华",8);
        this.connectInterchange("北滘公园",8);
    }

    private void connect(int station1,int station2,int weight){
        this.adjacencyMatrix[station1][station2] = weight;
        this.adjacencyMatrix[station2][station1] = weight;
    }

    private String getStationNameByID(int ID){
        return this.allStation[ID].getStation().getName();
    }

    private Integer[] getIDByStationName(String name) {
        ArrayList<Integer>arrayList = new ArrayList<>();
        for (int i = 0; i < allStation.length; i++) {
            if(allStation[i].getStation().getName().equals(name)){
                arrayList.add(allStation[i].getUniformID());
            }
        }

        return arrayList.toArray(new Integer[0]);
    }

    private void connectInterchange(String stationName,int weight){
        Integer[] ids = this.getIDByStationName(stationName);
        if(ids.length<= 1){
            return;
        }

        for (int i = 0; i < ids.length - 1; i++) {
            connect(ids[i],ids[i+1],weight);
        }
        connect(ids[0],ids[ids.length-1],weight);
    }

    public StationWithLineID[] getAllStation() {
        return allStation;
    }
}

