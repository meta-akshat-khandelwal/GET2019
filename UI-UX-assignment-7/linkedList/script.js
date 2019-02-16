class Node { 
	 //intializes the node with the data
	constructor(element) 
	{ 
		this.element = element; 
		this.next = null
	} 
} 
 
class LinkedList { 
	 //intialize the Linked List
	constructor() 
	{ 
		this.head = null; 
		this.size = 0; 
	} 

	 // addelement to the list
	addElement() 
	{ 
		let element=document.getElementById("input").value;
		if(element=="") 
		{
			alert("Input cannot be null..")
		}
		else
		{
		var node = new Node(element); 

		var current; 

		if (this.head == null) 
			this.head = node; 
		else { 
			current = this.head; 

			
			while (current.next) { 
				current = current.next; 
			} 

			
			current.next = node; 
		} 
		this.size++; 
		this.printList();
		}
		document.getElementById("input").value="";
		
	} 


     // removes element from list
	removeElement() 
	{ 
		let element=document.getElementById("input").value;
		if(element=="") 
		{
			alert("Input cannot be null..")
		}
		else
		{
		var current = this.head; 
		var prev = null; 

		while (current != null) { 
			
			if (current.element === element) { 
				if (prev == null) { 
					this.head = current.next; 
				} else { 
					prev.next = current.next; 
				} 
				break;
			} 
			prev = current; 
			current = current.next; 
		}
		this.printList(); 
		
		} 
		document.getElementById("input").value="";
	} 

	printList() 
	{ 
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
let object=new LinkedList();