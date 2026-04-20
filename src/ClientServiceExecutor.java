import java.util.Collection;

public class ClientServiceExecutor {

    private IMapDAO mapDAO;
    public void mapDao(IMapDAO mapDAO) {
        this.mapDAO = mapDAO;
    }

    public ClientServiceExecutor() {
        mapDao(new MapDAO());
    }

    boolean Create(Client client) {
        return mapDAO.Create(client);
    }

    Client Read(String cpf) {
        return mapDAO.Read(cpf);
    }

    boolean Update(String name, String cpf, String gender) {
        return mapDAO.Update(name, cpf, gender);
    }

    boolean Delete(String cpf) {
        return mapDAO.Delete(cpf);
    }

    Collection<Client> listAll() {
        return mapDAO.listAll();
    }
}
