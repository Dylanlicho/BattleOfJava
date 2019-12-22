package sample.rmi.server;

import sample.model.BattleOfJava;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String args[]) {
        InstructionsImpl instructions = null;
        try {
            BattleOfJava battleOfJava = new BattleOfJava();
            instructions = new InstructionsImpl(battleOfJava);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("instructions", instructions);
            System.out.println("Serveur:   "+battleOfJava.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

}
