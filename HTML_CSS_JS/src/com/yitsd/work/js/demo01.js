// noinspection JSDeprecatedSymbols

window.onload = function () {
    updateZJ();
    //当页面加载完成，我们需要绑定各种事件
    //根据id获取表格
    var fruitTBL = document.getElementById("tbl_fruit");
    //获取表格中的所有的行
    var rows = fruitTBL.rows;
    //alert(rows.length);
    for (var i = 1; i < rows.length - 1; i++) {
        var tr = rows[i];
        trBoundEvent(tr);
    }
    document.getElementById("addBtn").onclick = addFruit;


}

function trBoundEvent(tr){
    //1.绑定鼠标悬浮时以及离开时设置背景颜色事件事件
    tr.onmouseover = showBGColor;
    tr.onmouseout = clearBGColor;
    //获取tr这一行的所有单元格
    var cells = tr.cells;
    var priceTD = cells[1];
    //2.绑定鼠标悬浮在单价单元格变手势的事件
    priceTD.onmouseover = showHand;
    //3.绑定鼠标点击单价单元格的事件
    priceTD.onclick = editPrice;

    //4.绑定删除小图标的点击事件
    var img = cells[4].firstChild;
    if (img && img.tagName === "IMG") {
        //绑定单击事件
        img.onclick = delFruit;
    }
}

//添加水果信息
function addFruit() {
    var fname = document.getElementById("fname").value;
    var price = parseInt(document.getElementById("fprice").value);
    var fcount = parseInt(document.getElementById("fcount").value)
    var xj = price * fcount;

    var fruitTBL = document.getElementById("tbl_fruit");
    var tr = fruitTBL.insertRow(fruitTBL.rows.length - 1);

    var fnameTD = tr.insertCell();
    fnameTD.innerText = fname;

    var priceTD = tr.insertCell();
    priceTD.innerText = price;

    var fcountTD = tr.insertCell();
    fcountTD.innerText = fcount;

    var xjTD = tr.insertCell();
    xjTD.innerText = xj;

    var imgTD = tr.insertCell();
    imgTD.innerHTML = "<img src= 'imgs/del.jpg' class='delImg'/>";

    updateZJ();

    trBoundEvent(tr);

}

//当鼠标悬浮时显示背景颜色
function showBGColor() {
    //event：当前发生的事件
    //event.srcElement：事件源
    /*alert(event.srcElement);
    alert(event.srcElement.tagName); --> TD*/
    if (event && event.srcElement && event.srcElement.tagName === "TD") {
        //alert(event); -> [object MouseEvent]
        //alert(event.srcElement); -> [object HTMLTableCellElement]
        //alert(event.srcElement.tagName); -> TD
        var td = event.srcElement;
        //td.parentElement 表示获取td的父元素 —> TR
        var tr = td.parentElement;
        //alert(tr); /*->[object HTMLTableRowElement]*/
        //如果想要通过js代码设置某节点的样式，则需要加上 .style
        tr.style.backgroundColor = "navy";//设置某一行的背景颜色
        //alert(tr.style);
        //tr.cells 表示获取这个tr中所有的单元格
        var tds = tr.cells;

        for (var i = 0; i < tds.length; i++) {
            tds[i].style.color = "white";
        }
    }
}

//当鼠标离开时恢复原始样式
function clearBGColor() {
    if (event && event.srcElement && event.srcElement.tagName === "TD") {
        var td = event.srcElement;
        var tr = td.parentElement;
        tr.style.backgroundColor = "transparent";
        var tds = tr.cells;
        for (var i = 0; i < tds.length; i++) {
            tds[i].style.color = "darkslateblue";
        }
    }
}

//当鼠标悬浮在单价单元格时，显示手势
function showHand() {
    if (event && event.srcElement && event.srcElement.tagName === "TD") {
        var td = event.srcElement;
        td.style.cursor = "hand";
    }
}

//当鼠标点击单价单元格时 进行价格编辑
function editPrice() {
    if (event && event.srcElement && event.srcElement.tagName === "TD") {
        var priveTD = event.srcElement;
        //判断当前priceTD有子节点并且子节点是文本结点（TextNode -> 3  ElementNode -> 1）
        if (priveTD.firstChild.nodeType === 3 && priveTD.firstChild) {
            //innerText 表示获取或者设置当前节点的内部文本
            var oldPrice = priveTD.innerText;
            //alert(oldPrice);
            //innerHTML 表示设置当前节点内部的HTML
            priveTD.innerHTML = "<input type = 'text' size='3'/>";
            var input = priveTD.firstChild;
            if (input.tagName === "INPUT") {
                input.value = oldPrice;
                //选中输入框内部的文本
                input.select();
                //绑定输入框失去焦点事件，失去焦点，更新单价
                input.onblur = updatePrice;

                //绑定在输入框上键盘摁下的事件，此处我需要保证用户输入的是数字
                input.onkeydown = ckInput;
            }
        }
    }
}

//检验键盘摁下的值的方法
function ckInput(){
    var kc = event.keyCode;
    //0 ~ 9 : 48 ~ 57
    //backspace : 8
    //enter : 13
    //console.log(kc);
    if(!((kc >= 48 && kc <= 57) || kc === 8 || kc === 13)){
        event.returnValue = false;
    }
    if (kc === 13) {
        event.srcElement.blur();
    }

}

//更新单价的值的方法
function updatePrice() {
    if (event && event.srcElement && event.srcElement.tagName === "INPUT") {
        var input = event.srcElement;
        //alert(input);->[object HTMLInputElement]
        var newPrice = input.value;
        //input 的父节点是 td
        var priceTD = input.parentElement;
        priceTD.innerText = newPrice;


        //更新当前行的小计这一个格子
        //priceTD.parentElement  td的父元素是tr
        updateXJ(priceTD.parentElement);
    }
}

//更新指定行的小计
function updateXJ(tr) {
    if (tr && tr.tagName === "TR") {
        var tds = tr.cells;
        var price = tds[1].innerText;
        var count = tds[2].innerText;

        var xj = parseInt(price) * parseInt(count);
        tds[3].innerText = xj;

        //更新总计
        updateZJ();
    }
}

//更新总计
function updateZJ() {
    var fruitTBL = document.getElementById("tbl_fruit");
    var rows = fruitTBL.rows;
    var sum = 0;
    for (i = 1; i < rows.length - 1; i++) {
        var tr = rows[i];
        var xj = parseInt(tr.cells[3].innerText);
        sum += xj;
    }
    rows[rows.length - 1].cells[1].innerText = sum;
}

function delFruit(){
    if (event && event.srcElement && event.srcElement.tagName === "IMG"){
        //alert表示弹出一个对话框，只有确认一个按钮
        //confirm表示弹出一个对话框，有确定和取消按钮。当点击确定，返回true，否则返回false
        if(window.confirm("是否确认删除")){
            //img = event.srcElement -> [object HTMLImageElement]
            var img = event.srcElement;
            //alert(img);
            var tr = img.parentElement.parentElement;
            var fruitTBL = document.getElementById("tbl_fruit");
            fruitTBL.deleteRow(tr.rowIndex);
        }
        updateZJ();

    }

}