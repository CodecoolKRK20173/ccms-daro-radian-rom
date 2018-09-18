package com.codecool.model.daoloader;

import java.io.*;
import java.util.ArrayList;

public class DAOLoader {
private String sourceFileName;

    public DAOLoader(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }

    public String[][] getFileContent() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(sourceFileName);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        ArrayList<String[]> fileContent = new ArrayList<String[]>();

        String line = null;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                fileContent.add(line.split("\t"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  fileContent.toArray(new  String[][]{});
    }

    public void saveContentToFile(String[][] contentToSave) {
        String content = turnContentToString(contentToSave);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/" + sourceFileName);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String turnContentToString(String[][] contentToSave) {
        StringBuilder stringBuilderContent = new StringBuilder();

        for (String[] row: contentToSave) {
            StringBuilder stringBuilderRow = new StringBuilder();

            for (String string: row) {
                stringBuilderRow.append(string);
                stringBuilderRow.append("\t");
            }
            stringBuilderRow.deleteCharAt(stringBuilderRow.lastIndexOf("\t"));
            stringBuilderRow.append("\n");

            stringBuilderContent.append(stringBuilderRow.toString());
        }

        return stringBuilderContent.toString();
    }
}
