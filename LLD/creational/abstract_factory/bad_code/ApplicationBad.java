package creational.abstract_factory.bad_code;

// Windows UI components
class WindowsButton {
    public  void render() {
        System.out.println("Rendering windows UI button...");
    }
}

class WindowsScrollBar {
    public  void render() {
        System.out.println("Rendering windows Scroll Bar...");
    }
}

// Mac UI components
class MacButton {
    public  void render() {
        System.out.println("Rendering MAC UI button...");
    }
}

class MacScrollBar {
    public  void render() {
        System.out.println("Rendering MAC Scroll Bar...");
    }
}

public class ApplicationBad {
    public static void main(String[] args) {
        // Windows UI
        WindowsButton button = new WindowsButton();
        WindowsScrollBar scrollBar = new WindowsScrollBar();

        button.render();
        scrollBar.render();

    }
}
