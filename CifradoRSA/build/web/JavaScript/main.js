$(document).ready(function(){
    $('body').on('click', '#Des', function(){
        var texto= $("#txtDescifrar").val();
        $.ajax({
            url:"Descifrar",
            type:"post",
            data: {texto: texto},
            success: function(respuesta){
                if(respuesta.length>0)
                    $("#txtDescifrado").val(respuesta);
                else swal({
                    type: "error",
                    title: "Ups :c",
                    text: "Ha ocurrido un error al procesar la petición"
                });
            }
        });
    });
});
$(document).ready(function(){
    $('body').on('click', '#Cis', function(){
        var texto= $("#txtCifrar").val();
        $.ajax({
            url:"Cifrado",
            type:"post",
            data: {texto: texto},
            success: function(respuesta){
                if(respuesta.length>0)
                    $("#txtCifrado").val(respuesta);
                else swal({
                    type: "error",
                    title: "Ups :c",
                    text: "Ha ocurrido un error al procesar la petición"
                });
            }
        });
    });
});