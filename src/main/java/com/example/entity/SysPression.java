package com.example.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sys_pression database table.
 * 
 */
@Entity
@Table(name="sys_pression")
@NamedQuery(name="SysPression.findAll", query="SELECT s FROM SysPression s")
public class SysPression implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="p_id")
	private int pId;

	private String pression;

	@Column(name="pression_name")
	private String pressionName;

	public SysPression() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPId() {
		return this.pId;
	}

	public void setPId(int pId) {
		this.pId = pId;
	}

	public String getPression() {
		return this.pression;
	}

	public void setPression(String pression) {
		this.pression = pression;
	}

	public String getPressionName() {
		return this.pressionName;
	}

	public void setPressionName(String pressionName) {
		this.pressionName = pressionName;
	}

}