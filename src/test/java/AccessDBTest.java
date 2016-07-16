import org.junit.Test;

import java.util.List;

/**
 * Created by icondor on 16/07/16.
 */
public class AccessDBTest {

    public static void main(String[] argv) {
        try {

            List l = AccessDB.readTweets();
            l.forEach((temp) -> {
                TweetBean tb = (TweetBean) temp;
                System.out.println(tb.getContent());

            });

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Test
    public void testAddTweet() throws Exception {

    }

    @Test
    public void testReadTweets() throws Exception {

    }

    @Test
    public void testIsUserInDB() throws Exception {

    }

    @Test
    public void testReadMyFriends() throws Exception {

    }
}
