/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.academia.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table; 
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Brendo
 */
@Entity
@Table(name = "valor_medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ValorMedida.findAll", query = "SELECT v FROM ValorMedida v"),
    @NamedQuery(name = "ValorMedida.findById", query = "SELECT v FROM ValorMedida v WHERE v.id = :id"),
    @NamedQuery(name = "ValorMedida.findByValor", query = "SELECT v FROM ValorMedida v WHERE v.valor = :valor"),
    @NamedQuery(name = "ValorMedida.findByMembro", query = "SELECT v FROM ValorMedida v WHERE v.membro = :membro")})
public class ValorMedida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 6, scale = 2)
    private Double valor;
 
    @Column(length = 45)
    private String membro;
    @JoinColumn(name = "aluno_tem_medida_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private AlunoTemMedida alunoTemMedidaId;

    public ValorMedida() {
    }

    public ValorMedida(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getMembro() {
        return membro;
    }

    public void setMembro(String membro) {
        this.membro = membro;
    }

    public AlunoTemMedida getAlunoTemMedidaId() {
        return alunoTemMedidaId;
    }

    public void setAlunoTemMedidaId(AlunoTemMedida alunoTemMedidaId) {
        this.alunoTemMedidaId = alunoTemMedidaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValorMedida)) {
            return false;
        }
        ValorMedida other = (ValorMedida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerador.ValorMedida[ id=" + id + " ]";
    }
    
}
