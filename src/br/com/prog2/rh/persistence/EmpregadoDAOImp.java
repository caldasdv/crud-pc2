package br.com.prog2.rh.persistence;

import br.com.prog2.rh.model.Empregado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpregadoDAOImp implements EmpregadoDAO {

    /**
     * Insere um novo empregado no banco de dados.
     *
     * @param emp o objeto Empregado a ser inserido
     * @return uma mensagem de sucesso ou erro
     */
    @Override
    public String inserir(Empregado emp) {
        // Obtém uma conexão com o banco de dados
        Connection con = ConnectionFactory.getConnection();
        // Prepara a instrução SQL para inserção
        StringBuilder sql = new StringBuilder();
        sql.append("insert into empregado (cpf, nome, idade, salario)");
        sql.append(" values (?, ?, ?, ?)");

        try {
            // Prepara a declaração SQL com parâmetros
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setString(1, emp.getCpf());
            pst.setString(2, emp.getNome());
            pst.setInt(3, emp.getIdade());
            pst.setDouble(4, emp.getSalario());
            // Executa a atualização e verifica se a inserção foi bem-sucedida
            int resp = pst.executeUpdate();
            if (resp > 0) {
                return "Inserido com sucesso";
            } else {
                return "Erro ao inserir";
            }
        } catch (SQLException e) {
            // Retorna mensagem de erro se a inserção falhar
            return "Erro ao inserir os dados: " + e.getMessage();
        } finally {
            // Fecha a conexão com o banco de dados
            ConnectionFactory.close(con);
        }
    }

    /**
     * Atualiza os dados de um empregado existente no banco de dados.
     *
     * @param emp o objeto Empregado com os dados atualizados
     * @return uma mensagem de sucesso ou erro
     */
    @Override
    public String alterar(Empregado emp) {
        // Obtém uma conexão com o banco de dados
        Connection con = ConnectionFactory.getConnection();
        // Prepara a instrução SQL para atualização
        StringBuilder sql = new StringBuilder();
        sql.append("update empregado set nome=?, idade=?, salario=? where cpf=?");

        try {
            // Prepara a declaração SQL com parâmetros
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setString(1, emp.getNome());
            pst.setInt(2, emp.getIdade());
            pst.setDouble(3, emp.getSalario());
            pst.setString(4, emp.getCpf());
            // Executa a atualização e verifica se a alteração foi bem-sucedida
            int resp = pst.executeUpdate();
            if (resp > 0) {
                return "Alterado com sucesso";
            } else {
                return "Erro ao alterar";
            }
        } catch (SQLException e) {
            // Retorna mensagem de erro se a atualização falhar
            return "Erro ao alterar os dados: " + e.getMessage();
        } finally {
            // Fecha a conexão com o banco de dados
            ConnectionFactory.close(con);
        }
    }

    /**
     * Exclui um empregado do banco de dados baseado no CPF.
     *
     * @param emp o objeto Empregado a ser excluído
     * @return uma mensagem de sucesso ou erro
     */
    @Override
    public String excluir(Empregado emp) {
        // Obtém uma conexão com o banco de dados
        Connection con = ConnectionFactory.getConnection();
        // Prepara a instrução SQL para exclusão
        StringBuilder sql = new StringBuilder();
        sql.append("delete from empregado where cpf=?");

        try {
            // Prepara a declaração SQL com parâmetros
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setString(1, emp.getCpf());
            // Executa a atualização e verifica se a exclusão foi bem-sucedida
            int resp = pst.executeUpdate();
            if (resp > 0) {
                return "Excluído com sucesso";
            } else {
                return "Erro ao excluir";
            }
        } catch (SQLException e) {
            // Retorna mensagem de erro se a exclusão falhar
            return "Erro ao excluir: " + e.getMessage();
        } finally {
            // Fecha a conexão com o banco de dados
            ConnectionFactory.close(con);
        }
    }

    /**
     * Lista todos os empregados no banco de dados.
     *
     * @return uma lista de todos os objetos Empregado ou null em caso de erro
     */
    @Override
    public List<Empregado> listarTodos() {
        // Obtém uma conexão com o banco de dados
        Connection con = ConnectionFactory.getConnection();
        // Prepara a instrução SQL para seleção
        StringBuilder sql = new StringBuilder();
        sql.append("select * from empregado");

        try {
            // Prepara a declaração SQL e executa a consulta
            PreparedStatement pst = con.prepareStatement(sql.toString());
            ResultSet resp = pst.executeQuery();
            List<Empregado> lista = new ArrayList<Empregado>();
            // Itera sobre o resultado da consulta e popula a lista de empregados
            if (resp != null) {
                while (resp.next()) {
                    Empregado e = new Empregado();
                    e.setCpf(resp.getString(1));
                    e.setNome(resp.getString(2));
                    e.setIdade(resp.getInt(3));
                    e.setSalario(resp.getDouble(4));
                    lista.add(e);
                }
            } else {
                return null;
            }
            return lista;
        } catch (SQLException e) {
            // Retorna null em caso de erro na consulta
            return null;
        } finally {
            // Fecha a conexão com o banco de dados
            ConnectionFactory.close(con);
        }
    }

    /**
     * Pesquisa um empregado no banco de dados pelo CPF.
     *
     * @param cpf o CPF do empregado a ser pesquisado
     * @return o objeto Empregado correspondente ao CPF ou null se não encontrado
     */
    @Override
    public Empregado pesquisarPorCpf(String cpf) {
        // Método não implementado
        return null;
    }
}
