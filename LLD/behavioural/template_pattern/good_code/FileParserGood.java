package behavioural.template_pattern.good_code;

abstract class FileParser {

    public final void parse() {
        fileOpen();
        parseFile();
        fileClose();
    }

    public void fileOpen() {
        System.out.println("FIle Opened...");
    }

    public abstract void parseFile();

    public void fileClose() {
        System.out.println("File Closed...");
    }
}

class CsvParser extends FileParser {

    @Override
    public void parseFile() {
        System.out.println("Parsing CSV....");
    }
    
}

class JsonParser extends FileParser {

    @Override
    public void parseFile() {
        System.out.println("Parsing JSON....");
    }
    
}

public class FileParserGood {
    public static void main(String[] args) {
        FileParser csvParser = new CsvParser();
        FileParser jsonParser = new JsonParser();

        csvParser.parse();
        jsonParser.parse();
    }
    
}
