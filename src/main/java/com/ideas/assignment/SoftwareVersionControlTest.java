package com.ideas.assignment;

import org.junit.Before;
import org.junit.Test;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by bhuvneshk on 15/4/18.
 */


public class SoftwareVersionControlTest {

    File file;
    private List<String> rawDataList;
    private Map<String, List<String>> processcedData;
    private List<String> outDatedSoftware;

    @Before
    public void setup(){

        file = new File("input.txt");
    }

    @Test
    public void testInputFileExist(){

        assertEquals("FileExist ",true, file.exists());

    }

    @Test
    public void testInputFileContainsData() throws IOException {

       BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line = "";

            List<String> rawDataList = new ArrayList<String>();

            while ((line = bufferedReader.readLine()) != null) {

                rawDataList.add(line);

            }

            assertEquals("File Consist Data" , true, rawDataList.size() > 0 );


            this.rawDataList = rawDataList;

    }


    @Test
    public void testProcessRawData(){

        Map<String, List<String>> processcedData = SoftwareVersionControl.processStringToSoftwareVersion(rawDataList);

        assertEquals("ProcesscedRawData ", true, processcedData.size() == rawDataList.size());

        this.processcedData = processcedData;

    }

    @Test
    public void testOutdatedSoftwareList(){

        List<String> outDatedSoftware = SoftwareVersionControl.getOutDatedSoftware(processcedData);

        assertEquals("Outdated software fouund", true, outDatedSoftware.size() >0);

        this.outDatedSoftware = outDatedSoftware;
    }


    @Test
    public void testWriteOutputFile() throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        for (String outdatedSoftwareName :outDatedSoftware) {

            bufferedWriter.write(outdatedSoftwareName+"\n");

        }

        assertEquals("OutpuFile write succesfully", true, new File("output.txt").exists());

    }
}
