<%-- 
    Document   : index
    Created on : 12/09/2018, 11:14:38 PM
    Author     : Manager
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Algoritmo RSA</title>
        <script src="JavaScript/jQuery.js"></script>        
        <script src="JavaScript/SweetAlert.js"></script>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="author" content="Jiménez Miranda Eduardo; Velasco Guzmán Benjamín Antonio">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="Estilos/Estilos.css">
        <link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
    </head>
    <body>
        <header>
            <nav>
                <a href="index.html">Inicio</a>
                <a href="#">Un poco de historia</a>
                <a href="#">¿Cómo funciona?</a>
            </nav>
        </header>
        <div class="Inicio Categoría" id="cat">
            <h2>Ingresa el texto a cifrar</h2>
            <center><hr width="91%" border="30px"></center>
            <div class="Cifrado">
                <form method="post" class="form">
                    <fieldset>
                        <textarea id="txtCifrar" class="textarea primero"></textarea>
                        <textarea id="txtCifrado" class="textarea"></textarea>
                    </fieldset><br>
                    <input type="button" value="Cifrar" class="btn" id="Cis">
                </form>
            </div>
        </div>
        <div class="Subcategoría"><center><img src="img/Candado.png" width="600px" height="300px"></center></div>
        <div class="Categoría Acerca">
            <h2>Ingresa el texto a descifrar</h2>
            <center><hr width="91%" border="30px"></center>
            <div class="Descifrado">
                <form method="post" class="form">
                    <fieldset>
                        <textarea id="txtDescifrar" class="textarea primero"></textarea>
                        <textarea id="txtDescifrado" class="textarea"></textarea>
                    </fieldset><br>
                    <input type="button" value="Descifrar" class="btn" id="Des">
                </form>
            </div>
        </div>
        <footer><p>Cifrado RSA</p></footer>
        <script src="JavaScript/main.js"></script>
    </body>
</html>