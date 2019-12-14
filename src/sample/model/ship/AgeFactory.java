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

        Sailboat sailboat = new Sailboat(1,0,0,GameFactory.BOTTOM);
        Caravelle caravelle1 = new Caravelle(1,2,0,GameFactory.LEFT);
        Caravelle caravelle2 = new Caravelle(1,3,6,GameFactory.TOP);
        Flette flette1 = new Flette(1,4,2,GameFactory.LEFT);
        Flette flette2 = new Flette(1,5,8,GameFactory.RIGHT);
        Flette flette3 = new Flette(1,6,5,GameFactory.LEFT);
        Drakkar drakkar = new Drakkar(1,2,9,GameFactory.TOP);
//        Sailboat sailboat = new Sailboat(1,0,0,GameFactory.LEFT);
//        Caravelle caravelle1 = new Caravelle(1,0,sailboat.getY()+ Century15SFactory.WIDTHSAILBOAT + 1,GameFactory.LEFT);
//        Caravelle caravelle2 = new Caravelle(1,0,caravelle1.getY()+Century15SFactory.WIDTHCARAVELLE + 1,GameFactory.LEFT);
//        Flette flette1 = new Flette(1,0,caravelle2.getY()+Century15SFactory.WIDTHCARAVELLE + 1,GameFactory.LEFT);
//        Flette flette2 = new Flette(1,0,flette1.getY()+Century15SFactory.WIDTHFLETTE + 1,GameFactory.LEFT);
//        Flette flette3 = new Flette(1,0,flette2.getY()+Century15SFactory.WIDTHFLETTE + 1,GameFactory.LEFT);
//        Drakkar drakkar = new Drakkar(1,0,flette3.getY()+Century15SFactory.WIDTHFLETTE + 1,GameFactory.LEFT);
/*
        Sailboat sailboat = new Sailboat(1,1,8,GameFactory.LEFT);
        Caravelle caravelle1 = new Caravelle(1,0,4,GameFactory.LEFT);
        Caravelle caravelle2 = new Caravelle(1,2,4,GameFactory.LEFT);
        Flette flette1 = new Flette(1,4,0,GameFactory.LEFT);
        Flette flette2 = new Flette(1,4,2,GameFactory.LEFT);
        Flette flette3 = new Flette(1,4,4,GameFactory.LEFT);
        Drakkar drakkar = new Drakkar(1,4,6,GameFactory.LEFT);*/

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

        Corvette corvette = new Corvette(1,1,8,GameFactory.LEFT);
        Destroyer destroyer1 = new Destroyer(1,0,4,GameFactory.LEFT);
        Destroyer destroyer2 = new Destroyer(1,2,4,GameFactory.LEFT);
        Cruiser cruiser1 = new Cruiser(1,4,0,GameFactory.LEFT);
        Cruiser cruiser2 = new Cruiser(1,4,2,GameFactory.LEFT);
        Cruiser cruiser3 = new Cruiser(1,4,4,GameFactory.LEFT);
        Ironclad ironclad = new Ironclad(1,4,6,GameFactory.LEFT);

//        Corvette corvette = new Corvette(1,0,0,GameFactory.LEFT);
//        Destroyer destroyer1 = new Destroyer(1,0,corvette.getY()+ Century20SFactory.WIDTHCORVETTE + 1,GameFactory.LEFT);
//        Destroyer destroyer2 = new Destroyer(1,0,destroyer1.getY()+Century20SFactory.WIDTHDESTROYER+ 1,GameFactory.LEFT);
//        Cruiser cruiser1 = new Cruiser(1,0,destroyer2.getY()+Century20SFactory.WIDTHDESTROYER + 1,GameFactory.LEFT);
//        Cruiser cruiser2 = new Cruiser(1,0,cruiser1.getY()+Century20SFactory.WIDTHCRUISER + 1,GameFactory.LEFT);
//        Cruiser cruiser3 = new Cruiser(1,0,cruiser2.getY()+Century20SFactory.WIDTHCRUISER + 1,GameFactory.LEFT);
//        Ironclad ironclad = new Ironclad(1,0,cruiser3.getY()+Century20SFactory.WIDTHCRUISER + 1,GameFactory.LEFT);

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
