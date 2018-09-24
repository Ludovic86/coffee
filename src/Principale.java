






import javax.swing.JOptionPane;



public class Principale {


    public static void main(String[] args) {
   
        boolean run = true; 
        String selecteur;
   
   
    
   while (run = true){
        try{    
             Object[] selectionValues = { "Café (0,5€)", "Café au lait (1€)", "Latté (1,5€)", "Thé Vert (1€)", "Café Crème (2€)" };
             String initialSelection = "Café";
             Object selection = JOptionPane.showInputDialog(null, "Bonjour ! Que désirez-vous boire ?",
             "Kawa Machine X2200", JOptionPane.YES_NO_CANCEL_OPTION, null, selectionValues, initialSelection);
             String nom = selection.toString();
             Tarif t = new Tarif(boissonConstruct2(nom), boissonConstruct1(nom));
             
         } catch (NullPointerException e){
             
            String input;
             
            do{ input = JOptionPane.showInputDialog("Mot de passe requis pour le mode maintenance");
             
            }while (passwordCheck(input) == false);
             JOptionPane.showMessageDialog(null, Tarif.decomptePieces()+"\n"+Tarif.totalPieces(), "Maintenance", JOptionPane.INFORMATION_MESSAGE);
             JOptionPane.showMessageDialog(null, "Arret machine", "Bye", JOptionPane.INFORMATION_MESSAGE);
             System.exit(0);
         }
        }
}
    
    public static boolean passwordCheck(String input){
        
        String password = "pass";
        
    return !(password == null ? input != null : !password.equals(input));
    }
    
    public static String boissonConstruct1(String nom){
          
     
          switch (nom){
            
              case "Café (0,5€)":        
                   nom = "café, 50ct s'il vous plaît";
              break;
              case "Café au lait (1€)":  
                   nom = "café au lait, 1€ s'il vous plaît";
              break; 
              case "Latté (1,5€)":        
                  nom = "latté, 1,5€ s'il vous plaît";
              break;   
              case "Thé Vert (1€)":
                  nom = "thé vert, 1€ s'il vous plaît";
              break;   
              case "Café Crème (2€)":
                  nom = "café crème, 2€ s'il vous plaît";
              break;  
            
             
         }
       return nom; 
    } 
    
    public static int boissonConstruct2(String nom){
            
            int prix = 0;  
    
          switch (nom){
            
              case "Café (0,5€)":
                   prix = 50;
              break;
              case "Café au lait (1€)":
                   prix = 100;
              break; 
              case "Latté (1,5€)":
                  prix = 150;
              break;   
              case "Thé Vert (1€)":
                  prix = 100;
              break;   
              case "Café Crème (2€)":
                  prix = 200;
              break; 
        
            }
          return prix;
        
        
 
    }
    
}
