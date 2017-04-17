package by.ntck.sten.model;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "SkladH")
public class SkladH {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sklad", nullable = true)
	private Sklad sklad; 


	@Column(name = "operthiya")
	private String operthiya;

	@Column(name = "kol_vo")
	private float kol_vo;

	@Column(name = "data_oper")
	private String data_oper;

	@Column(name = "ttn")
	private String ttn;

	@Column(name = "postavhik")
	private String postavhik;

	@Column(name = "data_zayavki")
	private String data_zayavki;

	@Column(name = "data_ttn")
	private String data_ttn;

	@Column(name = "kod_zatrat")
	private String kod_zatrat;

	@Column(name = "naim")
	private String naim;

	@Column(name = "ttni")
	private String ttni;

	@Column(name = "fio_zakazchika")
	private String fio_zakazchika;

	@Column(name = "isdel")
	private String isdel;

	@Column(name = "is_del")
	private String is_del;

	@Column(name = "kol_vo_old")
	private int kol_vo_old;

	@Column(name = "obrabotano")
	private String obrabotano;

	@Column(name = "naim_doc")
	private String naim_doc;

	@Column(name = "rep_in")
	private String rep_in;

	@Column(name = "tab_nom_mol")
	private String tab_nom_mol;

	@Column(name = "sklad_out_key")
	private int sklad_out_key;

	@Column(name = "sklad_in_key")
	private int sklad_in_key;

	@Column(name = "rep_status")
	private int rep_status;

	@Column(name = "alt_edin")
	private String alt_edin;

	@Column(name = "alt_kol_vo")
	private float alt_kol_vo;

	@Column(name = "import_")
	private String import_;

	@Column(name = "id_zayavka")
	private int id_zayavka;

	@Column(name = "id_ord")
	private int id_ord;

	@Column(name = "real_data_oper")
	private String real_data_oper;

	@Column(name = "link")
	private int link;

	@Column(name = "master")
	private String master;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public int getSklad_id() { return sklad_id; }
	 * 
	 * public void setSklad_id(int sklad_id) { this.sklad_id = sklad_id; }
	 */

	public String getOperthiya() {
		return operthiya;
	}

	public void setOperthiya(String operthiya) {
		this.operthiya = operthiya;
	}

	public float getKol_vo() {
		return kol_vo;
	}

	public void setKol_vo(float kol_vo) {
		this.kol_vo = kol_vo;
	}

	public String getData_oper() {
		return data_oper;
	}

	public void setData_oper(String data_oper) {
		this.data_oper = data_oper;
	}

	public String getTtn() {
		return ttn;
	}

	public void setTtn(String ttn) {
		this.ttn = ttn;
	}

	public String getPostavhik() {
		return postavhik;
	}

	public void setPostavhik(String postavhik) {
		this.postavhik = postavhik;
	}

	public String getData_zayavki() {
		return data_zayavki;
	}

	public void setData_zayavki(String data_zayavki) {
		this.data_zayavki = data_zayavki;
	}

	public String getData_ttn() {
		return data_ttn;
	}

	public void setData_ttn(String data_ttn) {
		this.data_ttn = data_ttn;
	}

	public String getKod_zatrat() {
		return kod_zatrat;
	}

	public void setKod_zatrat(String kod_zatrat) {
		this.kod_zatrat = kod_zatrat;
	}

	public String getNaim() {
		return naim;
	}

	public void setNaim(String naim) {
		this.naim = naim;
	}

	public String getTtni() {
		return ttni;
	}

	public void setTtni(String ttni) {
		this.ttni = ttni;
	}

	public String getFio_zakazchika() {
		return fio_zakazchika;
	}

	public void setFio_zakazchika(String fio_zakazchika) {
		this.fio_zakazchika = fio_zakazchika;
	}

