new Vue({
    el: "#orderlog",
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
        //获取订单信息
        AAA: function (id,state) {
            var _this = this;
            axios.get('/shouhuo', {
                params: {
                    id: id,
                    state:state
                }
            })
                .then(function (value) {
                    _this.findall();
                    alert(value.data);
                    console.log();
                })
                .catch(function (error) {
                    console.log(error);
                })

        },

    }
})


