package pk.gov.dgip.entities;

public class Data {
	
	public Data() {
		super();
	}
    private String office_name;
    
	public Data(String office_name, String w_workstation, String f_workstation, String w_server, String f_server,
			String w_printer, String f_printer, String w_scanner, String f_scanner, String w_ac_units,
			String f_ac_units, String w_digital_camera, String f_digital_camera, String w_biometric, String f_biometric,
			String w_visa_printer, String f_visa_printer, String w_ups, String f_ups, String w_cctv, String f_cctv,
			String w_avr_voltageregulator, String f_avr_voltageregulator, String w_genset, String f_genset, String rack,
			String w_firewall, String f_firewall, String w_networkswitch, String f_networkswitch, String w_modem,
			String f_modem, String w_monitor, String f_monitor, String w_lcd, String f_lcd, String w_led_counter,
			String f_led_counter, String w_telephone, String f_telephone, String w_fax, String f_fax, String w_speaker,
			String f_speaker, String w_sound_amplifier, String f_sound_amplifier, String w_dvr, String f_dvr) {
		super();
		this.office_name = office_name;
		this.w_workstation = w_workstation;
		this.f_workstation = f_workstation;
		this.w_server = w_server;
		this.f_server = f_server;
		this.w_printer = w_printer;
		this.f_printer = f_printer;
		this.w_scanner = w_scanner;
		this.f_scanner = f_scanner;
		this.w_ac_units = w_ac_units;
		this.f_ac_units = f_ac_units;
		this.w_digital_camera = w_digital_camera;
		this.f_digital_camera = f_digital_camera;
		this.w_biometric = w_biometric;
		this.f_biometric = f_biometric;
		this.w_visa_printer = w_visa_printer;
		this.f_visa_printer = f_visa_printer;
		this.w_ups = w_ups;
		this.f_ups = f_ups;
		this.w_cctv = w_cctv;
		this.f_cctv = f_cctv;
		this.w_avr_voltageregulator = w_avr_voltageregulator;
		this.f_avr_voltageregulator = f_avr_voltageregulator;
		this.w_genset = w_genset;
		this.f_genset = f_genset;
		this.rack = rack;
		this.w_firewall = w_firewall;
		this.f_firewall = f_firewall;
		this.w_networkswitch = w_networkswitch;
		this.f_networkswitch = f_networkswitch;
		this.w_modem = w_modem;
		this.f_modem = f_modem;
		this.w_monitor = w_monitor;
		this.f_monitor = f_monitor;
		this.w_lcd = w_lcd;
		this.f_lcd = f_lcd;
		this.w_led_counter = w_led_counter;
		this.f_led_counter = f_led_counter;
		this.w_telephone = w_telephone;
		this.f_telephone = f_telephone;
		this.w_fax = w_fax;
		this.f_fax = f_fax;
		this.w_speaker = w_speaker;
		this.f_speaker = f_speaker;
		this.w_sound_amplifier = w_sound_amplifier;
		this.f_sound_amplifier = f_sound_amplifier;
		this.w_dvr = w_dvr;
		this.f_dvr = f_dvr;
	}

