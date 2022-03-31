/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.xsoup.Xsoup;

/**
 *
 * @author Admin
 */
public class OibUtil {
    public static String generirajOib() {

        // umjesto spajanja na web stranicu napraviti generiranje u java programskom jeziku ZA OIB
        // https://regos.hr/app/uploads/2018/07/KONTROLA-OIB-a.pdf
        try {
            URL url = new URL("http://oib.itcentrala.com/oib-generator/");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            url.openStream()));

            String inputLine;
            StringBuilder sb = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();

            Document d = Jsoup.parse(sb.toString());

            return Xsoup.compile("/html/body/div[1]/div[1]/text()").evaluate(d).get();

        } catch (Exception e) {
        }
        return "";
    }

}
    

