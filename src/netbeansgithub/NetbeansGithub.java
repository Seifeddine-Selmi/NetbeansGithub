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
    public static void main(String[] args) throws FileNotFoundException, IOException{
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
        
       //Exercice 3:  Afficher les objets qui sont des livres
        for(int i=0; i< root.size(); i++){
           JSONObject document = root.getJSONObject(i);
           if(document.getString("type").compareTo("book") == 0){
           
                System.out.println(document.getString("title") + " Livre de "
                                 + document.getJSONArray("author").getString(0) 
                                 + " publié en " + document.getString("year") );
              
           }//end if
       
       }//end for
        
      //Pour créer un nouveau livre il va falloir ajouter un JSONObject dans le tableau JSONArray.
      //Pour créer un JSONObject, rien de plus simple :

       JSONObject book = new JSONObject();
       
       // Une fois l'objet crée, il faut renseigner ses valeurs. La classe JSONObject dispose de la méthode
       // put(clef, valeur) qui va vous permettre de le remplir . Vous devez faire attention à ce que 
       // vos clefs soient les mêmes que celles déjà utilisées.

       book.put("type", "book");
       book.put("title", "Magento Optimization How to");
       book.put("author", "Mathieu Nayrolles");
       book.put("year", 2013);
        
       // Une fois le nouvel JSONObject créé vous devez l'ajouter au tableau d'objet courant 
       //(celui que vous avez construit lors de l'exo 2). Pour réaliser cette opération vous 
       // allez utiliser la méthode add de la classe JSONArray.

        root.add(book);
        
        // Il ne vous reste plus qu'a sauvegarder ce tableau mis à jour dans un nouveau fichier
        // (updatedLibrary.json) en utilisant un FileWriter

         FileWriter fr = new FileWriter(new File("libraryUpdated.json"));   
         fr.write(root.toString());        
         fr.flush();
         fr.close();
         
         // Exercice 5 : Suprimer un livre
       // L'objet JSONArray contient aussi une fonction remove pour supprimer des JSONObject. 
       // Cette fonction prends en argument la position de l'objet dans le JSONArray OU l'objet à supprimer.

      //  root.remove(aJSONObject);
      // OR
      root.remove(3); //Delete JSONObject at pos = 3
      
         FileWriter frm = new FileWriter(new File("libraryRemove.json"));   
         frm.write(root.toString());        
         frm.flush();
         frm.close();
         
          for(int j=0; j< root.size(); j++){
           JSONObject documentRm = root.getJSONObject(j);
           if(documentRm.getString("type").compareTo("book") == 0){
               
               if(documentRm.getString("title").compareTo("Design Patterns - Elements of Reusable Object-Oriented Software") == 0){
           
                      root.remove(j);
              
             }//end if
           }//end if
           
         FileWriter frm2 = new FileWriter(new File("libraryRemove2.json"));   
         frm2.write(root.toString());        
         frm2.flush();
         frm2.close();
         
         
         
         
         
           
       
       }//end for
         
      
    }
}
