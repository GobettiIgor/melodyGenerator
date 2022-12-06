$(function(){
    var $parametersForm = $("#parameters");
    if($parametersForm.length){
        $parametersForm.validate({
            rules:{
                username:{
                    required: true
                },
                bpm:{
                    range: [120, 1000]
                },
                qtdRep:{
                    range: [1, 100]
                }
            },
            messages:{
                username:{
                    required: 'Informe seu nome!'
                },
                bpm:{
                    range: 'Informe valores entre 120 e 1000!'
                },
                qtdRep:{
                    range: 'Informe valores entre 1 e 100!'
                }
            }
        })
    }
})