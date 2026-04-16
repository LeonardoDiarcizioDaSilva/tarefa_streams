import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.stream.Stream;

public class testMain {

    private static MapDAO mapDAO = new MapDAO();

    @Test
    public void testFilter() {

        mapDAO.Create(new Client("nome1", "cpf1", "feminino"));
        mapDAO.Create(new Client("nome2", "cpf2", "feminino"));
        mapDAO.Create(new Client("nome3", "cpf3", "feminino"));
        mapDAO.Create(new Client("nome4", "cpf4", "masculino"));

        Collection<Client> clientList = mapDAO.listAll();
        boolean filterTest = clientList.stream()
                .filter(client -> client.getGender().equals("feminino"))
                .allMatch(client -> client.getGender().equals("feminino"));
        Assert.assertEquals(true, filterTest);
    }
}
