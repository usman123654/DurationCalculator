package pk.gov.dgip.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@NamedQuery(name = "User.findItemsByUser", query = "SELECT i FROM Item i WHERE i.user=:user order by i.category.name")
public class Item {
	
	public Item() {
		
	}
	
	public Item(String model, String ram, Processor processor, String serialNo, String serviceTagNo, User user,
			Category category, Manufacturer manufacturer) {
		super();
		this.model = model;
		this.ram = ram;
		this.processor = processor;
		this.serialNo = serialNo;
		this.serviceTagNo = serviceTagNo;
		this.user = user;
		this.category = category;
		this.manufacturer = manufacturer;
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
		
	@Column(unique=true,length = 45)
	private String model;
	
	@Column(length=45)
	private String ram;
	
	@Column(length=45)
	private String location;
	
	@Column(length=200)
	private String purchaser;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Processor processor;
	
	@Column(length=100)
	private String license;
	
	@Column(length=45)
	private String hardDrive;
	

	@Column(length=45)
	private String InvoiceBillNo;
	
	@Column(length=45)
	private String refLetter;
	
	@Column(length=20)
	private String cores;
	
	@Column(unique=true,length = 50)
	private String serialNo;
	
	@Column(unique=true,length = 80)
	private String serviceTagNo;
	
	@ManyToOne
	private User user;
	
	@OneToOne
	private Section section;
	
	@Column(length=45)
	private String price;
	

	@Column(length=60)
	private String vendor;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date_expiry;
	

	@Column(length=45)
	private String recommendedBy;
	

	@OneToOne(cascade=CascadeType.PERSIST)
	private Supplier supplier;
	

	@OneToOne(cascade = CascadeType.PERSIST)
	private Category category;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Manufacturer manufacturer;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date date_indent;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date date_approval;
	
	@Column(length=45)
	private String approvedBy;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date date_purchase;	

	@Column(length=45)
	private String replacementNo;
	
	@Column(length=200)
	private String remarks;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Condition condition;
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public String getReplacementNo() {
		return replacementNo;
	}

	public void setReplacementNo(String replacementNo) {
		this.replacementNo = replacementNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public String getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}
	

	public String getInvoiceBillNo() {
		return InvoiceBillNo;
	}

	public void setInvoiceBillNo(String invoiceBillNo) {
		InvoiceBillNo = invoiceBillNo;
	}


	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}
	
	
	public String getRefLetter() {
		return refLetter;
	}

	public void setRefLetter(String refLetter) {
		this.refLetter = refLetter;
	}


	public String getHardDrive() {
		return hardDrive;
	}

	public void setHardDrive(String hardDrive) {
		this.hardDrive = hardDrive;
	}
	public String getCores() {
		return cores;
	}

	public void setCores(String cores) {
		this.cores = cores;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}


	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	public String getRecommendedBy() {
		return recommendedBy;
	}

	public void setRecommendedBy(String recommendedBy) {
		this.recommendedBy = recommendedBy;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
	public Date getDate_expiry() {
		DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
		return date_expiry;
	}

	public void setDate_expiry(Date date_expiry) {
		this.date_expiry = date_expiry;
	}

	
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	
	public Date getDate_purchase() {
		return date_purchase;
	}

	public void setDate_purchase(Date date_purchase) {
		this.date_purchase = date_purchase;
	}

	public Date getDate_issuance() {
		return date_issuance;
	}

	public void setDate_issuance(Date date_issuance) {
		this.date_issuance = date_issuance;
	}

	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date date_issuance;
	
	public Date getDate_approval() {
		return date_approval;
	}

	public void setDate_approval(Date date_approval) {
		this.date_approval = date_approval;
	}

	public Date getDate_indent() {
		return date_indent;
	}

	public void setDate_indent(Date date_indent) {
		this.date_indent = date_indent;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public Processor getProcessor() {
		return processor;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getServiceTagNo() {
		return serviceTagNo;
	}
	public void setServiceTagNo(String serviceTagNo) {
		this.serviceTagNo = serviceTagNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", model=" + model + ", ram=" + ram + ", location=" + location + ", purchaser="
				+ purchaser + ", processor=" + processor + ", license=" + license + ", hardDrive=" + hardDrive
				+ ", InvoiceBillNo=" + InvoiceBillNo + ", refLetter=" + refLetter + ", cores=" + cores + ", serialNo="
				+ serialNo + ", serviceTagNo=" + serviceTagNo + ", user=" + user + ", section=" + section + ", price="
				+ price + ", vendor=" + vendor + ", date_expiry=" + date_expiry + ", recommendedBy=" + recommendedBy
				+ ", supplier=" + supplier + ", category=" + category + ", manufacturer=" + manufacturer
				+ ", date_indent=" + date_indent + ", date_approval=" + date_approval + ", approvedBy=" + approvedBy
				+ ", date_purchase=" + date_purchase + ", replacementNo=" + replacementNo + ", remarks=" + remarks
				+ ", condition=" + condition + ", date_issuance=" + date_issuance + "]";
	}

	
}
