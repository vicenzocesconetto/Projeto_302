public class Venda {

    private String client;
    private ArrayList<Produtos> produtos;
    private ArraList<Servicos> servicos;
    private FormaPagamento formaPagamento;


    public Venda() {}

    public Venda(String client, ArrayList<Produtos> produtos, ArraList<Servicos> servicos, FormaPagamento formaPagamento) {
        this.client = client;
        this.produtos = produtos;
        this.servicos = servicos;
        this.formaPagamento = formaPagamento;
    }

    public float calcularValorTotal(float ... preco) {
        float total = 0;
        for (int i = 0; i < preco.length; i++) {
            total += preco[i];
        }

        return total;
    }

    public float calcularTroco(float preco, float valorPago) {
        if(valorPago < preco) {
            System.out.println("O valor pago eh menor que o preco! Revise a compra.");
            return -1;
        } else
        return valorPago - preco;
    }

    public float aplicarDesconto(float preco, float desconto) {
        if(desconto > preco) {
            System.out.println("O desconto eh maior que o preco da preco! Revise a compra.");
            return -1;
        }
        else {
            return preco - desconto;
        }
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public ArrayList<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produtos> produtos) {
        this.produtos = produtos;
    }

    public ArraList<Servicos> getServicos() {
        return servicos;
    }

    public void setServicos(ArraList<Servicos> servicos) {
        this.servicos = servicos;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "client='" + client + '\'' +
                ", produtos=" + produtos +
                ", servicos=" + servicos +
                ", formaPagamento=" + formaPagamento +
                '}';
    }
}