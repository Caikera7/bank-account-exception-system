package org.exception.flow.lab.service;

import org.exception.flow.lab.exception.SaldoInsulficienteException;
import org.exception.flow.lab.exception.ValorInvalidoException;
import org.exception.flow.lab.model.ContaBancaria;

public class ContaService {

    public void depositar(ContaBancaria conta, double valor){

        if (valor <= 0 ){
            throw new ValorInvalidoException("Valor do débito inválido");
        }

        conta.setSaldo(
                conta.getSaldo() + valor
        );
    }

    public void sacar(ContaBancaria contaBancaria, double valor) throws SaldoInsulficienteException {

        if(valor > contaBancaria.getSaldo()){
            throw new SaldoInsulficienteException(
                    "Saldo insulficiente!"
            );
        }
        contaBancaria.setSaldo(
                contaBancaria.getSaldo() - valor
        );
    }

}
