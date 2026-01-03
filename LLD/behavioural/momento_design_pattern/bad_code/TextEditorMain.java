package behavioural.momento_design_pattern.bad_code;

public class TextEditorMain {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.write("Hello WOrld");

        editor.write("Hello All");

        // Problem -> I want to undo the last write and see what was earlier
    }
}

