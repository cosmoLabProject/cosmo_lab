$(function(){
    var checkObj = document.getElementsByName("rowCheck");
    var rowCnt = checkObj.length;

    $("input[name='allCheck']").click(function() {
        var check_listArr = $("input[name='rowCheck']");
        for (var i=0; i<check_listArr.length; i++) {
            check_listArr[i].checked = this.checked;
        }
    });

    $("input[name='rowCheck']").click(function() {
        if($("input[name='rowCheck']:checked").length == rowCnt) {
            $("input[name='allCheck']")[0].checked = true;
        }
        else {
            $("input[name='allCheck']")[0].checked = false;
        }
    });
})

function deleteValue() {
    var url = "deleteProduct";
    var valueArr = new Array();
    var list = $("input[name='rowCheck']");
    for(var i = 0; i < list.length; i++) {
        if(list[i].checked) {
            valueArr.push(list[i].value);
        }
    }
    if (valueArr.length == 0) {
        alert("선택된 상품이 없습니다.");
    }
    else {
        var check = confirm("정말 삭제하시겠습니까?");
        $.ajax({
            url : url,
            type : 'POST',
            traditional : true,
            data : {
                valueArr : valueArr
            },
            success : function(jdata) {
                if(jdata = 1) {
                    alert("삭제 성공");
                    location.replace("cart")
                }
                else {
                    alert("삭제 실패");
                }
            }
        })
    }
}