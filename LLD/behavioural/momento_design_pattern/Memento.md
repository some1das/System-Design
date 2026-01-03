# Behavioural Design Pattern

##  1. Memento Design Pattern

The Memento Design Pattern is a behavioral design pattern used to save and restore an object’s previous state without violating **encapsulation** and **Single Responsibility Principle (SRP)**.

Example: Text Editor's Undo Functionallity

- BAD Code example:
    ```java

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

    ```

### How Memento Design Pattern Help here?

#### Components of Memento Design Patern
- **Originator**: The object whose state need to be saved.
- **Memento**: Captures and stores the internal state of the originator.
- **Caretaker**: Manages and stores the mementos without modifying them.

### Implementation of Undo in Text Editor Using Memento Design Pattern

#### TextEditor Class
This is our **originator**.
```java
public class TextEditor {
    private String content;

    public void write(String text) {
        this.content = text;
    }

    public String getContent() {
        return this.content;
    }
    public EditorMomento save() {
        return new EditorMomento(content);
    }

    public void restore(EditorMomento momento) {
        this.content = momento.getContent();
    }
}
```

#### EditorMemento Class

```java
public class EditorMomento {
    private final String content;

    public EditorMomento(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}

```

#### Caretacker Class [History Class]
It stores and manages the internal states of TextEditor class.
```java
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
```

#### Driver Class [Main Class]

```java
public class TextEditorMain {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.write("Hello WOrld");

        history.saveState(editor);

        editor.write("Hello All");
        history.saveState(editor);

        System.out.println(editor.getContent());

        history.undo(editor);
        System.out.println(editor.getContent());
    }
}
```