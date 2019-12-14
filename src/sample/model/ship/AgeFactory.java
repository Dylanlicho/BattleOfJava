package sample.model.ship;


import sample.model.factory.GameFactory;
import sample.model.ship.Ship;
import sample.model.ship.century15s.Caravelle;
import sample.model.ship.century15s.Drakkar;
import sample.model.ship.century15s.Flette;
import sample.model.ship.century15s.Sailboat;
import sample.model.ship.century20s.*;
import sample.model.ship.century15s.*;

import java.util.ArrayList;

public class AgeFactory {

    /**
     * Create 7 ship according to the age
     * @param age Century
     * @return A list of 7 ships of century age
     */
    public static ArrayList<Ship> createNewShip(int age){
        if (age == GameFactory.CENTURY15S) {
            return create15SShip();
        }else if (age == GameFactory.CENTURY20S){
            return create20SShip();
        }
        return new ArrayList<Ship>();
    }

    /**
     * Create 7 ships of the century 15
     * @return A list of 7 ships of century 15
     */
    private static ArrayList<Ship> create15SShip(){
        ArrayList<Ship> ships = new ArrayList<Ship>();

        Sailboat sailboat = new Sailboat(1,1,8,GameFactory.LEFT);
        Caravelle caravelle1 = new Caravelle(1,0,4,GameFactory.LEFT);
        Caravelle caravelle2 = new Caravelle(1,2,4,GameFactory.LEFT);
        Flette flette1 = new Flette(1,4,0,GameFactory.LEFT);
        Flette flette2 = new Flette(1,4,2,GameFactory.LEFT);
        Flette flette3 = new Flette(1,4,4,GameFactory.LEFT);
        Drakkar drakkar = new Drakkar(1,9,2,GameFactory.LEFT);

        ships.add(sailboat);
        ships.add(caravelle1);
        ships.add(caravelle2);
        ships.add(flette1);
        ships.add(flette2);
        ships.add(flette3);
        ships.add(drakkar);
        return ships;
    }

    /**
     * Create 7 ships of the century 20
     * @return A list of 7 ships of century 20
     */
    private static ArrayList<Ship> create20SShip(){
        ArrayList<Ship> ships = new ArrayList<Ship>();

        Corvette corvette = new Corvette(Century20SFactory.HEIGHTCORVETTE * Century20SFactory.WIDTHCORVETTE,1,8,GameFactory.LEFT);
        Destroyer destroyer1 = new Destroyer(Century20SFactory.HEIGHTDESTROYER * Century20SFactory.WIDTHDESTROYER,0,4,GameFactory.LEFT);
        Destroyer destroyer2 = new Destroyer(Century20SFactory.HEIGHTDESTROYER * Century20SFactory.WIDTHDESTROYER,2,4,GameFactory.LEFT);
        Cruiser cruiser1 = new Cruiser(Century20SFactory.HEIGHTCRUISER * Century20SFactory.WIDTHCRUISER,4,0,GameFactory.LEFT);
        Cruiser cruiser2 = new Cruiser(Century20SFactory.HEIGHTCRUISER * Century20SFactory.WIDTHCRUISER,4,2,GameFactory.LEFT);
        Cruiser cruiser3 = new Cruiser(Century20SFactory.HEIGHTCRUISER * Century20SFactory.WIDTHCRUISER,4,4,GameFactory.LEFT);
        Ironclad ironclad = new Ironclad(Century20SFactory.HEIGHTIRONCLAD * Century20SFactory.WIDTHIRONCLAD,9,2,GameFactory.LEFT);

        ships.add(corvette);
        ships.add(destroyer1);
        ships.add(destroyer2);
        ships.add(cruiser1);
        ships.add(cruiser2);
        ships.add(cruiser3);
        ships.add(ironclad);
        return ships;
    }

}
