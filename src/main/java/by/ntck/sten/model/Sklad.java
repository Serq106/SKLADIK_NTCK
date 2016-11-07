package by.ntck.sten.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Sklad")
public class Sklad {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "naim")
	private String naim;
	
	@Column(name = "edin")
	private	String edin;
	
	@Column(name = "kolvo")
	private float kolvo;
	
	@Column(name = "karta")
	private	String karta;
	
	@Column(name = "sklad_key")
	private int sklad_key;
	
	@Column(name = "isdel")
	private String isdel;
	
	@Column(name = "stelach")
	private String stelach;
	
	@Column(name = "yatheika")
	private String yatheika;
	
	@Column(name = "naim2")
	private String naim2;
	
	@Column(name = "used")
	private String used;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "in_bd")
	private String in_bd;
	
	@Column(name = "tolling")
	private String tolling;
	
	@Column(name = "testing")
	private String testing;
	
	@Column(name = "imports")
    private String imports;
	
	@Column(name = "close_kadr")
	private String close_kadr;
	
	@Column(name = "sap_kod")
	private String sap_kod;
	
	@Column(name = "bismt")
	private String bismt;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade= CascadeType.REFRESH)
    @JoinTable(name = "Sklad_SK", 
             joinColumns = { @JoinColumn(name = "sklad_id") }, 
             inverseJoinColumns = { @JoinColumn(name = "kladovshik_id") })
	private List<Kladovshik> kladovshik = new ArrayList<Kladovshik>();

			
	public List<Kladovshik> getKladovshik() {
		return kladovshik;
	}
	public void setKladovshik(List<Kladovshik> kladovshik) {
		this.kladovshik = kladovshik;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaim() {
		return naim;
	}
	public void setNaim(String naim) {
		this.naim = naim;
	}
	public String getEdin() {
		return edin;
	}
	public void setEdin(String edin) {
		this.edin = edin;
	}
	public float getKolvo() {
		return kolvo;
	}
	public void setKolvo(float kolvo) {
		this.kolvo = kolvo;
	}
	public String getKarta() {
		return karta;
	}
	public void setKarta(String karta) {
		this.karta = karta;
	}
	public int getSklad_key() {
		return sklad_key;
	}
	public void setSklad_key(int sklad_key) {
		this.sklad_key = sklad_key;
	}
	public String getIsdel() {
		return isdel;
	}
	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}
	public String getStelach() {
		return stelach;
	}
	public void setStelach(String stelach) {
		this.stelach = stelach;
	}
	public String getYatheika() {
		return yatheika;
	}
	public void setYatheika(String yatheika) {
		this.yatheika = yatheika;
	}
	public String getNaim2() {
		return naim2;
	}
	public void setNaim2(String naim2) {
		this.naim2 = naim2;
	}
	public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getIn_bd() {
		return in_bd;
	}
	public void setIn_bd(String in_bd) {
		this.in_bd = in_bd;
	}
	public String getTolling() {
		return tolling;
	}
	public void setTolling(String tolling) {
		this.tolling = tolling;
	}
	public String getTesting() {
		return testing;
	}
	public void setTesting(String testing) {
		this.testing = testing;
	}
	public String getImports() {
		return imports;
	}
	public void setImports(String imports) {
		this.imports = imports;
	}
	public String getClose_kadr() {
		return close_kadr;
	}
	public void setClose_kadr(String close_kadr) {
		this.close_kadr = close_kadr;
	}
	public String getSap_kod() {
		return sap_kod;
	}
	public void setSap_kod(String sap_kod) {
		this.sap_kod = sap_kod;
	}
	public String getBismt() {
		return bismt;
	}
	public void setBismt(String bismt) {
		this.bismt = bismt;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sklad [id=");
		builder.append(id);
		builder.append(", naim=");
		builder.append(naim);
		builder.append(", edin=");
		builder.append(edin);
		builder.append(", kolvo=");
		builder.append(kolvo);
		builder.append(", karta=");
		builder.append(karta);
		builder.append(", sklad_key=");
		builder.append(sklad_key);
		builder.append(", isdel=");
		builder.append(isdel);
		builder.append(", stelach=");
		builder.append(stelach);
		builder.append(", yatheika=");
		builder.append(yatheika);
		builder.append(", naim2=");
		builder.append(naim2);
		builder.append(", used=");
		builder.append(used);
		builder.append(", price=");
		builder.append(price);
		builder.append(", in_bd=");
		builder.append(in_bd);
		builder.append(", tolling=");
		builder.append(tolling);
		builder.append(", testing=");
		builder.append(testing);
		builder.append(", imports=");
		builder.append(imports);
		builder.append(", close_kadr=");
		builder.append(close_kadr);
		builder.append(", sap_kod=");
		builder.append(sap_kod);
		builder.append(", bismt=");
		builder.append(bismt);
		builder.append(", kladovshik=");
		builder.append(kladovshik);
		builder.append("]");
		return builder.toString();
	}
}