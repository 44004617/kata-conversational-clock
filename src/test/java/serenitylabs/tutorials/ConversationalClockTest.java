package serenitylabs.tutorials;

import com.googlecode.zohhak.api.Coercion;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ZohhakRunner.class)
public class ConversationalClockTest {

    @TestWith({
            "01:00, it's one o'clock",
    })
    public void should_tell_the_time_on_the_hour(ConversationalClock clock, String expectedTime) throws Exception {
        assertThat(clock.currentTime()).isEqualTo(expectedTime);
    }

    /**
     * Creates an instance of a ConversationalClock, set to a requiredTime
     *
     * @link https://github.com/piotrturski/zohhak/blob/master/Full-Guide.md
     *
     * @param requiredTime Time in the "HH:mm" format (for example "17:15") coming from the @TestWith
     * @return an instance of a ConversationalClock, set to a requiredTime
     */
    @Coercion
    public ConversationalClock clockSetTo(String requiredTime) {
        HourAndMinute time = new HourAndMinute(requiredTime);

        // TODO: how can you control the time?
        SystemTime systemTime = new SystemTime();

        return new ConversationalClock(systemTime);
    }
}
