new Vue({
    el: "#table1",
    data: {
        //商品列表
        productlist: {},
        //购物车列表
        cartlist: {},
        //购物车总数
        countC: '',
        //用户列表
        users: {},
        //收藏数统计
        countL: '',
        //分页按钮
        Limits: {},
        //当前种类id
        cid:''
    },
    created: function () {
        this.findAll();
        this.findCart();
        this.countcart();
        this.getusers();
        this.countlove();
        this.Limit();
        this.getClassId();
    },
    methods: {
        //获取商品 位于 主页 --新款商品
        findAll: function () {
            var _this = this;
            axios.get('/SelProduct', {
                params: {
                    id: 0
                }
            })
                .then(function (value) {
                    _this.productlist = value.data;
                    console.log("success")
                    console.log(value);
                })
                .catch(function (error) {
                    console.log("error")
                    console.log(error);
                })

        },
        // 模糊查询
        Sel: function (id) {
            if (id != null) {
                var p_classid = id;
            } else {
                var p_classid = $("#p_classid").val();
            }
            var p_name = $("#p_name").val();
            var _this = this;
            axios.get('/SelProductBymohu', {
                params: {
                    p_name: p_name,
                    p_classid: p_classid
                }
            })
                .then(function (value) {
                    _this.findAll();
                    _this.getClassId();
                    _this.Limit(1, 1, 0);
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })

        },

        //h获取种类ID
        getClassId: function () {
            var _this = this;
            axios.get('/getClassId', {
                params: {
                }
            })
                .then(function (value) {
                    _this.cid=value.data;
                })
        },
        //分页
        Limit: function (pageNum, pages, state) {
            var _this = this;
            if (pageNum == 0) {
                pageNum = 1;
            } else if (state == 1 && pageNum < pages) {
                pageNum++;
            } else if (state == -1 && pageNum > 1) {
                pageNum--;
            }
            axios.get('/Limit', {
                params: {
                    pageNum: pageNum,
                }
            })
                .then(function (value) {
                    _this.findAll();
                    _this.Limits = value.data;
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })

        },
        //    购物车列表
        findCart: function () {
            var _this = this;
            axios.get('/findCart', {
                params: {
                    id: 0
                }
            })
                .then(function (value) {
                    _this.cartlist = value.data;

                })
                .catch(function (error) {
                    console.log(error);
                })

        },
        //统计 购物车商品总数
        countcart: function () {
            var _this = this;
            axios.get('/countcart', {
                params: {}
            })
                .then(function (value) {
                    _this.countC = value.data;
                    console.log(value);
                })
                .catch(function (error) {

                    console.log(error);
                })

        },
        //    统计收藏数量
        countlove: function () {
            var _this = this;
            axios.get('/SelLoveCount', {
                params: {}
            })
                .then(function (value) {
                    _this.countL = value.data;
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        //    获取用户信息
        getusers: function () {
            var _this = this;
            axios.get('/getusers', {
                params: {}
            })
                .then(function (value) {
                    _this.users = value.data;
                    console.log(value);
                })
                .catch(function (error) {

                    console.log(error);
                })

        },
        //购买
        buy: function (p_id, p_uuid) {
            console.log("111")
            window.location.href = "/buy?p_id=" + p_id + "&&p_uuid=" + p_uuid;
        },

        //添加购物车
        AddCart: function (p_id, p_uuid) {
            var cart_sum = $('#cart_sum' + p_id).val();
            var keep = $('#keep'+p_id).html();
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
                            _this.findCart();
                            _this.countcart();
                            alert("添加成功")
                        }else if (value.data == '库存不足') {
                            _this.findAll();
                            _this.findCart();
                            _this.countcart();
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
                alert("error"+'购买数量为：'+cart_sum+'  库存='+keep)
        },

        //添加收藏
        love: function (p_id) {
            var _this = this;
            axios.get('/AddLove', {
                params: {
                    p_id: p_id,
                }
            })
                .then(function (value) {
                    if (value.data == '请先登录') {
                        window.location.href = "/login";
                    } else if (value.data == '添加成功') {
                        _this.countlove();
                        alert("添加成功")
                    } else if (value.data == '您已添加过了') {
                        alert("您已添加过了")
                    } else {
                        alert("添加异常")
                    }
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })

        },
        // 截取当前数据到小数点后两位
        numFilter(value) {
            const realVal = parseFloat(value).toFixed(2);
            return realVal;
        },

    }
})


// vue1.findAll(66)

