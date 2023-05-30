import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void MultipleCondition() {
        assertThrows(RuntimeException.class, () -> SILab2.function(null, new ArrayList<>()));
        assertThrows(RuntimeException.class, () -> SILab2.function(new User("username", null, "email"), new ArrayList<>()));
        assertThrows(RuntimeException.class, () -> SILab2.function(new User("username", "password", null), new ArrayList<>()));
        assertDoesNotThrow(() -> SILab2.function(new User("username", "password", "email"), new ArrayList<>()));
    }
    @Test
    void EveryBranch() {
        assertThrows(RuntimeException.class, () -> SILab2.function(new User("username", null, "email"), new ArrayList<>()));
        assertFalse(SILab2.function(new User(null, "password", "email@email.com"), List.of(new User(null, "password", "email@email.com"))));
        assertFalse(SILab2.function(new User("username", "!password", "email"), List.of(new User("username", "!password", "email"))));
        assertFalse(SILab2.function(new User("username", "!pass", "email"), List.of(new User("username", "!pass", "email"))));
        assertFalse(SILab2.function(new User("username1", "! password1", "email@email.com"), List.of(new User("username2", "! Password", "smth@smth.com"))));
    }
}