//time display funct
//The variable "time" is the time to do the quiz
function clock(time) {
    var countDownDate = time;
//  convert time to minutes and seconds
    var minutes = Math.floor(time / 60);
    var seconds = time % 60;
      
//  show the time
    document.getElementById("time").innerHTML =minutes + ":" + seconds;

//  countdown function
    function timeCount() {
        countDownDate = countDownDate - 1;
        minutes = Math.floor(countDownDate / 60);
        seconds = countDownDate % 60;

        document.getElementById("time").innerHTML = minutes + ":" + seconds;
//        Check if the countdown time is 0 => stop the countdown function and auto submit
        if (countDownDate <= 0) {
//            stop
            clearInterval(x);
            document.getElementById("time").innerHTML = "Time out"
//            submit form
            document.getElementById("takeResult").submit();
        }
    }
//    Repeat the countdown function after 1 second
    var x = setInterval(timeCount, 1000);
}



