/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package netbeansgithub;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import java.io.*;

/**
 *
 * @author Selmi
 */
public class NetbeansGithub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        BufferedReader br = new BufferedReader(
                new FileReader(
                new File("library.json")));
        String jSonText = "";
        String line = "";
        while((line = br.readLine()) != null){
            jSonText+= line;
        }
        
        //System.out.println(jSonText);
        
        //Code pour la création d'un JSONArray à partir d'une chaine de caractère :
        JSONArray root = (JSONArray) JSONSerializer.toJSON(jSonText);
        
       // Code pour récupérer un objet JSONObject dans un tableau JSONArray :
       // De plus la classe JSONObject dispose de méthodes tel que getString, getInt,
       // getFloat ect qui vont vous permettre de récupérer les valeurs contenues dans l'objet JSONObject.
       //Exercice 3: 
        for(int i=0; i<root.size(); i++){
           JSONObject document = root.getJSONObject(i);
           if(document.getString("type").compareTo("book") == 0){
           
                System.out.println(document.getString("title") + " Livre de "
                                 + document.getJSONArray("author").getString(0) 
                                 + " publié en " + document.getString("year") );
              
           }
       
       }//end for
        
        
        
      
    }
}
