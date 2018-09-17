package phonebookproject1;
/*
Phone book poject with the followings
Add Contact
Update Contact
Delete Contact
Find Contact
Print Contacts
Load Contac
*/


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PhoneBookProject1 {

    public static void main(String[] args) throws FileNotFoundException {
        phoneBook();
    }
    
      public static void addContact(String name, String number){
        System.out.println("Saved Contact " + name + " " + number);       
            try (PrintWriter pw = new PrintWriter(new FileWriter("contactlist.txt", true))){
                pw.println(name + " : " + number);

        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
    }
      
      
      public static String[] updateContact(String name){
          Scanner input = new Scanner(System.in);
          try(Scanner in = new Scanner(new File("contactlist.txt"))){
              String n [] = new String[0];
              boolean namePresent = false;
              while (in.hasNextLine()){
                  n = in.nextLine().split(" : ");
                  if (n[0].equals(name)){
                  System.out.println("Contact: " + name +" : " + n[1]);
                  namePresent = true;
                  System.out.println("Enter the name to update to");
                  String secondName = input.nextLine();
                  while (n[0].equals(name)){
                      name = secondName;
                      BufferedReader br = new BufferedReader(new FileReader("contactlist.txt"));
                      String replace = br.readLine().replace(name, secondName);
                      while (in.hasNextLine()){
                      n = in.nextLine().split(" : ");
                      if (n[0].equals(secondName)){
                          System.out.println("Contact updated to " + secondName + " : " + n[1]);
                      }
                  }
                  }
                  
                  break;
              }
            }
            if (!namePresent){
                System.out.println("Contact " + name + " not found");
                n = null;
            }
            return n;
                 
          }catch (IOException e){
              System.out.println(e.getMessage());
          } 
          return null;
          
      }
         
      
      public static void deleteContact(String name){
          try (Scanner in = new Scanner(new File("contactlist.txt"))){
              
              
              
          }catch(IOException b){
              System.out.println(b.getMessage());
          }
      }
      
      
      
      public static String[] findContact(String name){
          
          try(Scanner in = new Scanner(new File("contactlist.txt"))){
              String n [] = new String[0];
              boolean namePresent = false;
              while (in.hasNextLine()){
                  n = in.nextLine().split(" : ");
                  if (n[0].equals(name)){
                  System.out.println("Contact: " + name +" : " + n[1]);
                  namePresent = true;
                  break;
              }
            }
            if (!namePresent){
                System.out.println("Contact " + name + " not found");
                n = null;
            }
            return n;
                 
          }catch (IOException e){
              System.out.println(e.getMessage());
          } 
          return null;
      }
      
      
      
      public static void printContact(){
           try(Scanner in = new Scanner(new File("contactlist.txt"))){
               boolean contactlist = false;
               while(in.hasNext()){
                   String n[] = in.nextLine().split(" : ");                   
                   System.out.println(n[0] + " : " + n[1]);
                   contactlist = true;
                 
               }
               if (!contactlist){
                   System.out.println("Sorry no contact to print");
               }
           }catch (IOException ex){
               System.out.println(ex.getMessage());
              
           }
         
          
      }
      
      public static void loadContact(){
          try(Scanner in = new Scanner(new File("contactlist.txt"))){
               boolean contactlist = false;
               while(in.hasNext()){
                   //String n[] = in.nextLine().split(" : ");
                   if (contactlist = true){
                   System.out.println("Conatacts Loaded");
                   }
                   break; 
               }
               if (!contactlist){
                   System.out.println("Sorry no contact to load");
               }
           }catch (IOException ex){
               System.out.println(ex.getMessage());              
           }
          
      }
    
    
    public static void phoneBook() throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        String name;
        
        do{
        System.out.println("Make a choice 1, 2, 3, 4, 5 0r 6");
        System.out.println("Select 1 to Add Contact");
        System.out.println("Select 2 to Update Contact");
        System.out.println("Select 3 to Delete Contact");
        System.out.println("Select 4 to Find Contact");
        System.out.println("Select 5 to Print Contact");
        System.out.println("Select 6 to Load Contact");
        System.out.print("\f Choice: ");
        
        int choice = in.nextInt();
        in.nextLine();
        
        switch (choice){
            
            case 1:
                System.out.println("Contact Name (Firstname Lastname)");
                name = in.nextLine();
                System.out.println("Contact Number(1112223456)");
                String number = in.nextLine();
                
                addContact(name, number);
                break;
                
            case 2:
                System.out.println("Whats the name of the Contact you want to update? (name)");
                name = in.nextLine();                
               
                
                updateContact(name);
                break;
                
            case 3:
                System.out.println("Whats the name of the contact you want to delete? (name)");
                name = in.nextLine();
                
                deleteContact(name);
                break;
                
            case 4:
                System.out.println("Whats the name of the contact you are looking for? (name)");
                name = in.nextLine();
                
                findContact(name);
                break;
                
            case 5:
                System.out.println("Contact List");
                
                printContact();
                break;
                
            case 6:
                loadContact();
                break;
                
            default:
                
                break;
        }
        
        System.out.println("Do you want to perform another action (Y/N)");
        System.out.println("Y to continue"
                         + "\nN to Exit");
        if (in.next().toLowerCase().charAt(0) != 'y')
        break;
      }while(true);
      
    }
    
  
}
