


import javax.swing.JOptionPane;



public class Tarif{

    public static int ct1 = 50;
    public static int ct2 = 50;  
    public static int ct5 = 50;
    public static int ct10 = 50;
    public static int ct20 = 50;
    public static int ct50 = 50;
    public static int e1 = 50;
    public static int e2 = 50;
    public int input;
    public int monnaie;
    public int piece;
    boolean flag = false;
    String entree;
    
    public Tarif(int t, String nom){
          
        
        while (input < t && flag == false){    
                   
                   try{  
                    Object[] selectionValues = {"1ct", "2ct", "5ct", "10ct", "20ct", "50ct", "1€", "2€"};
                    String initialSelection = "1ct";
                    Object selection = JOptionPane.showInputDialog(null, "Selection: "+nom+"\n"+"Merci d'insérer votre règlement"+"\n"+"Montant inséré: "+affichage(input)+"€",
                    "Kawa Machine X2200", JOptionPane.YES_NO_CANCEL_OPTION, null, selectionValues, initialSelection);
                    entree = selection.toString();
                    piece = convertisseur(entree);   
                    input += piece;
                    entreePieces(piece);
                    } 
                    catch (NullPointerException e){
                        if (input > 0){
                         JOptionPane.showMessageDialog(null, "Annulation, retour monnaie:  "+ affichage(input) +"€", "Annulation", JOptionPane.INFORMATION_MESSAGE);
                         sortiePieces();
                         flag = true;
                        }
                        else flag = true;
                    }
                    monnaie= input - t;
        }
                    if (monnaie > 0){
                     JOptionPane.showMessageDialog(null, "Votre monnaie ! :  "+ affichage(monnaie) +"€"+"\n"+sortiePieces(), "Monnaie", JOptionPane.INFORMATION_MESSAGE);
                     sortiePieces(); 
                    }
                     
         

        System.out.println("1ct:  "+ct1);
        System.out.println("2ct:  "+ct2);                
        System.out.println("5ct:  "+ct5);
        System.out.println("10ct:  "+ct10);
        System.out.println("20ct:  "+ct20);
        System.out.println("50ct:  "+ct50);
        System.out.println("1€:  "+e1);
        System.out.println("2€:  "+e2);
                
                

    


}
    public int entreePieces(int piece){
        
        if (piece == 1){
            ct1++;}
        if (piece == 2){
            ct2++;}
        if (piece == 5){
            ct5++;}
        if (piece == 10){
            ct10++;}
        if (piece == 20){
            ct20++;}
        if (piece == 50){
            ct50++;}
        if (piece == 100){
            e1++;}
        if (piece == 200){
            e2++;}
        return 0;
    }
    
    public String sortiePieces(){
        int i = 200;
        boolean flag2 = false;
        String detailPieces = "";
        while (monnaie > 0){
            i -= 1;
            flag2 = false;
            
            while (flag2 == false){
                
            
                if (monnaie - 100 >= 0){
                    monnaie -= 100;
                    e1 -= 1;
                    detailPieces += "1€ ";
                    flag2 = true;
                    break;
                }
                if (monnaie - 50 >= 0){
                    monnaie -= 50;
                    ct50 -= 1;
                    detailPieces += "50ct ";
                    flag2 = true;
                    break;
                }
                if (monnaie - 20 >= 0){
                    monnaie -= 20;
                    ct20 -= 1;
                    detailPieces += "20ct ";
                    flag2 = true;
                    break;
                }
                if (monnaie - 10 >= 0){
                    monnaie -= 10;
                    ct10 -= 1;
                    detailPieces += "10ct ";
                    flag2 = true;
                    break;
                }
                if (monnaie - 5 >= 0){
                    monnaie -= 5;
                    ct5 -= 1;
                    detailPieces += "5ct ";
                    flag2 = true;
                    break;
                }
                if (monnaie - 2 >= 0){
                    monnaie -= 2;
                    ct2 -= 1;
                    detailPieces += "2ct ";
                    flag2 = true;
                    break;
                }
                if (monnaie - 1 >= 0){
                    monnaie -= 1;
                    ct1 -= 1;
                    detailPieces += "1ct ";
                    flag2 = true;
                    break;
                }
            }    
                
            
        }
        
        
        return detailPieces;   
    }
    
    public String affichage(int valeur){
        
        if (valeur < 10){
            return "0,0"+Integer.toString(valeur);
        } 
        if (valeur < 100){
            return "0,"+Integer.toString(valeur);
        } 
        if (valeur == 100){
            return "1";
        }
        if (valeur > 100 && valeur < 200){
            return "1,"+Integer.toString(valeur - 100);
        }
        if (valeur == 200){
            return "2";
        }
        if (valeur > 200){
            return "2,"+Integer.toString(valeur - 200);
        }
        
        return null;
    }
    
    public static String decomptePieces(){
        
        String affichageDecompte = "1ct: "+ct1+"\n"+"2ct: "+ct2+"\n"+"5ct: "+ct5+"\n"+"10ct: "+ct10+"\n"+"20ct: "+ct20+"\n"+"50ct: "+ct50+"\n"+"1€: "+e1+"\n"+"2€: "+e2;
       
        
        return affichageDecompte;
    }
    
    public static String totalPieces(){
        
        int total = ct1+ct2*2+ct5*5+ct10*10+ct20*20+ct50*50+e1+e2*2;
        
        String affichageTotal = "Total machine : "+total+"€";
        
        return affichageTotal;
    } 
    
    public int convertisseur(String paiement){
        int piece = 0;
        
            switch (paiement){
                case "1ct":
                    piece = 1;
                    break;
                case "2ct":
                    piece = 2;
                    break;
                case "5ct":
                    piece = 5;
                    break;
                case "10ct":
                    piece = 10;
                    break;
                case "20ct":
                    piece = 20;
                    break;
                case "50ct":
                    piece = 50;
                    break;
                case "1€":
                    piece = 100;
                    break;
                case "2€":
                    piece = 200;
                    break;
            }
        return piece;
    }
    
    
}
