package Procesos;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Descifrar extends HttpServlet {
    int prim=100613, sec=76493, publicKey= 65537, im=0; //valor estandar de la clave pública, me gustaría usar 51157
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
            Pattern pa = Pattern.compile("[^A-Za-z.@_-~#]+");
            Matcher ma = pa.matcher(a);
            boolean rem = ma.find();
            if(!rem) out.print("No es el formato solicitado");
            else{
                String mensaje="ﾸ|ￎￋﾫﾱ5￠>￟�ﾴￒ￲￢U.";
                /*try{
                    RSA r= new RSA();
                    r.openFromDiskPrivateKey("/tmp/rsa.pri");    
                    r.openFromDiskPublicKey("/tmp/rsa.pub");
                    String unsecure= r.Encrypt(a);
                    out.print(unsecure);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                Primer intento de descifrado
                */
                Pattern p = Pattern.compile("[^A-Za-z0-9.@_-~#]+");
                Matcher m = p.matcher(mensaje);
                boolean resultado = m.find();
                while(resultado && im<35) {
                    mensaje="";
                    RSA2 rsaServidor = new RSA2(1024);
                    BigInteger descifrado = rsaServidor.decrypt(new BigInteger(a));
                    byte[] miflujo= descifrado.toByteArray();
                    if(miflujo.length>0){
                        for (int i = 0; i < miflujo.length; i++)
                            mensaje+=(char) miflujo[i];
                    }
                    im++;
                    m = p.matcher(mensaje);
                    resultado = m.find();
                }
                im=0;
                out.print(mensaje);
            }
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
