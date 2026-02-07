package behavioural.command_pattern.with_command_design_pattern;

// import behavioural.momento_design_pattern.Good_code.TextEditor;

// Command interface
interface Command {
    void execute();
}

// Concrete classes for Commands
class BoldCommand implements Command {

    private TextEditor editor;

    public BoldCommand(TextEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.boldText();
    }
    
}

class TextEditor {
    public void boldText() {
        System.out.println("Bold Text...");
    }

    public void underLinedText() {
        System.out.println("Underlined Text...");
    }
}

// Button Class
class Button {
    private Command command;

    public void setCommandn(Command command) {
        this.command = command;
    }

    public void click() {
        command.execute();
    }
}


public class WithCommandDesignPattern {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        Button button = new Button();

        BoldCommand boldCommand = new BoldCommand(editor);

        button.setCommandn(boldCommand);

        button.click();
        
    }
}
