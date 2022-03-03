
$(document).ready(function (){
    var product_id = $("#product_id").val();
    var user_id =$("#user_id").val();
//     var us = $('input[name="check_us"]:checked').val();
//     console.log(us);

    $("#check_pay").click(function() {
        var IMP = window.IMP;
        IMP.init('imp20956590');

        IMP.request_pay({
            pg: "kakaopay",
            pay_method: 'card',
            merchant_uid: 'merchant_' + new Date().getTime(),
            name: 'Cosmetic 결제',
            amount: '17,000',
            buyer_email: '${us.email}',
            buyer_name: '${us.name}',
            buyer_tel: '${us.phone}',
            buyer_addr: '${us.address}',
            buyer_postcode: '${us.zipcode}',
            // m_redirect_url: 'redirect url'
        }, function (rsp) {
            if (rsp.success) {

                var msg = '결제가 완료되었습니다';
                var result = {
                    "imp_uid" : rsp.imp_uid,
                    "merchant_uid" : rsp.merchant_uid,
                    "biz_email" : '<%=email%>',
                    "pay_date" : new Date().getTime(),
                    "amount" : rsp.paid_amount,
                    "refund" : 'payed'
                }
                console.log("결제 성공" + msg);
                $.ajax({
                    url: '/',
                    type: 'POST',
                    data: json.stringify(result,
                        ['imp_uid', 'merchant_uid', 'biz_email', 'pay_date',
                            'amount', 'refund']),
                    contentType: 'application/json;charset=utf-8',
                    dataType: 'json', //서버에서 보내줄 데이터
                });
            } else {
                var msg = '결제에 실패하였습니다.';
                rsp.error_msg;

            }
        });

})});
