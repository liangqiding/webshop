new Vue({
    el:"#buy1",
        data:{
            product: {
            },
            imglist:{
            }
        },
        created:function () {
            this.findAll();
            // this.findimg();
        },
        methods:{
        //获取商品 位于 主页 --新款商品
        findAll:function () {
            var _this = this;
            axios.get('/SelProductOne', {
                params: {
                    p_id: -1
                }
            })
                .then(function (value) {
                    _this.product=value.data;
                })
                .catch(function (error) {
                    console.log("error")
                    console.log(error);
                })
        },
            // 截取当前数据到小数点后两位
            numFilter(value) {
                const realVal = parseFloat(value).toFixed(2);
                return realVal;
            },
            //添加购物车
            AddCart: function (p_id, p_uuid) {
                var cart_sum = $("#cart_sum").val();
                var keep = $("#keep").html();
                if (cart_sum <= 0) {
                    alert("输入错误");
                    _this.findAll();
                    return false;
                } else if (keep >= cart_sum) {
                    var _this = this;
                    axios.get('/Addcart', {
                        params: {
                            p_id: p_id,
                            p_uuid: p_uuid,
                            cart_sum: cart_sum
                        }
                    })
                        .then(function (value) {
                            if (value.data == '请先登录') {
                                window.location.href = "/login";
                            } else if (value.data == '添加成功') {
                                _this.findAll();
                                alert("添加成功")
                                window.location.href = "/";
                            }else if (value.data == '库存不足') {
                                _this.findAll();
                                alert("添加失败")
                            } else {
                                _this.findAll();
                                alert("添加失败")
                            }
                            console.log(value);
                        })
                        .catch(function (error) {
                            console.log("error")
                            console.log(error);
                        })
                }else
                    alert("error:"+'添加数量为：'+cart_sum+'  库存='+keep)
            },
    }
})



// vue1.findAll(66)

