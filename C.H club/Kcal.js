var btnCalc = document.getElementById("btn_calc");
var ActCal = document.getElementById("act_cal").value;

btnCalc.addEventListener("click",function(){
    var s = document.getElementById("sex");
    var sex = s.options[s.selectedIndex].value;
    var height = document.getElementById("height");
    var kg = document.getElementById("kg");
    var old = document.getElementById("old");
    var workout = document.getElementById("workout");
    var baseCal = document.getElementById("base_cal");
    var actCal = document.getElementById("act_cal");
    
    //여자
    if (sex === "true") {
        var kcal = 655 + (9.6 * kg.value) + (1.8 * height.value) - (4.7 * old.value);
        baseCal.value = kcal
        actCal.value= kcal*workout.value  //활동대사량
        ActCal = actCal.value
        return  ActCal 
    }
    //남자
    else {
        var kcal = 66 + (13.7 * kg.value) + (5 * height.value) - (6.5 * old.value);
        baseCal.value = kcal
        actCal.value= kcal*workout.value
        ActCal = actCal.value
        return  ActCal 
    }
}
);

var btnMeal = document.getElementById("btn_meal");

btnMeal.addEventListener("click",function(){
    var carbohydrateCal = document.getElementById("carbohydrate_cal"); 
    var proteinCal = document.getElementById("protein_cal"); 
    var fatCal = document.getElementById("fat_cal"); 
    var totalCal = document.getElementById("total_cal");     
    
    var carbohydrateG = document.getElementById("carbohydrate_g"); 
    var proteinG = document.getElementById("protein_g"); 
    var fatG = document.getElementById("fat_g"); 
    var totalG = document.getElementById("total_g");
    
    
    carbohydrateCal.value= ActCal*0.5;
    proteinCal.value = ActCal*0.3
    fatCal.value= ActCal*0.2;
    totalCal.value= ActCal*0.5+ ActCal*0.3 + ActCal*0.2;

    carbohydrateG.value = carbohydrateCal.value/4;
    proteinG.value = proteinCal.value/4;
    fatG.value = fatCal.value/9;
    totalG.value = carbohydrateCal.value/4 + proteinCal.value/4 + fatCal.value/9;

})

