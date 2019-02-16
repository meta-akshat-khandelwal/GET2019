String.prototype.repeatify=function(n) {
    
    str="";
    for(let i=0;i<n;i++) {
        str=str+this;
    }   
    return str;

};
function repeat() {
    var n = document.getElementById("numberOfTimes").value;
    var string= document.getElementById("inputString").value;
    if(n == "" || string == "")
       {
            alert("Input cannot be null");
       }
    else
    {
        document.getElementById("show").innerHTML=string.repeatify(n)
        
    }
   
}