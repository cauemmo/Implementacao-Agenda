import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contato {
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

public class Agenda {
    private List<Contato> contatos;
    private Scanner scanner;

    public Agenda() {
        contatos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void adicionarContato() {
        System.out.print("Digite o nome do contato: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o telefone do contato: ");
        String telefone = scanner.nextLine();

        Contato novoContato = new Contato(nome, telefone);
        contatos.add(novoContato);

        System.out.println("Contato adicionado com sucesso!");
    }

    public void exibirContatos() {
        if (contatos.isEmpty()) {
            System.out.println("A agenda está vazia.");
        } else {
            System.out.println("Lista de contatos:");

            for (Contato contato : contatos) {
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Telefone: " + contato.getTelefone());
                System.out.println("--------------------");
            }
        }
    }

    public void editarContato() {
        System.out.print("Digite o nome do contato que deseja editar: ");
        String nome = scanner.nextLine();

        boolean encontrado = false;

        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                System.out.print("Digite o novo nome do contato: ");
                String novoNome = scanner.nextLine();
                contato.setNome(novoNome);

                System.out.print("Digite o novo telefone do contato: ");
                String novoTelefone = scanner.nextLine();
                contato.setTelefone(novoTelefone);

                System.out.println("Contato editado com sucesso!");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Contato não encontrado na agenda.");
        }
    }

    public void excluirContato() {
        System.out.print("Digite o nome do contato que deseja excluir: ");
        String nome = scanner.nextLine();

        Contato contatoRemover = null;

        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contatoRemover = contato;
                break;
            }
        }

        if (contatoRemover != null) {
            contatos.remove(contatoRemover);
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Contato não encontrado na agenda.");
        }
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("----- Agenda -----");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Exibir contatos");
            System.out.println("3. Editar contato");
            System.out.println("4. Excluir contato");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    agenda.adicionarContato();
                    break;
                case 2:
                    agenda.exibirContatos();
                    break;
                case 3:
                    agenda.editarContato();
                    break;
                case 4:
                    agenda.excluirContato();
                    break;
                case 5:
                    System.out.println("Encerrando a agenda. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }
}
