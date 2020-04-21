//Represents the current question
currentID = 1;
//next question
function nextQ(number) {

//  Hide current question
    document.getElementById("q" + currentID).classList.add("hidden");

    currentID = (currentID + 1) % number;

//  Case last question
    if (currentID == 0) {

//       show button finish
        document.getElementById("finish").classList.remove("hidden");
        currentID = number;
    }
//       hide button finish when the user returns to the first question  
    if (currentID == 1) {
        document.getElementById("finish").classList.add("hidden");
    }
//    show next question
    document.getElementById("q" + currentID).classList.remove("hidden");
}
