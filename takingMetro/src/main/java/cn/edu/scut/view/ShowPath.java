package cn.edu.scut.view;

import cn.edu.scut.control.FloydFindWay;
import cn.edu.scut.model.StationWithLineID;

import java.util.ArrayList;

public class ShowPath {
    public static void main(String[] args) {
        FloydFindWay findWay = FloydFindWay.getInstance();
        findWay.floyd();
        ArrayList<StationWithLineID> path = findWay.getPath("大学城南", "江南西");

        for (int i = 0; i < path.size(); i++) {
            System.out.println(path.get(i));
        }
    }
}
