

class Common {
    goBack(btn){
        $(btn).on("click",function (){
            window.location.href ="http://localhost:8080/caseStudy/userListServlet"
        })
    }
}

const common = new Common();