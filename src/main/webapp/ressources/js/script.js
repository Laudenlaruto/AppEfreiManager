/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
  $('.modal').modal();
  $( "#buttondetails" ).click(function() {
    if($('input[name=modifstagiaire]').is(':checked')){
        var id_stagiaire= $('input[name=modifstagiaire]:checked').attr('id');
        var data ={ getuser : id_stagiaire };
        $.post("Servlet",data, function(json){
              stagiaire = data[0];
              $('#data').text(json["nom"]);              
        });     
    }
  });
});


