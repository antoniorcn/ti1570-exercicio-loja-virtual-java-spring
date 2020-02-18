package edu.curso.supermarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Produto {
	private long id;
	private String code;
	private String eanCode;
	private String nome;
	private String descricao;
	private double precoUnitario;
	private double volumeAltura;
	private double volumeLargura;
	private double volumeProfundidade;
	private double peso;
	private byte[] foto;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(length=25)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(length=20)
	public String getEanCode() {
		return eanCode;
	}
	public void setEanCode(String eanCode) {
		this.eanCode = eanCode;
	}
	
	@Column(length=100)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(length=255)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	public double getVolumeAltura() {
		return volumeAltura;
	}
	public void setVolumeAltura(double volumeAltura) {
		this.volumeAltura = volumeAltura;
	}
	
	public double getVolumeLargura() {
		return volumeLargura;
	}
	public void setVolumeLargura(double volumeLargura) {
		this.volumeLargura = volumeLargura;
	}
	
	public double getVolumeProfundidade() {
		return volumeProfundidade;
	}
	public void setVolumeProfundidade(double volumeProfundidade) {
		this.volumeProfundidade = volumeProfundidade;
	}
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	@Lob
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
}
