package navita.teste2.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the patrimonio database table.
 * 
 */
@Entity
@NamedQuery(name="Patrimonio.findAll", query="SELECT p FROM Patrimonio p")
public class Patrimonio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="num_tombo")
	private Integer numTombo;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to Marca
	@ManyToOne
	@JoinColumn(name="marca_id")
	private Marca marca;

	public Patrimonio() {
	}

	public Integer getNumTombo() {
		return this.numTombo;
	}

	public void setNumTombo(Integer numTombo) {
		this.numTombo = numTombo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Marca getMarca() {
		return this.marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}