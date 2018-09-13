package Procesos;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cifrado extends HttpServlet {
    int prim=100613, sec=76493, publicKey= 65537; //valor estandar de la clave pública, me gustaría usar 51157
    double n= prim*sec,
           phi=(prim-1)*(sec-1);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String a = request.getParameter("texto");
        if(a.length()<1 || a.trim().isEmpty()) response.sendRedirect("index.jsp");
        else{
            PrintWriter out = response.getWriter();
            /*try{
                RSA r= new RSA();
                r.genKeyPair(512);
                String file_private = "/tmp/rsa.pri";
                String file_public = "/tmp/rsa.pub";
                
                r.saveToDiskPrivateKey("/tmp/rsa.pri");
                r.saveToDiskPublicKey("/tmp/rsa.pub");
                
                String secure= r.Encrypt(a);
                out.print(secure);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
                Algoritmo encontrado en la WEB. Es muy sencillo de usar
            */
            byte[] miTexto= a.getBytes();
            System.out.println(Arrays.toString(miTexto));
            RSA2 rsaCliente = new RSA2(1024);
            RSA2 rsaServidor = new RSA2(1024);
            BigInteger cifrado = rsaCliente.encrypt(new BigInteger(miTexto), rsaServidor.getPublicKey());
            out.print(cifrado);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
