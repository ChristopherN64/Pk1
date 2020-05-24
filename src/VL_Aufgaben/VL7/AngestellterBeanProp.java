package VL_Aufgaben.VL7;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class AngestellterBeanProp implements Serializable {
    private SimpleStringProperty sName;
    private int iGehalt;

    public AngestellterBeanProp(String sName, int iGehalt)
    {
        this.sName = new SimpleStringProperty(sName);
        this.iGehalt=iGehalt;
    }
    public AngestellterBeanProp()
    {
        super();
        this.sName=new SimpleStringProperty("");
    }


    public SimpleStringProperty sNameProperty()
    {
        return sName;
    }

    public String getsName() {
        return sName.get();
    }

    public void setsName(String s) {
        this.sName.set(s);
    }

    public int getiGehalt() {
        return iGehalt;
    }

    public void setiGehalt(int iGehalt) {
        this.iGehalt = iGehalt;
    }
}
