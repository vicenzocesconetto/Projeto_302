import java.util.ArrayList;

public class Venda {

    private String cliente;
    private ArrayList<Produtos> produtos;
    private ArrayList<Servicos> servicos;
    private FormaPagamento formaPagamento;


    public Venda() {
        produtos = new ArrayList<Produtos>();
        servicos = new ArrayList<Servicos>();
        formaPagamento = new FormaPagamento;
    }

    public Venda(String cliente, ArrayList<Produtos> produtos, ArrayList<Servicos> servicos, FormaPagamento formaPagamento) {
        this.cliente = cliente;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produtos> produtos) {
        this.produtos = produtos;
    }

    public ArrayList<Servicos> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servicos> servicos) {
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
