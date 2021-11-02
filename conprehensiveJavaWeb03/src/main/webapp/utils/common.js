

class Common {
    goBack(btn){
        $(btn).on("click",function (){
            window.location.href ="http://localhost:8080/caseStudy/userListServlet"
        })
    }
    reset(){

    }
}

const common = new Common();