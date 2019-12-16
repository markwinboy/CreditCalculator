
package Servlets;

import ru.nsu.flowerstore.Data;
import ru.nsu.flowerstore.DataBaseImpl;
import ru.nsu.flowerstore.ValidateException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/admin")
public class AdminServlets extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Integer, String> map = new HashMap<Integer, String>();
        try {
            String minSum = req.getParameter("minSum");

            String maxSum = req.getParameter("maxSum");
            String minMonth = req.getParameter("minMonth");
            String maxMonth = req.getParameter("maxMonth");
            String intRate = req.getParameter("intRate");
            
            Data data = new Data(minSum,maxSum,minMonth,maxMonth,intRate);
            req.setAttribute("data", data);
//            if(!data.validation()){
//                req.setAttribute("minSum", data.validationMinSum());
//                req.setAttribute("maxSum", data.validationMaxSum());
//                req.setAttribute("minMonth1", data.validationMinTime());
//                req.setAttribute("maxMonth", data.validationMaxTine());
//                req.setAttribute("intRate", data.validationRate());
//                getServletContext().getRequestDispatcher("AdminException.jsp").forward(req, resp);
//                String nextJSP = "AdminException.jsp";
//                RequestDispatcher dispatcher = req.getRequestDispatcher(nextJSP);
//                dispatcher.forward(req,resp);
//                throw new ValidateException();
//            }
//            String nextJSP = "AdminException.jsp";
//            RequestDispatcher dispatcher = req.getRequestDispatcher(nextJSP);
//            dispatcher.forward(req,resp);

            try {
                DataBaseImpl database = new DataBaseImpl();
                database.changeData(data);
            } catch (ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }
            String nextJSP = "Admin.jsp";
            RequestDispatcher dispatcher = req.getRequestDispatcher(nextJSP);
            dispatcher.forward(req,resp);
        }catch (Exception e){
            String nextJSP = "AdminException.jsp";
            RequestDispatcher dispatcher = req.getRequestDispatcher(nextJSP);
            dispatcher.forward(req,resp);
        }

    }

}