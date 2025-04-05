import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int matricula = 146;
        Computador PC1 = new Computador("Apple", matricula, "Pentium Core i3", 2200 , "Memória RAM", 8, "HD", 500, "Linux Ubuntu", 32);
        Computador PC2 = new Computador("Samsung", matricula + 1234, "Pentium Core i5", 3370, "Memória RAM", 16, "HD", 1000, "Windows 8", 64);
        Computador PC3 = new Computador("Dell", matricula + 5678, "Pentium Core i7", 4500, "Memória RAM", 32, "HD", 2000, "Windows 10", 64);

        MemoriaUSB usb1 = new MemoriaUSB(16, "Pen-Drive");
        MemoriaUSB usb2 = new MemoriaUSB(32, "Pen-Drive");
        MemoriaUSB usb3 = new MemoriaUSB(1000, "HD Externo");

        PC1.addMemoriaUSB(usb1);
        PC2.addMemoriaUSB(usb2);
        PC3.addMemoriaUSB(usb3);

        int opcao;

        System.out.println("Olá, bem vindo a PC Mania!");


        System.out.println("\nEntre com o seu Nome:");
        String nomeCliente = entrada.nextLine();


        System.out.println("\nEntre com seu CPF:");
        long cpfCliente = entrada.nextLong();
        entrada.nextLine();

        Cliente cliente = new Cliente(nomeCliente, cpfCliente);

        System.out.println("\n\nSegue nosso catálogo de promoções:");
        System.out.println("\t-Promoção 1:");
        PC1.mostraPCConfigs();
        System.out.println("\t-Promoção 2:");
        PC2.mostraPCConfigs();
        System.out.println("\t-Promoção 3:");
        PC3.mostraPCConfigs();
        System.out.println("\n\nMenu: \n\tDigite '1' para Promoção 1");
        System.out.println("\tDigite '2' para Promoção 2");
        System.out.println("\tDigite '3' para Promoção 3");
        System.out.println("\tDigite '0' para Finalizar Compra");

        do {
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    for (int i = 0; i < cliente.computadores.length; i++) {
                        if (cliente.computadores[i] == null) {
                            cliente.computadores[i] = PC1;
                            break;
                        }
                    }
                    System.out.println("PC da promoção 1 adicionado com sucesso!");
                    break;
                case 2:
                    for (int i = 0; i < cliente.computadores.length; i++) {
                        if (cliente.computadores[i] == null) {
                            cliente.computadores[i] = PC2;
                            break;
                        }
                    }
                    System.out.println("PC da promoção 2 adicionado com sucesso!");
                    break;
                case 3:
                    for (int i = 0; i < cliente.computadores.length; i++) {
                        if (cliente.computadores[i] == null) {
                            cliente.computadores[i] = PC3;
                            break;
                        }
                    }
                    System.out.println("PC da promoção 3 adicionado com sucesso!");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
            if (opcao != 0) {
                System.out.println("Caso queira comprar mais PC's, continue pelo 'Menu'. Caso queira finalizar, digite '0'!");
            }
        } while (opcao != 0);


        System.out.println("\n=============== RESUMO DA COMPRA ===============");
        System.out.println("Cliente: " + cliente.nome);
        System.out.println("CPF: " + cliente.CPF);
        System.out.println("\nItens comprados:");

        int itemCount = 1;
        for (Computador pc : cliente.computadores) {
            if (pc != null) {
                System.out.println("\nItem " + itemCount++ + ":");
                pc.mostraPCConfigs();
            }
        }

        System.out.println("\nVALOR TOTAL DA COMPRA: R$" + cliente.calculaTotalCompra());
        System.out.println("==============================================");
        System.out.println("Obrigado por comprar na PC Mania!");

        entrada.close();
    }
}