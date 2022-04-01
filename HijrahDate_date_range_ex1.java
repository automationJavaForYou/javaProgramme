import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.ValueRange;

        public class HijrahDate_date_range_ex1 {
            public static void main(String[] args) {
                Chronology chronology = HijrahChronology.INSTANCE;
                ValueRange range = chronology.range(ChronoField.YEAR);
                int minYear = (int) range.getMinimum();
                int maxYear = (int) range.getMaximum();

                System.out.println("minYear: " + minYear);
                System.out.println("maxYear: " + maxYear);

                // ----- Find the first supported date --------
                // A Hijrah Month have 29 or 30 days.
                HijrahDate hijrahDate = null;
                try {
                    hijrahDate = HijrahDate.of(minYear, 12, 30);
                } catch (Exception e) {
                    hijrahDate = HijrahDate.of(minYear, 12, 29);
                }
                HijrahDate firstDate = hijrahDate.with(TemporalAdjusters.firstDayOfYear());
                System.out.println("First date: " + firstDate + " --> " + LocalDate.from(firstDate));

                // ----- Find the last supported date --------
                hijrahDate = HijrahDate.of(maxYear, 1, 1);

                hijrahDate.range(ChronoField.DAY_OF_YEAR);
                HijrahDate lastDate = hijrahDate.with(TemporalAdjusters.lastDayOfYear());
                System.out.println("Last date: " + lastDate + " --> " + LocalDate.from(lastDate));
            }
        }
