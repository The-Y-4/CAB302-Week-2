import java.util.ArrayList;

/**
 * Implements the IAuthenticationService interface for user authentication.
 */
public class AuthenticationService implements IAuthenticationService {
    private ArrayList<User> users;

    /**
     * Constructor initializes the users list with a default user.
     */
    public AuthenticationService() {
        users = new ArrayList<>();
        // Add default user
        users.add(new User("test", "test"));
    }

    /**
     * Registers a new user if the username is not already taken.
     *
     * @param username the username to register
     * @param password the password for the new user
     * @return the newly created user if registration is successful, null otherwise
     */
    @Override
    public User signUp(String username, String password) {
        // Check if the username already exists
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return null; // Username taken
            }
        }
        // Create and add new user
        User newUser = new User(username, password);
        users.add(newUser);
        return newUser;
    }

    /**
     * Authenticates a user based on username and password.
     *
     * @param username the username to authenticate
     * @param password the password to check
     * @return the authenticated user if credentials match, null otherwise
     */
    @Override
    public User logIn(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}