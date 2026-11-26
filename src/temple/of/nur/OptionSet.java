/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package temple.of.nur;

import java.awt.Graphics;

/**
 *
 * @author Abulele
 */
public class OptionSet {
    public String Name;
    public String[] Options;
    public int i;
    public OptionSet LastOptionSet;
    
    public OptionSet(String Name, String[] Options, int i){
        this.Name = Name;
        this.Options = Options;
        this.i = i;
    }
    public OptionSet(String Name, String[] Options, int i, OptionSet LastOptionSet){
        this.Name = Name;
        this.Options = Options;
        this.i = i;
        this.LastOptionSet = LastOptionSet;
    }
    public void OptionHandler(){}
    public void Draw(Graphics g){}
}
