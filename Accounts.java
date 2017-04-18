import java.io.Serializable;
import java.util.ArrayList;

public class Accounts implements Listing<Account>, Serializable {
    private ArrayList<Account> accs;
    
    public Accounts() {
        accs = new ArrayList<Account>();
    }

    public boolean add(Account acc) {
        return this.accs.add(acc);
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
    public Account remove(int index) {
        return this.accs.remove(index);
    }
    public int size() { return this.accs.size(); }

    public String toString() {
        String returns = "";
        for (Account acc : accs) {
            returns += acc.toString();
        }
        return returns;
    }
    //public boolean equals(Object obj) {
    //    if (this == obj) {
    //        return true;
    //    }
    //    if (obj == null) {
    //        return false;
    //    }
    //    if (this.getClass() != obj.getClass()) {
    //        return false;
    //    }
    //    return false;
    //}
}