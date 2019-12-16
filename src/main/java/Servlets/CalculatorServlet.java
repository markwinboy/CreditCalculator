package Servlets;

import org.apache.commons.math3.util.Precision;
import org.decimal4j.util.DoubleRounder;
import ru.nsu.flowerstore.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            DataBase dataBase = new DataBaseImpl();
            Data data = dataBase.getData();
            int minSum = Integer.parseInt(data.getMinSum());
            int maxSum = Integer.parseInt(data.getMaxSum());
            int minTime = Integer.parseInt(data.getMinTime());
            int maxTime = Integer.parseInt(data.getMaxTime());
            double rate = Double.parseDouble(data.getRate());
            Object sum = req.getParameter("sum");
            Object time = req.getParameter("time");
            req.setAttribute("minSum", minSum);
            req.setAttribute("maxSum", maxSum);
            req.setAttribute("minTime", minTime);
            req.setAttribute("maxTime", maxTime);
            if (sum == null || time == null) {
                sum = (minSum + maxSum) / 2;
                time = (maxTime + minTime) / 2;
                req.setAttribute("sum", sum);
                req.setAttribute("time", time);
                getServletContext().getRequestDispatcher("/index/index.jsp").forward(req, resp);
            } else {
                int newSum = Integer.parseInt(sum.toString());
                int newTime = Integer.parseInt(time.toString());
                Calculation calculation = new Calculation(newSum, rate, newTime);
                req.setAttribute("sum", newSum);
                req.setAttribute("time", newTime);
                long allSum = Math.round(calculation.sumCalculate());
                long monthPaymentSum = Math.round(calculation.getMonthPaymentSum());
                double monthInterestRate = DoubleRounder.round(calculation.getMonthInterestRate(),2);
                String date = calculation.getDate(newTime);
                req.setAttribute("allSum", allSum);
                req.setAttribute("monthPaymentSum", monthPaymentSum);
                req.setAttribute("monthInterestRate", monthInterestRate);
                req.setAttribute("date", date);
                getServletContext().getRequestDispatcher("/index/indexAfter.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            PrintWriter writer = resp.getWriter();
            writer.println("<h1> Oops, something went wrong </h1>");
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
