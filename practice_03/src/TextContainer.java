import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TextContainer {
    private String text;

    public TextContainer(String text) {
        this.text = text;
    }
    public TextContainer() {
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void saveTextToFile(String out) {
        try(PrintWriter pw = new PrintWriter(out)) {
            pw.println(this.text);
        } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
        }
    }
    @Override
    public String toString() {
        return "TextContainer{" +
                "text='" + text + '\'' +
                '}';
    }
}
