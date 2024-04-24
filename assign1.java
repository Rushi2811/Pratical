AddClient.java
import java.rmi.*;
public class AddClient {
public static void main(String args[]) { 
try {
// Get reference to the remote object
String addServerURL = "rmi://" + args[0] + "/AddServer"; 
AddServerIntf addServerIntf =
(AddServerIntf) Naming.lookup(addServerURL);
System.out.println("The first number is: " + args[1]); 
double d1 = Double.parseDouble(args[1]);
System.out.println("The second number is: " + args[2]);
double d2 = Double.parseDouble(args[2]);
// Invoke remote method to add numbers
System.out.println("The sum is: " + addServerIntf.add(d1, d2));
} 
catch (Exception e) { System.out.println("Exception: "+ e);
}}}


AddServer.java
import java.rmi.*;

public class AddServer {
public static void main(String args[]) {
try { 
//create remote object
AddServerImpl addServerImpl = new AddServerImpl(); 
//bind the remote object
Naming.rebind("AddServer", addServerImpl);
}
catch (Exception e) {
System.out.println("Exception: "+ e);
}}}

AddServerlmpl.java
import java.rmi.*;
import java.rmi.server.*;
//class that implements the remote interface
public class AddServerImpl extends UnicastRemoteObject 
implements AddServerIntf {
//constructor
public AddServerImpl() throws RemoteException {
}
//implement method declared in the interface
public double add(double d1, double d2) throws RemoteException {
 return d1 + d2; }
}

AddServerintf.java
import java.rmi.*;
public interface AddServerIntf extends Remote { 
//method declaration 
double add(double d1, double d2) throws RemoteException;
}


T1 - javac *.java
rmic AddServerImpl

T2- rmiregistry

T3- java AddServer

T4- java AddClient 127.0.0.1 5 8