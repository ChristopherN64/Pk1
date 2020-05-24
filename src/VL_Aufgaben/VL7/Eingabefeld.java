package VL_Aufgaben.VL7;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Eingabefeld {
    private StringProperty text;

    public Eingabefeld(String text)
    {
        super();
        this.text = new SimpleStringProperty(text);
    }

    public StringProperty testProperty()
    {
        return this.text;
    }

    public void setText(String text)
    {
        this.text.setValue(text);
    }

    public String getText()
    {
        return this.text.get();
    }

}
