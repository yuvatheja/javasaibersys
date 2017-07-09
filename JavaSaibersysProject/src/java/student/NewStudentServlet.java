/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sanket
 */
@WebServlet(name = "NewStudentServlet", urlPatterns = {"/NewStudentServlet"})
public class NewStudentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet NewStudentServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet NewStudentServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }

System.out.println("insideit");

        String name=request.getParameter("name");
        String phone=request.getParameter("pnoneNo");
        
        int pnoneNo = Integer.parseInt(phone);
        
        String email = request.getParameter("email");
        String university = request.getParameter("university");
        String roomNo = request.getParameter("roomNo");
        String tech = request.getParameter("tech");
        String status = request.getParameter("status");
        String date = request.getParameter("date");
        
        System.out.println("Nameis:" + name + " " + phone +" " + email + " " +university + " " +roomNo +" " + tech +" " + status +" " + date);
        
        
       
        //System.out.println("Datee1 "+ dateParameter);
       
       //Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateParameter);
       

        //===========================
        
        String url="jdbc:mysql://localhost:3306/jdbc_connection";
        String uname ="root";
        String pass ="root";
        
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(url,uname,pass);
        
        Statement st = con.createStatement();
        String sql = "Insert into student_sai_table(name, pnoneNo, email, university, roomNo, tech, status, date) values(?,?,?,?,?,?,?,?) "; 
        
        try (java.sql.PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, name);
            pst.setInt(2, pnoneNo);
            pst.setString(3, email);
            pst.setString(4, university);
            pst.setString(5, roomNo);
            pst.setString(6, tech);
            pst.setString(7, status);
            pst.setString(8, date);
            
            
            //pst.setDate(3, new java.sql.Date(date.getTime()));
           // pst.setDate(3, new java.sql.Date(date.getDate()));
           // pst.setString(3, dateParameter);
            
          //  System.out.println("Datee: " + new java.sql.Date(date.getDate()));
            
            pst.executeUpdate();
            System.out.println("Values are saved");
        }
         //============================
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/StudentPage.jsp");
        rd.include(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewStudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NewStudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewStudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NewStudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
