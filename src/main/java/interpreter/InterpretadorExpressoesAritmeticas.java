package interpreter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class InterpretadorExpressoesAritmeticas implements InterpretadorExpressao {
    private InterpretadorExpressao interpretadorExpressao;

    public InterpretadorExpressoesAritmeticas(String contextoExpressoes) {
        Stack<InterpretadorExpressao> pilhaInterpretadores = new Stack<>();
        List<String> elementos = Arrays.asList(contextoExpressoes.split(" "));
        Iterator<String> iterator = elementos.iterator();

        while (iterator.hasNext()) {
            String elemento = iterator.next();
            if (elemento.matches("\\d+(\\.\\d+)?")) {
                pilhaInterpretadores.push(new Numero(Double.parseDouble(elemento)));
            } else if (elemento.equals("+")) {
                if (!iterator.hasNext()) throw new IllegalArgumentException("Expressão inválida");
                InterpretadorExpressao elementoEsquerda = pilhaInterpretadores.pop();
                InterpretadorExpressao elementoDireita = new Numero(Double.parseDouble(iterator.next()));
                Adicao interpretador = new Adicao(elementoEsquerda, elementoDireita);
                pilhaInterpretadores.push(new Numero(interpretador.interpretar()));
            } else if (elemento.equals("/")) {
                if (!iterator.hasNext()) throw new IllegalArgumentException("Expressão inválida");
                InterpretadorExpressao elementoEsquerda = pilhaInterpretadores.pop();
                InterpretadorExpressao elementoDireita = new Numero(Double.parseDouble(iterator.next()));
                Divisao interpretador = new Divisao(elementoEsquerda, elementoDireita);
                pilhaInterpretadores.push(new Numero(interpretador.interpretar()));
            } else {
                throw new IllegalArgumentException("Expressão com elemento inválido");
            }
        }
        interpretadorExpressao = pilhaInterpretadores.pop();
    }

    public double interpretar() {
        return interpretadorExpressao.interpretar();
    }
}