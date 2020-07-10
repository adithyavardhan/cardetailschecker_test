package regression;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileUtilsClass {

    File myfile;

    public boolean checkFileExists(String fileName){
        myfile = new File(fileName);
        return myfile.exists();
    }

    public List<String> readFileLines() throws IOException {

        List<String> lines = FileUtils.readLines(myfile, "utf-8");
        System.out.println(lines);
        return lines;

    }

    public List<String> abstractCarNumbers(List<String> linesInFile) {
        List<String> carNumbers = new ArrayList<String>();
        String carNumber = "";

        for(String line:linesInFile){
            String beforeText1 = "registration ";
            if(line.contains(beforeText1)) {
                carNumber = line.substring(line.indexOf(beforeText1), line.indexOf(beforeText1) + (beforeText1).length() + 7).replace(beforeText1, "");
                carNumbers.add(carNumber);
            }

            String beforeText2 = "registrations ";
            if(line.contains(beforeText2)) {
                carNumber = line.substring(line.indexOf(beforeText2), line.indexOf(beforeText2) + (beforeText2).length() + 7).replace(beforeText2, "");
                carNumbers.add(carNumber);
            }

            String beforeText3 = "X and ";
            if(line.contains(beforeText3)) {
                carNumber = line.substring(line.indexOf(beforeText3), line.indexOf(beforeText3) + (beforeText3).length() + 7).replace(beforeText3, "");
                carNumbers.add(carNumber);
            }
        }
        return carNumbers;
    }

    public List<HashMap<String, String>> abstractExpDetailsOfCars(List<String> linesInFile) {

        List<HashMap<String, String>> myArrList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
        for(String line:linesInFile){
            map = new HashMap<String, String>();
            map.put("REGISTRATION",line.split(",")[0]);
            map.put("MAKE",line.split(",")[1]);
            map.put("MODEL",line.split(",")[2]);
            map.put("COLOR",line.split(",")[3]);
            map.put("YEAR",line.split(",")[4]);
            myArrList.add(map);
        }
        //remove first
        myArrList.remove(0);

        return myArrList;
    }
}
