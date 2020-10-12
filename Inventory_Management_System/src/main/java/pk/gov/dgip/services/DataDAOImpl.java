package pk.gov.dgip.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import pk.gov.dgip.entities.Data;

public class DataDAOImpl extends JdbcDaoSupport implements DataDAO {

private List<Data> records;	
	
        public List<Data> findAll()
        {
        		String sql = "select a.*,coalesce((b.faulty_dvr),0) as faulty_dvr from \n" + 
        				"(select a.*,coalesce((b.working_dvr),0) as working_dvr from \n" + 
        				"(select a.*,coalesce((b.faulty_sound_amplifier),0) as faulty_sound_amplifier from \n" + 
        				"(select a.*,coalesce((b.working_sound_amplifier),0) as working_sound_amplifier from \n" + 
        				"(select a.*,coalesce((b.faulty_speaker),0) as faulty_speaker from \n" + 
        				"(select a.*,coalesce((b.working_speaker),0) as working_speaker from \n" + 
        				"(select a.*,coalesce((b.faulty_fax),0) as faulty_fax from \n" + 
        				"(select a.*,coalesce((b.working_fax),0) as working_fax from \n" + 
        				"(select a.*,coalesce((b.faulty_telephone),0) as faulty_telephone from \n" + 
        				"(select a.*,coalesce((b.working_telephone),0) as working_telephone from \n" + 
        				"(select a.*,coalesce((b.faulty_led_counter),0) as faulty_led_counter from \n" + 
        				"(select a.*,coalesce((b.working_led_counter),0) as working_led_counter from \n" + 
        				"(select a.*,coalesce((b.faulty_lcd),0) as faulty_lcd from \n" + 
        				"(select a.*,coalesce((b.working_lcd),0) as working_lcd from \n" + 
        				"(select a.*,coalesce((b.faulty_monitor),0) as faulty_monitor from \n" + 
        				"(select a.*,coalesce((b.working_monitor),0) as working_monitor from \n" + 
        				"(select a.*,coalesce((b.faulty_modem),0) as faulty_modem from \n" + 
        				"(select a.*,coalesce((b.working_modem),0) as working_modem from \n" + 
        				"(select a.*,coalesce((b.faulty_networkswitch),0) as faulty_networkswitch from \n" + 
        				"(select a.*,coalesce((b.working_networkswitch),0) as working_networkswitch from \n" + 
        				"(select a.*,coalesce((b.faulty_workstation),0) as faulty_workstation from \n" + 
        				"(select a.*,coalesce((b.working_workstation),0) as working_workstation from \n" + 
        				"(select a.*,coalesce((b.faulty_firewall),0) as faulty_firewall from \n" + 
        				"(select a.*,coalesce((b.working_firewall),0)  as working_firewall from  \n" + 
        				"(select a.*,coalesce((b.rack),0) as rack from \n" + 
        				"(select a.*,coalesce((b.faulty_genset),0) as faulty_genset from \n" + 
        				"(select a.*,coalesce((b.working_genset),0) as working_genset from \n" + 
        				"(select a.*,coalesce((b.faulty_ac),0) as faulty_ac from \n" + 
        				"(select a.*,coalesce((b.working_ac),0) as working_ac from \n" + 
        				"(select a.*,coalesce((b.faulty_avr),0) as faulty_avr from \n" + 
        				"(select a.*,coalesce((b.working_avr),0) as working_avr from \n" + 
        				"(select a.*,coalesce((b.faulty_cctv),0) as faulty_cctv from \n" + 
        				"(select a.*,coalesce((b.working_cctv),0) as working_cctv from \n" + 
        				"(select a.*,coalesce((b.faulty_ups),0) as faulty_ups from \n" + 
        				"(select a.*,coalesce((b.working_ups),0) as working_ups from \n" + 
        				"(select a.*,coalesce((b.faulty_visa_printer),0) as faulty_visa_printer from \n" + 
        				"(select a.*,coalesce((b.working_visa_printer),0) as working_visa_printer from \n" + 
        				"(select a.*,coalesce((b.faulty_biometric),0) as faulty_biometric from \n" + 
        				"(select a.*,coalesce((b.working_biometric),0) as working_biometric from \n" + 
        				"(select a.*,coalesce((b.faulty_camera),0) as faulty_camera from \n" + 
        				"(select a.*,coalesce((b.working_camera),0) as working_camera from \n" + 
        				"(select a.*,coalesce((b.faulty_scanner),0) as faulty_scanner from \n" + 
        				"(select a.*,coalesce((b.working_scanner),0) as working_scanner from \n" + 
        				"(select a.*,coalesce((b.faulty_printer),0) as faulty_printer from \n" + 
        				"(select a.*,coalesce((b.working_printer),0) as working_printer from \n" + 
        				"(select a.*,coalesce((b.faulty_server),0) as faulty_server from \n" + 
        				"(select a.id,a.name,coalesce((b.working_server),0) as working_server \n" + 
        				"from \n" + 
        				"regional_office a \n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_server from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=2 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_server from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=2 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_printer from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=3 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_printer from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=3 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_scanner from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=4 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_scanner from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=4 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_camera from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=6 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_camera from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=6 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_biometric from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=7 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_biometric from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=7 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_visa_printer from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=8 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_visa_printer from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=8 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_ups from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=10 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_ups from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=10 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_cctv from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=11 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_cctv from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=11 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_avr from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=12 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join\n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_avr from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=12 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on\n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_ac from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=5 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_ac from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=5 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_genset from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=13 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_genset from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=13 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as rack from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=14 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_firewall from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=15 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_firewall from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=15 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_workstation from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=1 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_workstation from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=1 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_networkswitch from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=16 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_networkswitch from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=16 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_modem from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=17 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_modem from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=17 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_monitor from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=18 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_monitor from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=18 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_lcd from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=19 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_lcd from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=19 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_led_counter from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=20 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_led_counter from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=20 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a \n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_telephone from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=21 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_telephone from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=21 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_fax from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=22 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_fax from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=22 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a \n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_speaker from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=23 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a \n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_speaker from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=23 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_sound_amplifier from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=24 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_sound_amplifier from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=24 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_dvr from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=25 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a \n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_dvr from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=25 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id\n" + 
        				"union all \n" + 
        				"select a.*,coalesce((b.faulty_dvr),0) as faulty_dvr from \n" + 
        				"(select a.*,coalesce((b.working_dvr),0) as working_dvr from \n" + 
        				"(select a.*,coalesce((b.faulty_sound_amplifier),0) as faulty_sound_amplifier from \n" + 
        				"(select a.*,coalesce((b.working_sound_amplifier),0) as working_sound_amplifier from \n" + 
        				"(select a.*,coalesce((b.faulty_speaker),0) as faulty_speaker from \n" + 
        				"(select a.*,coalesce((b.working_speaker),0) as working_speaker from \n" + 
        				"(select a.*,coalesce((b.faulty_fax),0) as faulty_fax from \n" + 
        				"(select a.*,coalesce((b.working_fax),0) as working_fax from \n" + 
        				"(select a.*,coalesce((b.faulty_telephone),0) as faulty_telephone from \n" + 
        				"(select a.*,coalesce((b.working_telephone),0) as working_telephone from \n" + 
        				"(select a.*,coalesce((b.faulty_led_counter),0) as faulty_led_counter from \n" + 
        				"(select a.*,coalesce((b.working_led_counter),0) as working_led_counter from \n" + 
        				"(select a.*,coalesce((b.faulty_lcd),0) as faulty_lcd from \n" + 
        				"(select a.*,coalesce((b.working_lcd),0) as working_lcd from \n" + 
        				"(select a.*,coalesce((b.faulty_monitor),0) as faulty_monitor from \n" + 
        				"(select a.*,coalesce((b.working_monitor),0) as working_monitor from \n" + 
        				"(select a.*,coalesce((b.faulty_modem),0) as faulty_modem from \n" + 
        				"(select a.*,coalesce((b.working_modem),0) as working_modem from \n" + 
        				"(select a.*,coalesce((b.faulty_networkswitch),0) as faulty_networkswitch from \n" + 
        				"(select a.*,coalesce((b.working_networkswitch),0) as working_networkswitch from \n" + 
        				"(select a.*,coalesce((b.faulty_workstation),0) as faulty_workstation from \n" + 
        				"(select a.*,coalesce((b.working_workstation),0) as working_workstation from \n" + 
        				"(select a.*,coalesce((b.faulty_firewall),0) as faulty_firewall from \n" + 
        				"(select a.*,coalesce((b.working_firewall),0)  as working_firewall from  \n" + 
        				"(select a.*,coalesce((b.rack),0) as rack from \n" + 
        				"(select a.*,coalesce((b.faulty_genset),0) as faulty_genset from \n" + 
        				"(select a.*,coalesce((b.working_genset),0) as working_genset from \n" + 
        				"(select a.*,coalesce((b.faulty_ac),0) as faulty_ac from \n" + 
        				"(select a.*,coalesce((b.working_ac),0) as working_ac from \n" + 
        				"(select a.*,coalesce((b.faulty_avr),0) as faulty_avr from \n" + 
        				"(select a.*,coalesce((b.working_avr),0) as working_avr from \n" + 
        				"(select a.*,coalesce((b.faulty_cctv),0) as faulty_cctv from \n" + 
        				"(select a.*,coalesce((b.working_cctv),0) as working_cctv from \n" + 
        				"(select a.*,coalesce((b.faulty_ups),0) as faulty_ups from \n" + 
        				"(select a.*,coalesce((b.working_ups),0) as working_ups from \n" + 
        				"(select a.*,coalesce((b.faulty_visa_printer),0) as faulty_visa_printer from \n" + 
        				"(select a.*,coalesce((b.working_visa_printer),0) as working_visa_printer from \n" + 
        				"(select a.*,coalesce((b.faulty_biometric),0) as faulty_biometric from \n" + 
        				"(select a.*,coalesce((b.working_biometric),0) as working_biometric from \n" + 
        				"(select a.*,coalesce((b.faulty_camera),0) as faulty_camera from \n" + 
        				"(select a.*,coalesce((b.working_camera),0) as working_camera from \n" + 
        				"(select a.*,coalesce((b.faulty_scanner),0) as faulty_scanner from \n" + 
        				"(select a.*,coalesce((b.working_scanner),0) as working_scanner from \n" + 
        				"(select a.*,coalesce((b.faulty_printer),0) as faulty_printer from \n" + 
        				"(select a.*,coalesce((b.working_printer),0) as working_printer from \n" + 
        				"(select a.*,coalesce((b.faulty_server),0) as faulty_server from \n" + 
        				"(select a.id,a.name,coalesce((b.working_server),0) as working_server \n" + 
        				"from \n" + 
        				"foreign_mission a \n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_server from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=2 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_server from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=2 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_printer from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=3 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_printer from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=3 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_scanner from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=4 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_scanner from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=4 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_camera from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=6 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_camera from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=6 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_biometric from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=7 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_biometric from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=7 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_visa_printer from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=8 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_visa_printer from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=8 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_ups from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=10 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_ups from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=10 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_cctv from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=11 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_cctv from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=11 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_avr from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=12 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join\n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_avr from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=12 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on\n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_ac from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=5 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_ac from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=5 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_genset from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=13 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_genset from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=13 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as rack from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=14 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_firewall from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=15 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_firewall from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=15 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_workstation from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=1 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_workstation from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=1 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_networkswitch from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=16 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_networkswitch from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=16 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_modem from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=17 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_modem from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=17 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_monitor from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=18 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_monitor from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=18 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_lcd from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=19 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_lcd from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=19 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_led_counter from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=20 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_led_counter from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=20 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a \n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_telephone from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=21 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_telephone from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=21 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_fax from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=22 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_fax from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=22 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a \n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_speaker from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=23 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a \n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_speaker from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=23 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_sound_amplifier from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=24 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_sound_amplifier from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=24 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a\n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as working_dvr from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=25 and i.category_id=c.id and (i.condition_id=1 or i.condition_id=2)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id) a \n" + 
        				"left outer join \n" + 
        				"(select u.id,u.fullname,count(c.condition_id) as faulty_dvr from (select id,name from condition) con,(select i.id,i.user_id,i.category_id,i.condition_id from item i,category c where i.category_id=25 and i.category_id=c.id and (i.condition_id=3 or i.condition_id=4)) c,(select id,fullname from users order by fullname) u where c.condition_id=con.id and c.user_id=u.id group by u.id,u.fullname) b\n" + 
        				"on \n" + 
        				"a.id=b.id\n" + 
        				"";
        		
        		String url = "jdbc:postgresql://localhost:5432/postgres";
        		Properties props = new Properties();
        		props.setProperty("user","postgres");
        		props.setProperty("password","Pakistan123!");
        		Connection conn;
				try {
					records=null;
					records = new ArrayList<Data>();
					conn = DriverManager.getConnection(url, props);
	                PreparedStatement pst = conn.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery();
                    while(rs.next()) {
                    Data data = new Data(rs.getString("name"),rs.getString("working_workstation"),rs.getString("faulty_workstation"),rs.getString("working_server"),rs.getString("faulty_server"),rs.getString("working_printer"),rs.getString("faulty_printer"),rs.getString("working_scanner"),rs.getString("faulty_scanner"),rs.getString("working_ac"),rs.getString("faulty_ac"),rs.getString("working_camera"),rs.getString("faulty_camera"),rs.getString("working_biometric"),rs.getString("faulty_biometric"),rs.getString("working_visa_printer"),rs.getString("faulty_visa_printer"),rs.getString("working_ups"),rs.getString("faulty_ups"),rs.getString("working_cctv"),rs.getString("faulty_cctv"),rs.getString("working_avr"),rs.getString("faulty_avr"),rs.getString("working_genset"),rs.getString("faulty_genset"),rs.getString("rack"),rs.getString("working_firewall"),rs.getString("faulty_firewall"),rs.getString("working_networkswitch"),rs.getString("faulty_networkswitch"),rs.getString("working_modem"),rs.getString("faulty_modem"),rs.getString("working_monitor"),rs.getString("faulty_monitor"),rs.getString("working_lcd"),rs.getString("faulty_lcd"),rs.getString("working_led_counter"),rs.getString("faulty_led_counter"),rs.getString("working_telephone"),rs.getString("faulty_telephone"),rs.getString("working_fax"),rs.getString("faulty_fax"),rs.getString("working_speaker"),rs.getString("faulty_speaker"),rs.getString("working_sound_amplifier"),rs.getString("faulty_sound_amplifier"),rs.getString("working_dvr"),rs.getString("faulty_dvr"));
                    records.add(data);
                    }
				} catch (SQLException e) {
					e.printStackTrace();
				}
                return records;      
        }
    }
