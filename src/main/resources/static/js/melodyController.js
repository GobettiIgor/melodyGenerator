const starWrapper = document.querySelector(".stars");
const starsFeedback = document.querySelectorAll(".stars a");

var input = document.getElementById("star1");
var idRadio = 0;

const btDownload = document.getElementById("download");
const form = document.getElementById("form");

var frm = $('#form');

starsFeedback.forEach((star, clickedIdx) => {
    btDownload.hidden = true;
    star.addEventListener('click', () => {
        starWrapper.classList.add("disabled");
        starsFeedback.forEach((otherStar, otherIdx) => {
            if(otherIdx <= clickedIdx) {
                otherStar.classList.add("active");
            }
        });

        idRadio = "star" + (clickedIdx + 1);
        input = document.getElementById(idRadio)
        input.checked = true;

        starWrapper.valueOf(clickedIdx);
        star.setAttribute("value", `${clickedIdx + 1}`);

    })
});
/*
function download() {
    if(document.getElementById("melhoria").value != null && document.getElementById("melhoria").value != ""){
        btDownload.hidden = false;
        form.hidden = true;
    }
}

function ajaxDownload(){
    if(document.getElementById("melhoria").value != null && document.getElementById("melhoria").value != ""){
        btDownload.hidden = false;
        form.hidden = true;
    }
    $.ajax({
        type: "post",
        url: "${pageContext.request.contextPath}/generatedMelody",
        cache: false,
        data: "grade="+$("#grade").val()+"&improvement_suggestion="+$("#melhoria").val()
    });
    /*document.getElementById("submit").addEventListener("click", function(event){
        event.preventDefault()
    });
}*/

frm.submit(function (e){
    e.preventDefault();

    if(document.getElementById("melhoria").value != null && document.getElementById("melhoria").value != ""){
        btDownload.hidden = false;
        form.hidden = true;
    }

    $.ajax({
        type: frm.attr('method'),
        url: frm.attr('action'),
        data: frm.serialize(),
        success: function (data) {
            console.log('Submission was successful.');
            console.log(data);
        },
        error: function (data) {
            console.log('An error occurred.');
            console.log(data);
        },
    });
})
