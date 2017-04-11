import java.util.ArrayList;

public class Accounts implements Listing<Account> {
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
    public Account remove(int index) {
        return this.accs.remove(index);
    }
}