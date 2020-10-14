public class UsersArrayList implements UsersList {
    private int len = 2;
    private int i = 0;
    User[] usersArr = new User[len];

    public void addUser(String name) {
        while(i < len && usersArr[i] != null) {
            i++;
        }
        if (i == len) {
            User[] newUsersArr = new User[len + (len / 2)];
            for (i = 0; i < len; i++) {
                newUsersArr[i] = usersArr[i];
            }
            len = len + (len / 2);
            usersArr = newUsersArr;
        }
        usersArr[i] = new User(name);
    }
    public User getUserById(int id) {
        i = 0;
        while(i < len) {
            if (usersArr[i] != null && usersArr[i].getId() == id) {
                return usersArr[i];
            }
            i++;
        }
        System.err.println("UserNotFound");
        return null;
    }
    public User getUserByInd(int index) {
        return usersArr[index];
    }
    public int getTotal() {
        int total = 0;
        i = 0;
        while (i < len) {
            if (usersArr[i] != null) {
                total++;
            }
            i++;
        }
        return total;
    }
}