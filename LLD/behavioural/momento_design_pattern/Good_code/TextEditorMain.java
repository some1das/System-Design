package behavioural.momento_design_pattern.Good_code;

public class TextEditorMain {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.write("Hello WOrld");

        history.saveState(editor);

        editor.write("Hello All");
        history.saveState(editor);

        System.out.println(editor.getContent());

        // Undo the last write


        history.undo(editor);
        System.out.println(editor.getContent());

        // Problem -> I want to undo the last write and see what was earlier
        // SOlution -> Memento Design Pattern
    }
}

