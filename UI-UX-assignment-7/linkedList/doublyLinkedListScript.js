
class DoubleNode{
    //intializes the node with the data
    constructor(element){
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}

class DoubleLinkedList{
    //intialize the Linked List
    constructor(){
        this.size = 0;
        this.head = null;
            
    }

    // addelement to the list
    addDouble(){
        var value = document.getElementById("input").value;
       
        if(value == "") {
            alert("Input Can't be null");
        }
        else{
            

                var node = new DoubleNode(value); 

                
                if(this.head == null){
                    this.head = node; 
                    this.size++;
                }

                else{
                    var currentNode = this.head;
                    while (currentNode.next != null) {
                        currentNode = currentNode.next;
                    }
                    currentNode.next = node;
                    node.prev = currentNode;
                    this.size++;
                }
            
            
            document.getElementById("input").value="";
            
            this.printListDouble();
        }
    }

    // removes element from list
    deleteDouble(){
        var value = document.getElementById("input").value;
        var current = this.head; 
        var prev = null; 
        var flag=0;
        if(this.size == 0){
            alert("List is Empty");
        }
        else if(value == ""){
            alert("Input Can't be null");
        }
        else{
            while(current != null){

                if(current.element == value){
                    
                    if(current.next){
                        current.next.prev = current.prev;
                    }
                    if(current.prev){
                        current.prev.next = current.next;
                    }
                    
                    else{
                        this.head = current.next;
                        if(this.head){
                            this.head.prev = null;
                        }
                    }
                    flag=1;
                    break;
                }
                current = current.next;
            }

            if(flag == 0){
                alert("Element Not found");
            }

        }

        document.getElementById("input").value="";
       
        this.printListDouble();
    }

   
    printListDouble() { 

	    var curr = this.head; 
	    var str = ""; 
	    while (curr) { 
		    str += curr.element + " "; 
		    curr = curr.next; 
        } 
        if(str=="") alert("no element");
    
	    document.getElementById("show").innerHTML=str; 
    } 

}

let doubleObject = new DoubleLinkedList();