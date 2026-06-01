package org.exception.flow.lab;

import org.exception.flow.lab.exception.SaldoInsulficienteException;
import org.exception.flow.lab.model.ContaBancaria;
import org.exception.flow.lab.service.ContaService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ContaBancaria contaBancaria = new ContaBancaria(570);

        ContaService contaService = new ContaService();

        try {
            contaService.sacar(contaBancaria,1000);
        }catch (SaldoInsulficienteException e){

            System.out.println("Erro de négocio");

            e.printStackTrace();

            throw new RuntimeException(
                    "Falha a processar o saque",
                    e
            );
        }finally {
            System.out.println("Operação Finalizada!");
        }

    }
}