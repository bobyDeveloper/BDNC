/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BDNCPractica01;

import java.sql.Connection;
/**
 *
 * @author boby
 */
public abstract class Transaction<T> {
    protected T pojo;
    protected Transaction(T pojo){
        this.pojo=pojo;
    }
    public abstract boolean execute(Connection con);   
}
