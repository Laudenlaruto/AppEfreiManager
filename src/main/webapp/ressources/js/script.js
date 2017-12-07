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
              $('#classe').text(json["classe"]);
              $('#nom').text(json["nom"]);
              $('#prenom').text(json["prenom"]);
              $('#cdc').prop('checked', json["cdc"]);
              $('#fiche_visite').prop('checked', json["fiche_visite"]);
              $('#fiche_evaluation').prop('checked', json["fiche_evaluation"]);
              $('#sondage_web').prop('checked', json["sondage_web"]);
              $('#rapport_rendu').prop('checked', json["rapport_rendu"]);
              $('#soutenance').prop('checked', json["soutenance"]);
              $('#visite_planif').prop('checked', json["visite_planif"]);
              $('#visite_faite').prop('checked', json["visite_faite"]);
              $('#debut').text(json["debut"]);
              $('#fin').text(json["fin"]);
              $('#entreprise').text(json["entreprise"]);
              $('#mds').text(json["mds"]);
              $('#stage_adresse').text(json["stage_adresse"]);
              $('#note_tech').text(json["note_tech"]);
              $('#note_com').text(json["note_com"]);
              $('#commentaire').text(json["commentaire"]);
              $('#description_mission').text(json["description_mission"]); 
        });     
    }
  });
  
  
      $("#" ).click(function() {
        var doc = new jsPDF();

        doc.text('Hello world!', 10, 10);
        doc.save('a4.pdf');
    });
});


