package sample.rmi.server;

import sample.model.BattleOfJava;
import sample.rmi.server.Instructions;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InstructionsImpl extends UnicastRemoteObject implements Instructions {

    private BattleOfJava model;

    protected InstructionsImpl(BattleOfJava model) throws RemoteException {
        this.model = model;
    }

    @Override
    public BattleOfJava getBattleOfJava() throws RemoteException {
        return model;
    }
}
