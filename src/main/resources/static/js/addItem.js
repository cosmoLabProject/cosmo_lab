// const addItemBtn = document.querySelector("#addItem");
// addItemBtn.addEventListener("click", function() {
//     const checking = confirm("등록하시겠습니까?");
//     if(checking) {
//         const category = document.querySelector("#category");
//         const selectedCategory = category.options[category.selectedIndex].value;
//         const status = document.querySelector("#status");
//         const selectedStatus = status.options[status.selectedIndex].value;
//         const itemName = document.querySelector("#itemName").value;
//         const originalPrice = document.querySelector("#originalPrice").value;
//         const sellingPrice = document.querySelector("#sellingPrice").value;
//         const itemImage = document.querySelector("#itemImage").files[0];
//         const itemDescription = document.querySelector("#itemDescription").value;
//
//         const form = document.querySelector("#new-item");
//         // form.append("img", itemImage);
//         // form.append("categoryName", selectedCategory);
//         // form.append("status", selectedStatus);
//         // form.append("itemName", itemName);
//         // form.append("originalPrice", originalPrice);
//         // form.append("sellingPrice", sellingPrice);
//         // form.append("itemDescription", itemDescription);
//
//         form.action = "/admin/addItem";
//         form.method = "POST";
//         form.submit();
//     }else{
//         return;
//     }
// })