package com.jpaprojeto.entity;

import com.jpaprojeto.validacao.MaxAnoAtualMais;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Temporal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@NamedQuery(name = "Automovel.LISTAR_DESTAQUES",
        query = "select a from Automovel a",
        hints = {
            @QueryHint(name = "org.hibernate.cacheable", value = "true")
            ,
               @QueryHint(name = "org.hibernate.cacheRegion",
                    value = Automovel.LISTAR_DESTAQUES)})

@Entity
@Cacheable
public class Automovel implements Serializable {

    //rastrear a compatibilidade de versos serializadas das classes
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 4, nullable = false)
    @Min(1900)
    @MaxAnoAtualMais(message = "O Valor maximo do ano de fabricacao e {0}")
    private Integer anoFabricacao;

    @Min(1900)
    @MaxAnoAtualMais(value = 1, message = "O Valor máximo do ano do modelo é {0}")
    private Integer anoModelo;

    @Column(length = 50, nullable = false)
    @ManyToOne
    private Modelo modelo;

    @Column(length = 4, nullable = false)
    @ManyToOne
    private Cor cor;

    @OneToMany(mappedBy = "automovel", cascade = CascadeType.ALL)
    private List<Foto> fotos;

    @Column(length = 10, nullable = false)
    private Float preco;

    private Float kilometragem;

    @Column(length = 100, nullable = false)
    private String observacoes;

    public static final String LISTAR_DESTAQUES
            = "Automovel.buscarDestaques";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Float getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(Float kilometragem) {
        this.kilometragem = kilometragem;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

}
