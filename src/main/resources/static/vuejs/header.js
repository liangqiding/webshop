new Vue({
    el: "#header_include",
    data: {
        cartlist: {},
        countC: '',
        users: {},
        countL: '',
    },
    created: function () {
        this.findCart();
        this.countcart();
        this.getusers();
        this.countlove();
    },
    methods: {
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
        // 模糊查询
        Sel: function () {
            var p_classid = $("#p_classid").val();
            var p_name = $("#p_name").val();
            var _this = this;
            axios.get('/SelProductBymohu', {
                params: {
                    p_name: p_name,
                    p_classid: p_classid
                }
            })
                .then(function (value) {
                    window.location.href="/"
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })

        },
    }
})


