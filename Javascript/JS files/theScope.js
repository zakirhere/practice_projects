var the_meaning = "Init value";

function BigComputer(answer) { 
   this.the_answer = answer; 
   this.ask_question = function () { 
      return this.the_answer; 
   } 
 } 
 function SmallComputer() {
 	the_meaning1 = "Small computer";
 	return this.the_meaning1;
  }
  
  function AddWait() {
 	 document.getElementById("waitmessage").innerHTML="Waiting for delay to complete";
     setTimeout(function(){ 
 	 	document.getElementById("waitmessage").innerHTML=printValue();
     }, 3000);
     return this.SmallComputer();
  }
  
  
  var the_meaning = new BigComputer("Big Computer").the_answer;
  SmallComputer();