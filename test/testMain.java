import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.stream.Stream;

public class testMain {

    @Test
    public void testFilter() {

        ClientServiceExecutor dao = new ClientServiceExecutor();
        dao.mapDao(new MockMapDAO());

        dao.Create(new Client("nome1", "cpf1", "feminino"));
        dao.Create(new Client("nome2", "cpf2", "feminino"));
        dao.Create(new Client("nome3", "cpf3", "feminino"));
        dao.Create(new Client("nome4", "cpf4", "masculino"));

        Collection<Client> clientList = dao.listAll();
        boolean filterTest = clientList.stream()
                .filter(client -> client.getGender().equals("feminino"))
                .allMatch(client -> client.getGender().equals("feminino"));
        Assert.assertTrue(filterTest);
    }

    @Test
    public void createTest() {
        ClientServiceExecutor dao = new ClientServiceExecutor();
        dao.mapDao(new MockMapDAO());

        boolean verify = dao.Create(new Client("nome1", "cpf1", "feminino"));
        Assert.assertTrue(verify);
    }

    @Test
    public void readTest() {
        ClientServiceExecutor dao = new ClientServiceExecutor();
        dao.mapDao(new MockMapDAO());
        dao.Create(new Client("nome1", "cpf1", "feminino"));

        Assert.assertEquals(Client.class, dao.Read("cpf1").getClass());
    }

    @Test
    public void updateTest() {
        ClientServiceExecutor dao = new ClientServiceExecutor();
        dao.mapDao(new MockMapDAO());
        dao.Create(new Client("nome1", "cpf1", "feminino"));

        boolean verify = dao.Update("newName", "cpf1", "newGender");
        Assert.assertTrue(verify);
    }

    @Test
    public void deleteTest() {
        ClientServiceExecutor dao = new ClientServiceExecutor();
        dao.mapDao(new MockMapDAO());
        dao.Create(new Client("nome1", "cpf1", "feminino"));

        boolean verify = dao.Delete("cpf1");
        Assert.assertTrue(verify);
    }
}
