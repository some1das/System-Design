package behavioural.momento_design_pattern.Good_code;

import java.util.Stack;

// Manages Memento
public class History {
    private final Stack<EditorMomento> history = new Stack<>();

    public void saveState(TextEditor editor) {
        history.push(editor.save());
    }

    public void undo(TextEditor editor) {
        if(!history.isEmpty()) {
            history.pop();
            editor.restore(history.peek());
        }
    }
}
