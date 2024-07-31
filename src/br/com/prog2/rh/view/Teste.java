package br.com.prog2.rh.view;

import java.util.List;
import br.com.prog2.rh.controller.EmpregadoController;
import br.com.prog2.rh.model.Empregado;

public class Teste {
    /**
     * Método principal para testar a funcionalidade do EmpregadoController.
     * Cria uma instância de EmpregadoController, opcionalmente configura um objeto Empregado,
     * e recupera e exibe uma lista de todos os objetos Empregado.
     *
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        // Cria uma instância do controlador
        EmpregadoController ec = new EmpregadoController();

        try {
            // Opcionalmente, configura um objeto Empregado para uso futuro
            Empregado e = new Empregado();
            e.setCpf("11111111");
            e.setIdade(21);
            e.setNome("Vivian");
            e.setSalario(3050.0);
            // Descomente a linha a seguir para usar o método 'alterar' se necessário
            // System.out.println(ec.alterar(e));

            // Recupera a lista de todos os objetos Empregado
            List<Empregado> lista = ec.listarTodos();
            if (lista != null && !lista.isEmpty()) {
                // Imprime o nome de cada Empregado se a lista não estiver vazia
                for (Empregado emp : lista) {
                    System.out.println(emp.getNome());
                }
            } else {
                // Imprime uma mensagem se nenhum objeto Empregado for encontrado
                System.out.println("Nenhum empregado encontrado.");
            }
        } catch (Exception ex) {
            // Imprime uma mensagem de erro se ocorrer uma exceção
            System.err.println("Ocorreu um erro: " + ex.getMessage());
        }
    }
}
