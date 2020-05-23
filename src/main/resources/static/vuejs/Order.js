new Vue({
    el: "#order",
    data: {
        orderlist: {},
    },
    created: function () {
        this.findall();
    },
    methods: {
        //获取订单信息
        findall: function () {
            var _this = this;
            axios.get('/SelOrderAndCart', {
                params: {
                    uuid: -1
                }
            })
                .then(function (value) {
                    _this.orderlist = value.data;
                    console.log();
                })
                .catch(function (error) {
                    console.log(error);
                })

        },
        fahuo: function (id) {
            var _this = this;
            axios.get('/fahuo', {
                params: {
                    id: id
                }
            })
                .then(function (value) {
                    alert(value.data)
                    _this.findall();
                    console.log();
                })
                .catch(function (error) {
                    console.log(error);
                })

        },

    }
});


