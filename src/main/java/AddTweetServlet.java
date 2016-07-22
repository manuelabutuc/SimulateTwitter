import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by icondor on 16/07/16.
 */

@WebServlet("/addtweet")
public class AddTweetServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String textToTweet = req.getParameter("textToTweet");
        try {
            HttpSession session = req.getSession(true);
            Integer user_id = (Integer)session.getAttribute("iduser");
            AccessDB.addTweet(user_id, textToTweet);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

//    /**/
//    private void returnJsonResponse(HttpServletResponse response, String jsonResponse) {
//        response.setContentType("application/json");
//        PrintWriter pr = null;
//        try {
//            pr = response.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        assert pr != null;
//        pr.write(jsonResponse);
//        pr.close();
//    }
//}
