/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.zavrsnirad.controller;

import edunova.zavrsnirad.util.HibernateUtil;
import edunova.zavrsnirad.util.ZavrsniRadException;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public abstract class Obrada<T> {
    protected Session session;
    protected T entitet;

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
    public abstract List<T> read();
    protected abstract void kontrolaCreate() throws ZavrsniRadException;
    protected abstract void kontrolaUpdate() throws ZavrsniRadException;
    protected abstract void kontrolaDelete() throws ZavrsniRadException;

    
    public Obrada() {
        session = HibernateUtil.getSession();
    }
    
    
    public T create() throws ZavrsniRadException {
        kontrolaCreate();
        save();
        return entitet;
    }

    public T update() throws ZavrsniRadException {
        kontrolaUpdate();
        save();
        return entitet;
    }

    public void delete() throws ZavrsniRadException {
        kontrolaDelete();
        session.beginTransaction();
        session.delete(entitet);
        session.getTransaction().commit();
    }
    
    private void save() {
        session.beginTransaction();
        session.save(entitet);
        session.getTransaction().commit();
    }
    
}
