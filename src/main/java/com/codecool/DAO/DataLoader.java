package com.codecool.DAO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataLoader {
    private String sourceFileName;

    public DataLoader(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }

    public String[][] getFileContent() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //File tmpSourceFile = new File(classLoader.getResource(sourceFileName).getFile());
        Path tempPath = Paths.get("src/main/resources/" + sourceFileName);

        if (!Files.exists(tempPath)) {
            File tmpSourceFile = new File("src/main/resources/" + sourceFileName);
            try {
                FileWriter fileWriter = new FileWriter(tmpSourceFile);
                fileWriter.write("");
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //InputStream inputStream = classLoader.getResourceAsStream(sourceFileName);
        //inputStream = classLoader.getResourceAsStream(sourceFileName);
        InputStreamReader inputStreamReader = new InputStreamReader(classLoader.getResourceAsStream(sourceFileName)); // gdy plik csv nie istnieje wywala NullPointera

//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
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

        return fileContent.toArray(new String[][]{});
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

        for (String[] row : contentToSave) {
            StringBuilder stringBuilderRow = new StringBuilder();

            for (String string : row) {
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
