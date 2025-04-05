import java.util.Arrays;

public class Computador {
    public String marca;
    public float preco;
    public MemoriaUSB memoriaUSB;
    public SistemaOperacional sistemaOperacional;
    public HardwareBasico[] hardwareBasico = new HardwareBasico[3];

    public Computador(String marca, float preco, String nomeProcessador, float capacidadeProcessador, String nomeRAM, float capacidadeRAM, String nomeHD, float capacidadeHD, String nomeSO, int tipoSO) {
        this.marca = marca;
        this.preco = preco;
        this.hardwareBasico[0] = new HardwareBasico(nomeProcessador, capacidadeProcessador);
        this.hardwareBasico[1] = new HardwareBasico(nomeRAM, capacidadeRAM);
        this.hardwareBasico[2] = new HardwareBasico(nomeHD, capacidadeHD);
        this.sistemaOperacional = new SistemaOperacional();
        this.sistemaOperacional.nome = nomeSO;
        this.sistemaOperacional.tipo = tipoSO;
    }


    public void mostraPCConfigs() {
        System.out.println("{");
        System.out.println("    Marca: '" + marca + "'");
        System.out.println("    Preço: R$" + preco);

        System.out.print("    Hardware Básico: [");
        for (int i = 0; i < hardwareBasico.length; i++) {
            if (hardwareBasico[i] != null) {

                String capacidadeFormatada = "";

                if(i != 0){
                    if(hardwareBasico[i].capacidade >= 1000){
                        capacidadeFormatada = hardwareBasico[i].capacidade/1000 + " TB";
                    } else {
                        capacidadeFormatada = hardwareBasico[i].capacidade + " GB";
                    }
                } else {
                    capacidadeFormatada = "Mhz";
                }

                System.out.print("{" + hardwareBasico[i].nome + " (" +
                        capacidadeFormatada + ")}");
                if (i < hardwareBasico.length - 1 && hardwareBasico[i+1] != null) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println("]");

        System.out.println("    Sistema Operacional: {" + sistemaOperacional.nome +
                " (" + sistemaOperacional.tipo + " bits)}");

        String capacidadeFormatada = "";

        if (memoriaUSB != null) {

            if(memoriaUSB.capacidade >= 1000){
                capacidadeFormatada = memoriaUSB.capacidade/1000 + " TB";
            } else {
                capacidadeFormatada = memoriaUSB.capacidade + " GB";
            }

            System.out.println("    Acompanha: {" + memoriaUSB.nome + " de " +
                    capacidadeFormatada  + "}");
        }

        System.out.println("}");
    }


    public void addMemoriaUSB(MemoriaUSB musb) {
        if(this.memoriaUSB ==null) this.memoriaUSB = musb;
        else System.out.println("Memória já adicionada");
    }
}