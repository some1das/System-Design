package behavioural.momento_design_pattern.Good_code;

// Stores Internal State of Text Editor
public class EditorMomento {
    private final String content;

    public EditorMomento(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }


}
