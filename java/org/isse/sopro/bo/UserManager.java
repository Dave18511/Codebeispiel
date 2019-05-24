package org.isse.sopro.bo;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Wrapps the Methods to get Users from DB and stores them in memory
 *
 */
public class UserManager {

    private static UserManager unique = null;
    private HashMap<String, UserEntity> users;

    private UserManager() {
        loadUsers();
    }

    /**
     * Adds user to DB, creates new one
     *
     * @param u
     */
    public void linkUser(UserEntity u) {
        SessionFactoryManager.instance().save(u);
        users.put(u.getMail(), u);
    }

    /**
     * Deletes User from DB
     *
     * @param u
     */
    public void deleteUser(UserEntity u) {
        SessionFactoryManager.instance().delete(u);
        users.remove(u.getMail());
    }

    /**
     * Gets all Users from DB from the Hashmap
     *
     * @return
     */
    public Collection<UserEntity> getUsers() {
        return users.values();
    }

    /**
     * Gets the UserEntity with the @param mail
     *
     */
    public UserEntity getUserByMail(String mail) {
        return users.get(mail);
    }

    private void loadUsers() {
        users = new HashMap<>();
        List<UserEntity> list = SessionFactoryManager.instance().getAll(UserEntity.class);
        for (UserEntity u : list) {
            users.put(u.getMail(), u);
        }
    }

    /**
     *
     * Singleton for the
     *
     * @return
     */
    public static UserManager instance() {
        if (unique == null) {
            unique = new UserManager();
            //Default admin, if the user is also Persitet only one with the mail will be in HashMap and DB
            unique.linkUser(new UserEntity("David", "david.scherle13@gmail.com", "test1234", "Uni", true));
        }
        return unique;
    }
}
