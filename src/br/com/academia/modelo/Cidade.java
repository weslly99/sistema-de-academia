/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.academia.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table; 
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @author Brendo
 */
@Entity
@Table(name = "cidade")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
		@NamedQuery(name = "Cidade.findById", query = "SELECT c FROM Cidade c WHERE c.id = :id"),
		@NamedQuery(name = "Cidade.findBySigla", query = "SELECT c FROM Cidade c WHERE c.sigla = :sigla"),
		@NamedQuery(name = "Cidade.findByNome", query = "SELECT c FROM Cidade c WHERE c.nome = :nome") })
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "sigla", length = 2)
	private String sigla;

	@Column(name = "nome", length = 50)
	private String nome;
	@JoinColumn(name = "estado_id", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Estado estadoId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadeId")
	private List<Endereco> enderecoList;

	public Cidade() {
	}

	public Cidade(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Estado estadoId) {
		this.estadoId = estadoId;
	}

	@XmlTransient
	public List<Endereco> getEnderecoList() {
		return enderecoList;
	}

	public void setEnderecoList(List<Endereco> enderecoList) {
		this.enderecoList = enderecoList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Cidade)) {
			return false;
		}
		Cidade other = (Cidade) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "gerador.Cidade[ id=" + id + " ]";
	}

}
