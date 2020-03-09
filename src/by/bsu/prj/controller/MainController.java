package by.bsu.prj.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

@WebServlet(urlPatterns = "/controller")
public class MainController extends HttpServlet {
    static Logger log = LogManager.getLogger(MainController.class.getName());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         String numberStr1 = request.getParameter("firstNumber");
         String numberStr2 = request.getParameter("secondNumber");
         int num1 = Integer.parseInt(numberStr1);
         int num2 = Integer.parseInt(numberStr2);
         int result = num1 * num2;

    log.debug("jfnvofsn");

     request.setAttribute("res",result);
     request.getRequestDispatcher("pages/main.jsp").forward(request, response);

    }
   /* public static String readFile(File reader) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        FileReader fileRead = new FileReader(reader);
        Scanner fileScanner = new Scanner(fileRead);
        while (fileScanner.hasNextLine()){
            content.append(fileScanner.nextLine()).append("<br>");
        }

        try {
            fileRead.close();
        }
        catch (Exception e){
            log.error("Can't close the file reader" + e.getMessage());
        }

        return content.toString();
    }*/

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
