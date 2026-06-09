package interpreter;

public class Divisao implements InterpretadorExpressao {
    private InterpretadorExpressao esq;
    private InterpretadorExpressao dir;

    public Divisao(InterpretadorExpressao esq, InterpretadorExpressao dir) {
        this.esq = esq;
        this.dir = dir;
    }

    public double interpretar() {
        return esq.interpretar() / dir.interpretar();
    }
}