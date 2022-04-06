/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.view;

import edunova.zavrsnirad.model.Komponenta;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author Admin
 */
public class KomponentaComparator implements Comparator<Komponenta>{
    private Collator hr;

    public KomponentaComparator() {
        hr = Collator.getInstance(new Locale("hr", "HR")); //Your locale here
        hr.setStrength(Collator.PRIMARY);
    }

    @Override
    public int compare(Komponenta o1, Komponenta o2) {
        return hr.compare(o1.getNaziv(), o2.getNaziv());
    }

    

    
}
