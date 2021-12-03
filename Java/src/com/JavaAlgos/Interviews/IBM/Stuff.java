package com.JavaAlgos.Interviews.IBM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Stuff {
    /**
     * /** * Returns the list of contacts
     * that you and I share, assuming that each contact can be * uniquely identified by their phone number.
     **/
    public class Contact {
        String name;
        String phoneNumber;
    }

    public List<Contact> findCommonContacts(List<Contact> yourContacts, List<Contact> myContacts) {
        if (yourContacts == null || myContacts == null) return null;
        if (yourContacts.size() == 0) return new ArrayList<>();
        List<Contact> finalAnswer = new ArrayList<>();
        HashMap<String, Contact> bag = new HashMap<>();
        for (int i = 0; i < yourContacts.size(); i++) {
            Contact curContact = yourContacts.get(i);
            bag.put(curContact.phoneNumber, curContact);
        }

        for (int i = 0; i < myContacts.size(); i++) {
            Contact curContact = myContacts.get(i);
            if (bag.containsKey(curContact.phoneNumber)) {
                finalAnswer.add(curContact);
            }
        }

        return finalAnswer;
    }

}
