package cn.edu.scut.control;

import cn.edu.scut.model.Station;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MakeStationArr{

    private static MakeStationArr instance;
    private MakeStationArr() {
    }

    public static MakeStationArr getInstance(){
        if(instance == null){
            instance = new MakeStationArr();
        }
        return instance;
    }

    public Station[] getArrByLineID(String lineName) {
        //TODO 切换文件在这里
        String json = JSONtoStr("F:\\javaPlace\\takingMetro\\src\\main\\resources\\Stations.json");
        JSONObject jobject = JSON.parseObject(json);
        JSONArray jsonArray = jobject.getJSONArray(lineName);

        Station[] stations = jsonArray.toArray(Station.class);

        return stations;
    }

    private static String JSONtoStr(String fileName){
        StringBuilder stringBuilder = new StringBuilder();

        try(BufferedReader br= Files.newBufferedReader(Paths.get(fileName))) {
            String str;
            while ((str=br.readLine())!=null){
                stringBuilder.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
