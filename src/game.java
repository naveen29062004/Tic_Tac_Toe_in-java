import java.util.Random;
import java.util.Scanner;

class tictactoe {
          static char[][] arr;

          public tictactoe(){

              arr = new char[3][3];
              inside();



          }

          void inside() {
              for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[0].length; j++) {
                      arr[i][j] = ' ';
                  }
              }

          }
       static    void placemark(int row,int col,char mark)
          {
              if(row>=0 && row<=2 && col<=2 && col>=0) {
                  arr[row][col] = mark;
              }
              else {
                  System.out.println("INVALID INPUT");
              }
          }
          static boolean checkcolwin(){
              for(int j=0;j<arr[0].length;j++)
              {
                  if(arr[0][j]!=' '&& arr[0][j]==arr[1][j] && arr[0][j]==arr[2][j])
                  {
return true;
                  }
              }
              return false;
          }
 static boolean checkrow(){
              for(int i=0;i<arr.length;i++)
              {
                  if(arr[i][0]!=' ' && arr[i][0]==arr[i][1] && arr[i][0]==arr[i][2])
                  {
                      return true;
                  }

              }
              return false;
}
static boolean checkdiagonal(){
              if(arr[0][0]!=' ' && arr[0][0]==arr[1][1] && arr[0][0]==arr[2][2] || arr[0][2]!=' '&& arr[0][2]==arr[1][1] && arr[0][2]==arr[2][0] )
              {
                  return true;
              }
              else {
                  return false;
              }
}


        static   void display() {

              for(int i = 0;i <arr.length; i++) {
                 System.out.println("---------------");
                  System.out.print("|");

                  for (int j = 0; j < arr[0].length;j++) {
                      System.out.print(" "+arr[i][j] + " | ");

                  }
                  System.out.println("");
              }
              System.out.println("---------------");
          }
      }
      abstract  class player{
 public String  name;

   public char mark;
    abstract void makemove();
     boolean validmove(int row,int col)
    {
        if(row>=0 && row<=2 || col>=0 && col<=2)
        {
            if(tictactoe.arr[row][col]==' ')
            {
                return true;
            }
        }
        return false;
    }


      }
      class humanpalyer extends player{
    //String name;
   // char mark;
     humanpalyer (String name1,char mark1)
    {
       name=name1;
       mark=mark1;
    }
   void makemove()
    {
Scanner sc=new Scanner(System.in);
int row;
int col;
do{
    System.out.println("enter the row and column");
    row=sc.nextInt();
    col=sc.nextInt();
}while (validmove(row,col)==false);
tictactoe.placemark(row,col,mark);

    }

      }
      class AI extends player{
    //String namme;
   // char mark;
      AI (String name1,char mark1)
    {
       name=name1;
       mark=mark1;

    }

    Random r=new Random();

   void makemove()
    {

int row;
int col;
do{

    row=r.nextInt(3);
 col=r.nextInt(3);
}while (validmove(row,col)==false);
tictactoe.placemark(row,col,mark);

    }

      }
public class game {
    public static void main(String[] args) {
        System.out.println("WELCOME TO THE GREAT TICTACTOE GAME ..........................................................");
        Scanner sc = new Scanner((System.in));
        System.out.println("1.single player");
        System.out.println("2. two players");
        System.out.println("select any one");
        int num = sc.nextInt();
        int count=0;
        switch (num) {

            case 1: {
                System.out.println("enter a name");
                String h = sc.next();
                System.out.println(" the marking character is 'X' ");


                tictactoe t = new tictactoe();
                t.display();

                humanpalyer p1 = new humanpalyer(h,'X');
                AI p2 = new AI("computer", 'O');
                player cp;
                cp =p1;
                while (true) {
                    System.out.println(cp.name + " turn");
                    cp.makemove();
                    tictactoe.display();
                    count++;

                    if (tictactoe.checkdiagonal() || tictactoe.checkrow() || tictactoe.checkcolwin()) {
                        System.out.println(cp.name + " won the match");
                        break;
                    } else {
                        if (cp == p1) {
                            cp = p2;
                        } else {
                            cp = p1;
                        }
                    }
                    if(count==9)
                    {
                        System.out.println("THE MATCH IS DRAW");
                        break;
                    }
                }
                break;
            }
            case 2:
            {
                 System.out.println("enter a name 1");
                String h = sc.next();
                System.out.println(" the marking character is 'X' OR 'O' ex...");
                String s = sc.next();
                 System.out.println("enter a name 2");
                String h1 = sc.next();
                System.out.println(" the marking character is 'X' OR 'O' ex...");
                String s1 = sc.next();


                tictactoe t = new tictactoe();
                t.display();

                humanpalyer p1 = new humanpalyer(h, s.charAt(0));
                 humanpalyer p2 = new humanpalyer(h1, s1.charAt(0));

                humanpalyer cp;
                cp = p1;
                while (true) {
                    System.out.println(cp.name + " turn");
                    cp.makemove();
                    tictactoe.display();
                    count++;

                    if (tictactoe.checkdiagonal() || tictactoe.checkrow() || tictactoe.checkcolwin()) {
                        System.out.println(cp.name + " won the match");
                        break;
                    } else {
                        if (cp == p1) {
                            cp = p2;
                        } else {
                            cp = p1;
                        }
                    }
                     if(count==9)
                    {
                        System.out.println("THE MATCH IS DRAW");
                        break;
                    }
                }
            }



        }
    }
}
