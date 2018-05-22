package nl.fontys.util;

<<<<<<< HEAD
import javax.persistence.Embeddable;
<<<<<<< HEAD
import java.sql.Time;
import java.util.TimeZone;
@Embeddable
public class FontysTime {
=======
import java.io.Serializable;
import java.sql.Time;
import java.util.TimeZone;

@Embeddable
public class FontysTime implements Serializable {
>>>>>>> c36485ce9e90321e1569a68fda7fc5624d096f84
=======
import java.sql.Time;
import java.util.TimeZone;

public class FontysTime {
>>>>>>> parent of f12b1e9... Finished for week 12, need help doe
	private long seconds;

	public FontysTime() {
		seconds = 0;
	}

	public static FontysTime now() {
		FontysTime someTime;
		someTime = FontysTime.fromSeconds(System.currentTimeMillis() / 1000);
		return someTime;
	}

	public static FontysTime fromSeconds(long iseconds) {
		FontysTime someTime;
		someTime = new FontysTime();
		someTime.seconds = iseconds;
		return someTime;
	}

	public FontysTime increment(long seconds) {
		this.seconds += seconds;
		return this;
	}

	public long asSeconds() {
		return (seconds);
	}

	public long subtractTime(FontysTime someTime) {
		return this.asSeconds() - someTime.asSeconds();
	}

	public String toString() {
		Time time;

		// de java Time class is in staat strings van tijd objecten
		// te maken echter vindt er ongewenste conversie plaats tov gmt
		// corrigeer hiervoor
		TimeZone current = TimeZone.getDefault();
		TimeZone tz = TimeZone.getTimeZone("GMT");
		TimeZone.setDefault(tz);

		time = new Time(this.asSeconds() * 1000);
		String timeString;
		timeString = time.toString();

		TimeZone.setDefault(current);
		return timeString;
	}
}
