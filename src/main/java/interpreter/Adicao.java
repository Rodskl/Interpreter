package interpreter;

public class Adicao implements InterpretadorExpressao {
    private InterpretadorExpressao esq;
    private InterpretadorExpressao dir;

    public Adicao(InterpretadorExpressao esq, InterpretadorExpressao dir) {
        this.esq = esq;
        this.dir = dir;
    }

    public double interpretar() {
        return esq.interpretar() + dir.interpretar();
    }
}