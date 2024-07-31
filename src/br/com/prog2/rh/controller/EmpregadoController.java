package br.com.prog2.rh.controller;

import java.util.List;

import br.com.prog2.rh.model.Empregado;
import br.com.prog2.rh.persistence.EmpregadoDAO;
import br.com.prog2.rh.persistence.EmpregadoDAOImp;

public class EmpregadoController {
    /**
     * Insere um novo objeto Empregado no banco de dados.
     *
     * @param emp o objeto Empregado a ser inserido
     * @return uma mensagem de confirmação ou erro retornada pelo DAO
     */
    public String inserir(Empregado emp) {
        // Cria uma instância do DAO (Data Access Object) para interação com o banco de dados
        EmpregadoDAO dao = new EmpregadoDAOImp();
        // Chama o método inserir do DAO e retorna o resultado
        return dao.inserir(emp);
    }

    /**
     * Altera os dados de um objeto Empregado existente no banco de dados.
     *
     * @param emp o objeto Empregado com os dados atualizados
     * @return uma mensagem de confirmação ou erro retornada pelo DAO
     */
    public String alterar(Empregado emp) {
        // Cria uma instância do DAO (Data Access Object) para interação com o banco de dados
        EmpregadoDAO dao = new EmpregadoDAOImp();
        // Chama o método alterar do DAO e retorna o resultado
        return dao.alterar(emp);
    }

    /**
     * Lista todos os objetos Empregado presentes no banco de dados.
     *
     * @return uma lista contendo todos os objetos Empregado
     */
    public List<Empregado> listarTodos() {
        // Cria uma instância do DAO (Data Access Object) para interação com o banco de dados
        EmpregadoDAO dao = new EmpregadoDAOImp();
        // Chama o método listarTodos do DAO e retorna a lista de empregados
        return dao.listarTodos();
    }
}
