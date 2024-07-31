package br.com.prog2.rh.persistence;

import br.com.prog2.rh.model.Empregado;
import java.util.List;

public interface EmpregadoDAO {

    /**
     * Insere um novo empregado no banco de dados.
     *
     * @param emp o objeto Empregado a ser inserido
     * @return uma mensagem indicando o sucesso ou falha da inserção
     */
    public String inserir(Empregado emp);

    /**
     * Atualiza os dados de um empregado existente no banco de dados.
     *
     * @param emp o objeto Empregado com os dados atualizados
     * @return uma mensagem indicando o sucesso ou falha da atualização
     */
    public String alterar(Empregado emp);

    /**
     * Exclui um empregado do banco de dados com base no objeto Empregado fornecido.
     *
     * @param emp o objeto Empregado a ser excluído
     * @return uma mensagem indicando o sucesso ou falha da exclusão
     */
    public String excluir(Empregado emp);

    /**
     * Lista todos os empregados presentes no banco de dados.
     *
     * @return uma lista de objetos Empregado ou uma lista vazia se não houver empregados
     */
    public List<Empregado> listarTodos();

    /**
     * Pesquisa um empregado no banco de dados pelo CPF fornecido.
     *
     * @param cpf o CPF do empregado a ser pesquisado
     * @return o objeto Empregado correspondente ao CPF ou null se não encontrado
     */
    public Empregado pesquisarPorCpf(String cpf);
}
