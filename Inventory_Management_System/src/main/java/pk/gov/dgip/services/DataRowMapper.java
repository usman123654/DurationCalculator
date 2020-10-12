package pk.gov.dgip.services;

import org.springframework.jdbc.core.RowMapper;
import pk.gov.dgip.entities.Data;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataRowMapper implements RowMapper<Data> {

    @Override
    public Data mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Data data = new Data(rs.getString("name"),rs.getString("working_workstation"),rs.getString("faulty_workstation"),rs.getString("working_server"),rs.getString("faulty_server"),rs.getString("working_printer"),rs.getString("faulty_printer"),rs.getString("working_scanner"),rs.getString("faulty_scanner"),rs.getString("working_ac"),rs.getString("faulty_ac"),rs.getString("working_camera"),rs.getString("faulty_camera"),rs.getString("working_biometric"),rs.getString("faulty_biometric"),rs.getString("working_visa_printer"),rs.getString("faulty_visa_printer"),rs.getString("working_ups"),rs.getString("faulty_ups"),rs.getString("working_cctv"),rs.getString("faulty_cctv"),rs.getString("working_avr"),rs.getString("faulty_avr"),rs.getString("working_genset"),rs.getString("faulty_genset"),rs.getString("rack"),rs.getString("working_firewall"),rs.getString("faulty_firewall"),rs.getString("working_networkswitch"),rs.getString("faulty_networkswitch"),rs.getString("working_modem"),rs.getString("faulty_modem"),rs.getString("working_monitor"),rs.getString("faulty_monitor"),rs.getString("working_lcd"),rs.getString("faulty_lcd"),rs.getString("working_led"),rs.getString("faulty_led"),rs.getString("working_telephone"),rs.getString("faulty_telephone"),rs.getString("working_fax"),rs.getString("faulty_fax"),rs.getString("working_speaker"),rs.getString("faulty_speaker"),rs.getString("working_sound_amplifier"),rs.getString("faulty_sound_amplifier"),rs.getString("working_dvr"),rs.getString("faulty_dvr"));
        return data;
    }
}
