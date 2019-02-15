class Queue {
    constructor() {
       this.elements=[];
    }

    addElement() 
    {
                try{
                        var input=document.getElementById("inputString").value;
                       if(input == "")
                       {
                           alert("Input cannot be null...!!");
                       }
                       else
                       {
                        this.elements.push(input);
                        console.log(this.elements);
                       }
                       document.getElementById("inputString").value="";
                       this.viewQueue();

                    }
                catch(err)
                {
                document.getElementById("demo").innerHTML=err.message;
                }
    }

    removeElement()
    {
                try{
                        if(this.elements.length!=0)
                        {
                        var output=this.elements.shift();
                        console.log(output);
                        console.log(this.elements);
                        this.viewQueue();
                        }
                        else
                        alert("Queue is empty...!!");
                }
                catch(err)
                {
                document.getElementById("demo").innerHTML=err.message;
                }
    }


    viewQueue() 
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

let queue=new Queue();