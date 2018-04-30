package com.ideas.assignment;


import java.io.*;
import java.util.*;

/**
 * Created by bhuvneshk on 15/4/18.
 */
public class SoftwareVersionControl {


    public static Map<String, List<String>> processStringToSoftwareVersion(List<String> softVerDetailStringList){

        Map<String, List<String>> softwareNameAndVersionMap = new HashMap<String, List<String>>();

        for (String softVerDetailString : softVerDetailStringList) {

            String[] rawSoftwareDetailString = softVerDetailString.split(",");
            String softwareName = rawSoftwareDetailString[2];
            String softwareVersion = rawSoftwareDetailString[3].trim();


            if (softwareNameAndVersionMap.containsKey(softwareName)) {

                List<String> versions = softwareNameAndVersionMap.get(softwareName);

                String latestVersion = versions.get(versions.size()-1);

                if(softwareVersion.compareTo(latestVersion) > 0){

                    versions.add(softwareVersion);

                }else{

                    versions.set(versions.size()-1 , softwareVersion);

                    versions.add(latestVersion);
                }

            } else {

                List<String> versions = new ArrayList<String>();

                versions.add(softwareVersion);

                softwareNameAndVersionMap.put(softwareName, versions);

            }

        }

        return softwareNameAndVersionMap;
    }

    public static List<String> getOutDatedSoftware(Map<String, List<String>> softwareVersionMap){

        List<String> outdateVersion = new ArrayList();

        for (String softwareName : softwareVersionMap.keySet()){

            List<String>  softVerList = softwareVersionMap.get(softwareName);

            if(softVerList.size() > 2){

                String latestVersion = softVerList.get(softVerList.size()-1);

                int count =0;

                for ( String softwareVersion : softVerList) {

                    if(!latestVersion.equals(softwareVersion)){

                        count++;

                        if(count == 2){

                            outdateVersion.add(softwareName);
                            break;
                        }

                    }

                }
            }

        }

        return outdateVersion;
    }
    public static void main(String[] args)  {


            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(
                    new File("src/main/java/com/ideas/assignment/SoftwareVersionDetails.txt")));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/java/com/ideas/assignment/SoftwareVersionDetailsOP.txt"))){

            String line = "";

            List<String> rawDataList = new ArrayList<String>();

            while ((line = bufferedReader.readLine()) != null) {

                rawDataList.add(line);

            }

            Map<String, List<String>> softwareVersionMap = processStringToSoftwareVersion(rawDataList);

            List<String> outDatedSoftwareList = getOutDatedSoftware(softwareVersionMap);


            for (String outDateSoftware : outDatedSoftwareList)
            bufferedWriter.write(outDateSoftware+" \n" +
                    "");

            }catch (IOException e){

                e.printStackTrace();

            }
    }
}
