package Project;

/**
 * This class represent a Time object of the WIFI scan
 * @author Bar,Noy,Doriya
 *
 */
public class Time {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;

	public Time(){}

	public Time(int year, int month, int day, int hour, int minute, int second) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	/**
	 * This function take a String from the csv file and adapt it to the Time object
	 * @param time String time
	 * @return new Time object
	 */
	public Time set_Date(String time){
		Time _time = new Time();
		String[]date;
		String[]times =time.split(" ");
		if(times[0].contains("/")){
		date = times[0].split("/");
		}
		else{
			date = times[0].split("-");
		}
		String[]t = times[1].split(":");
		_time.setYear(Integer.parseInt(date[0]));
		_time.setMonth(Integer.parseInt(date[1]));
		_time.setDay(Integer.parseInt(date[2]));
		_time.setHour(Integer.parseInt(t[0]));
		_time.setMinute(Integer.parseInt(t[1]));
		if(t.length==2){
		_time.setSecond(00);
		}
		else{
			_time.setSecond(Integer.parseInt(t[2]));
		}
		return _time;
	}
	/**
	 * This function take a String from the CSV file and adapt it to the Time object
	 * for Algo1
	 * @param time String time
	 * @return new Time object
	 */
	public Time set_Date2(String time){
		Time _time = new Time();
		String[]times =time.split("T");
		String[]date = times[0].split("-");
		String[]t = times[1].split(":");
		_time.setYear(Integer.parseInt(date[0]));
		_time.setMonth(Integer.parseInt(date[1]));
		_time.setDay(Integer.parseInt(date[2]));
		_time.setHour(Integer.parseInt(t[0]));
		_time.setMinute(Integer.parseInt(t[1]));
		String s=t[2].replace("Z","");
		_time.setSecond(Integer.parseInt(s));
		return _time;
	}
	/**
	 * This function checks if two given times are equals
	 * @param t Time object
	 * @return true if equals
	 */
	public boolean is_Equal(Time t){
		if(this.day==t.day&&this.month==t.month&&this.year==t.year&&this.minute==t.minute&&
				this.second==t.second&&this.hour==t.hour){
			return true;
		}
		return false;
	} 
	/**
	 * This function check if a certain time is between start time and end time
	 * @param start - the starting time
	 * @param end - the final time
	 * @return true if is in the time range
	 */
	public boolean time_Between(Time start , Time end){
		if((start.getYear() <= this.getYear())&&(end.getYear()>=this.getYear())){
			if((start.getMonth()<=this.getMonth())&&(end.getMonth()>=this.getMonth())){
				if((start.getDay()<=this.getDay())&&(end.getDay()>=this.getDay())){
					if((start.getHour()<=this.getHour())&& (end.getHour()>=this.getHour())){
						if((start.getMinute()<=this.getMinute()) && (end.getMinute()>=this.getMinute())){
							if((start.getSecond()<this.getSecond())&&(end.getSecond()>this.getSecond())){
								return true;
							}
							return ((this.minute>=start.getMinute())&&(end.getMinute()>=this.minute));
						}
					return false;
					}
				return false;
				}
			return false;
			}
		return false;
		}
		return false;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return year+"-"+month+"-"+day+"T"+hour+":"+minute+":"+second+"Z";
	}	
}
