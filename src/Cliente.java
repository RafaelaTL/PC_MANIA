public class Cliente {
    public String nome;
    public long CPF;
    public Computador[] computadores = new Computador[50];

    public Cliente(String nome, long CPF) {
        this.nome = nome;
        this.CPF = CPF;
    }

    public float calculaTotalCompra() {
        float totalCompra = 0;
        for (int i = 0; i < computadores.length; i++) {
            if(computadores[i] != null){
                totalCompra += computadores[i].preco;
            }
            else break;
        }
        return totalCompra;
    }

}
