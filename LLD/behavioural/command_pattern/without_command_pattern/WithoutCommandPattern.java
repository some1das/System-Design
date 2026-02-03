package behavioural.command_pattern.without_command_pattern;

class TextEditor {
    public void boldText() {
        System.out.println("Bold Text...");
    }

    public void underLinedText() {
        System.out.println("Underlined Text...");
    }
}

// UI Button
class BoldButton {
    private TextEditor editor;

    public BoldButton(TextEditor editor) {
        this.editor = editor;
    }

    public void click() {
        editor.boldText();
    }
}

class UnderlinedButton {
    private TextEditor editor;

    public UnderlinedButton(TextEditor editor) {
        this.editor = editor;
    }

    public void click() {
        editor.underLinedText();
    }
}

public class WithoutCommandPattern {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        BoldButton boldButton = new BoldButton(editor);

        boldButton.click();
    }
}
