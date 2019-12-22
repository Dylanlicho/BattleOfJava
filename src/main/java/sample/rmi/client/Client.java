package sample.rmi.client;

import sample.rmi.server.Instructions;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Client {

    public static void main(String[] args){
        try {
            Instructions instructions = (Instructions)Naming.lookup("instructions");
            System.out.println("Client:   "+instructions.getBattleOfJava().toString());
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
