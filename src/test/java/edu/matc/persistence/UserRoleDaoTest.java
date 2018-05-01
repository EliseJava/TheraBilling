package edu.matc.persistence;

import edu.matc.entity.Role;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This program is testing adding and selecting Users
 *
 * @author   Elise Strauss
 */
class UserRoleDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The genericDao.
     */
    GenericDao genericDao;

    /**
     * Sets up. Run sql to recreate the database before each test
     */
    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleanpatientdb.sql");
    }

    /**
     * Verify a user is returned correctly by their id.
     */
    @Test
    void getUserByIdIsSuccessful() {
        User user = (User) genericDao.getById(1);
        assertNotNull(user);
        assertEquals("Dot", user.getFirstName());
    }

    /**
     * Gets ALL users in the database.
     */
    @Test
    void getAllAreSuccessful() {
        List<User> users = (List<User>)genericDao.getAllByTable();
        assertEquals(2, users.size());
    }

    /**
     * Verify successful insert of a new user and role
     */
    @Test
    void insertUserRoleIsSuccessful() {

        User newUser = new User("Sandy", "Kmiec", "skmiec", "ss99");
        int id = genericDao.insert(newUser);
        assertNotEquals(3,id);

        User userAdded = (User)genericDao.getById(id);

        GenericDao genericDao2 = new GenericDao(Role.class);
        Role role = new Role("receptionist", "skmiec", userAdded);
        int id2 = genericDao2.insert(role);
        assertNotEquals(3,id);
    }
}