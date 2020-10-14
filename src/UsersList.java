interface UsersList {
    void addUserByName(String name);

    void addUser(User user);
    void addUsers(User... user);
    User getUserById(int id) throws UserNotFoundException;
    User getUserByInd(int index) throws UserNotFoundException;

    User[] getUsers(int... id);

    int getTotal();

    void addUsersByName(String... joe);
}
