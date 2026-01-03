package behavioural.momento_design_pattern.bad_code;

public class TextEditor {
    private String content;

    public void write(String text) {
        this.content = text;
    }

    public String getContent() {
        return this.content;
    }
}


/**
 * Here If we introduce feature of state management then it will voilate SRP
 * As state management is not the responsibility of our TextEditor
 * 
 */
