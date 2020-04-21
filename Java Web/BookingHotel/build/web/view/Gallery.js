function ua(){
    var s = "<table>";
    var sohang = 3;
    var socot = 5;
    for (var i = 0; i < sohang; i++) {
        s += "<tr>";
        for (var j = 0; j < socot; j++) {
            s += "<td><img src='image/" + albumanh[i * socot + j] + "' style='width: 100%'/></td>";
        }
        s += "</tr>";
    }
    s += "</table>";
    s += "<div class='loadmore'><button type='button' onclick ='morong()'>Xem thêm<span></span></button></div>";
    return s;
}
function thuvien() {
    var s = "<table>";
    var sohang = 3;
    var socot = 5;
    for (var i = 0; i < sohang; i++) {
        s += "<tr>";
        for (var j = 0; j < socot; j++) {
            s += "<td><img src='..\\Dulich\\" + albumanh[i * socot + j] + "' style='width: 100%'/></td>";
        }
        s += "</tr>";
    }
    s += "</table>";
    s += "<div class='loadmore'><button type='button' onclick ='morong()'>Xem thêm<span></span></button></div>";
    return s;
}
albumanh = ["K01.PNG", "K02.PNG", "K03.PNG", "nghiduong4.jpg", "nghiduong5.jpg", "nghiduong6.jpg", "nghiduong7.jpg", "nghiduong8.jpg", "nghiduong9.jpg",
    "nghiduong10.jpg", "nghiduong11.jpg", "nghiduong12.jpg", "nghiduong13.jpg", "nghiduong14.jpg", "nghiduong15.jpg"];
function anhmorong() {
    var s = "<table>";
    var sohang = 3;
    var socot = 5;
    for (var i = 0; i < sohang; i++) {
        s += "<tr>";
        for (var j = 0; j < socot; j++) {
            if (i * socot + j < quocgiaalbum.length) {
                s += "<td><img src='..\\Dulich\\" + albumanh1[i * socot + j] + "' style='width: 100%'/></td>";
            }
        }
        s += "</tr>";
    }
    s += "</table>";
    s += "<div class='loadmore'><button type='button' onclick ='morong()'>Xem thêm<span></span></button></div>";
    document.getElementById("noideanh").innerHTML = s;
    document.getElementById("noideanh").style.height = "800";
}
albumanh1 = ["leonui1.jpg", "leonui2.jpg", "leonui3.jpg", "leonui4.jpg", "leonui5.jpg", "leonui6.jpg", "leonui7.jpg", "leonui8.jpg", "tambien1.jpg",
    "tambien2.jpg", "tambien3.jpg", "tambien4.jpg", "tambien5.jpg", "tambien6.jpg", "tambien7.jpg", "tambien8.jpg", "tambien9.jpg", "tambien10.jpg"];
function anhquocgia() {
    var s = "<table>";
    var socot = 5;
    var sohang = (quocgiaalbum.length % socot == 0 ? 0 : 1) + quocgiaalbum.length / socot;
    for (var i = 0; i < sohang; i++) {
        s += "<tr>";
        for (var j = 0; j < socot; j++) {
            if (i * socot + j < quocgiaalbum.length) {
                s += "<td><img src='..\\Dulich\\" + quocgiaalbum[i * socot + j] + "' style='width: 100%'/></td>";
            }
        }
        s += "</tr>";
    }
    s += "</table>";
    s += "<div class='loadmore'><button type='button' onclick ='morong()'>Xem thêm<span></span></button></div>";
    return s;
}
quocgiaalbum = ["nuocanh1.jpg", "nuocanh2.jpg", "nuocanh3.jpg", "nuocanh4.jpg", "nuocanh5.jpg", "nuocanh6.jpg", "nuocanh7.jpg", "nuocanh8.jpg", "nuocanh9.jpg", "nuocanh10.jpg"];
function anhchauluc() {
    var s = "<table>";
    var socot = 5;
    var sohang = (chaulucalbum.length % socot == 0 ? 0 : 1) + chaulucalbum.length / socot;

    for (var i = 0; i < sohang; i++) {
        s += "<tr>";
        for (var j = 0; j < socot; j++) {
            if (i * socot + j < chaulucalbum.length) {
                s += "<td><img src='..\\Dulich\\" + chaulucalbum[i * socot + j] + "' style='width: 100%'/></td>";
            }
        }
        s += "</tr>";
    }
    s += "</table>";
    s += "<div class='loadmore'><button type='button' onclick ='morong()'>Xem thêm<span></span></button></div>";
    return s;
}
chaulucalbum = ["chauau1.jpg", "chauau2.jpg", "chauau3.jpg", "chauau4.jpg", "chauau5.jpg", "chauau6.jpg", "chauau7.jpg", "chauau8.jpg", "chauau9.jpg",
    "chaua1.jpg", "chaua2.jpg", "chaua3.jpg", "chaua4.jpg", "chaua5.jpg", "chaua6.jpg", "chaua7.jpg", "chaua8.jpg", "chaua9.jpg"];
