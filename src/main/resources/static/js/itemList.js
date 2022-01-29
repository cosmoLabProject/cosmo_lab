const btns = document.querySelectorAll(".modifyBtn");
for(const btn of btns) {
    btn.addEventListener("click", function(e) {
        const inputHidden = (e.target).parentNode.previousSibling.previousSibling;
        const productId = inputHidden.value;

        const modalCategory = document.querySelector("#modalCategory");
        const status = document.querySelector("#status");
        const modalItemName = document.querySelector("#modalItemName");
        const modalPrice = document.querySelector("#itemPrice");
        const modalDescription = document.querySelector("#itemDescription");

        $.ajax({
            url: "/admin/modifyForm/" + productId,
            method: "GET",
            success: function (response) {
                for (const category of modalCategory.children) {
                    if(parseInt(category.value) === response.kind) {
                        category.selected = true;
                    }
                }
                for (const sts of status.children) {
                    if(sts.value.toUpperCase() === response.available) {
                        sts.selected = true;
                    }
                }
                modalItemName.value = response.productName;
                modalPrice.value = response.price2;
                modalDescription.value = response.content;
            },
            error: function (response) {
                console.log(response);
            }
        });
    })
}

const modifyBtn = document.querySelector("#submitBtn");
modifyBtn.addEventListener("click", function () {
    const itemId = document.querySelector("#itemId");
    const modalItemId = document.querySelector("#modalItemId");
    modalItemId.value = parseInt(itemId.value);
    const form = document.querySelector("#modify-item");
    form.submit();
})


