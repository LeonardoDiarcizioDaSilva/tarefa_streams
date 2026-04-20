import java.util.Collection;

public interface IMapDAO {

    boolean Create(Client client);

    Client Read(String cpf);

    boolean Update(String name, String cpf, String gender);

    boolean Delete(String cpf);

    Collection<Client> listAll();
}
