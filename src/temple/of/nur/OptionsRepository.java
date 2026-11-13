/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package temple.of.nur;

/**
 *
 * @author Abulele
 */
public class OptionsRepository {
    Options PauseMenuOptions = new Options(new String[]{
        "Resume",
        "Check Inventory",
        "Exit Game"
    }, 0){
        @Override
        public void OptionHandler(){
            switch(this.i){
                case 0 -> Resume();
                case 1 -> CheckInventory();
                case 2 -> ExitGame();
            }
            System.out.println("Clicked");
        }
        public void Resume(){
            GamePanel.GamePaused = false;
            
        }
        public void CheckInventory(){}
        public void ExitGame(){
            System.exit(0);
        }
         
    };
    Options FightMenuOptions = new Options(new String[]{
        "Attack",
        "Use Item",
        "Block",
        "Escape",
        "Filler"
    },0){
        @Override
        public void OptionHandler(){
            switch(this.i){
                case 0 -> Attack();
                case 1 -> UseItem();
                case 2 -> Block();
                case 3 -> Escape();
            }
        }
        public void Attack(){}
        public void UseItem(){}
        public void Block(){}
        public void Escape(){}
    };
}
