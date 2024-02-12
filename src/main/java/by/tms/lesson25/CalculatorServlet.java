package by.tms.lesson25;

import by.tms.lesson25.model.Operation;
import by.tms.lesson25.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

    OperationService operationService=new OperationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String type = req.getParameter("type");

        resp.getWriter().println("num1= "+num1);
        resp.getWriter().println("num2= "+num2);
        resp.getWriter().println("type= "+type);

        Operation operation=new Operation(num1,num2,type);

        Operation result=operationService.calculate(operation);

        resp.getWriter().println("Result= "+result.getResult());

    }
}
