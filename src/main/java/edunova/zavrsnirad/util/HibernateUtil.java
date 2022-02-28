/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 *
 * @author Admin
 */


// singleton princip https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
public class HibernateUtil {
    
    private static StandardServiceRegistry registry;
    private static Session session;
    public static Session getSession() {
        if(session==null) {
            // upogoni hibernate
            
            try {
                registry = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources sources = new MetadataSources(registry);
                Metadata metadata = sources.getMetadataBuilder().build();
                SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
                session = sessionFactory.openSession();
            } catch (Exception e) {
                e.printStackTrace();
                if(registry!=null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
            
        }
        return session;
    }
    
    
    
    
    
}
