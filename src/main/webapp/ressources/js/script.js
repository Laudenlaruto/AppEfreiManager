/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
  $('.modal').modal();
    

    $("#").click(function () {
        var doc = new jsPDF();
        
        doc.text('Hello world!', 10, 10);
        doc.save('a4.pdf');
    });
});


