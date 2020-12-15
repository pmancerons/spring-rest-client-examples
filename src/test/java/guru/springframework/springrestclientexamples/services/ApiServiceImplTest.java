package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceImplTest extends TestCase {

    @Autowired
    ApiService apiService;

    @Test
    public void testGetUsers() {
        List<User> users = apiService.getUsers(5);

        assertEquals(5,users.size());
    }

    @Test
    public void testGet10Users() {
        List<User> users = apiService.getUsers(10);

        assertEquals(10,users.size());
    }
}