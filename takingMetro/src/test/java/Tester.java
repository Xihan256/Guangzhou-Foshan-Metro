import cn.edu.scut.control.FindWayPrepare;
import cn.edu.scut.control.FloydFindWay;
import cn.edu.scut.control.LoadAll;
import cn.edu.scut.model.StationWithLineID;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class Tester {

    @Test
    public void readJson(){

        LoadAll findWay = LoadAll.getInstance();
        findWay.showAll();
        System.out.println(findWay.getNumofStations());
    }

}


