/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.util;
import edunova.zavrsnirad.model.Operater;

/**
 *
 * @author Admin
 */
public class OperaterUtil {
    public static Operater operater;
    public static final String NAZIV_APP = "Edunova app";
    
    
    public static String getNaslov(String naslov) {
        if (OperaterUtil.operater == null) {
            return OperaterUtil.NAZIV_APP + " " + naslov;
        }
        return OperaterUtil.NAZIV_APP + " " + naslov + " " + OperaterUtil.operater.getIme() + " "
                + OperaterUtil.operater.getPrezime() + " " + OperaterUtil.operater.getUloga();

    }
}
