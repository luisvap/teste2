package navita.teste2.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marca database table.
 * 
 */
@Entity
@NamedQuery(name="Marca.findAll", query="SELECT m FROM Marca m")
public class Marca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="marca_id")
	private Integer marcaId;

	private String marca;

	//bi-directional many-to-one association to Patrimonio
	@OneToMany(mappedBy="marca")
	private List<Patrimonio> patrimonios;

	public Marca() {
	}

	public Integer getMarcaId() {
		return this.marcaId;
	}

	public void setMarcaId(Integer marcaId) {
		this.marcaId = marcaId;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public List<Patrimonio> getPatrimonios() {
		return this.patrimonios;
	}

	public void setPatrimonios(List<Patrimonio> patrimonios) {
		this.patrimonios = patrimonios;
	}

	public Patrimonio addPatrimonio(Patrimonio patrimonio) {
		getPatrimonios().add(patrimonio);
		patrimonio.setMarca(this);

		return patrimonio;
	}

	public Patrimonio removePatrimonio(Patrimonio patrimonio) {
		getPatrimonios().remove(patrimonio);
		patrimonio.setMarca(null);

		return patrimonio;
	}

}