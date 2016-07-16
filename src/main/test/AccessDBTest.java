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
}
