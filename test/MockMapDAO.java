import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MockMapDAO implements IMapDAO{
    private Map<String, Client> map;

    public MockMapDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public boolean Create(Client client) {

        if (Validator(client.getCpf())){

            map.put(client.getCpf(), client);
            return true;
        }
        return false;
    }

    @Override
    public Client Read(String cpf) {
        return map.get(cpf);
    }

    @Override
    public boolean Update(String name, String cpf, String gender) {

        if (!Validator(cpf)) {

            map.get(cpf).setName(name);
            map.get(cpf).setGender(gender);
            return true;
        }
        return false;
    }

    @Override
    public boolean Delete(String cpf) {

        if (!Validator(cpf)) {

            map.remove(cpf);
            return true;
        }
        return false;
    }

    public boolean Validator(String cpf) {
        if (cpf == null || cpf.isEmpty() || map.containsKey(cpf)) {
            return false;
        } return true;
    }

    public Collection<Client> listAll() {
        return map.values();
    }
}
