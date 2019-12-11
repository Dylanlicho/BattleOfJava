package sample.model.factory;


import sample.model.ship.Ship;
import sample.model.ship.century15s.Caravelle;
import sample.model.ship.century15s.Drakkar;
import sample.model.ship.century15s.Flette;
import sample.model.ship.century15s.Sailboat;

import java.util.ArrayList;

public class AgeFactory {

    /**
     * Create 7 ship according to the age
     * @param age Century
     * @return A list of 7 ships of century age
     */
    public ArrayList<Ship> createNewShip(int age){
        if (age == GameFactory.CENTURY15S) {
            return create15SShip();
        }
        return new ArrayList<Ship>();
    }

    /**
     * Create 7 ships of the century 15
     * @return A list of 7 ships of century 15
     */
    public ArrayList<Ship> create15SShip(){
        ArrayList<Ship> ships = new ArrayList<Ship>();

        Sailboat sailboat = new Sailboat(1,0,0,GameFactory.LEFT);
        Caravelle caravelle1 = new Caravelle(1,0,sailboat.getY()+Century15SFactory.WIDTHSAILBOAT + 1,GameFactory.LEFT);
        Caravelle caravelle2 = new Caravelle(1,0,caravelle1.getY()+Century15SFactory.WIDTHCARAVELLE + 1,GameFactory.LEFT);
        Flette flette1 = new Flette(1,0,caravelle2.getY()+Century15SFactory.WIDTHCARAVELLE + 1,GameFactory.LEFT);
        Flette flette2 = new Flette(1,0,flette1.getY()+Century15SFactory.WIDTHFLETTE + 1,GameFactory.LEFT);
        Flette flette3 = new Flette(1,0,flette2.getY()+Century15SFactory.WIDTHFLETTE + 1,GameFactory.LEFT);
        Drakkar drakkar = new Drakkar(1,0,flette3.getY()+Century15SFactory.WIDTHFLETTE + 1,GameFactory.LEFT);

        ships.add(sailboat);
        ships.add(caravelle1);
        ships.add(caravelle2);
        ships.add(flette1);
        ships.add(flette2);
        ships.add(flette3);
        ships.add(drakkar);
        return ships;
    }

}
