public class UsersArrayList implements UsersList {

    private static final int DEFAULT_LIST_SIZE = 10;

    private User[] users;
    private int currentIndex;


    public UsersArrayList() {
        this(DEFAULT_LIST_SIZE);
    }


    public UsersArrayList(int size){
        users = new User[size];
        currentIndex = 0;
    }


    @Override
    public void addUsers(User... users){
        for(User u : users){
            addUser(u);
        }
    }

    @Override
    public void addUsersByName(String... names) {
        for(String u : names){
            addUser(new User(u));
        }
    }

    @Override
    public void addUserByName(String name){
        addUser(new User(name));

    }




    @Override
    public void addUser(User user) {
        int nextIndex = currentIndex + 1;
        if (currentIndex > 0 && currentIndex % DEFAULT_LIST_SIZE == 0) {
            int newArrayLength = users.length + users.length / 2;
            User[] newArray = new User[newArrayLength];
            for (int i = 0; i < nextIndex; i++) {
                newArray[i] = users[i];
            }
            users = newArray;
            users[nextIndex] = user;
            currentIndex = nextIndex;
        }
    }

    @Override
    public User getUserById(int id) throws UserNotFoundException {
        for (User user : users) {
            if (user != null && user.getId() == id) {
                return user;
            }
        }
        throw new UserNotFoundException(String.format("User %s not found", id ));
    }

    @Override
    public User getUserByInd(int index) throws UserNotFoundException {
        if(index <= currentIndex ){
            User res = users[index];
            if(res == null) {
              throw new UserNotFoundException(String.format("User index index %s is null", index));
            }
            return res;
        }else{
            throw new UserNotFoundException(String.format("%s index is out of bound", index));
       }
    }

    @Override
    public User[] getUsers(int... id){
        int len = id.length;
        User[] res = new User[len];

        int counter = 0;
        for(int i : id){
            try{
               User usr =  getUserById(i);
               res[counter] = usr;
               counter++;
            }catch (UserNotFoundException e){
                e.printStackTrace();
            }
        }
        return res;
    }


    public User[] getAll(){
        trim();
        return users;
    }



    @Override
    public int getTotal() {
        int i = 0;
        for(User usr : users){
            if(usr!= null){
                i++;
            }
        }
        return i;
    }

    public void trim() {

        //TODO : trim array and delete null entries;

    }

}