const checkObj = {
    "inputNo" : false, 
    "inputMajor" : false
};

const inputNo = document.getElementById("inputNo");
const inputMajor = document.getElementById("inputMajor");
const numText = document.getElementById("numText");
const majorText = document.getElementById("majorText");

inputNo.addEventListener("change",function(){

    const regExp =/^[0-9]\d{0,8}$/;

    if(regExp.test(this.value)){
        this.style.backgroundColor = "white";
        numText.innerText ="";
        checkObj.inputNo = true;
    } else{
        this.style.backgroundColor='#ed3251';
        checkObj.inputId = false;
        numText.innerText="숫자만 입력해주세요."
    }
});


inputMajor.addEventListener("keyup", function(){

    const regExp = /^[가-힣]{2,13}$/;

    if(regExp.test(this.value)){
        checkObj.inputMajor = true;
        majorText.innerText="";
        this.style.backgroundColor="white";

    } else {
        console.log("test");
        checkObj.inputMajor = false;
        this.style.backgroundColor = '#ed3251';
        majorText.innerText="한글만 입력해주세요";
        

    }

});


function validate(){

    for(let key in checkObj){

        if( !checkObj[key]){
            alert("[아이디 찾기 실패!] 다시 확인해주세요");
            return false;
        }

    }
    return true;

};
