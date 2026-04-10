import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDAO {

    private Map<String, Client> map;

    public MapDAO() {
        this.map = new HashMap<>();
    }

    public void Create(Client client) {
        map.put(client.getCpf(), client);
    }

    public Client Read(String cpf) {
        return map.get(cpf);
    }

    public void Update(String name, String cpf, String gender) {
        map.get(cpf).setName(name);
        map.get(cpf).setGender(gender);
    }

    public void Delete(String cpf) {
        map.remove(cpf);
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
