package by.ntck.sten.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Sklad_HistoryOperation")
public class HistoryOperation {

	@Id
	@Column(name = "id_historyOperation")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_historyOperation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kladovshik_id", nullable = false)
	private Kladovshik kladovshik;

	@Column(name = "tableName")
	private String tableName;

	@Column(name = "id_row")
	private int id_row;

	@Column(name = "date")
	private String date;

	@Column(name = "kol_vo")
	private double kol_vo;

	@Column(name = "kol_vo_old")
	private double kol_vo_old;
	
	@Column(name = "operation")
	private String operation;
	
	public double getKol_vo() {
		return kol_vo;
	}

	public void setKol_vo(double kol_vo) {
		this.kol_vo = kol_vo;
	}

	public double getKol_vo_old() {
		return kol_vo_old;
	}

	public void setKol_vo_old(double kol_vo_old) {
		this.kol_vo_old = kol_vo_old;
	}
	
	public Kladovshik getKladovshik() {
		return kladovshik;
	}

	public void setKladovshik(Kladovshik kladovshik) {
		this.kladovshik = kladovshik;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public int getId_historyOperation() {
		return id_historyOperation;
	}

	public void setId_historyOperation(int id_historyOperation) {
		this.id_historyOperation = id_historyOperation;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getId_row() {
		return id_row;
	}

	public void setId_row(int id_row) {
		this.id_row = id_row;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HistoryOperation [id_historyOperation=");
		builder.append(id_historyOperation);
		builder.append(", kladovshik=");
		builder.append(kladovshik);
		builder.append(", tableName=");
		builder.append(tableName);
		builder.append(", id_row=");
		builder.append(id_row);
		builder.append(", date=");
		builder.append(date);
		builder.append(", operation=");
		builder.append(operation);
		builder.append("]");
		return builder.toString();
	}

}