import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Accounts implements Listing<Account>, Serializable {
    private ArrayList<Account> accs;
    private Tags tags;
    
    public Accounts() {
        accs = new ArrayList<Account>();
        tags = new Tags();
    }

    public boolean add(Account acc) {
        boolean addingSuccessful = this.accs.add(acc);
        Collections.sort(this.accs);
        return addingSuccessful;
    }
    public Account get(int index) {
        return this.accs.get(index);
    }
    public Account get(String username) {
        for (Account acc: accs) {
            if (acc.getUsername().equals(username)) {
                return acc;
            }
        }
        return null;
    }
    public Tags getTag() { return this.tags; }
    public int indexOf(String username) {
        for (int i = 0; i < accs.size(); i++) {
            if (accs.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }
    public Account remove(int index) {
        return this.accs.remove(index);
    }
    public Account remove(String username) {
        int index = this.indexOf(username);
        if (index != -1) {
            return this.accs.remove(index);
        } else {
            return null;
        }
    }
    public int size() { return this.accs.size(); }

    public String toString() {
        String returns = "";
        for (Account acc : accs) {
            returns += acc.toString();
        }
        return returns;
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Accounts accsTest = (Accounts) obj;
        if (this.accs.size() != accsTest.size()) {
             return false;
        }
        // Assumption: Accounts list is sorted prior to comparing indexes
        for (int i = 0; i < this.accs.size(); i++) {
            if (!this.accs.get(i).equals(accsTest.get(i))) {
                return false;
            }
        }
        return true;
    }
}