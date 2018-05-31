package client;

import compute.Compute;
import compute.Task;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Client implements Serializable{

    public static void main(String[] args){
        //System.setProperty("java.security.policy", "file:/c:/Users/john/desktop/client.policy");
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }

        String name = "Compute";
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            Compute comp = (Compute) registry.lookup(name);
            System.out.println(comp.executeTask(new HelloTask()));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
