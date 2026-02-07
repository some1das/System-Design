package behavioural.template_pattern.bad_code;


class CSVParser {
    public void parse() {
        openFile();
        
        // csvSpecificParsingLogin();
        System.out.println("Parsing CSV file...");

        closeFile();
    }

    private void openFile() {
        System.out.println("Opening file...");
    }

    private void closeFile() {
        System.out.println("Close file...");
    }
}

class JSONParser {
    public void parse() {
        openFile();
        
        // jsonSpecificParsingLogin();
        System.out.println("Parsing JSON file...");

        closeFile();
    }

    private void openFile() {
        System.out.println("Opening file...");
    }

    private void closeFile() {
        System.out.println("Close file...");
    }
}


public class FileParser {
    public static void main(String[] args) {
        CSVParser csvParser = new CSVParser();
        csvParser.parse();

        JSONParser jsonParser = new JSONParser();
        jsonParser.parse();
    }
    
}
