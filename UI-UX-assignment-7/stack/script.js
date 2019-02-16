class stack {
    constructor() {
       this.elements=[];
    }

    push() 
    {
                try{
                        var input=document.getElementById("inputString").value;
                       if(input == "")
                       {
                           alert("Input cannot be null...!!");
                       }
                       else
                       {
                        this.elements.unshift(input);
                        console.log(this.elements);
                       }
                       document.getElementById("inputString").value="";
                       this.viewStack();

                    }
                catch(err)
                {
                document.getElementById("demo").innerHTML=err.message;
                }
    }

    pop()
    {
                try{
                        if(this.elements.length!=0)
                        {
                        var output=this.elements.shift();
                        console.log(output);
                        console.log(this.elements);
                        this.viewStack();
                        }
                        else
                        alert("Stack Empty...!!");
                }
                catch(err)
                {
                document.getElementById("demo").innerHTML=err.message;
                }
    }


    viewStack() 
    {
                    try{
                            var i=0;
                            for(i=0;i,i<this.elements.length;i++)
                            {
                            console.log(this.elements[i]);
                            }
                            document.getElementById("demo").innerHTML=this.elements;

                    }
                    catch(err)
                    {
                    document.getElementById("demo").innerHTML=err.message;
                    }
    }


    
}

let stck=new stack();