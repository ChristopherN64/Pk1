package VL_Aufgaben.VL7;

import java.io.Serializable;

public class AngestellterBean implements Serializable {
    private String sName;
    private int iGehalt;

    public AngestellterBean(String sName, int iGehalt)
    {
        this.sName=sName;
        this.iGehalt=iGehalt;
    }
    public AngestellterBean()
    {
        super();
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getiGehalt() {
        return iGehalt;
    }

    public void setiGehalt(int iGehalt) {
        this.iGehalt = iGehalt;
    }
}
