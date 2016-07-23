import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Manu on 23-Jul-16.
 */
@WebServlet("/newAccount")
public class NewUserServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("usernameNew");
        String password = req.getParameter("passwordNew");
        String password1 = req.getParameter("passwordNew1");

        if (password.equals(password1) && (username != "") && (password != "") && (password1 != "")) {
            try {

                AccessDB.createAccount(username, password);
                System.out.println(username);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");

            out.println("<body>");

            out.println("<p style=\"text-align:center;margin-top:30px;font-size: 30px;\"><b>" +
                    "New account was created successfully!" + "</b><br>");
            out.println("<a href=\"login.html\" style=\"text-align:center;font-size: 17px;" +
                    "color:#006dcc;position:relative; top:20px;\"><b>Sign in right now</b></a>");

            out.close();
        } else {
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");

            out.println("<body>");

            out.println("<p style=\"text-align:center;margin-top:30px;font-size: 30px;\"><b>" +
                    "Ups, something went wrong!" + "</b><br>");
            out.println("<a href=\"new_account.html\" style=\"text-align:center;font-size: 17px;" +
                    "color:#006dcc;position:relative; top:20px;\"><b>Try again</b></a>");

            out.close();
        }


    }


}

