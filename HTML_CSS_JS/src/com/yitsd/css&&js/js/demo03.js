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
    }

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
            }
        }
    }
}

function updatePrice() {
    if (event && event.srcElement && event.srcElement.tagName === "INPUT") {
        var input = event.srcElement;
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
