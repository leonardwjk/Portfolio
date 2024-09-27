/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author jawsS
 * @param
 */
public interface SortedListInterface <T>{
    public boolean add(T newEntry);
   public boolean remove(T anEntry);
   public T find(int id);
   public void filter(Object prefix);
   public boolean Change(T studentChange, Object changeTo);
    public void list();
    public void generateReport();
}
