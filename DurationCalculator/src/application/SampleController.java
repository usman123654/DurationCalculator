package application;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;

import com.jfoenix.controls.JFXTimePicker;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SampleController extends Application {
	
	@FXML
	private DatePicker startDate,endDate;
	@FXML
	private JFXTimePicker startTime,endTime;
	@FXML
	private Button calculateButton,clearButton;
	@FXML
	private TextField totalYears,totalMonths,totalDays,totalHours,totalMinutes,totalSeconds;
	
	@FXML
	public void calculate() {
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");		
		
		//Formatting the starting and ending dates
	    String startingDate = dateFormatter.format(startDate.getValue());
	    String endingDate = dateFormatter.format(endDate.getValue());    
	    
	    // Appending dates to times
	    String dateStart = startingDate+" "+startTime.getValue()+":00";
	    String dateEnd = endingDate+" "+endTime.getValue()+":00";
	    
	    Date d1 = null;
		Date d2 = null;
		
		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateEnd);

			DateTime dt1 = new DateTime(d1);
			DateTime dt2 = new DateTime(d2);

			System.out.print(Days.daysBetween(dt1, dt2).getDays() + " days, ");
			System.out.print(Hours.hoursBetween(dt1, dt2).getHours() % 24 + " hours, ");
			System.out.print(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " minutes, ");
			System.out.print(Seconds.secondsBetween(dt1, dt2).getSeconds() % 60 + " seconds.");

		
		} catch (Exception e) {
			e.printStackTrace();
		 }
	}
	public void clear() {
		
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Hello World!");

	}
	
	@FXML
	public void initialize() {
		startTime.setIs24HourView(true);
		endTime.setIs24HourView(true);
	    
	}

}

	

