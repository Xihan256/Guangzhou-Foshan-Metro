package cn.edu.scut.control;

import cn.edu.scut.model.StationWithLineID;

import java.util.ArrayList;
import java.util.Arrays;

public class FloydFindWay {
    private StationWithLineID[] allStation;
    private int[][] adjacencyMatrix_init;
    private int[][] path;//前驱矩阵

    private int[][] adjacencyMatrix_use;
    public static FloydFindWay instance;

    private int numOfStations;

    private ArrayList<StationWithLineID>foundedPath;

    private FloydFindWay(){
        FindWayPrepare fp = FindWayPrepare.getInstance();
        this.allStation = fp.getAllStation();
        this.adjacencyMatrix_init = fp.getAdjacencyMatrix();
        this.numOfStations = fp.getSize();
        this.path = new int[numOfStations][numOfStations];
        this.foundedPath = new ArrayList<>();


        for (int i = 0; i < numOfStations; i++) {
            Arrays.fill(path[i],i);
        }

        this.adjacencyMatrix_use = new int[numOfStations][numOfStations];
        resetAdjacencyMatrix();
    }

    private void resetAdjacencyMatrix(){
        for (int i = 0; i < numOfStations; i++) {
            for (int j = 0; j < numOfStations; j++){
                adjacencyMatrix_use[i][j] = adjacencyMatrix_init[i][j];
            }
        }
    }

    public static FloydFindWay getInstance(){
        if(instance == null){
            instance = new FloydFindWay();
        }
        return instance;
    }

    public void floyd() {
        this.resetAdjacencyMatrix();


        //保存距离
        int len;
        //k为中间顶点
        for (int k = 0; k < this.numOfStations; k++) {
            //i为开始顶点
            for (int i = 0; i < this.numOfStations; i++) {
                //j为结束顶点
                for (int j = 0; j < this.numOfStations; j++) {
                    len = adjacencyMatrix_use[i][k] + adjacencyMatrix_use[k][j];
                    if (len < adjacencyMatrix_use[i][j]) {
                        adjacencyMatrix_use[i][j] = len;//更新距离
                        path[i][j] = path[k][j];//更新前驱矩阵
                    }
                }
            }
        }

    }

    private void showAToBPath(int beginIndex, int endIndex) {
        if (this.path[beginIndex][endIndex] == endIndex && this.path[beginIndex][endIndex] == beginIndex) {
            return;
        }

        showAToBPath(beginIndex, path[beginIndex][endIndex]);
        foundedPath.add(this.allStation[path[beginIndex][endIndex]]);

    }

    public ArrayList<StationWithLineID> getPath(String begin, String end ){
        this.foundedPath.clear();

        int beginID = this.getIDByStationName(begin);
        int endID = this.getIDByStationName(end);

        //System.out.println(beginID + " " + endID);

        showAToBPath(beginID,endID);
        this.foundedPath.add(getStationByName(end));

        if(this.foundedPath.get(0).getStation().getName().equals(this.foundedPath.get(1).getStation().getName())){
            this.foundedPath.remove(0);
        }
        int tmp = this.foundedPath.size();
        if(this.foundedPath.get(tmp-1).getStation().getName().equals(this.foundedPath.get(tmp-2).getStation().getName())){
            this.foundedPath.remove(tmp-1);
        }

        return this.foundedPath;
    }

    private StationWithLineID getStationByName(String name){
        for (int i = 0; i < this.allStation.length; i++) {
            if(this.allStation[i].getStation().getName().equals(name)){
                return this.allStation[i];
            }
        }
        return null;
    }

    private int getIDByStationName(String name) {
        for (int i = 0; i < allStation.length; i++) {
            if(allStation[i].getStation().getName().equals(name)){
                return allStation[i].getUniformID();
            }
        }

        return -1;
    }
}
