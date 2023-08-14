import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> myContact = new ArrayList<Contact>();





    public boolean addContact(Contact contact){
        if(findContact(contact.getName())>=0){
            System.out.println("Contact already exist");
            return false;
        }else{
            myContact.add(contact);
            return true;
        }
    }


    public void viewContact(){
        for(int i=0; i<this.myContact.size() ;i++){
            System.out.println((i+1) + ". " + this.myContact.get(i).getName()+"  -> " + this.myContact.get(i).getPhoneNumber() );
        }
        System.out.println("Total contact = "  + this.myContact.size());

    }


    public boolean updateContact(Contact oldContact, Contact newContact){
        int position = findContact(oldContact);
        if(position>=0){
            myContact.set(position, newContact);
            System.out.println(oldContact.getName() + " had been updated to " + newContact.getName());
            return true;
        }else{
            System.out.println( oldContact.getName() + " is not present in the Contact List.");
            return false;
        }
    }


    public boolean removeContact( Contact contact ){
        int position = findContact(contact);
        if(position>=0){
            myContact.remove(position);
            System.out.println(contact.getName() + " deleted.");
            return true;
        }else{
            System.out.println( contact.getName() + " not found.");
            return false;
        }
    }


    public String searchContact(Contact contact){
        if(findContact(contact)>=0){
            return contact.getName();
        } else{
            return null;
        }
    }

    public Contact searchContact(String name){
        int position = findContact(name);
        if(position>=0){
            return this.myContact.get(position);
        }
        return null;
    }







    private int findContact(Contact contact){
        return myContact.indexOf(contact);
    }

    private int findContact(String contactName){
        for(int i=0; i<myContact.size(); i++){
             Contact contact = myContact.get(i);
             if(contact.getName().equals(contactName)){
                 return i;
             }
        }
        return -1;
    }





}