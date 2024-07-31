package br.com.prog2.rh.view;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.prog2.rh.controller.EmpregadoController;
import br.com.prog2.rh.model.Empregado;
public class Teste {
    public static void main(String[] args) {
        EmpregadoController ec  = new EmpregadoController();
        Empregado e = new Empregado();
        e.setCpf("11111111");
        e.setIdade(21);
        e.setNome("Vivian");
        e.setSalario(3050.0);
        //System.out.println(ec.alterar(e));
        List<Empregado> lista = ec.listarTodos();
        if (lista !=  null && !lista.isEmpty()) {
            for(Empregado emp : lista) {
                System.out.println(emp.getNome());
            }
        }
    }
}
