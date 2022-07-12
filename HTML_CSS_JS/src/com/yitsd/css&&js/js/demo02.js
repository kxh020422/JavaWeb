//当鼠标悬浮时显示背景颜色
function showBGColor(){
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
function clearBGColor(){
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
function showHand(){
    if (event && event.srcElement && event.srcElement.tagName === "TD") {
        var td = event.srcElement;
        td.style.cursor = "hand";
    }
}