function cell(){
    var s = document.getElementById("sex");
    var index = s.selectedIndex;
    var sex = s.options[index].value;
        sex = (sex == "true")?true:false;
    var  height = document.getElementById("height").value;
    var  kg = document.getElementById("kg").value;
    var  old = document.getElementById("old").value;
    var workout = document.getElementById("workout").value;
    if (sex===true){
       Kcal=655+(9.6*kg)+(1.8*height)-(4.7*old);
       total=workout*Kcal
        document.write(total+"입니다.")
    
    }
    else {
       Kcal=66+(13.7*kg)+(5*height)-(6.5*old);
       total=workout*Kcal
        document.write(total+"입니다.")
        document.head
    }
}

