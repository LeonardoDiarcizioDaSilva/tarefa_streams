import javax.swing.*;
import java.util.Collection;
import java.util.List;

public class Main {

    private static MapDAO mapDAO = new MapDAO();

    public enum Option {
        CREATE(1),
        READ(2),
        UPDATE(3),
        DELETE(4);

        private int value;
        Option(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {

        Integer val = 1;

        do {
            val = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite 1 para cadastrar um cliente" +
                    ", 2 para buscar, 3 para atualizar, 4 para excluir, e 5 para sair"));
            for (Option opt : Option.values()) {
                if (opt.getValue() == val) {
                    switch (opt) {
                        case CREATE -> {
                            String name = JOptionPane.showInputDialog(null, "Digite o nome da pessoa que deseja " +
                                    "cadastrar");
                            String cpf = JOptionPane.showInputDialog(null, "Digite o cpf da pessoa que deseja " +
                                    "cadastrar");
                            String gender = JOptionPane.showInputDialog(null, "Digite o gênero da pessoa que deseja " +
                                    "cadastrar");

                            if (mapDAO.Validator(cpf)) {
                                mapDAO.Create(new Client(name, cpf, gender));
                                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                                break;
                            }
                            JOptionPane.showMessageDialog(null, "Cliente ja se encontra cadastrado ou cpf esta vazio");
                        }
                        case READ -> {
                            String cpf = "";

                            String filter = JOptionPane.showInputDialog(null, "Deseja buscar o cliente" +
                                    " por cpf, ou por gênero? 1 PARA CPF /=/ 2 PARA GÊNERO");

                            if (filter.equals("1")) {
                                cpf = JOptionPane.showInputDialog(null, "Digite o cpf" +
                                        " que deseja consultar:");
                                if (mapDAO.Validator(cpf)) {
                                    JOptionPane.showMessageDialog(null, mapDAO.Read(cpf));
                                    break;
                                }
                                JOptionPane.showMessageDialog(null, "Cpf não existe ou digitado incorretamente.");
                                break;
                            }
                            String gender = JOptionPane.showInputDialog(null, "Digite o gênero" +
                                    " das pessoas que deseja filtrar: f ou m");
                            Collection<Client> clientList = mapDAO.listAll();
                            List<Client> clientFilter = clientList.stream()
                                    .filter(client -> client.getGender().equals(gender))
                                    .toList();
                            JOptionPane.showMessageDialog(null, clientFilter.toString());

                        }
                        case UPDATE -> {
                            String cpf = JOptionPane.showInputDialog(null, "Digite o cpf " +
                                    "do cliente que deseja alterar:");
                            if (mapDAO.Validator(cpf)) {
                                String name = JOptionPane.showInputDialog(null, "Digite o novo nome:");
                                String gender = JOptionPane.showInputDialog(null, "Digite o novo gênero:");

                                mapDAO.Update(name, cpf, gender);
                            }
                        }
                        case DELETE -> {
                            String cpf = JOptionPane.showInputDialog(null, "Digite o cpf " +
                                    "do cliente que deseja excluir:");
                            if (mapDAO.Validator(cpf)) {
                                mapDAO.Delete(cpf);
                            }
                        }
                    }
                }
            }
        } while (val != Option.values().length);
    }
}
