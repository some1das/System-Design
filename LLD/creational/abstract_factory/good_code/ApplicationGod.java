package creational.abstract_factory.good_code;

// Abstract Product Interface

interface Button {
    void render();
}

interface ScrollBar {
    void scroll();
}

// Windows UI components
class WindowsButton implements Button{
    public  void render() {
        System.out.println("Rendering windows UI button...");
    }
}

class WindowsScrollBar implements ScrollBar{
    public  void scroll() {
        System.out.println("Rendering windows Scroll Bar...");
    }
}

// Mac UI components
class MacButton implements Button{
    public  void render() {
        System.out.println("Rendering MAC UI button...");
    }
}

class MacScrollBar implements ScrollBar{
    public  void scroll() {
        System.out.println("Rendering MAC Scroll Bar...");
    }
}

interface UIFactory {
    public Button createButton();

    public ScrollBar createScrollBar();
}

class WindowsFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new WindowsScrollBar();
    }
    
}

class MacFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new MacScrollBar();
    }
    
}



public class ApplicationGod{
    private Button button;

    private ScrollBar scrollBar;

    public ApplicationGod(UIFactory factory) {
        this.button = factory.createButton();
        this.scrollBar = factory.createScrollBar();
    }

    public void renderUI() {
        button.render();
        scrollBar.scroll();
    }
    public static void main(String[] args) {
        // Windows UI
        UIFactory factory = new WindowsFactory();
        ApplicationGod application = new ApplicationGod(factory);

        application.renderUI();

    }
}
