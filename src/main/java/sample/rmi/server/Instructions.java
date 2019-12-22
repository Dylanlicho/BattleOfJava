package sample.rmi.server;

import sample.model.BattleOfJava;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Instructions extends Remote {

    public BattleOfJava getBattleOfJava() throws RemoteException;

}
