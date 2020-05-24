package VL_Aufgaben.VL7;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class start {
    public static void main(String[] args) {

//Angestellert mit regisrierten Listener auf Eingabefeld
        /*
        AngestellterBean ab = new AngestellterBean("Christopher",50000);
        Eingabefeld e = new Eingabefeld(ab.getsName());
        System.out.println(ab.getsName());

        //Registrieren von change listener auf die Property text des Objektes e vom Typ Eingabefeld
        e.testProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                ab.setsName(newValue);
                System.out.println("Wert von Text geändert von "+oldValue+" nach "+newValue);
            }
        });

        //Registrieren von change listener auf die Property text des Objektes e vom Typ Eingabefeld
        e.testProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                SimpleStringProperty sp = (SimpleStringProperty) observable;
                ab.setsName(sp.get());
                System.out.println("Wert von Text geändert nach "+sp.get());
            }
        });


        //Ändern des Wertes von text in Objekt e zum testen der Listener
        e.setText("Paul");
        System.out.println(ab.getsName());
        */

 //Angestellter mit Bindings
        AngestellterBeanProp abp = new AngestellterBeanProp("Christopher",50000);
        Eingabefeld e = new Eingabefeld(abp.getsName());

        System.out.println(abp.getsName());

        //Binden der Textproperty des Eingabefeldes des Eingabeobjektes
        abp.sNameProperty().bind(e.testProperty());

        e.setText("Paul");
        System.out.println(abp.getsName());

    }
}
