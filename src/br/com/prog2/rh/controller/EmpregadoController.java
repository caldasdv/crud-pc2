package br.com.prog2.rh.controller;

import java.util.List;

import br.com.prog2.rh.model.Empregado;
import br.com.prog2.rh.persistence.EmpregadoDAO;
import br.com.prog2.rh.persistence.EmpregadoDAOImp;

public class EmpregadoController {
    public String inserir(Empregado emp) {
        EmpregadoDAO dao = new EmpregadoDAOImp();
        return dao.inserir(emp);
    }
    public String alterar(Empregado emp) {
        EmpregadoDAO dao = new EmpregadoDAOImp();
        return dao.alterar(emp);
    }
    public List<Empregado> listarTodos() {
        EmpregadoDAO dao = new EmpregadoDAOImp();
        return dao.listarTodos();
    }
}