function anhdiemden() {
    var s = "<table>";
    var socot = 5;
    var sohang = (diemdenalbum.length % socot == 0 ? 0 : 1) + diemdenalbum.length / socot;

    for (var i = 0; i < sohang; i++) {
        s += "<tr>";
        for (var j = 0; j < socot; j++) {
            if (i * socot + j < diemdenalbum.length) {
                s += "<td><img src='..\\Dulich\\" + diemdenalbum[i * socot + j] + "' style='width: 100%'/></td>";
            }
        }
        s += "</tr>";
    }
    s += "</table>";
    s += "<div class='loadmore'><button type='button' onclick ='morong()'>Xem thêm<span></span></button></div>";
    return s;
}
diemdenalbum = ["leonui1.jpg", "leonui2.jpg", "leonui3.jpg", "leonui4.jpg", "leonui5.jpg", "leonui6.jpg", "leonui7.jpg", "leonui8.jpg", "tambien1.jpg",
    "tambien2.jpg", "tambien3.jpg", "tambien4.jpg", "tambien5.jpg", "tambien6.jpg", "tambien7.jpg", "tambien8.jpg", "tambien9.jpg", "tambien10.jpg",
    "nghiduong1.jpg", "nghiduong2.jpg", "nghiduong3.jpg", "nghiduong4.jpg", "nghiduong5.jpg", "nghiduong6.jpg", "nghiduong7.jpg", "nghiduong8.jpg",
    "nghiduong9.jpg", "nghiduong10.jpg", "nghiduong11.jpg", "nghiduong12.jpg", "nghiduong13.jpg", "nghiduong14.jpg", "nghiduong15.jpg"];
function anhnoibat() {
    var s = "<table>";
    var socot = 5;
    var sohang = (noibatalbum.length % socot == 0 ? 0 : 1) + noibatalbum.length / socot;
    for (var i = 0; i < sohang; i++) {
        s += "<tr>";
        for (var j = 0; j < socot; j++) {
            if (i * socot + j < noibatalbum.length) {
                s += "<td><img src='..\\Dulich\\" + noibatalbum[i * socot + j] + "' style='width: 100%'/></td>";
            }
        }
        s += "</tr>";
    }
    s += "</table>";
    s += "<div class='loadmore'><button type='button' onclick ='morong()'>Xem thêm<span></span></button></div>";
    return s;
}
noibatalbum = ["noibat1.jpg", "noibat2.jpg", "noibat3.jpg", "noibat4.jpg", "noibat5.jpg", "noibat6.jpg", "noibat7.jpg", "noibat8.jpg", "noibat9.jpg", "noibat10.jpg"];
function anhkhachsan() {
    var s = "<table>";
    var socot = 5;
    var sohang = (khachsanalbum.length % socot == 0 ? 0 : 1) + khachsanalbum.length / socot;
    for (var i = 0; i < sohang; i++) {
        s += "<tr>";
        for (var j = 0; j < socot; j++) {
            if (i * socot + j < khachsanalbum.length) {
                s += "<td><img src='..\\Dulich\\" + khachsanalbum[i * socot + j] + "' style='width: 100%'/></td>";
            }
        }
        s += "</tr>";
    }
    s += "</table>";
    s += "<div class='loadmore'><button type='button' onclick ='morong()'>Xem thêm<span></span></button></div>";
    return s;
}
khachsanalbum = ["khachsan1.jpg", "khachsan2.jpg", "khachsan3.jpg", "khachsan4.jpg", "khachsan5.jpg", "khachsan6.jpg", "khachsan7.jpg", "khachsan8.jpg", "khachsan9.jpg", "khachsan10.jpg", "khachsan11.jpg", "khachsan12.jpg"];
