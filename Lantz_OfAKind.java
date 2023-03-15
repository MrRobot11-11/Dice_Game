/*Steven Lantz
ITDEV-140-002
Fall 2019
Assignment 3*/
package lantz_ofakind;


public class Lantz_OfAKind {

   
    public static void main(String[] args) {
    
        Controller play = new Controller();    
        View ui = new View();

       ui.Intro();
        ui.pressEnter();
        play.Play();
        ui.peaceOut();
    
    }

}
