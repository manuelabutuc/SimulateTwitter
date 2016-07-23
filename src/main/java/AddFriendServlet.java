import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Manu on 23-Jul-16.
 */
@WebServlet("/addfriend")
public class AddFriendServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String friend = req.getParameter("friend");
        try {
            HttpSession session = req.getSession(true);
            Integer user_id = (Integer) session.getAttribute("iduser");
            AccessDB.addFriend(user_id, friend);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

