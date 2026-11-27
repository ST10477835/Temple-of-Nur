/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package temple.of.nur;

/**
 *
 * @author Abulele
 */
class Item {
    
    public String Name;
    public temple.of.nur.Status Status = new Status(); //effect
    public int Price = 0;
    public Item(){}
    public Item(String Name){
        this.Name = Name;
    }
    
}