	public String getIsdel() {
		return isdel;
	}

	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}

	public String getIs_del() {
		return is_del;
	}

	public void setIs_del(String is_del) {
		this.is_del = is_del;
	}

	public int getKol_vo_old() {
		return kol_vo_old;
	}

	public void setKol_vo_old(int kol_vo_old) {
		this.kol_vo_old = kol_vo_old;
	}

	public String getObrabotano() {
		return obrabotano;
	}

	public void setObrabotano(String obrabotano) {
		this.obrabotano = obrabotano;
	}

	public String getNaim_doc() {
		return naim_doc;
	}

	public void setNaim_doc(String naim_doc) {
		this.naim_doc = naim_doc;
	}

	public String getRep_in() {
		return rep_in;
	}

	public void setRep_in(String rep_in) {
		this.rep_in = rep_in;
	}

	public String getTab_nom_mol() {
		return tab_nom_mol;
	}

	public void setTab_nom_mol(String tab_nom_mol) {
		this.tab_nom_mol = tab_nom_mol;
	}

	public int getSklad_out_key() {
		return sklad_out_key;
	}

	public void setSklad_out_key(int sklad_out_key) {
		this.sklad_out_key = sklad_out_key;
	}

	public int getSklad_in_key() {
		return sklad_in_key;
	}

	public void setSklad_in_key(int sklad_in_key) {
		this.sklad_in_key = sklad_in_key;
	}

	public int getRep_status() {
		return rep_status;
	}

	public void setRep_status(int rep_status) {
		this.rep_status = rep_status;
	}

	public String getAlt_edin() {
		return alt_edin;
	}

	public void setAlt_edin(String alt_edin) {
		this.alt_edin = alt_edin;
	}

	public float getAlt_kol_vo() {
		return alt_kol_vo;
	}

	public void setAlt_kol_vo(float alt_kol_vo) {
		this.alt_kol_vo = alt_kol_vo;
	}

	public String getImport_() {
		return import_;
	}

	public void setImport_(String import_) {
		this.import_ = import_;
	}

	public int getId_zayavka() {
		return id_zayavka;
	}

	public void setId_zayavka(int id_zayavka) {
		this.id_zayavka = id_zayavka;
	}

	public int getId_ord() {
		return id_ord;
	}

	public void setId_ord(int id_ord) {
		this.id_ord = id_ord;
	}

	public String getReal_data_oper() {
		return real_data_oper;
	}

	public void setReal_data_oper(String real_data_oper) {
		this.real_data_oper = real_data_oper;
	}

	public int getLink() {
		return link;
	}

	public void setLink(int link) {
		this.link = link;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}
	
	

	public Sklad getSklad() {
		return sklad;
	}

	public void setSklad(Sklad sklad) {
		this.sklad = sklad;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SkladH [id=");
		builder.append(id);
		builder.append(", sklad=");
		builder.append(sklad);
		builder.append(", operthiya=");
		builder.append(operthiya);
		builder.append(", kol_vo=");
		builder.append(kol_vo);
		builder.append(", data_oper=");
		builder.append(data_oper);
		builder.append(", ttn=");
		builder.append(ttn);
		builder.append(", postavhik=");
		builder.append(postavhik);
		builder.append(", data_zayavki=");
		builder.append(data_zayavki);
		builder.append(", data_ttn=");
		builder.append(data_ttn);
		builder.append(", kod_zatrat=");
		builder.append(kod_zatrat);
		builder.append(", naim=");
		builder.append(naim);
		builder.append(", ttni=");
		builder.append(ttni);
		builder.append(", fio_zakazchika=");
		builder.append(fio_zakazchika);
		builder.append(", isdel=");
		builder.append(isdel);
		builder.append(", is_del=");
		builder.append(is_del);
		builder.append(", kol_vo_old=");
		builder.append(kol_vo_old);
		builder.append(", obrabotano=");
		builder.append(obrabotano);
		builder.append(", naim_doc=");
		builder.append(naim_doc);
		builder.append(", rep_in=");
		builder.append(rep_in);
		builder.append(", tab_nom_mol=");
		builder.append(tab_nom_mol);
		builder.append(", sklad_out_key=");
		builder.append(sklad_out_key);
		builder.append(", sklad_in_key=");
		builder.append(sklad_in_key);
		builder.append(", rep_status=");
		builder.append(rep_status);
		builder.append(", alt_edin=");
		builder.append(alt_edin);
		builder.append(", alt_kol_vo=");
		builder.append(alt_kol_vo);
		builder.append(", import_=");
		builder.append(import_);
		builder.append(", id_zayavka=");
		builder.append(id_zayavka);
		builder.append(", id_ord=");
		builder.append(id_ord);
		builder.append(", real_data_oper=");
		builder.append(real_data_oper);
		builder.append(", link=");
		builder.append(link);
		builder.append(", master=");
		builder.append(master);
		builder.append("]");
		return builder.toString();
	}

}