
package btechcse29;
import static java.lang.Math.random;
import java.util.ArrayList;
import static java.lang.System.*;

class One
{
    int attackpower;
    int health;
    
    One(int attackpower,int health)
    {
        this.attackpower=attackpower;
        this.health=health;
    }
    
   public static int findRandom(int max,int min)
   {
       int rand=(int) (random() * (max-min+1) + min);
       return rand;
   }
}
class Two
{
    int attackpower;
    int health;
    
    Two(int attackpower,int health)
    {
        this.attackpower=attackpower;
        this.health=health;
    }
}

public class MainStart {

   
    public static void main(String[] args) {
        // TODO code application logic here
        int chance,chance1,aT=0,flag,choice,damage1=0,damage2=0;
        
        int []count1=new int[3];
        int []count2=new int[3];
        One Ace=new One(150,200);
        One King=new One(150,220);
        One Queen=new One(155,200);
        
         Two Jack=new Two(150,200);
        Two Spade=new Two(150,220);
        Two Diamond=new Two(155,200);
        
        ArrayList <One> player1=new ArrayList();
        ArrayList<Two> player2=new ArrayList();
        
        player1.add(Ace);
        player1.add(King);
        player1.add(Queen);
        
        player2.add(Jack);
        player2.add(Spade);
        player2.add(Diamond);
        
       for(;;)
       {
           chance=One.findRandom(1,0);
           flag=0;
           out.println("Toss winner "+(chance+1));
           if(chance==0)
           {    out.println("Inside player1");
               chance1=One.findRandom(6,1);
               
               if(chance1==1||chance1==2||chance1==3)
               {   
                   aT=player1.get(chance1-1).attackpower;
                   
                   if(player1.get(chance1-1).health>0)
                   {   
                       out.println("attacker is no. "+chance1);
                       flag=7;
                   }
                   else
                   out.println("missed chance ");
                   
               }
               
               else
                   out.println("missed chance ");
           }
           else
           {    out.println("Inside player2");
               chance1=One.findRandom(6,1);
               if(chance1==1||chance1==2||chance1==3)
               {    
                   aT=player2.get(chance1-1).attackpower;
                   if(player2.get(chance1-1).health>0)
                   {
                   out.println("attacker is no. "+chance1);
                   flag=8;
                   }
                   else
                   out.println("missed chance ");
               }
               else
                   out.println("missed chance ");
               
           }
           if(flag==7)
           {
               choice=One.findRandom(6, 1);
               if(choice==1||choice==2||choice==3)
               {    
                   if(player2.get(choice-1).health>  aT)
                   {
                    out.println("target is player2 person no. "+ choice);
                    player2.get(choice-1).health-=aT;
                   }
                   
                   else if(player2.get(choice-1).health <=aT && player2.get(choice-1).health>0)
                   {
                       out.println(" player2 person no. "+ choice+" get killed");
                       player2.get(choice-1).health=0;
                    
                       damage2++;
                   }
                   
                   
               }
                   
               
               else if(choice==6)
               {
                   if(player1.get(chance1-1).health==0)
                   {out.println("player 1 person no "+chance1 +" get alive by magic drink");
                       damage1--;
                   }
                   
               player1.get(chance1-1).health+=150;
               
               }
               else
                out.println("missed chance");
           }
           if(flag==8)
           {
               choice=One.findRandom(6, 1);
               if(choice==1||choice==2||choice==3)
               {    
                   if(player1.get(choice-1).health>  aT)
                   {out.println("target is player1 person no. "+ choice);
                    player1.get(choice-1).health-=aT;
                   }
                   else if(player1.get(choice-1).health<=aT && player1.get(choice-1).health>0)
                   {  out.println(" player1 person no. "+ choice+" get killed");
                       player1.get(choice-1).health=0;
                       damage1++;
                   }
                   
               }
               else if(choice==6)
               {
                   if(player2.get(chance1-1).health==0)
                   {
                       out.println("player 2 person no "+chance1 +" get alive by magic drink");
                   damage2--;
                   }
               player2.get(chance1-1).health+=150;
               }
               else 
                   out.println("missed chance");
           }
       if(damage1==3||damage2==3)
           break;
          
       }
       if(damage2==3)
       System.out.println("Player 1 wins");
       else
       System.out.println("Player 2 wins");
      
    }
}
    

