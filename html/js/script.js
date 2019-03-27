$(document).ready(function () {
    const URL = 'http://localhost:8080/pedidos/guardar';
    $('#registerbtn').click(function () {
        if (inputValidos()) {
            var postData      = {};
            postData.nombre     = document.getElementById("nombre").value;
            postData.monto      = document.getElementById("precio").value;
            postData.descuento  = document.getElementById("descuento").value;
            $.ajax(
            {
                url: URL,
                type: "POST",
                data: JSON.stringify(postData),
                contentType:"application/json",
                success: function (result) {
                    console.log(result);
                    $('#result').text("Pedido registrado con exito.");
                },
                error:function (error) {
                    console.log(`Error ${error}`);
                    $('#result').text("Error al intentar registrar el pedido.");
                }
            });
        }
    });
});

function inputValidos() {
    clearParagraphs();
    if (document.getElementById("nombre").value === "" || document.getElementById("nombre").value.length > 20) {
        document.getElementById("nombreRequired").innerHTML = "Entrada no valida!";
        return false;
    } else if (document.getElementById("precio").value === "") {
        document.getElementById("precioRequired").innerHTML = "Entrada no valida!";
        return false;
    } else if (document.getElementById("descuento").value === "") {
        document.getElementById("descuentoRequired").innerHTML = "Entrada no valida!";
        return false;
    }
    return true;
}

function clearParagraphs() {
    document.getElementById("nombreRequired").innerHTML = "";
    document.getElementById("precioRequired").innerHTML = "";
    document.getElementById("descuentoRequired").innerHTML = "";
}
