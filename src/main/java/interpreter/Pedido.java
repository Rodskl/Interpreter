package interpreter;

public class Pedido {
    private double valorLanche;
    private double valorAdicionais;

    public double getValorLanche() {
        return valorLanche;
    }

    public void setValorLanche(double valorLanche) {
        this.valorLanche = valorLanche;
    }

    public double getValorAdicionais() {
        return valorAdicionais;
    }

    public void setValorAdicionais(double valorAdicionais) {
        this.valorAdicionais = valorAdicionais;
    }

    public double calcularTotalConta() {
        String expressao = valorLanche + " + " + valorAdicionais;
        InterpretadorExpressao interpretador = new InterpretadorExpressoesAritmeticas(expressao);
        return interpretador.interpretar();
    }

    public double calcularTotalPromocao() {
        String expressao = valorLanche + " + " + valorAdicionais + " / 2.0";
        InterpretadorExpressao interpretador = new InterpretadorExpressoesAritmeticas(expressao);
        return interpretador.interpretar();
    }
}