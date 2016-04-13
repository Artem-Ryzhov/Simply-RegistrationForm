$(document).ready(function(){
    $('#bttHello').click( function(){
        var fullname  = $('#fullnaame').val();
        var sername  = $('#sername').val();
        $.ajax({
                    type: 'GET',
                    url: '/ajaxcontroller',
                    data: {fullnaame : fullname,
                        sername : sername},
                    success: function(aaa){
                        $('#result1').html(aaa);
                    }
                });
    });

});
