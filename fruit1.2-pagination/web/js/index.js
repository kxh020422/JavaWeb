function delFruit(fid) {
    if (confirm('是否确认删除')) {
        window.location.href = 'del.do?fid=' + fid;
    }
}

function page(pageNo) {
    window.location.href = "index?pageNo=" + pageNo;
}

function myPage(){
    var pageNum = document.getElementById("pageNum").value;
    var pageCount = document.getElementById("myPageCount").value;
    // alert(pageCount);
    // alert(pageNum)
    if (pageNum <= 0 || pageNum > pageCount){
        alert("输入有误")
    } else {
        window.location.href = "index?pageNo=" + pageNum;
    }
}
