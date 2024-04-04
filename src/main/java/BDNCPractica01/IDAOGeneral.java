/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BDNCPractica01;

import java.util.List;

/**
 *
 * @author boby
 */
public interface IDAOGeneral<T, ID>{
    public T buscarById(ID id);
    List<T> buscarAll();
    public boolean guardar(T p);
    public boolean modificar(T p);
    public boolean eliminar(T p);    
}
