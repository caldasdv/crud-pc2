package br.com.prog2.rh.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.prog2.rh.model.Empregado;
public class EmpregadoDAOImp implements EmpregadoDAO {
    @Override
    public String inserir(Empregado emp) {
        Connection con = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("insert into empregado (cpf,nome,idade,salario)");
        sql.append("values(?,?,?,?)");

        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setString(1, emp.getCpf());
            pst.setString(2, emp.getNome());
            pst.setInt(3, emp.getIdade());
            pst.setDouble(4, emp.getSalario());
            int resp = pst.executeUpdate();
            if (resp > 0 ) {
                return "Inserido com sucesso";
            }
            else {
                return "Erro ao inserir";
            }

        }
        catch (SQLException e) {
            return "Erro ao inserir os dados " + e.getMessage();
        }
        finally {

            ConnectionFactory.close(con);
        }
    }
    @Override
    public String alterar(Empregado emp) {
        Connection con = ConnectionFactory.getConnection();
        StringBuilder sql  = new StringBuilder();
        sql.append("update empregado set nome=?, idade=?, salario=? where cpf =?");
        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setString(1, emp.getNome());
            pst.setInt(2, emp.getIdade());
            pst.setDouble(3,emp.getSalario());
            pst.setString(4, emp.getCpf());
            int resp = pst.executeUpdate();
            if (resp > 0 ) {
                return "Alterado com sucesso";
            }
            else {
                return "Erro ao alterar";
            }

        }
        catch (SQLException e) {
            return "Erro ao alterar os dados " + e.getMessage();
        }
        finally {
            ConnectionFactory.close(con);

        }
    }
    @Override
    public String excluir(Empregado emp) {
        Connection con = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("delete from empregado where cpf=?");
        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            pst.setString(1, emp.getCpf());
            int resp = pst.executeUpdate();
            if(resp > 0){
                return "Alterado com sucesso.";
            }else{
                return "Erro ao alterar.";
            }
        }catch(SQLException e){
            return "Erro ao excluir " + e.getMessage();
        }finally {
            ConnectionFactory.close(con);
        }
    }
    @Override
    public List<Empregado> listarTodos() {
        Connection con  =  ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from empregado");
        try {
            PreparedStatement pst = con.prepareStatement(sql.toString());
            ResultSet resp = pst.executeQuery();
            List<Empregado> lista = new ArrayList<Empregado>();
            if (resp != null) {
                while(resp.next()) {
                    Empregado e = new Empregado();
                    e.setCpf(resp.getString(1));
                    e.setNome(resp.getString(2));
                    e.setIdade(resp.getInt(3));
                    e.setSalario(resp.getDouble(4));
                    lista.add(e);
                }
            }else {
                return null;
            }
            return lista;
        } catch (SQLException e) {
            return null;
        }finally {
            ConnectionFactory.close(con);
        }
    }
    @Override
    public Empregado pesquisarPorCpf(String cpf) {
        return null;
    }
}
