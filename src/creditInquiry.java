import java.io.*;
import java.text.MessageFormat;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class creditInquiry {
    private menuOption accountKind;
    private Scanner input;
    private menuOption choices[] = { menuOption.zero_balance, menuOption.credito_balance, menuOption.debito_balance,
            menuOption.end };

    private void readRecords() throws IOException {
        AccountRecord record = new AccountRecord();
        try {
            File arquivo = new File("cliente.txt");
            arquivo.createNewFile();
            input = new Scanner(arquivo);
            while (input.hasNext()) {
                record.setAccount(input.nextInt());
                record.setfirstName(input.next());
                record.setlastName(input.next());
                record.setbalance(input.nextDouble());
                if (shouldDisplay(record.getbalance())) {
                    System.out.printf(MessageFormat.format("{0}, {1}, {2}, {3}\n", record.getAccount(), record.getfirstName(),
                    record.getlastName(), record.getbalance()));
                }
            }
        } catch (NoSuchElementException elemException) {
            System.out.println(" erro no arquivo!");
            input.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.out.println("arquivo não encontrado");
            input.close();
            System.exit(1);
        } finally {
            if (input != null)
                input.close();
        }
    }

    private boolean shouldDisplay(double balance) {
        if ((accountKind == menuOption.credito_balance) && (balance < 0))
            return true;
        else if ((accountKind == menuOption.debito_balance) && (balance > 0))
            return true;
        else if ((accountKind == menuOption.zero_balance) && (balance == 0))
            return true;
        return false;
    }

    private menuOption getRequest(Scanner textIn) {
        int request = 1;
        System.out.printf("\n%s\n%s\n%s\n%s\n%s\n", "Enter request", "1 - Lista contas com zero",
                "2 - Lista contas com credito", "3 - Lista contas com debito", "4 - fim");
        try {
            do {
                System.out.print("\n?");
                request = textIn.nextInt();
            } while ((request < 1) || (request > 4));
        } catch (NoSuchElementException elem) {
            System.out.println("Entrada inválida");
            System.exit(1);
        }
        return choices[request - 1];
    }

    public void processRequest() throws IOException {
        Scanner textIn = new Scanner(System.in);
        accountKind = getRequest(textIn);
        while (accountKind != menuOption.end) {
            switch (accountKind) {
                case zero_balance:
                    System.out.println("\nConta com saldo zero:\n");
                    break;
                case credito_balance:
                    System.out.println("\nConta com credito\n");
                case debito_balance:
                    System.out.println("Conta  com debito:\n");
                    break;
                default:
                    break;
            }
            readRecords();
            accountKind = getRequest(textIn);
        }
        textIn.close();
    }
}
