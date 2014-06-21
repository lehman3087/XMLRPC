/*
Kyle Barbauld
Lab 01
Server Programming
*/

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpc;
import org.apache.xmlrpc.XmlRpcException;
import java.util.*;
import java.io.*;
import java.net.*;

public class beer
{
   public static void main(String[]args)
   {
      try 
      {
         XmlRpcClient client = new XmlRpcClient("http://alvin.ist.rit.edu:8100");
         Vector params = new Vector();
         
         Object result = client.execute("beer.getMethod",params);
         System.out.println(result.toString());
         
         result = client.execute("beer.getBeers",params);
         System.out.println(result.toString());
         
         result = client.execute("beer.getCheapest",params);
         System.out.println(result.toString());
         
         result = client.execute("beer.getCostliest",params);
         System.out.println(result.toString());
         
         params.addElement(args[0]);
         result = client.execute("beer.getPrice",params);
         System.out.println(result.toString());
      }
      catch (XmlRpcException e) {
         System.out.println("XmlRpc error: "+e.getMessage());
      }
      catch (MalformedURLException e) {
         System.out.println("BadURL error: "+e.getMessage());
      }
      catch (IOException e) {
         System.out.println("IO error: "+e.getMessage());
      }
   }
}