	public String getOffice_name() {
		return office_name;
	}

	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}

	@Override
	public String toString() {
		return "Data [office_name=" + office_name + ", w_workstation=" + w_workstation + ", f_workstation="
				+ f_workstation + ", w_server=" + w_server + ", f_server=" + f_server + ", w_printer=" + w_printer
				+ ", f_printer=" + f_printer + ", w_scanner=" + w_scanner + ", f_scanner=" + f_scanner + ", w_ac_units="
				+ w_ac_units + ", f_ac_units=" + f_ac_units + ", w_digital_camera=" + w_digital_camera
				+ ", f_digital_camera=" + f_digital_camera + ", w_biometric=" + w_biometric + ", f_biometric="
				+ f_biometric + ", w_visa_printer=" + w_visa_printer + ", f_visa_printer=" + f_visa_printer + ", w_ups="
				+ w_ups + ", f_ups=" + f_ups + ", w_cctv=" + w_cctv + ", f_cctv=" + f_cctv + ", w_avr_voltageregulator="
				+ w_avr_voltageregulator + ", f_avr_voltageregulator=" + f_avr_voltageregulator + ", w_genset="
				+ w_genset + ", f_genset=" + f_genset + ", rack=" + rack + ", w_firewall=" + w_firewall
				+ ", f_firewall=" + f_firewall + ", w_networkswitch=" + w_networkswitch + ", f_networkswitch="
				+ f_networkswitch + ", w_modem=" + w_modem + ", f_modem=" + f_modem + ", w_monitor=" + w_monitor
				+ ", f_monitor=" + f_monitor + ", w_lcd=" + w_lcd + ", f_lcd=" + f_lcd + ", w_led_counter="
				+ w_led_counter + ", f_led_counter=" + f_led_counter + ", w_telephone=" + w_telephone + ", f_telephone="
				+ f_telephone + ", w_fax=" + w_fax + ", f_fax=" + f_fax + ", w_speaker=" + w_speaker + ", f_speaker="
				+ f_speaker + ", w_sound_amplifier=" + w_sound_amplifier + ", f_sound_amplifier=" + f_sound_amplifier
				+ ", w_dvr=" + w_dvr + ", f_dvr=" + f_dvr + "]";
	}

	public String getW_workstation() {
		return w_workstation;
	}

	public void setW_workstation(String w_workstation) {
		this.w_workstation = w_workstation;
	}

	public String getF_workstation() {
		return f_workstation;
	}

	public void setF_workstation(String f_workstation) {
		this.f_workstation = f_workstation;
	}

	public String getW_server() {
		return w_server;
	}

	public void setW_server(String w_server) {
		this.w_server = w_server;
	}

	public String getF_server() {
		return f_server;
	}

	public void setF_server(String f_server) {
		this.f_server = f_server;
	}

	public String getW_printer() {
		return w_printer;
	}

	public void setW_printer(String w_printer) {
		this.w_printer = w_printer;
	}

	public String getF_printer() {
		return f_printer;
	}

	public void setF_printer(String f_printer) {
		this.f_printer = f_printer;
	}

	public String getW_scanner() {
		return w_scanner;
	}

	public void setW_scanner(String w_scanner) {
		this.w_scanner = w_scanner;
	}

	public String getF_scanner() {
		return f_scanner;
	}

	public void setF_scanner(String f_scanner) {
		this.f_scanner = f_scanner;
	}

	public String getW_ac_units() {
		return w_ac_units;
	}

	public void setW_ac_units(String w_ac_units) {
		this.w_ac_units = w_ac_units;
	}

	public String getF_ac_units() {
		return f_ac_units;
	}

	public void setF_ac_units(String f_ac_units) {
		this.f_ac_units = f_ac_units;
	}

	public String getW_digital_camera() {
		return w_digital_camera;
	}

	public void setW_digital_camera(String w_digital_camera) {
		this.w_digital_camera = w_digital_camera;
	}

	public String getF_digital_camera() {
		return f_digital_camera;
	}

	public void setF_digital_camera(String f_digital_camera) {
		this.f_digital_camera = f_digital_camera;
	}

	public String getW_biometric() {
		return w_biometric;
	}

	public void setW_biometric(String w_biometric) {
		this.w_biometric = w_biometric;
	}

	public String getF_biometric() {
		return f_biometric;
	}

	public void setF_biometric(String f_biometric) {
		this.f_biometric = f_biometric;
	}

	public String getW_visa_printer() {
		return w_visa_printer;
	}

	public void setW_visa_printer(String w_visa_printer) {
		this.w_visa_printer = w_visa_printer;
	}

	public String getF_visa_printer() {
		return f_visa_printer;
	}

	public void setF_visa_printer(String f_visa_printer) {
		this.f_visa_printer = f_visa_printer;
	}

	public String getW_ups() {
		return w_ups;
	}

	public void setW_ups(String w_ups) {
		this.w_ups = w_ups;
	}

	public String getF_ups() {
		return f_ups;
	}

	public void setF_ups(String f_ups) {
		this.f_ups = f_ups;
	}

	public String getW_cctv() {
		return w_cctv;
	}

	public void setW_cctv(String w_cctv) {
		this.w_cctv = w_cctv;
	}

	public String getF_cctv() {
		return f_cctv;
	}

	public void setF_cctv(String f_cctv) {
		this.f_cctv = f_cctv;
	}

	public String getW_avr_voltageregulator() {
		return w_avr_voltageregulator;
	}

	public void setW_avr_voltageregulator(String w_avr_voltageregulator) {
		this.w_avr_voltageregulator = w_avr_voltageregulator;
	}

	public String getF_avr_voltageregulator() {
		return f_avr_voltageregulator;
	}

	public void setF_avr_voltageregulator(String f_avr_voltageregulator) {
		this.f_avr_voltageregulator = f_avr_voltageregulator;
	}

	public String getW_genset() {
		return w_genset;
	}

	public void setW_genset(String w_genset) {
		this.w_genset = w_genset;
	}

	public String getF_genset() {
		return f_genset;
	}

	public void setF_genset(String f_genset) {
		this.f_genset = f_genset;
	}

	public String getRack() {
		return rack;
	}

	public void setRack(String rack) {
		this.rack = rack;
	}

	public String getW_firewall() {
		return w_firewall;
	}

	public void setW_firewall(String w_firewall) {
		this.w_firewall = w_firewall;
	}

	public String getF_firewall() {
		return f_firewall;
	}

	public void setF_firewall(String f_firewall) {
		this.f_firewall = f_firewall;
	}

	public String getW_networkswitch() {
		return w_networkswitch;
	}

	public void setW_networkswitch(String w_networkswitch) {
		this.w_networkswitch = w_networkswitch;
	}

	public String getF_networkswitch() {
		return f_networkswitch;
	}

	public void setF_networkswitch(String f_networkswitch) {
		this.f_networkswitch = f_networkswitch;
	}

	public String getW_modem() {
		return w_modem;
	}

	public void setW_modem(String w_modem) {
		this.w_modem = w_modem;
	}

	public String getF_modem() {
		return f_modem;
	}

	public void setF_modem(String f_modem) {
		this.f_modem = f_modem;
	}

	public String getW_monitor() {
		return w_monitor;
	}

	public void setW_monitor(String w_monitor) {
		this.w_monitor = w_monitor;
	}

	public String getF_monitor() {
		return f_monitor;
	}

	public void setF_monitor(String f_monitor) {
		this.f_monitor = f_monitor;
	}

	public String getW_lcd() {
		return w_lcd;
	}

	public void setW_lcd(String w_lcd) {
		this.w_lcd = w_lcd;
	}

	public String getF_lcd() {
		return f_lcd;
	}

	public void setF_lcd(String f_lcd) {
		this.f_lcd = f_lcd;
	}

	public String getW_led_counter() {
		return w_led_counter;
	}

	public void setW_led_counter(String w_led_counter) {
		this.w_led_counter = w_led_counter;
	}

	public String getF_led_counter() {
		return f_led_counter;
	}

	public void setF_led_counter(String f_led_counter) {
		this.f_led_counter = f_led_counter;
	}

	public String getW_telephone() {
		return w_telephone;
	}

	public void setW_telephone(String w_telephone) {
		this.w_telephone = w_telephone;
	}

	public String getF_telephone() {
		return f_telephone;
	}

	public void setF_telephone(String f_telephone) {
		this.f_telephone = f_telephone;
	}

	public String getW_fax() {
		return w_fax;
	}

	public void setW_fax(String w_fax) {
		this.w_fax = w_fax;
	}

	public String getF_fax() {
		return f_fax;
	}

	public void setF_fax(String f_fax) {
		this.f_fax = f_fax;
	}

	public String getW_speaker() {
		return w_speaker;
	}

	public void setW_speaker(String w_speaker) {
		this.w_speaker = w_speaker;
	}

	public String getF_speaker() {
		return f_speaker;
	}

	public void setF_speaker(String f_speaker) {
		this.f_speaker = f_speaker;
	}

	public String getW_sound_amplifier() {
		return w_sound_amplifier;
	}

	public void setW_sound_amplifier(String w_sound_amplifier) {
		this.w_sound_amplifier = w_sound_amplifier;
	}

	public String getF_sound_amplifier() {
		return f_sound_amplifier;
	}

	public void setF_sound_amplifier(String f_sound_amplifier) {
		this.f_sound_amplifier = f_sound_amplifier;
	}

	public String getW_dvr() {
		return w_dvr;
	}

	public void setW_dvr(String w_dvr) {
		this.w_dvr = w_dvr;
	}

	public String getF_dvr() {
		return f_dvr;
	}

	public void setF_dvr(String f_dvr) {
		this.f_dvr = f_dvr;
	}

	private String w_workstation;
	private String f_workstation;
	private String w_server;
	private String f_server;
	private String w_printer;
	private String f_printer;
	private String w_scanner;
	private String f_scanner;
	private String w_ac_units;
	private String f_ac_units;
	private String w_digital_camera;
	private String f_digital_camera;
	private String w_biometric;
	private String f_biometric;
	private String w_visa_printer;
	private String f_visa_printer;
	private String w_ups;
	private String f_ups;
	private String w_cctv;
	private String f_cctv;
	private String w_avr_voltageregulator;
	private String f_avr_voltageregulator;
	private String w_genset;
	private String f_genset;
	private String rack;
	private String w_firewall;
	private String f_firewall;
	private String w_networkswitch;
	private String f_networkswitch;
	private String w_modem;
	private String f_modem;
	private String w_monitor;
	private String f_monitor;
	private String w_lcd;
	private String f_lcd;
	private String w_led_counter;
	private String f_led_counter;
	private String w_telephone;
	private String f_telephone;
	private String w_fax;
	private String f_fax;
	private String w_speaker;
	private String f_speaker;
	private String w_sound_amplifier;
	private String f_sound_amplifier;
	private String w_dvr;
	private String f_dvr;
	
	
}
