package Tests;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomDataProvider {
    @DataProvider(name = "amountDataProvider")
    public Object[][] readTestData() throws IOException {
        String csvFile = "TransferData.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            List<Object[]> testData = new ArrayList<>();
            br.readLine();
            int index = 0;
            while ((line = br.readLine()) != null) {
                String[] stringData = line.split(csvSplitBy);
                testData.add(stringData);
                index++;
            }

            return testData.toArray(new Object[0][0]);
        }
    }
}
