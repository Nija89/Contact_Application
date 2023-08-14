import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {

        getInformation();
        boolean isTrue = true;
        while(isTrue){
            System.out.print("Choose a number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    getInformation();
                    break;
                case 1:
                    viewContact();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    isTrue = false;
                    break;
            }
        }
    }




    private static  void getInformation() {
        System.out.println("Choose:");
        System.out.println("0. to get information.");
        System.out.println("1. to view Contact");
        System.out.println("2. to add Contact." );
        System.out.println("3. to update contact");
        System.out.println("4. to delete contact.");
        System.out.println("5. to search for contact.");
        System.out.println("6. to exit.");
    }







    private static void addContact(){
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your contact number: ");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phoneNumber);

        if(mobilePhone.addContact(newContact)){
            System.out.println("New contact added successfully. Name -> " + name + " Number -> " + phoneNumber);
        }else{
            System.out.println("Already exist in the Contact.");
        }
    }

    private static void viewContact(){
        mobilePhone.viewContact();
    }


    private static void updateContact(){
        System.out.print("Enter the Contact you wanna update: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.searchContact(name);

        if(existingContact==null) {
            System.out.println("Contact not found");
            return;
        }else{
            System.out.println("Enter new contact name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter new  Contact number: ");
            String newNumber = scanner.nextLine();

            Contact newContact = Contact.createContact(newName,newNumber);
            if(mobilePhone.updateContact(existingContact, newContact)){
                System.out.println("Successfuly updated.");
            }else {
                System.out.println("Erroe.");
            }
        }
    }


    private static void removeContact() {
        System.out.print("Enter the Contact you wanna remove: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.searchContact(name);

        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }

        if(mobilePhone.removeContact(existingContact)){
            System.out.println("Contact Successfully deleted");
        }else{
            System.out.println("Error deleting.");
        }
    }



    private static void searchContact() {
        System.out.print("Enter the Contact you wanna search: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.searchContact(name);

        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Name: " + existingContact.getName() + " phone number is: " + existingContact.getPhoneNumber());
    }


}