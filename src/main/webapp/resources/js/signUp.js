const checkObj = {
    "inputId" : false, 
    "inputPw" : false,
    "inputPwConfirm" : false,
    "inputName" : false,
    "inputMajor" : false
};

const inputId = document.getElementById("inputId");
const inputPw = document.getElementById("inputPw");
const inputPwConfirm = document.getElementById("inputPw2");
const inputName = document.getElementById("inputName");
const inputMajor = document.getElementById("inputMajor");
const idText = document.getElementById("idText");
const pwText2 = document.getElementById("pwText2");
const nameText = document.getElementById("nameText");
const majorText = document.getElementById("majorText");


inputId.addEventListener("keyup", function(){

    const regExp = /^[a-z]\w{5,13}$/;

    if(regExp.test(this.value)){
        this.style.backgroundColor = "white";
        idText.innerText="";
        checkObj.inputId = true;
        
    } else {
        this.style.backgroundColor = '#ed3251';
        checkObj.inputId = false;
        idText.innerText="영어 및 숫자 5~13자리만 입력해주세요";
        
    }

});

inputPwConfirm.addEventListener("keyup",function(){
    
    
    if(inputPw.value == inputPwConfirm.value){
        pwText2.innerText ="비밀번호가 일치합니다";
        this.style.background='white';
        checkObj.inputPw = true;
        checkObj.inputPwConfirm =true;
        
    } else {
        pwText2.innerText="비밀번호가 일치하지 않습니다.";
        this.style.backgroundColor = '#ed3251';
        checkObj.inputPw = false;
        checkObj.inputPwConfirm = false;
    }

});

inputName.addEventListener("keyup", function(){

    const regExp = /^[가-힣]{2,5}$/;
    if(regExp.test(this.value)){
        checkObj.inputName = true;
        nameText.innerText ="";
        this.style.backgroundColor = "white";

    } else {
        checkObj.inputName = false;
        nameText.innerText="한글 2~5글자만 입력 가능합니다.";
        this.style.backgroundColor = '#ed3251';
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
            alert("[회원가입 실패!] 다시 확인해주세요");
            return false;
        }

    }
    return true;
};
