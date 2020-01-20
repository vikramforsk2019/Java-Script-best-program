/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author vikram
 */
@WebServlet(urlPatterns = {"/Ved"})
public class Ved extends HttpServlet {

    /**
     *
     */
  String UPLOAD_DIRECTORY = "/home/vikram";
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
        }
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
        processRequest(request, response);
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
        
        String fname = "";
        String ved = "";
        
        PrintWriter out = response.getWriter();
        if(ServletFileUpload.isMultipartContent(request))
        {
            try{
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for(FileItem item : multiparts)
                {
                    if(!item.isFormField())
                    {
                        fname = new File(item.getName()).getName();
                        item.write(new File(UPLOAD_DIRECTORY + File.separator + fname));
                    }
                     if(item.isFormField())
                    {
                     ved = item.getString();
                    }
            }
                out.println("Update successfully "+UPLOAD_DIRECTORY+ File.separator+fname);
                out.println("value : "+ved);
        }   catch (FileUploadException ex) {
                Logger.getLogger(Ved.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Ved.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        else{
            out.println("rahul gadha h");
        }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
//    @Override
   // public String getServletInfo() {
    //    return "Short description";
    }// </editor-fold>

}
