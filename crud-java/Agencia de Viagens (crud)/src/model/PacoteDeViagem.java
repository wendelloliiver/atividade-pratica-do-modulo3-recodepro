package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PacoteDeViagem {
    private int id;
    private String destino;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private BigDecimal preco;
    private int idCliente;

    public PacoteDeViagem(int id, String destino, LocalDate dataInicio, LocalDate dataFim, BigDecimal preco, int idCliente) {
        this.id = id;
        this.destino = destino;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.preco = preco;
        this.idCliente = idCliente;
    }

    public int getId() {
        return id;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getIdCliente() {
        return idCliente;
    }
}
